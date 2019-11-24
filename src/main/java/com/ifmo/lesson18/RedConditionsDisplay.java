package com.ifmo.lesson18;

public class RedConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;

    public RedConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature) {
        if(temperature > 110)  {
            display();
        }
    }

    public void display() {
        System.out.println("Внимание! Температура опастная для жизни!");
        System.out.println("Внимание! Пора бежать в бункер!");
    }
}
