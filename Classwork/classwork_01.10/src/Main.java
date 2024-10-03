import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "file.txt";

        createAndWriteToFile(file);

        List<String> lines = readLinesFromFile(file);
        System.out.println("Before delete: " + lines);

        lines = removeRandomLine(lines);
        System.out.println("After delete: " + lines);

        writeLinesToFile(file, lines);
    }

    public static void createAndWriteToFile(String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for (int i = 0; i < 10; i++) {
                bw.write("Number: " + i);
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLinesFromFile(String file) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> removeRandomLine(List<String> lines) {
        Random random = new Random();
        int randomIndex = random.nextInt(lines.size());
        System.out.println("Удаляю строку: " + lines.get(randomIndex));
        lines.remove(randomIndex);
        return lines;
    }

    public static void writeLinesToFile(String file, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}