
public class LinkedList {

	private ListNodeSL anchor; 
	
	public LinkedList() {
		this.anchor = null;
	}
	
	public ListNodeSL getFirst() throws ListEmptyException {
		if (isEmpty())
			throw new ListEmptyException();
		
		return anchor;
	}
	
	public boolean isEmpty() {
		return anchor == null;
	}
	
	public ListNodeSL getLast() throws ListEmptyException {
		if (isEmpty())
			throw new ListEmptyException();
		
		return getPrevious(null);
	}
	
	public ListNodeSL getNext(ListNodeSL node) {
		return node.getNext();
	}
	
	public ListNodeSL getPrevious(ListNodeSL node) {
		ListNodeSL curr = anchor; 
		while(curr.getNext() != node) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	public void insertLast(int key) {
		if (isEmpty()) {
			insertFirst(key);
		} else {
			try {
				getLast().setNext(new ListNodeSL(key, null));
			} catch(Exception e) {
				// passiert nicht
			}
		}
	}
	
	public void insert(int key) {
		ListNodeSL prev = null;
		ListNodeSL curr = anchor;
		
		if (isEmpty()) {
			insertFirst(key);
			return;
		}
		
		while(curr != null && curr.getKey() < key) {
			prev = curr;
			curr = curr.getNext();
		}	
		
		if (prev != null) {
			ListNodeSL nnode = new ListNodeSL(key, curr);
			prev.setNext(nnode);
		} else 
			insertFirst(key);
	}
	
	public void insertFirst(int key) {
		anchor = new ListNodeSL(key, anchor);
	}
	
	public void show1() {
		ListNodeSL curr = anchor;
		while(curr != null) {
			System.out.println("key -> " + curr.getKey());
			curr = curr.getNext();
		}
	}
	
	public void show2() {
		rec_show(anchor);
	}
	
	private void rec_show(ListNodeSL node) {
		System.out.println("key -> " + node.getKey());
		if (node.getNext() != null)
			rec_show(node.getNext());
	}
	
	public void dispose1() {
		anchor = null;
	}
	
	public void dispose2() {
		ListNodeSL curr = anchor;
		while(curr != null) {
			ListNodeSL next = curr.getNext(); 
			anchor.setNext(null); 
			anchor = next;
		}
	}
	
	public void delete4(int key) {
		ListNodeSL curr = anchor; 
		ListNodeSL prev = null;
		if (!isEmpty()) {
			if (curr.getKey() == key) {
				anchor = anchor.getNext();
				return;
			}
			
			do {
				prev = curr;
				curr = curr.getNext();
			} while (curr != null && curr.getKey() != key);
				
			if (curr != null) 
				prev.setNext(curr.getNext());
		}
	}
	
	public void delete5(int key) {
		if (!isEmpty()) {
			if (anchor.getKey() == key) {
				anchor = anchor.getNext();
				return;
			}
			delete_rec(anchor, key);
		}
	}
	
	private void delete_rec(ListNodeSL prev, int key) {
		if (prev != null && prev.getNext() == null) // wenn prev auf null checken
			return;
		
		if (prev.getNext().getKey() == key) {
			prev.setNext(prev.getNext().getNext());
			return;
		}
		delete_rec(prev.getNext(), key);
	}
	
	class ListEmptyException extends Exception {
		
		public ListEmptyException() {
			super("Liste ist leer");
		}
	}
}
