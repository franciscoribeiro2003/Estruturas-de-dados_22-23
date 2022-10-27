import java.util.*;
public class Pizza_ED243{



  public static void main(String[] args){
    Scanner stdin = new Scanner (System.in);
    int n = stdin.nextInt(); // ingredienti che a Mario non piacciono sulla pizza
    ArrayList<Integer> non_ingredienti = new ArrayList<>();
    for (int i=0;i<n;i++) {
      int cod = stdin.nextInt();
      non_ingredienti.add(cod);
    }
    //System.out.println("---------"+non_ingredienti);
    int p = stdin.nextInt(); // numero di pizze
    //System.out.println("---------"+p);
    int output= p,k,flag=0;
    for (int i=0;i<p;i++) {
      //System.out.println("......."+i);
      k = stdin.nextInt(); // numero di ingredienti in ogni pizza
      for (int j=0;j<k;j++){
        int b = stdin.nextInt(); // codi di ingredienti
        for (int l=0;l<non_ingredienti.size() ; l++) {
          if (non_ingredienti.get(l)==b) {
            flag=1;
          }
        }
      }
      if (flag==1){output-=1;flag=0;}
    }
    System.out.println(output);
  }
}
