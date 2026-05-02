package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationTest {
    @Test
    void handle_shouldReturnToBalance() {
        Storage.getStorage().clear();
        FruitTransaction balanceTx = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 100);
        new BalanceOperation().handle(balanceTx);
        FruitTransaction returnTx = new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, "apple", 100);
        new SupplyOperation().handle(returnTx);
        assertEquals(200, Storage.getStorage().get("apple"));
    }
}
