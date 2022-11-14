
public class ArrayListIntSet implements IntSet {
   private int size;   // Numero de elementos do conjunto
   private int elem[]; // Array que contem os elementos em si

   ArrayListIntSet(int maxSize) {
      elem = new int[maxSize];
      size = 0;
   }

   public boolean add(int x) {
      if (!contains(x)) {
         if (size == elem.length)
            throw new RuntimeException("Maximum size of set reached");
         elem[size] =  x;
         size++;
         return true;
      }
      return false;
   }

   public boolean remove(int x) {
      if (contains(x)) {
         int pos = 0;
         while (elem[pos] != x) pos++;
         size--;
         elem[pos] = elem[size]; // Trocar ultimo elemento
         return true;            // com o que se removeu
      }
      return false;
   }

   public boolean contains(int x) {
      for (int i=0; i<size; i++)
         if (elem[i] == x)
            return true;
      return false;
   }

   public void clear() {
      size = 0;
   }

   @Override
   public String toString() {
      String res = "{";
      for (int i=0; i<size; i++) {
         if (i>0) res += ",";
         res += elem[i];
      }
      res += "}";
      return res;
   }

   @Override
   public int size() {
      return size;
   }



   public boolean equals(IntSet s){
     if (this.size==s.size()){
       for (int i=0;i<size;i++){
          if(this.contains(i)!=s.contains(i)) return false;
       }
     return true;
    }
    return false;
   }

   public IntSet intersection(IntSet s){
     IntSet output= new ArrayListIntSet(100);
     int x ,y;
     for (int i=0;i<this.size;i++) {
         x=this.elem[i];
         if(this.contains(x) && s.contains(x)) {
           output.add(x);}
     }
     return output;
   }


}
