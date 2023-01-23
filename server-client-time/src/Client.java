import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Client {
    public static void main(String[] args) throws Exception {

        try{      
            Socket s=new Socket();  
            s.connect(new InetSocketAddress("localhost", 6666), 1000);
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            Scanner scan = new Scanner(System.in);     

            while (true) {
                try{
                    String command = scan.nextLine();
                    outputStream.writeObject(command);
                    String response = (String) in.readObject();
                    System.out.println(response);
                }
                catch(SocketTimeoutException e)
                {
                    System.out.println("timeout");
                }

            }

        }
        catch(Exception e){System.out.println(e);}  

            
    }

    public void sendData() {
        
    }
    
}
