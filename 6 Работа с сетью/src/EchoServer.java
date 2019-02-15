import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;


public class EchoServer {
    // порт, который будет прослушивать наш сервер
    static final int PORT = 7777;
    private static int client_count = 0;
    private static ServerSocket serverSocket;
    // список клиентов, которые будут подключаться к серверу
    private static List<ClientConnected> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.print("Введите сообщение->");
                        while (!Thread.currentThread().isInterrupted() && scanner.hasNextLine()) {
                            String msg = scanner.nextLine();
                            Iterator<ClientConnected> iterator = clients.iterator();
                            while (iterator.hasNext()) {
                                ClientConnected connected1 = iterator.next();
                                try {
                                    connected1.Send(msg);
                                } catch (EOFException | SocketException e) {
                                    e.printStackTrace();
                                    iterator.remove();
                                }
                            }
                            System.out.print("Введите сообщение->");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен");
                clients.add(new ClientConnected(clientSocket));
                client_count++;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //отправляем сообщение всем клиентам
    public static void sendMessageToAllClients(String msg) throws IOException {
        for (ClientConnected o : clients) {
            o.Send(msg);
        }
    }

}

