package se.sveki.emaillistparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputFileHandlerTest {

    @Test
    void shouldWriteSimpleFileCorrectly() {
        List<String> inputFileLines = new ArrayList<>();
        inputFileLines.add("stefan.andersson@sveki.se");
        inputFileLines.add("stefan.andersson@appliedtechnology.se");
        List<String> expectedOutputFileLines = new ArrayList<>();
        expectedOutputFileLines.add("First name;Last name;Email");
        expectedOutputFileLines.add("Stefan;Andersson;stefan.andersson@sveki.se");
        expectedOutputFileLines.add("Stefan;Andersson;stefan.andersson@appliedtechnology.se");

        OutputFileHandler outputFileHandler = new OutputFileHandler(inputFileLines, "output.csv");
        outputFileHandler.createOutputLines();

        assertEquals(expectedOutputFileLines, outputFileHandler.getOutputFileLines());
    }
}