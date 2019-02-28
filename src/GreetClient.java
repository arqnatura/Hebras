import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void startConnection(String ip, int port) {
        try {
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e) {
            System.out.println("Servidor no encontrado...");
		} catch (IOException e) {
            System.out.println("Error en Server...");
		}
    }
 
    public String sendMessage(String msg) {
			String resp = null;
			try {
				out.println(msg);
				resp = in.readLine();
			} catch (IOException e) {
	            System.out.println("Error en cliente...");
			}
			return resp;
		}
 
 
    public void stopConnection() {
        try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
            System.out.println("Error en Server2...");
		}
    }


    public static void main(String[] args){
	   	GreetClient client = new GreetClient ();
    	client.startConnection("192.168.104.58", 6666); //47 SHEILA
    	String response = client.sendMessage("hello server");
    	System.out.println("Cliente :" + response);
	
    }

}