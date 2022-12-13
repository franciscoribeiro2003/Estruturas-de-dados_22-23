import java.util.Scanner;

public class ED164{
    public static void main(String[] args) {
      BSTree<String> t = new BSTree<String>();
      Scanner stdin = new Scanner(System.in);
      int n = stdin.nextInt();
      while(n>0){
        String linha=stdin.next();
        t.insert(linha);
        n--;
      }
    System.out.println(t.numberNodes());
    }
}