public class TestED205{
    
    public static void main(String[] args){

        // Ler arvore de inteiros em preorder
        BTNode<Integer> n2 = new BTNode<Integer>(5, null, null);
        BTNode<Integer> n1 = new BTNode<Integer>(4, n2, null);
        BTNode<Integer> n22 = new BTNode<Integer>(2, null, null);
        BTNode<Integer> n = new BTNode<Integer>(3, n22, n1);
        BTree<Integer> t = new BTree<>();
        t.setRoot(n);
        
        t.printPreOrder();
        
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("E Binaria ? = " + t.strict());
        
    }
}