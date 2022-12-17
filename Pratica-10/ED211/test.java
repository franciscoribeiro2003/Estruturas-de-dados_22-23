import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(stdin);
        System.out.println(ED211.countEven(t));


        
    }
    
}
