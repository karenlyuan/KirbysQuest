public class p1 {
  
	public static void main(String[] args) {
		System.out.println("Map based:");
		Formats.mapBased(Formats.scanner, Formats.fMap);
		System.out.println();
		System.out.println("Coordinate based:");
		Formats.coordinateBased(Formats.scanner, Formats.fRoute);
		
		//print out queue route
		Queue.algorithm();
		
		//print out stack route
		Stack.algorithm();
		
		//print out optimal path route
		OptimalPath.algorithm();
		
	}

}
