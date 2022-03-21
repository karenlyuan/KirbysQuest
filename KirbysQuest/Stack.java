import java.util.ArrayList;
import java.util.Scanner;

public class Stack {
	
	private static ArrayList<Integer> stackA;
	private static ArrayList<Integer> stackB;
	
	private static boolean foundCake;
	
	private static boolean north;
	private static boolean south;
	private static boolean east;
	private static boolean west;
	
	public Stack() {
		stackA = new ArrayList<Integer>();
		stackB = new ArrayList<Integer>();
	}
	
	public static void push(ArrayList stack, int el) {
		stack.add(el);
	}
	
	public static void pop() {
		int temp = stackA.get(stackA.size()-1);
		stackA.remove(stackA.size()-1);
		push(stackB, temp);
	}
	
	public static int stackBpop() {
		int temp = stackB.get(stackB.size()-1);
		stackB.remove(stackB.size()-1);
		return temp;
	}
	
	public static void stackATiles (int currentX, int currentY) {
		/*
		 * first of every two elements in queue
		 * is the x location
		 * second is the y location
		 */
		
		//stackA Kirby's start position
		push(stackA, currentX);
		push(stackA, currentY);
		//stackB start position
		pop();
		pop();
		
		//stackA walkable tiles (., C) North, South, East, West
		north();
		south();
		east();
		west();
	}
	
	public static void algorithm() {
		stackATiles(Formats.startX, Formats.startY);
		
		while(!foundCake) {
			//stackB next location (both x and y coordinates)
			pop();
			pop();
			if(north == true) {
				Formats.setCurrX(Formats.startX);
				Formats.setCurrY(Formats.startY-1);
			}
			else if(south == true) {
				Formats.setCurrX(Formats.startX);
				Formats.setCurrY(Formats.startY+1);
			}
			else if(east == true) {
				Formats.setCurrX(Formats.startX+1);
				Formats.setCurrY(Formats.startY);
			}
			else {
				Formats.setCurrX(Formats.startX-1);
				Formats.setCurrY(Formats.startY);
			}
			stackATiles(Formats.getCurrX(), Formats.getCurrY());
		}
		
		if(foundCake) {
			printMapBased();
		}
		
	}
	
	public static void printMapBased() {
		int temp1; //pops top element in stackB and returns number (first of every pair is x, second is y)
		int temp2;
		
		while(stackB.size() > 0) {
			
			temp1 = stackBpop();
			temp2 = stackBpop();
			Formats.map[temp1][temp2] = "+";
		}
		
		//print out map with path
		try {
			//code that might throw a special error
			Scanner scan = new Scanner("Map1"); //fRoute - Map1Route
				
			for(int r=0; r<Formats.getRows(); r++) {
				for(int c=0; c<Formats.getCols(); c++) {
//					String line = scan.nextLine();
//					if(scan.hasNext("+")) {
//						System.out.println("+"+" "+r+" "+c);
//					}
						
					//String line = scan.nextLine();
					//System.out.println(line.charAt(c)+" "+r+" "+c);
					Formats.map[r][c] = String.valueOf(scan.next());
					System.out.println(Formats.map[r][c]+" "+r+" "+c);
				}
					
				scan.nextLine();
					
				}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void north() {
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY-1] == ".") {
			push(stackA, Formats.startX);
			push(stackA, Formats.startY-1);
			north = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY-1] == "C") {
			push(stackA, Formats.startX);
			push(stackA, Formats.startY-1);
			foundCake = true;
			north = true;
		}
	}
	
	public static void south() {
		if(Formats.startY < Formats.getRows()-1 && Formats.map[Formats.startX][Formats.startY+1] == ".") {
			push(stackA, Formats.startX);
			push(stackA, Formats.startY+1);
			south = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY+1] == "C") {
			push(stackA, Formats.startX);
			push(stackA, Formats.startY+1);
			foundCake = true;
			south = true;
		}
	}
	
	public static void east() {
		if(Formats.startX < Formats.getCols()-1 && Formats.map[Formats.startX+1][Formats.startY]== ".") {
			push(stackA, Formats.startX+1);
			push(stackA, Formats.startY);
			east = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX+1][Formats.startY]== "C") {
			push(stackA, Formats.startX+1);
			push(stackA, Formats.startY);
			foundCake = true;
			east = true;
		}
	}
	
	public static void west() {
		if(Formats.startX > 0 && Formats.map[Formats.startX-1][Formats.startY]== ".") {
			push(stackA, Formats.startX-1);
			push(stackA, Formats.startY);
			west = true;
		}
		
		if(Formats.startX > 0 && Formats.map[Formats.startX-1][Formats.startY]== "C") {
			push(stackA, Formats.startX-1);
			push(stackA, Formats.startY);
			foundCake = true;
			west = true;
		}
	}
	
	
}
