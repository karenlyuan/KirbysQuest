import java.io.File;
import java.util.Scanner;

public class p1 {
	
	private static int rows, cols;
	private static int rooms;

	public static void main(String[] args) {
		
		Scanner scanner;
		File f = new File("Map1");
		File fRoute = new File("Map1Route");
		
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
		
		System.out.println(f); //original maze setup
		System.out.println(fRoute); //route Kirby takes
		
		
		try {
			//code that might throw a special error
			scanner = new Scanner(fRoute);
			
			//use next methods to grab the first 3 numbers
			//from the file for your map info
			
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt();
			
			String[][] map = new String[rows][cols];
			
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					map[r][c] = scanner.next();
				}
				
				scanner.nextLine();
			}
			
			for(int i=0; i<rows; i++) {
				int count = 0;
				for(int j=0; j<cols; j++) {
					if(scanner.hasNext("+")) {
						//set first column first row a "+" sign and its coordinates
						System.out.println("+ " + i + " " + j);
					} else if(!scanner.hasNext("+")) {
						System.out.println();
					}
					if(scanner.hasNext("C")) {
						count++;
					}
				}
					
				scanner.nextLine();
				if(count != 1) {
					System.out.println("The cake is a lie.");
				}
				
			} //prints coordinate-based solution of Kirby's route
			
			scanner.nextLine(); //move scanner to next line
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String num = line.charAt(2)+"";
				
				//use charAt to grab the element of the map for a given row
				System.out.println(line);
				System.out.println(line.charAt(1));
				
				//be able to read in a map-based input in a way that each
				// element of the map is accessible in some easy way
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*public void coordinateBased(Scanner scan) {
			rows = scan.nextInt();
			cols = scan.nextInt();
			rooms = scan.nextInt();
			
			scan.nextLine();
			
			while(scanner.hasNextLine()) {
				Integer.valueOf(rows);
				scan.next();
			}
			
			
		}
		

	}

	private static char[] charAt(int i) {
		if(i < 0 || i > rows) {
			throw new StringIndexOutOfBoundsException(i);
		}
		return rows[i];
	} */

	}

}
