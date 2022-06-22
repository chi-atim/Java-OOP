import java.io.*;
import java.net.*;
import java.util.*;

public class HotelClient {
	
   public static void main(String[] args) throws IOException
   {
	  String user = "default";
      final int PORT = 1181;
      try (Socket s = new Socket("localhost", PORT)) {
    	  Scanner userInput = new Scanner(System.in);
	      InputStream instream = s.getInputStream();
	      OutputStream outstream = s.getOutputStream();
	
	      DataInputStream in = new DataInputStream(instream);
	      DataOutputStream out = new DataOutputStream(outstream);
	      
	      String response = in.readUTF();
	      System.out.println("Receiving: " + response);
	      
	      String menu = "\n1: Change Name\n"+
	                    "2: Make a Reservation\n"+
	                    "3: Cancel current Reservation\n"+
	                    "4: Show Reservation Status\n"+
	                    "5: Exit\n"+
	                    "Choose an option: ";
	      boolean done=false;
	      while (!done) {
	    	  int choice = -1;
	    	  while (choice<1 || choice>5) 
	    		  try {
	    	    	  System.out.print(menu);
	    			  choice = Integer.parseInt(userInput.nextLine());
	    		  } catch (Exception e){}
	    			  switch (choice) {
		    	  case 1:
		    		  System.out.print("Enter user:");
		    		  user = userInput.nextLine();
		    		  out.writeUTF("USER");
		    		  out.writeUTF(user);
		    		  out.flush();    		  
		    		  break;
		    	  case 2:
		    		  System.out.print("Enter first day (1-31):");
		    		  int first = Integer.parseInt(userInput.nextLine());
		    		  System.out.print("Enter last day:");
		    		  int last = Integer.parseInt(userInput.nextLine());
		    		  out.writeUTF("RESERVE");
		    		  out.writeInt(first);
		    		  out.writeInt(last);
		    		  out.flush();
		    		  break;
		    	  case 3:
		    		  out.writeUTF("CANCEL");
		    		  out.flush();	
		    		  break;
		    	  case 4:
		    		  out.writeUTF("STATUS");
		    		  out.flush();	
		    		  break;
		    	  case 5:
		    		  out.writeUTF("QUIT");
		    		  out.flush();
		    		  done=true;
	    	  }
	    	  System.out.println("\nReceiving: " + in.readUTF());	
	      }
      } catch(Exception e) {}
   }
}