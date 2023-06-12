package by.tms.storage;

import by.tms.service.CalculatorOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationStorage implements OperationStorage {

    private final List<CalculatorOperation> history = new ArrayList<>();
    @Override
    public void save(CalculatorOperation operation) {
        history.add(operation);
    }

    @Override
    public List<CalculatorOperation> findAll() {
        return history;
    }

    public List<CalculatorOperation> findAllByUsername(String username) {
        List<CalculatorOperation> operations = new ArrayList<>();
        for (CalculatorOperation calculatorOperation : history) {
            if (calculatorOperation.getAuthor().getUsername().equals(username)) {
                operations.add(calculatorOperation);
            }
        }
        return operations;
    }
}
