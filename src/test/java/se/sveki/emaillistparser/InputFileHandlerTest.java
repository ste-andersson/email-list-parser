package se.sveki.emaillistparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class InputFileHandlerTest {

    private InputFileHandler inputFileHandler;

    @BeforeEach
    void setUp() throws Exception {
        // 1. Hämta testfilen från src/test/resources
        URL url = getClass().getClassLoader().getResource("testInput.txt");
        assertNotNull(url, "testInput.txt not found in src/test/resources");
        String filePath = Path.of(url.toURI()).toString();
        inputFileHandler = new InputFileHandler(filePath);
    }

    @Test
    void shouldReturnFirstEmailOfTestList() {
        assertEquals("stefan.andersson@sveki.se", inputFileHandler.getInputFileLines().get(0));
    }
}