package com.ifmo.lesson18;

public class OrangeConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;

    public OrangeConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature) {
        if(temperature > 70 && temperature <= 110)  {
            display();
        }
    }

    public void display() {
        System.out.println("Внимание! Температура в оранжевой зоне!");
    }
}
