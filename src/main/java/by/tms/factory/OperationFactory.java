package by.tms.factory;

import by.tms.entity.OperationType;
import by.tms.entity.User;
import by.tms.service.*;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {
    public CalculatorOperation getInstance(double num1, double num2, OperationType operationType, User author) {
        switch (operationType) {
            case SUM:
                SumOperation sumOperation = new SumOperation();
                sumOperation.setNum1(num1);
                sumOperation.setNum2(num2);
                sumOperation.setAuthor(author);
                return sumOperation;

            case DIV:
                DivOperation divOperation = new DivOperation();
                divOperation.setNum1(num1);
                divOperation.setNum2(num2);
                divOperation.setAuthor(author);
                return divOperation;
            case MUL:
                MulOperation mulOperation = new MulOperation();
                mulOperation.setNum1(num1);
                mulOperation.setNum2(num2);
                mulOperation.setAuthor(author);
                return mulOperation;
            case SUB:
                SubOperation subOperation = new SubOperation();
                subOperation.setNum1(num1);
                subOperation.setNum2(num2);
                subOperation.setAuthor(author);
                return subOperation;
        }
        throw new RuntimeException();
    }
}
