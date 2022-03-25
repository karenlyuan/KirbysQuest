import java.util.ArrayList;
import java.util.Scanner;

public class Queue {
	
	private static ArrayList<Integer> enqueue;
	private static ArrayList<Integer> dequeue;
	
	private static boolean foundCake;
	
	private static boolean north;
	private static boolean south;
	private static boolean east;
	private static boolean west;
	
	public Queue() {
		enqueue = new ArrayList<Integer>();
		dequeue = new ArrayList<Integer>();
	}
	
	public static void add(ArrayList queue, int el) {
		queue.add(el);
	}
	
	public static void remove() {
		int temp = enqueue.get(0);
		enqueue.remove(0);
		add(dequeue, temp);
	}
	
	public static int dequeueRemove() {
		int temp = dequeue.get(0);
		dequeue.remove(0);
		return temp;
	}
	
	public static void enqueueTiles (int currentX, int currentY) {
		/*
		 * first of every two elements in queue
		 * is the x location
		 * second is the y location
		 */
		
		//enqueue Kirby's start position
		add(enqueue, currentX);
		add(enqueue, currentY);
		//dequeue start position
		remove();
		remove();
		
		//enqueue walkable tiles (., C) North, South, East, West
		north();
		south();
		east();
		west();
	}
	
	public static void algorithm() {
		enqueueTiles(Formats.startX, Formats.startY);
		
		while(!foundCake) {
			//dequeue next location (both x and y coordinates)
			remove();
			remove();
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
			enqueueTiles(Formats.getCurrX(), Formats.getCurrY());
		}
		
		if(foundCake) {
			printMapBased();
		}
		
	}
	
	public static void printMapBased() {
		int temp1; //removes top element in dequeue and returns number (first of every pair is x, second is y)
		int temp2;
		
		while(dequeue.size() > 0) {
			
			temp1 = dequeueRemove();
			temp2 = dequeueRemove();
			Formats.map[temp1][temp2] = "+";
		}
		
		//print out map with path
		try {
			//code that might throw a special error
			Scanner scan = new Scanner(p1.f); //fRoute - Map1Route
				
			for(int room=0; room<Formats.getRooms(); room++) {
				for(int r=0; r<Formats.getRows(); r++) {
					for(int c=0; c<Formats.getCols(); c++) {
//						String line = scan.nextLine();
//						if(scan.hasNext("+")) {
//							System.out.println("+"+" "+r+" "+c);
//						}
							
						//String line = scan.nextLine();
						//System.out.println(line.charAt(c)+" "+r+" "+c);
						Formats.map[r][c] = String.valueOf(scan.next());
						System.out.println(Formats.map[r][c]+" "+r+" "+c);
					}
						
					scan.nextLine();
						
					}
				}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void north() {
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY-1] == ".") {
			add(enqueue, Formats.startX);
			add(enqueue, Formats.startY-1);
			north = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY-1] == "C") {
			add(enqueue, Formats.startX);
			add(enqueue, Formats.startY-1);
			foundCake = true;
			north = true;
		}
	}
	
	public static void south() {
		if(Formats.startY < Formats.getRows()-1 && Formats.map[Formats.startX][Formats.startY+1] == ".") {
			add(enqueue, Formats.startX);
			add(enqueue, Formats.startY+1);
			south = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX][Formats.startY+1] == "C") {
			add(enqueue, Formats.startX);
			add(enqueue, Formats.startY+1);
			foundCake = true;
			south = true;
		}
	}
	
	public static void east() {
		if(Formats.startX < Formats.getCols()-1 && Formats.map[Formats.startX+1][Formats.startY]== ".") {
			add(enqueue, Formats.startX+1);
			add(enqueue, Formats.startY);
			east = true;
		}
		
		if(Formats.startY > 0 && Formats.map[Formats.startX+1][Formats.startY]== "C") {
			add(enqueue, Formats.startX+1);
			add(enqueue, Formats.startY);
			foundCake = true;
			east = true;
		}
	}
	
	public static void west() {
		if(Formats.startX > 0 && Formats.map[Formats.startX-1][Formats.startY]== ".") {
			add(enqueue, Formats.startX-1);
			add(enqueue, Formats.startY);
			west = true;
		}
		
		if(Formats.startX > 0 && Formats.map[Formats.startX-1][Formats.startY]== "C") {
			add(enqueue, Formats.startX-1);
			add(enqueue, Formats.startY);
			foundCake = true;
			west = true;
		}
	}
	
	
}
