// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";
      }
      str += "}";
      return str;
   }
//----------------------------------------------------------//
//    Exercicios realizados por Francisco Ribeiro 2022      //
//----------------------------------------------------------//
// ED188
   public T get(int pos){
     T out;
     int index=0;
     Node<T> cur = first;
     while (cur!=null && index<=pos){
       if (index==pos){
         out=cur.getValue();
         return out;}
       cur=cur.getNext();
       index++;
     }
     return null;
   }
//ED189---------------------------------------------------------
   public T remove(int pos){
     Node<T> cur = first;
     T var=get(pos);
     int index=0;
     //---------------------
     if (pos==size-1){
     removeLast();
     return var;
     }
     //--------------------
     if (pos==0){
     removeFirst();
     return var;
     }
     //-------------------
     while (index<=pos && pos<size){
       if (index+1==pos){
         cur.setNext(cur.getNext().getNext());
         size--;
         return var;}
       cur=cur.getNext();
       index++;
   }
   return null;
   }
//ED190---------------------------------------------------------
   public SinglyLinkedList<T> copy(){
     SinglyLinkedList<T> list = new SinglyLinkedList<>();
     Node<T> cur = first;
     for (int i=0;i<size;i++){
       list.addLast(get(i));
       cur=cur.getNext();
     }
     return list;
   }
//ED191---------------------------------------------------------
   public void addPos(int pos, T elem){
      if (pos>0 && pos<size){
         Node<T> cur = first;
         size++;
         for (int i=0; i<pos-1;i++){
            cur=cur.getNext();
         }
         Node<T> next= new Node<T>(elem,cur.getNext());
         cur.setNext(next);
      }

      else if(pos==0){addFirst(elem);}
      else {addLast(elem);}
   }



   public void duplicate(){
     for(int i=0;i<size;i=i+2){
       addPos(i,get(i));
     }
   }

}
