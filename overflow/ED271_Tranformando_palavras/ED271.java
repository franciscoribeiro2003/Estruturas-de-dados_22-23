import java.util.Scanner;
class Letras{
    private char letras[][]; 
    private int n,k;
    

    //Construtor
    Letras(int n,int k){
        letras= new char[n][k];
        this.n=n;
        this.k=k;
        letras[0][0]='A';
    }

    //retorno
    public char output(int x,int y){
        return letras[x-1][y-1];
    }
    
    //constituir lista
    public void Const(){
        for (int i=1;i<n;i++) {
          for (int l=0;l<k;l++){
              for (int j=0;letras[i-1][j]=='A' || letras[i-1][j]=='B' || letras[i-1][j]=='C';j++){
                    if (letras[i-1][j]=='A') {
                        letras[i][l]='A';
                        if (l+1<k) l++;
                        else break;
                        letras[i][l]='B';
                        if (l+1<k) l++;
                        else break;
                    }

                    else if (letras[i-1][j]=='B') {
                        letras[i][l]='A';
                        if (l+1<k) l++;
                        else break;
                        letras[i][l]='C';
                        if (l+1<k) l++;
                        else break;
                    }

                    else if (letras[i-1][j]=='C') {
                        letras[i][l]='A';
                        if (l+1<k) l++;
                        else break;

                    }

                }
              }
        }

    }
}



public class ED271{

    private static int n[];
    private static int k[];


    public static int max(int max, int comp){
        if (comp>max) {
            return (max=comp);
        }
        else return max;
    }

    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int c=in.nextInt();
      String output=new String();
      n=new int[c];
      k=new int[c];
      read(in);
      int maxx=0,maxy=0;
      for (int i=0;i<c;i++){
        maxx=max(maxx,n[i]);
        maxy=max(maxy,k[i]);
      }
      Letras teste=new Letras(maxx,maxy);
      teste.Const();
      for (int i=0;i<c;i++){
        maxx=max(maxx,n[i]);
        maxy=max(maxy,k[i]);
      }
      for (int i=0;i<c;i++){
          output+=teste.output(n[i],k[i]);
          output+='\n';
      }
      System.out.print(output);
    }

    static void read(Scanner in){
      for (int i=0;i<n.length;i++){
        n[i]=in.nextInt();
        k[i]=in.nextInt();
      } 
    }




}