import java.util.ArrayList;
import java.util.Scanner;

public class OptimalPath {

	/*
	 * approach: find x and y coordinates of Kirby and Cake location
	 * and compare the x and y coordinates
	 * move horizontally (avoiding barriers like "@") until reaching column
	 * of the cake and then move verically (avoiding "@") until reaching the row
	 * of cake --> reached cake
	 */
	
	private static int kirbyX, kirbyY;
	private static int cakeX, cakeY;
	
	private static ArrayList<Integer> path;
	
	public OptimalPath() {
		kirbyX = Formats.startX;
		kirbyY = Formats.startY;
		
		path = new ArrayList<Integer>();
	}
	
	public static void algorithm() {
		
		for(int r=0; r<Formats.getRows();r++) {
			for(int c=0; c<Formats.getCols(); c++) {
				if(Formats.map[r][c] == "C") {
					cakeX = r;
					cakeY = c;
				}
			}
		}
		
		while(kirbyX <= cakeX) {
			kirbyX+=1;
			add(kirbyX);
			add(kirbyY);
		}
		
		while(kirbyX >= cakeX) {
			kirbyX-=1;
			add(kirbyX);
			add(kirbyY);
		}
		
		while(kirbyY <= cakeY) {
			kirbyY+=1;
			add(kirbyY);
			add(kirbyX);
		}
		
		while(kirbyY >= cakeY) {
			kirbyY-=1;
			add(kirbyY);
			add(kirbyX);
		}
		
		printMapBased();
		
	}
	
	public static void printMapBased() {
		
		int indexX = 0;
		int indexY = 1;
		
		while(path.size() > 0) {
			Formats.map[indexX][indexY] = "+";
			indexX+=2;
			indexY+=2;
		}
		
		//print out map with path
		try {
			//code that might throw a special error
			Scanner scan = new Scanner("Map1"); //fRoute - Map1Route
				
			for(int r=0; r<Formats.getRows(); r++) {
				for(int c=0; c<Formats.getCols(); c++) {
					System.out.println(Formats.map[r][c]+" "+r+" "+c);
				}
							
				scan.nextLine();
							
				}
						
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void add(int el) {
		path.add(el);
	}
}
