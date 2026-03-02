package se.sveki.emaillistparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputFileHandler {

    private List<String> inputFileLines;

    public InputFileHandler(String filePath) {
        readFile(filePath);
    }

    private void readFile(String filePath) {
        try {
            this.inputFileLines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getInputFileLines(){
        return inputFileLines;
    }
}
