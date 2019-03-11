import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HttpClient {
    static  String hostname;
    static  int PORT;
    static  String command;
    static String path;

    public static void main(String[] args)
    {

        Socket socket=null;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;


        System.out.println("enter input as: Hostname port command path");
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();
        String[] in= input.split(" ");
        hostname = in[0];
        PORT =Integer.parseInt(in[1]);
        command = in[2];
        path =in[3];
        try {
            socket = new Socket(hostname,PORT);
            System.out.println("Connected");
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(command+" "+path);
             String s= " ";
             inputStream = new DataInputStream(socket.getInputStream());
             while (!s.equals("end")) {
                 s= inputStream.readUTF();
                 System.out.println(s);
             }


        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }


    }
}
