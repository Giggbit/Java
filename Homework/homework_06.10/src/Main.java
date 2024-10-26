import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> slowTask("Запрос к сервису", 3));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> slowTask("Чтение данных из файла", 2));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> slowTask("Вычисление в отдельном потоке", 1));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.thenRun(() -> {
            try {
                System.out.println("Результат 1: " + future1.get());
                System.out.println("Результат 2: " + future2.get());
                System.out.println("Результат 3: " + future3.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }

    public static String slowTask(String taskName, int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return taskName + " завершена через " + seconds + " секунд";
    }
}
