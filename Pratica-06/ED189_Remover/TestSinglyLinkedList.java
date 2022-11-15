public class TestSinglyLinkedList {
    public static void main(String[] args) {

	SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

  list.addLast(5);
  list.addLast(2);
  list.addLast(4);
  list.addLast(6);
  list.addLast(8);
  list.addLast(10);
  //5 2 4 6 8 10
  System.out.println("Lista antes do remove " + list);
	list.remove(2);
	System.out.println("Lista depois do remove " + list);

    }
}
