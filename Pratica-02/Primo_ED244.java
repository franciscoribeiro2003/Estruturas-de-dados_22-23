import java.util.*;

public class Primo_ED244
{
    public static ArrayList<Integer> Crivo(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        ArrayList<Integer> origem = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                origem.add(i);
        }
        return origem;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> origem = new ArrayList<>();
        Scanner stdin = new Scanner (System.in);
        int a = stdin.nextInt(); // inicio da lista
        int n = stdin.nextInt(); // limite da lista
        origem=Crivo(n);
        origem.removeIf(k->(k<=1));
        origem.removeIf(k->(k<a));
        int tamanho=origem.size();
        System.out.println(tamanho);
    }
}
