package com.ifmo.lesson18;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        GreeenConditionsDisplay greeenConditionsDisplay = new GreeenConditionsDisplay(weatherData);
        OrangeConditionsDisplay orangeConditionsDisplay = new OrangeConditionsDisplay(weatherData);
        RedConditionsDisplay redConditionsDisplay = new RedConditionsDisplay(weatherData);

        for (int i = 0; i < 200; i++) {
            weatherData.setMeasurements(10.0f + i);
         }
    }
}
