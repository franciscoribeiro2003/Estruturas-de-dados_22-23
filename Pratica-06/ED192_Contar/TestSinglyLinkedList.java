public class TestSinglyLinkedList {
    public static void main(String[] args) {

	SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
  list.addLast(200);
  list.addLast(42);
  list.addLast(200);
  list.addLast(42);
  list.addLast(9999);
  list.addLast(42);
  list.addLast(200);
  list.addLast(42);
  System.out.println("Lista antes " + list);
  System.out.println("COUNT 42:  " + list.count(42));
  System.out.println("COUNT 200:  " + list.count(200));
  System.out.println("COUNT 9999:  " + list.count(9999));
  System.out.println("COUNT 1:  " + list.count(1));
}
}
