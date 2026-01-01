import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler implements Runnable {
    private Socket socket;

    // creating the thread pool
    ExecutorService service = Executors.newFixedThreadPool(1000);

    void Handler(Socket socket) {
        this.socket = socket;
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
