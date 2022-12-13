import java.util.Scanner;

class ED165{

    public static BSTree<Integer> combina(int[] conj_n){
        BSTree<Integer> numeros = new BSTree<>();
        for (int i=0;i<conj_n.length;i++){
            for (int j=0;j<conj_n.length;j++){
                numeros.insert(conj_n[i]+conj_n[j]);
            }
        }
        return numeros;
    }

    public static void main(String[] args){
        BSTree<Integer> numeros = new BSTree<>();
        Scanner stdin=new Scanner(System.in);
        int n = stdin.nextInt();
        int conj_n[]=new int[n];
        for (int i = 0;i<n;i++){
           conj_n[i]=stdin.nextInt();
        }
        int p = stdin.nextInt();
        int conj_p[]=new int[p];
        for (int i = 0;i<p;i++){
            conj_p[i]=stdin.nextInt();
        }
        numeros=combina(conj_n);
        for (int i=0;i<p;i++){
            System.out.print (conj_p[i] + ": ");
            if (numeros.contains(conj_p[i])) System.out.println("sim");
            else System.out.println("nao");
        }
    }
}