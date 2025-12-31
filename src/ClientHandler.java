import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

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
