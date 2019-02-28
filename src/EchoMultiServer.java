import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoMultiServer {
    private ServerSocket serverSocket;
 
    public void start(int port) {
        try {
			serverSocket = new ServerSocket(port);
			while (true)
			new EchoClientHandler(serverSocket.accept()).start();
		} catch (IOException e) {
            System.out.println("Error al arrancar...");
		}
    }
 
    public void stop() {
        try {
			serverSocket.close();
		} catch (IOException e) {
            System.out.println("Error al parar...");
		}
    }
 
    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        public EchoClientHandler(Socket socket) {
        this.clientSocket = socket;
        }
      
        public void run() {
            try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
				    if (".".equals(inputLine)) {
				        out.println("bye");
				        break;
				    }
				    out.println(inputLine);
				}
 
				in.close();
				out.close();
				clientSocket.close();
			} catch (IOException e) {
	            System.out.println("Error al correr...");
			}
    }
}
    
    
    public static void main(String[] args) {
		GreetServer server=new GreetServer();
		server.start(6666);
}
}