public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      System.out.println(list);
      list.duplicate(2);
      System.out.println(list);
      
      SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
      SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>();
      int listaa[]={1,3,4,5};
      for (int i=2; i<=12; i=i+2)
        list2.addLast(i);
      System.out.println("Antes remove: " + list2 + "  size: " + list2.size());
      list3=list2.remove(listaa);
      System.out.println("Antes remove: " + list2 + "  size: " + list2.size());
      System.out.println("Depois remove: " + list3 + "  size: " + list3.size());
   }
}
