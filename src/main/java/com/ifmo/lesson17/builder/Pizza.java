package com.ifmo.lesson17.builder;

public class Pizza {
    private final String dougn;
    private final String cheese;
    private final int iatchug;
    private final int tomatoes;
    private final int pepperoni;

    public static class Builder {

        private final String dougn;
        private final String cheese;

        private int iatchug = 0;
        private int tomatoes = 0;
        private int pepperoni = 0;

        public Builder(String dougn, String cheese) {
            this.dougn = dougn;
            this.cheese = cheese;
        }

         public Builder iatchug(int val) {
            iatchug = val;
            return this;
        }
        public Builder tomatoes(int val) {
            tomatoes = val;
            return this;
        }
        public Builder pepperoni(int val) {
            pepperoni = val;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public Pizza(Builder builder) {
        dougn = builder.dougn;
        cheese = builder.cheese;
        iatchug = builder.iatchug;
        tomatoes = builder.tomatoes;
        pepperoni = builder.pepperoni;
    }

    public String getCheese() {
        return cheese;
    }

    @Override
    public String toString() {
        return "Pizza [" + dougn + " " + cheese + ", Tomato=" + tomatoes + ", Pepperoni=" + pepperoni + "]";
    }
}
