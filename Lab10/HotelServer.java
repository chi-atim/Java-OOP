import java.io.*;
import java.net.*;

public class HotelServer {
	
	final int PORT = 1181;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private Hotel hotel = new Hotel();
	
	public static void main(String[] args) throws IOException{
		(new HotelServer()).runServer();
	}
	public void runServer() {
		try {
			server = new ServerSocket(PORT);
			System.out.println("Waiting for client to connect . . . ");
			while (true){
				Socket s = server.accept();
				in = new DataInputStream(s.getInputStream());
				out = new DataOutputStream(s.getOutputStream());
				System.out.println("Client connected.");
				out.writeUTF("Welcome to our hotel!");
				out.flush();
				Thread t = new Thread(new ClientHandler(s));
				t.start();
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
/*****************************************************************************/
	public class ClientHandler implements Runnable {
		private Socket s;
		private String name = "default";

		public ClientHandler(Socket s) {
			this.s = s;
		}
		public void run() {
			try {
				try{
					doService();
				}finally { s.close();}
			}catch(IOException e){
		         e.printStackTrace();
			}
		}
		public void doService() throws IOException{
			while(true) {
				String command = in.readUTF();
				if (command.equals("QUIT")) {
					out.writeUTF("Closing Connection");
					System.out.println("\nClosing Connection");
					return;
				} else
		            executeCommand(command);
			}
		}
		public void executeCommand(String command) throws IOException {
						
			if (command.equals("USER")){
				String oldName = name;
				name = in.readUTF();
				out.writeUTF("Hello, " + name);
				for(int i=0; i< hotel.getReservInfoMay().size();i++) {
					if (hotel.getReservInfoMay().get(i).equalsIgnoreCase(oldName)){
						hotel.getReservInfoMay().set(i, name);
					}
				}
				System.out.println("\nClient's name: " + name);   
			}else if (command.equals("RESERVE")){
				int firstDay = in.readInt();
				int lastDay = in.readInt();
				out.writeUTF(hotel.makeReservation(name, firstDay, lastDay));
				System.out.println(name + " made a reservation"); 
			}else if(command.equals("CANCEL")){
				out.writeUTF(hotel.cancelReservation(name));
				System.out.println("\n" + name + " canceled reservation");
			}else if(command.equals("STATUS")){
				out.writeUTF(hotel.reservationInformation());
			}else{
				out.writeUTF("Invalid command: Closing Connection");
				out.flush();
				return;
			}
			out.flush();
		}
	}
}	