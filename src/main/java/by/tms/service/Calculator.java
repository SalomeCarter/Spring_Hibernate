package by.tms.service;
import by.tms.entity.Operation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Calculator {
    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case SUM:
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case SUB:
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case MUL:
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case DIV:
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
        }
        return operation;

    }
}