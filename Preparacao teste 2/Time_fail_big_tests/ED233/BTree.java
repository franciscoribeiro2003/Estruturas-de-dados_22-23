// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   
   //--------------------------------------------------------------
   //ED233 Francisco Ribeiro

   // devolver a quantidade de nós internos da árvore.
   public int internal(){
      return internal(root);
   }

   private int internal(BTNode<T> n){
      if (n==null) return 0;
      if (n.getRight()==null && n.getLeft()==null) return 0;
      else if (n.getRight()==null && n.getLeft()!=null) return (1 + internal(n.getLeft()));
      else if (n.getLeft()==null && n.getRight()!=null) return (1 + internal(n.getRight()));
      return (1 + internal(n.getLeft()) + internal(n.getRight()));
   }


   //remover da árvore todos os nós com profundidade ≥d
   public void cut(int d){
      setRoot(cut(root,d)); 
   }

   private BTNode<T> cut(BTNode<T> n,int d){
      if (n==null) return n;
      if (d<=0) return null;
      if (d>depth()) return n;
      n.setLeft(cut(n.getLeft(), d-1));
      n.setRight(cut(n.getRight(), d-1));
      return (n);
   }

   //devolver um array [a,b] onde a é a quantidade máxima de nós num único nível de profundidade, e b é a quantidade de níveis com essa quantidade a de nós.
   public int[] maxLevel(){
     int a=maxNdL();
     int b=contatore(a, 0);
     int out[]={a,b};
     return out;

   }

   public int until(BTNode<T> n,int d){
      if (n==null) return 0;
      if (d==0) return 1;
      else if (d<0) return 0;
      return (1 + until(n.getRight(),d-1) + until(n.getLeft(),d-1));
   }

   public int level(BTNode<T> n,int d){
      return until(n,d)-until(n,d-1);
      
   }

   private int contatore(int max,int i){ 
     if (depth()==0 && root.getValue()!=null) return 1;
     if (i>depth()) return 0;
     if (max==level(root,i)) return 1 + contatore(max, i+1);
     return contatore(max, i+1);

      
   }

   private int maxNdL(){
   int max=0;
   if (depth()==0 && root.getValue()!=null) return 1;
   for (int i=1; i<=depth(); i++){
      if (level(root, i)>max) max=level(root, i);


   }
   return max;

   }




}
