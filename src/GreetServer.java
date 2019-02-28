import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void start(int port) {
        try {
			serverSocket = new ServerSocket(port);	//Lado del servidor.
            System.out.println("Servidor en funcionamiento...");
			clientSocket = serverSocket.accept();   //devuelve la referencia al socket del cliente.
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
            	out.println("Hola soy el servidor 58");
            }
            else {
                out.println("unrecognised greeting");
            }
            this.stop();
 		} catch (IOException e) {
            System.out.println("Error en Server...");
		}  
    }
 
    public void stop() {
        try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
    		GreetServer server=new GreetServer();
    		server.start(6666);
    }
}