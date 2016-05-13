public class DLinkedList {

	private ListNodeDL anchor; 
	
	public DLinkedList() {
		this.anchor = new ListNodeDL(0, null, null); 
		this.anchor.setNext(anchor);
		this.anchor.setPrev(anchor);
	}
	
	public void show() {
		ListNodeDL current = anchor.getNext(); 
		
		while(current != anchor) {
			System.out.print(current.getKey() + " ");
			current = current.getNext(); 
		}
	}
	
	public void dispose() {
		ListNodeDL current = anchor.getNext(); 
		
		while(current != anchor) {
			current.setPrev(null);
			current = current.getNext(); 
		}
		
		anchor.setNext(anchor);
		anchor.setPrev(anchor);
 	}
	
	public void insertFirst(int key) {
		ListNodeDL node = new ListNodeDL(key, anchor, anchor.getNext());
		anchor.getNext().setPrev(node);
		anchor.setNext(node);
	}
	
	public void insertLast(int key) {
		ListNodeDL node = new ListNodeDL(key, anchor.getPrev(), anchor);
		anchor.getPrev().setNext(node);
		anchor.setPrev(anchor);
	}
	
	public void insert(int key) {
		ListNodeDL current = anchor; 
		
		while (((current = current.getNext()) != anchor) && (key >= current.getKey()));
		
		ListNodeDL node = new ListNodeDL(key, current.getPrev(), current);
		current.getPrev().setNext(node);
		current.setPrev(node);
	}
	
	public void delete(int key) {
		ListNodeDL node = search(key);
		
		if (node != null) {
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
		}
	}
	
	public void reverse() {
		ListNodeDL current = anchor; 
		
		// set next pointer
		do {
			ListNodeDL prev = current.getPrev();
			current.setNext(prev);
			current = prev;
		} while(current != anchor);
		
		current = anchor; 
		
		// set prev pointer
		do {
			ListNodeDL next = current.getNext();
			next.setPrev(current);
			current = next;
		} while(current != anchor);
	}
	
	public ListNodeDL search(int key) {
		ListNodeDL current = anchor;
		while (((current = current.getNext()) != anchor) && (key != current.getKey())); 
		
		return current != anchor ? current : null;
	}
	
	public void swap(ListNodeDL node1, ListNodeDL node2) {
		ListNodeDL nnode1 = search(node1.getKey());
		ListNodeDL nnode2 = search(node2.getKey());
		
		if (nnode1 != null && nnode2 != null) {
			ListNodeDL n1prev = nnode1.getPrev(); 
			ListNodeDL n1next = nnode1.getNext(); 
			
			ListNodeDL n2prev = nnode2.getPrev(); 
			ListNodeDL n2next = nnode2.getNext();

			// wenn die zwei nodes direkt nebeneinander liegen müssen die elemente angepasst werden
			n1prev = n1prev != nnode2 ? n1prev : nnode1; 
			n1next = n1next != nnode2 ? n1next : nnode1;
			
			n2prev = n2prev != nnode1 ? n2prev : nnode2; 
			n2next = n2next != nnode1 ? n2next : nnode2;
			
			nnode1.setNext(n2next);
			nnode1.setPrev(n2prev);
			
			nnode2.setNext(n1next);
			nnode2.setPrev(n1prev);
			
			n2next.setPrev(nnode1);
			n2prev.setNext(nnode1);
			
			n1next.setPrev(nnode2);
			n1prev.setNext(nnode2);
		}
	}
	
	public ListNodeDL showMiddle() {
		ListNodeDL start = anchor; 
		ListNodeDL end = anchor; 
		
		while((start = start.getNext()) != (end = end.getPrev()));
		
		return start != anchor ? start : null; // wenn sie sich am anker treffen war die Liste gerade
	}
}
