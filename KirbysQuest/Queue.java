import java.util.ArrayList;

public class Queue {
	
	private ArrayList<Integer> enqueue;
	private ArrayList<Integer> dequeue;
	
	public Queue() {
		enqueue = new ArrayList<Integer>();
		dequeue = new ArrayList<Integer>();
	}
	
	public void add(int el) {
		enqueue.add(el);
	}
	
	public void remove() {
		int temp = enqueue.get(0);
		enqueue.remove(0);
		dequeue.add(temp);
	}
	
	public void algorithm() {
		//enqueue Kirby's start position
		add(p1.startPositionX(p1.scanner));
		//also add y value of Kirby's starting position!
		
		
	}
	
	
	
	
}
