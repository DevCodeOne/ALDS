package tree;

public class Stack {

	public static final int STACK_SIZE = 128;
	
	Object object[];
	int index = 0;
	
	public Stack() {
		this.object = new Object[STACK_SIZE];
	}
	
	public Stack push(Object object) throws StackOverflowException {
		if (index >= this.object.length) {
			throw new StackOverflowException();
		}
		
		this.object[index++] = object;
		return this;
	}
	
	public Stack pop() throws StackUnderflowException {
		if (index - 1 < 0) {
			throw new StackUnderflowException();
		}
		this.object[--index] = null; 
		return this;
	}
	
	public Object top() throws StackUnderflowException {
		if (index - 1 < 0) {
			throw new StackUnderflowException();
		}
		return this.object[index - 1];
	}
	
	public boolean empty() { return index == 0; }
}
