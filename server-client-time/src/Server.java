import java.io.*;
import java.net.*;
import java.sql.Date;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(6666);  
        System.out.println("[SERVER] Server Start");
        Socket clientSocket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        System.out.println("[SERVER] client connected");

        while(true)
        {
            String request = (String) in.readObject();
            System.out.println(request);
            if(request != null)
            {
                out.writeObject(Long.toString(secondsBetween()));
            }
        }

    }


    public static long secondsBetween()
    {
        long seconds = System.currentTimeMillis()/1000;
        return seconds;
    }
}
