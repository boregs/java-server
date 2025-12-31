import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import static java.nio.file.Files.newBufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("> Servidor Iniciado na porta: " + port);
            while (true) {
                Socket client = server.accept(); // Bloqueia até um cliente conectar

                System.out.println("> Cliente conectado: " + client.getInetAddress());

                new Thread(() -> {

                    try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                         String inputLine;

                        while ((inputLine = in.readLine()) != null) {

                            System.out.println("> Recebido do cliente: " + inputLine);

                            out.println("> Eco: " + inputLine);

                        }

                    } catch (IOException e) {

                        System.err.println("> Erro ao lidar com o cliente: " + e.getMessage());

                    } finally {

                        try {

                            client.close();

                        } catch (IOException e) {

                            e.printStackTrace();

                        }

                    }

                }).start();

            }

            }catch(IOException e){

            System.err.println("> Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}

