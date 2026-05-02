package core.basesyntax.service.impl;

import org.junit.jupiter.api.Test;
import core.basesyntax.db.Storage;
import static org.junit.Assert.assertTrue;

public class ReportGeneratorServiceImplTest {
    private final ReportGeneratorServiceImpl report = new ReportGeneratorServiceImpl();

    @Test
    void createReport() {
        Storage.getStorage().clear();
        Storage.getStorage().put("banana", 200);
        Storage.getStorage().put("apple", 400);
        String actual = report.getReport();
        assertTrue(actual.contains("fruit,quantity"));
        assertTrue(actual.contains("apple,400"));
        assertTrue(actual.contains("banana,200"));
    }
}
