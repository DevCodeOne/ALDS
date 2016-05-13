public class ListNodeDL {

	private int key; 
	private ListNodeDL next; 
	private ListNodeDL prev;
	
	public ListNodeDL(int key, ListNodeDL prev, ListNodeDL next) {
		this.key = key; 
		this.next = next; 
		this.prev = prev;
	}
	
	public ListNodeDL() {
		this(0, null, null);
	}

	public int getKey() { return key; }

	public void setKey(int key) { this.key = key; }

	public ListNodeDL getNext() { return next; }

	public void setNext(ListNodeDL next) { this.next = next; }

	public ListNodeDL getPrev() { return prev; }

	public void setPrev(ListNodeDL prev) { this.prev = prev; }
}
