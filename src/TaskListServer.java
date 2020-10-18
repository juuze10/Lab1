import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;

public class TaskListServer {
    ServerSocket serverSocket = new ServerSocket(4242);
    System.out.println("Servidor iniciado na porta 4242");
    Socket clientSocket;
    Socket clientSocket = serverSocket.accept();
    //tudo bloquado ate ser feita conexão e liberar o accept()




    
}
