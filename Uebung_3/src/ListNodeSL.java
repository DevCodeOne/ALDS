
public class ListNodeSL {

	private int key; 
	private ListNodeSL next; 
	
	public ListNodeSL(int key, ListNodeSL next) {
		this.key = key; 
		this.next = next;
	}
	
	public ListNodeSL() {
		this(0, null);
	}
	
	public ListNodeSL getNext() {
		return next;
	}
	
	public void setNext(ListNodeSL next) {
		this.next = next;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
}
