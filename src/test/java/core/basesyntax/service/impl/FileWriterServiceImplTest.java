package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FileWriterServiceImplTest {
    private final FileWriterServiceImpl service = new FileWriterServiceImpl();

    @Test
    void createFile(@TempDir Path tempDir) throws Exception {
        Path file = tempDir.resolve("test.csv");
        String text = "type,fruit,quantity\nb,banana,200";
        service.write(text, file.toString());
        assertEquals(text, Files.readString(file));
    }

    @Test
    void createEmptyFile(@TempDir Path tempDir) throws Exception {
        Path file = tempDir.resolve("empty.csv");
        service.write("", file.toString());
        assertEquals("", Files.readString(file));
    }
}
