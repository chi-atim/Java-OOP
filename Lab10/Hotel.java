import java.util.ArrayList;

public class Hotel {
	private ArrayList<String> reservInfoMay;

	public Hotel() {
		reservInfoMay = new ArrayList<String>();
		for (int i=0; i < 31 ; i++) {
			reservInfoMay.add(i, "vacancy");
		}
	}
	public ArrayList<String> getReservInfoMay() {
		return reservInfoMay;
	}
	public synchronized String makeReservation(String name, int firstDay, int lastDay) {
		String result = "";
		if(firstDay < 1 || lastDay > 31 || firstDay > lastDay) {
				result += "Check your dates!";
		}
		else if(contains(reservInfoMay, name)) {
			result += "You already have a reservation!";
		}
		else if(!isAvailable(reservInfoMay, firstDay, lastDay)) {
			result += "No vacancy";
		}
		else {
			for(int i = firstDay-1; i < lastDay; i++) {
				reservInfoMay.set(i, name);
			}
			result += "You've made a reservation from " + firstDay + " to " + lastDay;
		}
		return result;		
	}
	public boolean contains (ArrayList<String> list, String name) {
		for(String str: list) {
			if (str.equalsIgnoreCase(name)) 
				return true;			
		}
		return false;
	}
	public boolean isAvailable (ArrayList<String> list, int first, int last) {
		for(int i = first-1; i< last-1; i++) {
			if (!list.get(i).equals("vacancy")) 
				return false;
		}
		return true;
	}
	public synchronized String cancelReservation(String name) {
		String result = "";
		boolean check = false;
		int firstDay=31, lastDay=0;
		for(int i = 0; i< reservInfoMay.size();i++) {			
			if(reservInfoMay.get(i).equalsIgnoreCase(name)) {
				reservInfoMay.set(i, "vacancy");
				check = true;
				if (i+1 < firstDay) 
					firstDay = i+1;
				if (i+1 > lastDay) 
					lastDay = i+1;
			}
		}
		if(!check) {
			result += "You don't have a reservation!";
		}
		else {
			result += "Your reservation from "+ firstDay + " to " + lastDay + " is canceled.";
		}		
		return result;		
	}
	public String reservationInformation() {
		String result = "\n";
		for(int i = 0; i< reservInfoMay.size();i++) {
			result += i+1 + ": " + reservInfoMay.get(i) + "\n";
		}		
		return result;
	}
}
