import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException
	{
		ServerSocket server = new ServerSocket(3000);
		System.out.println("Server started");
		Socket socket = server.accept();
		System.out.println("Client connected");
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			String receive = dis.readUTF();
			System.out.println(receive);
			String binary =  Integer.toBinaryString(Integer.valueOf(receive));
			dos.writeUTF(binary);
			dos.flush();
		}
		
	}
}
