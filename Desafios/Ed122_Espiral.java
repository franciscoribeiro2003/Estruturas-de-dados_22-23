//ED122
import java.util.Scanner;

public class Ed122_Espiral{

  public static void main(String[] args){
    Scanner stdin = new Scanner(System.in);
    int n=stdin.nextInt();
    int x=0,y=0;
    int max_x=0, max_y=0;
    int min_x=0, min_y=0;
    int i=1;
    while (i<n){
      while (i<n && x<=max_x) {
        x++;
        i++;}
      max_x=x;
      while (i<n && y>=min_y) {
        y--;
        i++;}
      min_y=y;
      while (i<n && x>=min_x) {
        x--;
        i++;}
      min_x=x;
      while (i<n && y<=max_y) {
        y++;
        i++;}
      max_y=y;
    }
    System.out.println("("+x+","+y+")");
  }
}
