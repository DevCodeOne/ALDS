
public class Test {

	public static void main(String [] args) throws Exception {
		Stack stack = new Stack();
		String s = "Hello World";
		String s2 = "Top test";
		stack.push(s);
		stack.push(s2);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println("stack ist leer " + stack.empty());
		
		QueueAsTwoStacks queue = new QueueAsTwoStacks(); 
		
		queue.enqueue(s);
		queue.enqueue(s2);
		
		System.out.println(queue.front());
		queue.dequeue();
		System.out.println(queue.front());
		queue.dequeue();
		System.out.println("queue ist leer " + queue.empty());
	}
}
