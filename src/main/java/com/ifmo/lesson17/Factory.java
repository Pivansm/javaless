package com.ifmo.lesson17;

public abstract class Factory {
    public static Factory getFactory(String country) {
        if(country.equals("JP"))
            return new JapanFactory();
      return null;
    }

    public abstract Car create();

}
