package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import core.basesyntax.model.FruitTransaction;

public class OperationStrategyImplTest {
    @Test
    void getHandler_shouldReturnCorrectHandler() {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        OperationHandler expected = new SupplyOperation();
        map.put(FruitTransaction.Operation.SUPPLY, expected);
        OperationStrategy strategy = new OperationStrategyImpl(map);
        OperationHandler actual = strategy.getHandler(FruitTransaction.Operation.SUPPLY);
        assertEquals(expected, actual);
    }
}