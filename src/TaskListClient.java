import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 4242);//criação de Socket de clt arranca servidor cliente na maquina local
        Scanner scan = new Scanner(System.in);

        while (true) {


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("You are the client, Please send a message to the server: ");
            String clientMessage = scan.nextLine();

            switch (clientMessage) {



                case "L":
                    out.write("L");
                    break;

                case "R":
                    out.write("R");
                    String newTask = scan.nextLine();
                    out.append(newTask);
                    break;

                case "Q":
                    out.write("Q");

                    out.flush();
                    in.close();
                    out.close();

                    String reponse = in.readLine();
                    System.out.println(reponse);

            }
        }
    }
}