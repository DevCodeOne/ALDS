
public class QueueAsArray implements Queue {

	public static final int QUEUE_SIZE = 20;
	
	Object object[]; 
	int len = 0;
	int front = 0;
	
	public QueueAsArray() {
		this.object = new Object[QUEUE_SIZE];
	}
	
	@Override
	public Queue enqueue(Object x) throws QueueOverflowException {
		if (len >= object.length) {
			throw new QueueOverflowException();
		}
		object[(front + len) % QUEUE_SIZE] = x;
		len++;
		return this;
	}

	@Override
	public Queue dequeue() throws QueueUnderflowException {
		if (len - 1 < 0) {
			throw new QueueUnderflowException();
		}
		object[front] = null; 
		front = (front + 1) % QUEUE_SIZE;
		len--;
		return this;
	}

	@Override
	public Object front() throws QueueUnderflowException {
		if (len - 1 < 0) {
			throw new QueueUnderflowException();
		}
		return object[front];
	}

	@Override
	public boolean empty() {
		return len == 0;
	}

	
}
