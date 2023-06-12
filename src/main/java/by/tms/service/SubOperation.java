package by.tms.service;

import by.tms.entity.User;

public class SubOperation implements CalculatorOperation {
    private double num1;
    private double num2;
    private double result;
    private User author;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public void process() {
        this.result = num1 - num2;
    }

    @Override
    public double getFinalResult() {
        return this.result;
    }

    @Override
    public User getAuthor() {
        return this.author;
    }
}
