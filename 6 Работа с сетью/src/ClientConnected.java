import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnected {
    private Socket socket;
    //private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread thread;

    public ClientConnected(Socket socket) throws IOException {

            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()){
                        String msg = in.readUTF();
                        //System.out.println("message "+msg);
//                        out.writeUTF(msg);
//                        out.flush();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void Send(String msg) throws IOException {

        out.writeUTF(msg);
        out.flush();
    }

}

