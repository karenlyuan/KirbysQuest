import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Formats {
	
	private static int rows, cols;
	private static int rooms;
	private static int kX, kY; //kirby starting position coordinates
	
	static Scanner scanner;
	static File fMap = new File("Map1Route");
	static File fRoute = new File("Map1Route");
	static File Map1 = new File("Map1");
	
	public static int startX;
	public static int startY;
	
	public static String[][] map;
	public static int currX, currY;
		
	public Formats() {
		startX = Formats.startPositionX(Formats.scanner);
		startY = Formats.startPositionY(Formats.scanner);
	}
	
	public static int getRows() {
		return rows;
	}
	
	public static int getCols() {
		return cols;
	}
	
	public static int getRooms() {
		return rooms;
	}
	
	public static void fillMap(Scanner scan) {
		try {
			scan = new Scanner(Map1);
			
			rows = scan.nextInt();
			cols = scan.nextInt();
			map = new String[rows][cols];
			
			while(scan.hasNextLine()) {
				for(int r=0; r<rows; r++) {
					for(int c=0; c<cols; c++) {
						map[r][c] = String.valueOf(scan.next());
			}
				System.out.println();
				scan.nextLine();
				}
			}
		}
	 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getMap() {
		fillMap(scanner);
		return map;
	}
	
	public static int getCurrX() {
		return currX;
	}
	
	public static int getCurrY() {
		return currY;
	}
	
	public static void setCurrX(int x) {
		x = currX;
	}
	
	public static void setCurrY(int y) {
		y = currY;
	}
	
	
	public static void mapBased(Scanner scan, File file) {
		try {
			scan = new Scanner(file); //fMap - Map1Route
			
			rows = scan.nextInt();
			cols = scan.nextInt();
			rooms = scan.nextInt();
				
			System.out.println(rows+" "+cols+" "+rooms);
				
			String[][] map = new String[rows][cols];
				
			while(scan.hasNextLine()) {
				for(int r=0; r<rows; r++) {
					for(int c=0; c<cols; c++) {
						map[r][c] = String.valueOf(scan.next());
						System.out.print(map[r][c]+" ");
					}
					System.out.println();
					scan.nextLine();
				}
			}
				
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		
	public static void coordinateBased(Scanner scan, File file) {
//		scan.nextLine();
//			
//		while(scanner.hasNextLine()) {
//			Integer.valueOf(rows);
//			scan.next();
//		}
			
		try {
			//code that might throw a special error
			scan = new Scanner(file); //fRoute - Map1Route
				
			//use next methods to grab the first 3 numbers
			//from the file for your map info
				
			rows = scan.nextInt();
			cols = scan.nextInt();
			rooms = scan.nextInt();
				
			//System.out.println("rows: "+rows+" cols: "+cols+" rooms: "+rooms);
			// rows: 4 cols: 4 rooms: 1
				
			String[][] cMap = new String[rows][cols];
				
			int count = 0;
				
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
//					String line = scan.nextLine();
//					if(scan.hasNext("+")) {
//						System.out.println("+"+" "+r+" "+c);
//					}
						
					//String line = scan.nextLine();
					//System.out.println(line.charAt(c)+" "+r+" "+c);
					cMap[r][c] = String.valueOf(scan.next());
					System.out.println(cMap[r][c]+" "+r+" "+c);
					if(cMap[r][c] == "C") {
						count = 1;
					}
				}
					
				scan.nextLine();
					
				}
				
//			while(scan.hasNextLine()) {
//				String line = scan.nextLine();
//				
//				String num = line.charAt(2)+"";
//				
//				//use charAt to grab the element of the map for a given row
//				System.out.println(line);
//				System.out.println(line.charAt(1));
//					
//			}
				
//			for(int i=0; i<rows; i++) {
//				for(int j=0; j<cols; j++) {
//					if(scan.next() == "+") {
//						//set first column first row a "+" sign and its coordinates
//						System.out.print("+ " + i + " " + j);
//					} else if(scan.next() != "+") {
//						System.out.print(cMap[i][j] + " " + i + " " + j);
//					}
//				}
//					
//				System.out.println();
//				scan.nextLine();
//					
//			}
				
			if(!(count >= 1)) {
				System.out.println("The cake is a lie.");
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	public static int startPositionX(Scanner scan) {
		try {
			scan = new Scanner(Map1);
			
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int rooms = scan.nextInt();
				
			//System.out.println("rows: "+rows+" cols: "+cols+" rooms: "+rooms);
			// rows: 4 cols: 4 rooms: 1
				
			String[][] cMap = new String[rows][cols];
				
			int count = 0;
				
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					cMap[r][c] = String.valueOf(scan.next());
					if(cMap[r][c] == "K") {
						kX = r;
					}
				}
					
				scan.nextLine();
					
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return kX;
			
	}
	
	public static int startPositionY(Scanner scan) {
		try {
			scan = new Scanner(Map1);
			
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int rooms = scan.nextInt();
				
			//System.out.println("rows: "+rows+" cols: "+cols+" rooms: "+rooms);
			// rows: 4 cols: 4 rooms: 1
				
			String[][] cMap = new String[rows][cols];
				
			int count = 0;
				
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					cMap[r][c] = String.valueOf(scan.next());
					if(cMap[r][c] == "K") {
						kY = c;
					}
				}
					
				scan.nextLine();
					
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return kY;
			
	}
	
}
		
	/* private static char[] charAt(int i) {
		if(i < 0 || i > rows) {
			throw new StringIndexOutOfBoundsException(i);
		}
		return rows[i];
	} */
