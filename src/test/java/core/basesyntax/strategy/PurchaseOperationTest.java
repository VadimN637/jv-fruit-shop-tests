package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

import org.junit.jupiter.api.Test;

public class PurchaseOperationTest {
    @Test
    void handle_shouldSubstractFromBalance() {
        Storage.getStorage().clear();
        FruitTransaction balanceTx = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 100);
        new BalanceOperation().handle(balanceTx);
        FruitTransaction purchaseTx = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "apple", 50);
        new PurchaseOperation().handle(purchaseTx);
        assertEquals(50, Storage.getStorage().get("apple"));
    }
}
