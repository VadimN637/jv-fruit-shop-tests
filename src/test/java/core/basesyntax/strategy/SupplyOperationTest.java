package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

import org.junit.jupiter.api.Test;

public class SupplyOperationTest {
    @Test
    void handle_shouldAddToBalance() {
        Storage.getStorage().clear();
        FruitTransaction balanceTx = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 100);
        new BalanceOperation().handle(balanceTx);
        FruitTransaction supplyTx = new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, "apple", 100);
        new SupplyOperation().handle(supplyTx);
        assertEquals(200, Storage.getStorage().get("apple"));
    }
}
