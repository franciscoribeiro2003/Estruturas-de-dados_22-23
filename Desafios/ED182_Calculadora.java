//ED182
import java.util.*;

public class ED182_Calculadora{
  public static String num (int i, int j){
    String[] zero=new String[]{".##.","#..#","#..#","....","#..#","#..#",".##."};
    String[] um=new String[]{"....","...#","...#","....","...#","...#","...."};
    String[] dois=new String[]{".##.","...#","...#",".##.","#...","#...",".##."};
    String[] tres=new String[]{".##.","...#","...#",".##.","...#","...#",".##."};
    String[] quatro=new String[]{"....","#..#","#..#",".##.","...#","...#","...."};
    String[] cinco=new String[]{".##.","#...","#...",".##.","...#","...#",".##."};
    String[] seis=new String[]{".##.","#...","#...",".##.","#..#","#..#",".##."};
    String[] sete=new String[]{".##.","#..#","#..#","....","...#","...#","...."};
    String[] oito=new String[]{".##.","#..#","#..#",".##.","#..#","#..#",".##."};
    String[] nove=new String[]{".##.","#..#","#..#",".##.","...#","...#",".##."};

    if (i==1){
      return(um[j]);}
    else if (i==2){
        return(dois[j]);}
    else if (i==3){
        return(tres[j]);}
    else if (i==4){
        return(quatro[j]);}
    else if (i==5){
        return(cinco[j]);}
    else if (i==6){
        return(seis[j]);}
    else if (i==7){
        return(sete[j]);}
    else if (i==8){
        return(oito[j]);}
    else if (i==9){
        return(nove[j]);}
    else {return zero[j];}
  }

  public static void main(String[] args){
    Scanner stdin=new Scanner(System.in);
    int num=stdin.nextInt();
    ArrayList <Integer> nums= new ArrayList<>();
    while (num > 0) {
      nums.add(num % 10);
      num = num / 10;
    }
    for(int j=0;j<7;j++){
      for (int i=nums.size()-1;i>=0;i--) {
          if(i!=0){System.out.print(num((nums.get(i)), j) + " ");}
          else{System.out.print(num((nums.get(i)), j));}
      }
      System.out.print("\n");
    }
  }
}
