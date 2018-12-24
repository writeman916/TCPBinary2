import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static boolean isBinarySymmetry(String binary) {
		int numBinary = Integer.parseInt(binary);
		int temp = numBinary;
		int reverse = 0;
		while(temp != 0) {
			int tmp = temp % 10;
			reverse = reverse*10 + tmp;
			temp /= 10;
		}
		if(reverse == numBinary) {
			return true;
		}else
			return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost",3000);
		System.out.println("Server connected");
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		
		Scanner keyboard = new Scanner(System.in);
		boolean checker = true;
		while(checker) {
			System.out.println("Client: ");
			String send = keyboard.nextLine().trim();
			dos.writeUTF(send);
			dos.flush();
			keyboard = keyboard.reset();
			
			String receive = dis.readUTF().trim();
			System.out.println("Binary " + receive);
			if(isBinarySymmetry(receive)) {
				checker = false;
				System.out.println("Disconnect!");
			}
			
		}
	}

}
