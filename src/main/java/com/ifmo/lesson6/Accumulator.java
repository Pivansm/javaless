package com.ifmo.lesson6;

public class Accumulator  {
    double value;
    private Operation oper;

    public Accumulator(double val, Operation opr) {
        value = val;
        this.oper = opr;
    }

    void accumulate(double vl){
        value = oper.calculate(value, vl);
    }


    double getValue(){
        return value;
    }

    public static void main(String[] args) {
        double oSum=0.0;
        Accumulator acm = new Accumulator(23.0, new Plus());
        acm.accumulate(100500);
        Accumulator acmMns = new Accumulator(23.0, new Minus());
        acmMns.accumulate(100700);
        Accumulator acmDvd = new Accumulator(23.0, new Divide());
        acmDvd.accumulate(100700);
        Accumulator acmMltp = new Accumulator(23.0, new Multiply());
        acmMltp.accumulate(100700);
        oSum = acm.getValue() + acmMns.getValue() + acmDvd.getValue() + acmMltp.getValue();
        System.out.print("" + oSum);
    }
}
