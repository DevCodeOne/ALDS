
public class QueueAsTwoStacks implements Queue {

	private Stack stack_one;
	private Stack stack_two; 
	
	public QueueAsTwoStacks() {
		stack_one = new Stack();
		stack_two = new Stack();
	}
	
	@Override
	public Queue enqueue(Object x) throws QueueOverflowException {
		try {
			stack_one.push(x);
		} catch (StackOverflowException e) {
			e.printStackTrace();
			throw new QueueOverflowException();
		}
		return this;
	}

	@Override
	public Queue dequeue() throws QueueUnderflowException {
		try {
			while(!stack_one.empty()) {
				stack_two.push(stack_one.top());
				stack_one.pop();
			}
			stack_two.pop(); 
			
			while(!stack_two.empty()) {
				stack_one.push(stack_two.top());
				stack_two.pop();
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			e.printStackTrace();
			throw new QueueUnderflowException();
		}
		return this;
	}

	@Override
	public Object front() throws QueueUnderflowException {
		Object x = null;
		try {
			while(!stack_one.empty()) {
				stack_two.push(stack_one.top());
				stack_one.pop();
			}
			x = stack_two.top();
			
			while(!stack_two.empty()) {
				stack_one.push(stack_two.top());
				stack_two.pop();
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			e.printStackTrace();
			throw new QueueUnderflowException();
		}
		return x;
	}

	@Override
	public boolean empty() {
		return stack_one.empty();
	}

}
