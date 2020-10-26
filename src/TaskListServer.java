import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskListServer {
    public static void main(String[] args) throws Exception {

        ArrayList<String> tasks = new ArrayList(); //lista com os dados do cliente

        ServerSocket serverSocket = new ServerSocket(4242);
        Socket clientSocket = serverSocket.accept(); //aceita ligação do cliente tudo bloquado ate ser feita conexão e liberar o accept()
        System.out.println("Client Connected!");

        while (true) {


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//servidor envia informaçao ao cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//servidor captura o que o cliente envia
            String command = in.readLine(); //captura da mensagem do cliente
            switch (command) {
                case "L":
                    String showList = Arrays.toString(tasks.toArray());
                    out.write(showList);
                    break;
                case "R":
                    String newTask = in.readLine();
                    if (newTask.length() <= 120) {
                        tasks.add(newTask);
                        out.println("Task added Succesfully!");
                    } else {
                        out.println("You entered more than 120 characters");
                    }
                    break;
                case "Q":
                    out.println("Server: received command " + command);//escreve no cliente
                    in.close();
                    out.flush();
                    out.close();
                    clientSocket.close();

                    if (clientSocket.isClosed() == true){
                        serverSocket.close();
                    }

                    break;

                default:
                    System.out.println("Invalid option, please try again");

            }

        }
    }}
