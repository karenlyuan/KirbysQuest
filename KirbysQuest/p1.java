import java.io.File;
import java.util.Scanner;

public class p1 {
	
	private static int rows, cols;
	private static int rooms;
	
	static Scanner scanner;
	static File fMap = new File("Map1Route");
	static File fRoute = new File("Map1Route");

	public static void main(String[] args) {
		
		/* two output formats
		 * 
		 * FIRST
		 * 1) original maze setup
		 * 2) route that Kirby takes (+)
		 * 
		 * SECOND (coordinate-based system)
		 * only include locations of the route in the order at which Kirby travels (to get to the cake)
		 * 
		 * - if solution does not exist, print "The cake is a lie."
		 * - for both inputs, use a scanner --> for output use a standard system.out command
		 * 
		 */
		
		
		System.out.println("Map based:");
		mapBased(scanner);
		System.out.println();
		System.out.println("Coordinate based:");
		coordinateBased(scanner);
	}
	
	
		public static void mapBased(Scanner scan) {
			try {
				scan = new Scanner(fMap);
				
				int rows = scan.nextInt();
				int cols = scan.nextInt();
				int rooms = scan.nextInt();
				
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
		
		
		public static void coordinateBased(Scanner scan) {
//			scan.nextLine();
//			
//			while(scanner.hasNextLine()) {
//				Integer.valueOf(rows);
//				scan.next();
//			}
			
			try {
				//code that might throw a special error
				scan = new Scanner(fRoute);
				
				//use next methods to grab the first 3 numbers
				//from the file for your map info
				
				int rows = scan.nextInt();
				int cols = scan.nextInt();
				int rooms = scan.nextInt();
				
				//System.out.println("rows: "+rows+" cols: "+cols+" rooms: "+rooms);
				// rows: 4 cols: 4 rooms: 1
				
				String[][] cMap = new String[rows][cols];
				
				int count = 0;
				
				for(int r=0; r<rows; r++) {
					for(int c=0; c<cols; c++) {
//						String line = scan.nextLine();
//						if(scan.hasNext("+")) {
//							System.out.println("+"+" "+r+" "+c);
//						}
						
						//String line = scan.nextLine();
						//System.out.println(line.charAt(c)+" "+r+" "+c);
						cMap[r][c] = String.valueOf(scan.next());
						System.out.println(cMap[r][c]+" "+r+" "+c);
						if(scan.next() == "C") {
							count++;
						}
					}
					
					scan.nextLine();
					
					}
				
//				while(scan.hasNextLine()) {
//					String line = scan.nextLine();
//					
//					String num = line.charAt(2)+"";
//					
//					//use charAt to grab the element of the map for a given row
//					System.out.println(line);
//					System.out.println(line.charAt(1));
//					
//				}
				
//				for(int i=0; i<rows; i++) {
//					for(int j=0; j<cols; j++) {
//						if(scan.next() == "+") {
//							//set first column first row a "+" sign and its coordinates
//							System.out.print("+ " + i + " " + j);
//						} else if(scan.next() != "+") {
//							System.out.print(cMap[i][j] + " " + i + " " + j);
//						}
//					}
//					
//					System.out.println();
//					scan.nextLine();
//					
//				}
				
				if(count != 1) {
					System.out.println("The cake is a lie.");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
	}
}
		


	/* private static char[] charAt(int i) {
		if(i < 0 || i > rows) {
			throw new StringIndexOutOfBoundsException(i);
		}
		return rows[i];
	} */
