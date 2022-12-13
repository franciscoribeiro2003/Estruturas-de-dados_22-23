import java.util.Scanner;

class ED172{
    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        BSTMap<String, Integer> palavras=new BSTMap<>();
        while (stdin.hasNext()){
            String word=stdin.next();
            if (palavras.get(word)==null){
                palavras.put(word,1);
            }
            else palavras.put(word,palavras.get(word) +1);
        }
        for (String K : palavras.keys()){
            System.out.println(K + ": " + palavras.get(K));
        }

    }


}