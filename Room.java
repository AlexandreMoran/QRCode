package ie.itsligo.roomroute;

//import java.util.StringTokenizer;

public class Room {
	//private String room;

	public Room() {
		
	}
	
	public String get(String data)
	{
		System.out.println("The string is " + data); //
		String[] parts = data.split("\n");
		String room = parts[3].replace("Room: ","");
		return(room);
	}

}
