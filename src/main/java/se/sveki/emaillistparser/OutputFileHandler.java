package se.sveki.emaillistparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OutputFileHandler {
    private final List<String> inputFileLines;
    private final List<String> outputFileLines = new ArrayList<>();
    private final String destinationPath;
    private static final String HEADER = "First name;Last name;Email";

    public OutputFileHandler(List<String> inputFileLines, String destinationPath) {
        this.inputFileLines = inputFileLines;
        this.destinationPath = destinationPath;
    }

    public void process() {
        createOutputLines();
        writeFile();
    }

    public void createOutputLines() {
        outputFileLines.add(HEADER);

        for (String inputFileLine : inputFileLines) {
            String email = inputFileLine.toLowerCase();
            String firstName = email.substring(0, email.indexOf("."));
            String lastName = email.substring(email.indexOf(".") + 1, email.indexOf("@"));
            outputFileLines.add(capitalize(firstName) + ";" + capitalize(lastName) + ";" + email);
        }
    }

    private String capitalize(String inputString) {
        switch (inputString.length()) {
        case 0:
            return "";
        case 1:
            return inputString.toUpperCase();
        default:
            return inputString.substring(0, 1).toUpperCase() + inputString.substring(1);
        }
    }

    private void writeFile() {
        try{
            Files.write(Path.of(destinationPath), outputFileLines);
        } catch (IOException e) {
            System.out.println("Output file destination is invalid");
        }
    }

    public List<String> getOutputFileLines() {
        return outputFileLines;
    }
}
