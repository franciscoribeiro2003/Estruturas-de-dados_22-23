import java.util.Scanner;

class test_ED239 {
  public static void main(String[] args){
    Scanner stdin=new Scanner(System.in);
    BTree<Integer> t=LibBTree.readIntTree(stdin);
    //System.out.println(t.count());
    System.out.println("t2:  " + "   == 1  "  + t.level(2));
    System.out.println("t3:  " + "   == 2  "  + t.level(5));
    System.out.println("t4:  " + "   == -1  " + t.level(1) );
    System.out.println("t5:  " + "   == 0  "  + t.level(3) );

  }

}
