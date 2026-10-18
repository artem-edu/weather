package mephi.weather.ui;

import java.util.Scanner;

import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.Weather;
import mephi.weather.api.exception.WeatherApiException;
import mephi.weather.service.GeoService;
import mephi.weather.service.WeatherService;

public class ConsoleUI {
    private final Scanner scanner;
    private final GeoService geoService = new GeoService();
    private final WeatherService weatherService = new WeatherService();

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Введите название стараны, города или полный адрес: ");
        String addr = scanner.nextLine().trim();

        if (addr.isEmpty()) {
            System.out.println("Аддрес не введен, по умолчанию погода для города Москва");
            addr = "Москва";
        }

        System.out.print("Введите количество дней в прогнозе: ");
        int limit = scanner.nextInt();

        try {
            Point point = geoService.getPoint(addr);
            Weather weather = weatherService.getWeather(point, limit);

            System.out.print("RawJSON: " + weather.rawJson);
            System.out.println("\n===============================\n");
            System.out.println("Текущая температура: " + weather.fact);
            System.out.println("\n===============================\n");
            if (weather.averageTemperatures.size() > 0) {
                int avg = 0;
                int daysCount = weather.averageTemperatures.size();

                for (int item : weather.averageTemperatures) {
                    avg += item;
                }

                avg /= daysCount;

                System.out.printf("Средняя температура за %d дней: %d\n", daysCount, avg);
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
