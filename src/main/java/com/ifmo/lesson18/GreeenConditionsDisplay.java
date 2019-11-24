package com.ifmo.lesson18;

public class GreeenConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;

    public GreeenConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature) {
         if(temperature <= 70) {
            display();
        }
    }

    public void display() {
        System.out.println("Температура еще ок!");
    }
}
