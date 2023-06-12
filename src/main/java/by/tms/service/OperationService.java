package by.tms.service;

import by.tms.storage.OperationStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    private final OperationStorage operationStorage;

    public OperationService(OperationStorage operationStorage) {
        this.operationStorage = operationStorage;
    }

    public double calculate(CalculatorOperation operation) {
        operation.process();
        operationStorage.save(operation);
        return operation.getFinalResult();
    }

    public List<CalculatorOperation> findAllByUsername(String username) {
        return operationStorage.findAllByUsername(username);
    }
}
