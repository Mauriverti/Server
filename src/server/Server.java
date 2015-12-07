package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author mauriverti
 */
public class Server {
    
    public static final Integer portEntrada = 8910;

    public static void main(String[] args) throws IOException {
        
        Socket client;
        try (ServerSocket server = new ServerSocket(portEntrada)) {
            client = server.accept();
            System.out.println("Conexao com o cliente:" + client.getInetAddress().getHostAddress());
            Scanner scanner = new Scanner(client.getInputStream());
            
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }   scanner.close();
            
            
            client.close();
        } catch(IOException ioE) {
            System.out.println("Problemas em criar socket, porta ocupada?");
        } catch(Exception e) {
            System.out.println("Problemas em criar socket");
        }
    }
}
