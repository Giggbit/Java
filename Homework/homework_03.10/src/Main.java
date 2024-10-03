import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/todos";

        try {
            String jsonResponse = getJsonResponse(url);
            List<Todo> todos = parseJsonToObjects(jsonResponse);
            List<Todo> completedTodos = todos.stream()
                    .filter(Todo::isCompleted)
                    .collect(Collectors.toList());

            completedTodos.forEach(System.out::println);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonResponse(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        return content.toString();
    }

    public static List<Todo> parseJsonToObjects(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, new TypeToken<List<Todo>>() {}.getType());
    }

}
