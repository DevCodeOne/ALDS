import java.util.Scanner;

public class Test {
	
	private static Scanner sc;

	public static void main(String [] args) throws Exception {
		sc = new Scanner(System.in);
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
		
		/*for (int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}
		
		for (int i = 0; i < 10; i++) {
			third(stack);
		}*/
		
	}
	
	public static void first(Stack s) throws Exception {
		s.push(read());
		write(s.top());
		s.pop();
		s.push(read());

	}

	public static void second(Stack s) throws Exception {
		write(s.top());
		s.pop();
		write(s.top());
		s.pop();
		s.push(read());
	}
	
	 public static void third(Stack s) throws Exception {
		 s.pop();
		 s.push(s.top());
		 write(s.top());
		 s.pop();
		 s.push(read());
	 }
	
	 public static void write(Object o) {
		 System.out.print(o);
	 }
	
	 public static Object read() {
		 return sc.next();
	 }
}
