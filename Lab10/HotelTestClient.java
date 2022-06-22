import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HotelTestClient {
	public static void main(String[] args) throws IOException {

		final int PORT = 1181;
		try (Socket s = new Socket("localhost", PORT)) {
			
			InputStream instream = s.getInputStream();
			OutputStream outstream = s.getOutputStream();

			DataInputStream in = new DataInputStream(instream);
			DataOutputStream out = new DataOutputStream(outstream);

			String response = in.readUTF();
			System.out.println("Receiving: " + response);

			String command = "";

			// Test "USER" command
			command = "USER Beyonce";
			out.writeUTF("USER");
			out.writeUTF("Beyonce");
			System.out.println("\nRequesting: " + command);
			out.flush();
			System.out.println("Receiving: " + in.readUTF());

			// Test "RESERVE" command
			command = "RESERVE 10 25";
			out.writeUTF("RESERVE");
			out.writeInt(10);
			out.writeInt(25);
			System.out.println("\nRequesting: " + command);
			out.flush();
			System.out.println("Receiving: " + in.readUTF());

			// Test "STATUS" command
			command = "STATUS";
			System.out.println("\nRequesting: " + command);
			out.writeUTF(command);
			out.flush();
			System.out.println("Receiving: " + in.readUTF());

			// Test "CANCEL" command
			command = "CANCEL";
			out.writeUTF(command);
			System.out.println("\nRequesting: " + command);
			out.flush();
			System.out.println("Receiving: " + in.readUTF());

			// Test "QUIT" command
			command = "QUIT";
			System.out.println("\nRequesting: " + command);
			out.writeUTF(command);
			out.flush();
			System.out.println("Receiving: " + in.readUTF());
		}
	}
}
