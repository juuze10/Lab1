import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TaskListClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.0", 4242);//criação de Socket de clt arranca servidor cliente na maquina local
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("Q");
        String reponse = in.readLine();
        System.out.println(reponse);
        in.close();
        out.close();
        clientSocket.close();

    }
}
