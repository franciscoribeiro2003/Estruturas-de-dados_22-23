import java.util.Scanner;
class ED234{

    public static int flag1(Scanner stdin,int n){
        BSTree<String> t=new BSTree<>();
        for (int i=0;i<n;i++){
            t.insert(stdin.next());
            stdin.nextInt();
        }
        return (t.numberNodes());
    }

    public static String flag2(Scanner stdin,int n){
        BSTMap<String, Integer> t = new BSTMap<>();
        for (int i=0;i<n;i++){
            String buf=stdin.next();
            if (stdin.hasNextInt()) stdin.nextInt();
            if (t.get(buf)==null) t.put(buf, 1);
            else t.put(buf, t.get(buf)+1);
        }
        int max=0;
        String out="";
        for (String K: t.keys()){
            if (t.get(K)>max) {
                max = t.get(K);
                out=K;
            }
        }
        return (out+" "+max);
    }

    public static String flag3(Scanner stdin,int n){
        BSTMap<String, Integer> t = new BSTMap<>();
        BSTMap<String, Integer> t2=new BSTMap<>();
        for (int i=0;i<n;i++){
            String buf=stdin.next();
            int a = stdin.nextInt();
            if (t.get(buf)==null){
                t.put(buf, a);
                t2.put(buf, 1);
            }
            else{
                t.put(buf, t.get(buf)+a);
                t2.put(buf, t2.get(buf)+1);
            }
        }
        String  out="";
        for (String K:t.keys()){
           if (t.get(K)/t2.get(K)>=5) out+=K+'\n';
        }
        return out;
    }

    
    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int flag=stdin.nextInt();
        int n=stdin.nextInt();
        
        if (flag==1) System.out.println(flag1(stdin, n));
        else if (flag==2) System.out.println(flag2(stdin,n));
        else if (flag==3) System.out.print(flag3(stdin,n));
    }

}