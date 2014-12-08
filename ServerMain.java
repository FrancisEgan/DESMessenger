import java.net.*;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		
		try {
			serverSocket = new ServerSocket(60007);
			socket = serverSocket.accept();
			serverSocket.close();
	 	  Controller controller = new Controller(socket);

	 	  
		} catch (Exception e){
			e.printStackTrace();
		}
	}


}