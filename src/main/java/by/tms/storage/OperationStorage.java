package by.tms.storage;

import by.tms.service.CalculatorOperation;

import java.util.List;

public interface OperationStorage {
    public void save(CalculatorOperation operation);
    public List<CalculatorOperation> findAll();
    List<CalculatorOperation> findAllByUsername(String username);
}
