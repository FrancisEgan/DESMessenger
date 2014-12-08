import java.net.*;

public class ClientMain {

	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 60007);
	 	  Controller controller = new Controller(socket);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
