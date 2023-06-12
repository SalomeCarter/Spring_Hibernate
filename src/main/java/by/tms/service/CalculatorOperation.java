package by.tms.service;

import by.tms.entity.User;

public interface CalculatorOperation {
    void process();
    double getFinalResult();
    User getAuthor();
}
