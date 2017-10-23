package caveExplorer;

public class CaveRoom {

	private String description;
	private String directions;//tells which doors can be used
	private String contents;//symbol showing what is in the room
	private String defaultContents;//what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		// Arrays are instantiated with 'null' values;
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String describing the door and where it is
	 * There is a (passage) to (the North)
	 * There is a (passage) to (the East)
	 * If there are no doors that are not null, this sets directions to:
	 * "there is no way out. you are trapped in this room"
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i=0;i<doors.length;i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the"+
				toDirection(i)+". "+doors[i].getDetails()+"\n";
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
		}
	}
	
	public static String toDirection(int dir) {
		String[] direction = {"the North","the East","the South","the West"};
		return direction[dir];
	}
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDirections() {
		return directions;
	}


	public void setDirections(String directions) {
		this.directions = directions;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}

}