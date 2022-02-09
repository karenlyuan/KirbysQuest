import java.io.File;
import java.util.Scanner;

public class p1 {
	
	private static int rows, cols;
	private static int rooms;

	public static void main(String[] args) {
		
		Scanner scanner;
		File f = new File("Map1");
		
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
		
		
		try {
			//code that might throw a special error
			scanner = new Scanner(f);
			
			//use next methods to grab the first 3 numbers
			//from the file for your map info
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int room = scanner.nextInt();
			
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
		
		public void coordinateBased(Scanner scan) {
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
	}

}
