public class DListTest {

	
	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(5);
		list.insert(3);
		list.insert(17);
		list.show();  //3 5 10 17 20
		System.out.println();
		list.reverse(); //20 17 10 5 3
		list.show();
		
		list.swap(new ListNodeDL(5,null,null), new ListNodeDL(10,null,null)); 
		System.out.println();
		list.show();//20 17 5 10 3
		
		
		list.swap(new ListNodeDL(10,null,null), new ListNodeDL(5,null,null));
		System.out.println();
		list.show();//20 17 10 5 3
		
		list.swap(new ListNodeDL(17,null,null), new ListNodeDL(5,null,null));
		System.out.println();
		list.show();//20 5 10 17 3
		
		list.swap(new ListNodeDL(17,null,null), new ListNodeDL(5,null,null));
		System.out.println();
		list.show();//20 17 10 5 3
		
		list.swap(new ListNodeDL(20,null,null), new ListNodeDL(3,null,null));
		System.out.println();
		list.show();//3 17 10 5 20
		
		list.swap(new ListNodeDL(20,null,null), new ListNodeDL(3,null,null));
		System.out.println();
		list.show();//20 17 10 5 3

		ListNodeDL mitte = list.showMiddle();
		if(mitte != null)
			System.out.println("\nMitte: "+ mitte.getKey()); //Mitte: 10
		
		System.out.println();
		
		list.reverse();
		list.show();//3 5 10 17 20

	}

}
