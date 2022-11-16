import java.util.Scanner;

class ED235{
  public static String linha_retangulo(int sharps, int dots){
    String out = new String();
    while (sharps != 0){
      out=out+'#';
      sharps--;
    }
    while (dots != 0){
      out=out+'.';
      dots--;
    }
    out=out+'\n';
    return out;
  }

  public static String retangulo(int size){
    int sharps=size, dots=0;
    String out = new String();
    while (sharps!=0) {
      out=out+linha_retangulo(sharps,dots);
      sharps--;
      dots++;
    }
    return out;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num= in.nextInt();
    String out = new String();
    int sizes;
    while (num>0){
      sizes=in.nextInt();
      out=out+retangulo(sizes);
      num--;
    }
    System.out.print(out);
  }
}
