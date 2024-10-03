import java.io.IOException;
import java.nio.file.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String pathToFile = "C:/Programming/Java/Classwork/classwork_03.10/data.txt";
        List<Integer> numbers = Arrays.asList(54,12,76,3,12,49,4,11,98,1,12);

        try {
            FilterLines(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FindOftenNumber(numbers);
    }

    // practise 1
    public static void FilterLines(String pathToFile) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(pathToFile))) {
            lines.filter(line -> line.startsWith("А")).forEach(System.out::println);
        }
    }

    // practice 2
    public static void FindOftenNumber(List<Integer> numbers) {
        Integer mostOften = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        if (mostOften != null) {
            System.out.println("Самый частый элемент: " + mostOften);
        }
        else {
            System.out.println("Список пуст.");
        }
    }
}