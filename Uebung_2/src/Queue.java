public interface Queue {
	
	public Queue enqueue(Object x) throws QueueOverflowException;
	
	public Queue dequeue() throws QueueUnderflowException; 
	
	public Object front() throws QueueUnderflowException; 
	
	public boolean empty();
}
