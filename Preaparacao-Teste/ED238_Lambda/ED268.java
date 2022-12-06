import java.util.Scanner;

class Lambda{
    public char[][] lambda;
    public int size;

    public Lambda(int size){ //construtor
        this.size = size;
        lambda = new char[size][size];
    }

    public void inicio(){
        int meio=size/2+1;
        for (int i=0;i<meio;i++){
            for (int j=0;j<size;j++){
               if (i==j) lambda[i][j]='#';
               else lambda[i][j]='.';
            }
        }
    }
    
    public void fim(){
        int meio=size/2;
        int lin=1;
        for (int i=meio+1;i<size;i++){
            for (int j=0;j<size;j++){
               if (j==meio-lin || j==meio+lin) {
                lambda[i][j]='#';
                lambda[i][j]='#';
               }
               else lambda[i][j]='.';
            }
            lin++;
        }
    }

    public void draw(){
        inicio();
        fim();
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                result += lambda[i][j];
            }
            result += '\n';
        }
            return result;

}
}
public class ED268{

    public static void main(String[] args) {
        // draw a lambda with '#'
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();      // number of lambdas to draw
        int size;
        Lambda lmda[] = new Lambda[n];
        for (int i=0;i<n;i++){
            size=in.nextInt();
            lmda[i]=new Lambda(size);
            lmda[i].draw();
        }
        for (int j=0;j<n;j++){
            System.out.print(lmda[j]);
        }
    }
}
