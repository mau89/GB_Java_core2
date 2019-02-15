import swing.Message;
import swing.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientHandler {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);
    private final Thread handleThread;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final ChatServer server;
    private final String username;
    private final Socket socket;

    public ClientHandler(String username, Socket socket, ChatServer server) throws IOException {
        this.username = username;
        this.socket = socket;
        this.server = server;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        Matcher matcher = MESSAGE_PATTERN.matcher(msg);
                        if (matcher.matches()){
                        String userTo = matcher.group(1);
                        String msg1 = matcher.group(2);
                        System.out.println("Matcher1 "+userTo+" Matcher2 "+msg1);
                        System.out.printf("Message from user %s: %s%n", username, msg1);
                        // TODO реализовать прием сообщений от клиента и пересылку адресату через сервер
                        server.sendMessage(userTo,username,msg1);}

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("Client %s disconnected%n", username);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        handleThread.start();
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}