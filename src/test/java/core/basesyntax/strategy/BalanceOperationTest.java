package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

public class BalanceOperationTest {
    @Test
    void handle_shouldSetBalance() {
        Storage.getStorage().clear();
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 100);
        BalanceOperation operation = new BalanceOperation();
        operation.handle(transaction);
        assertEquals(100, Storage.getStorage().get("apple"));
    }
}
