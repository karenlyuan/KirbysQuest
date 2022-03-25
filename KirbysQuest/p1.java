import java.io.File;
import java.util.Scanner;

public class p1 {
  
	public static void main(String[] args) {
		
		String str = args[args.length-1];
		File f = new File(str);
		Scanner scan = new Scanner(f);
		
		System.out.println("Map based:");
		Formats.mapBased(Formats.scanner, Formats.fMap);
		System.out.println();
		System.out.println("Coordinate based:");
		Formats.coordinateBased(Formats.scanner, Formats.fRoute);
		
		//print out queue route
		long queueStart = System.currentTimeMillis();
		Queue.algorithm();
		System.out.println("Total Runtime: " + String.valueOf(System.currentTimeMillis()-queueStart) + " seconds");
		
		//print out stack route
		long stackStart = System.currentTimeMillis();
		Stack.algorithm();
		System.out.println("Total Runtime: " + String.valueOf(System.currentTimeMillis()-stackStart) + " seconds");
		
		//print out optimal path route
		long optimalStart = System.currentTimeMillis();
		OptimalPath.algorithm();
		System.out.println("Total Runtime: " + String.valueOf(System.currentTimeMillis()-optimalStart) + " seconds");
		
	}

}
