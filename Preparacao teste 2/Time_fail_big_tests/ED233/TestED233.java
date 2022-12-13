import java.util.Scanner;
class TestED233{

    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);

        //teste internal---------------------------------
        /*
        BTree<Integer> t = LibBTree.readIntTree(stdin);
        System.out.println("internal: " + t.internal());


        //Teste cut---------------------------------------
        BTree<Integer> t2 = LibBTree.readIntTree(stdin);
        t2.printPreOrder();
        t2.cut(42);
        System.out.print("Para " + 42 + " ->  ");
        t2.printPreOrder();
        for (int i=3; i>=-1; i--){
            t2.cut(i);
            System.out.print("Para " + i + " ->  ");
            t2.printPreOrder();

        }
        */
        //-----------------------------------------------
        BTree<Integer> t3 =LibBTree.readIntTree(stdin);
        t3.printPreOrder();
        int out[]=t3.maxLevel();
        //for (int i=1;i<=t3.depth();i++) System.out.println("i= " + t3.level(t3.getRoot(),i));
        System.out.println("MaxLevel: " + out[0]);
        System.out.println("MaxLevel: " + out[1]);
    }
}