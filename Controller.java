import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Controller {

	View view;
	TripleDES tDES;
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	OutputStreamWriter oStreamWriter;
	PrintStream printStream;
	InputStreamReader iStreamReader;
	PrintWriter printWriter;
	BufferedReader buffReader;
	
	Controller(Socket s){
		socket = s;
		initialize();
	}
	
	private void initialize(){
		try {
		  view = new View(this);
		  tDES = new TripleDES("k2J23hSd", "9aldhk23", "5ak6s2dg");
		  inputStream = socket.getInputStream();
		  outputStream = socket.getOutputStream();
		  oStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.ISO_8859_1.newEncoder());
		  printStream = new PrintStream(outputStream);
		  printWriter = new PrintWriter(oStreamWriter);
		  iStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1.newDecoder());
		  buffReader = new BufferedReader(iStreamReader);
	    new Thread(view).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String s){
		printWriter.println(tDES.encrypt(s));
		System.out.println(tDES.encrypt(s));
		
		printWriter.flush();
	}
	
	public void listen(){
			try{
				String s = buffReader.readLine();
				System.out.println(s);
				view.displayMessage(tDES.decrypt(s));
			}	catch (Exception e){
				e.printStackTrace();
			}
	}
	
}
