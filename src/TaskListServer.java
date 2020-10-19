import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;

public class TaskListServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(4242);
        Socket clientSocket = serverSocket.accept();
        //tudo bloquado ate ser feita conexão e liberar o accept()
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//servidor envia informaçao ao cliente
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//servidor captura o que o cliente envia
        String command = in.readLine();
        out.println("Server: received command " + command);//escreve no cliente
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
