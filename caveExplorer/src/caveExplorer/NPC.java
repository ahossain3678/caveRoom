package caveExplorer;

public class NPC {

	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There's someone in front of you press 'e' to talk";
		this.inactiveDescription = "You talked to this guy earlier";
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}

	public boolean isActive() {
		return active;
		
	}

	public void interact() {
		CaveExplorer.print("Hi! Type 'bye' to stop");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("Hi!");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Bye!");
		active = false;
		
	}

	public String getDescription() {
		
		return activeDescription;
	}

	public String getInactiveDescription() {
		
		return inactiveDescription;
	}

	public String getSymbol() {
		
		return "P";
	}

	public void setPosition(int row, int col) {
		if(row >= 0 && row < floor.length &&
				col >=  0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			
			currentRow = row;
			currentCol = col;
			// cast
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
		
	}

	public void autoMove() {
		if(active) {
			int[] move = calculateMove();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
		}
		
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int index = 
		return null;
	}

}