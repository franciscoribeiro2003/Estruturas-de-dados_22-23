import java.util.Scanner;

public class ED120{
    static char output[][];
    static String out="";
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt();
        output=new char[n][n];
        out=new String();
        draw(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                out+=output[i][j];
            }
            out +='\n';
        }
        System.out.print(out);
    }

    public static void line(int n, int i){
      int meio=n/2;
      int dots = n-meio-(i+1);
      if (dots<0) dots=dots*(-1);
      for (int j=0;j<n;j++){
        if (j<dots){
            output[i][j]='.';
            output[i][(n-1)-j]='.';
        }
        else if (j>=dots && output[i][j]==0) output[i][j]='#';
      }
    }

    public static void draw(int n){
        for (int i=0;i<n;i++){
          line(n,i);
        }
    }
}