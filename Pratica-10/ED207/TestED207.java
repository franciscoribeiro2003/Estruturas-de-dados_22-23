public class TestED207{
    
    public static void main(String[] args){

        // Ler arvore de inteiros em preorder
        BTNode<Integer> n2 = new BTNode<Integer>(5, null, null);
        BTNode<Integer> n11 = new BTNode<Integer>(3, null, null);
        BTNode<Integer> direita = new BTNode<Integer>(4, n11, n2);
        BTNode<Integer> esquerda = new BTNode<Integer>(1, null, null);
        BTNode<Integer> n = new BTNode<Integer>(2, esquerda,direita);
        BTree<Integer> t = new BTree<>();
        t.setRoot(n);
        
        t.printPreOrder();
        
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("Nivel 1 = " + t.nodesLevel(0));
        System.out.println("Nivel 1 = " + t.nodesLevel(1));
        System.out.println("Nivel 2 = " + t.nodesLevel(2));
        
    }
}


/*

t:

     2
    / \
   1   4
      / \
     3   5

 */