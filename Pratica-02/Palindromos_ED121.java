import java.util.*;

public class Palindromos_ED121 {

/*****************************************************************************/
    public static String reverse (String original) //reverter a String
      {
      char ch;
      String reverse=""; // output do metodo reverse
      for (int i=0;i<original.length();i++){
        ch=original.charAt(i);  //obter caracter a caracter
        reverse=ch+reverse;
        }
      return reverse;
      }

/*****************************************************************************/
    public static String remover (String str) // remover os espaços brancos e sinais de pontuacao
    {
    str = str.replaceAll("[^a-zA-Z ]", "");
    str = str.replaceAll("\\s", "");
    return str;}

/*****************************************************************************/

    public static String upper (String str) // transformar todas as letras para maiusculas
    {
    str = str.toUpperCase();
    return str;}

/*****************************************************************************/

    public static String compilar (String str) // compilar todos os metodos
    {
    str = remover(upper(str));
    return str;}

/*****************************************************************************/
    public static boolean stringCompare(String str1, String str2) // comparar strings
        {
        boolean areEqual = str1.equals(str2);
        if (areEqual) {
		     	return true;
		    } else {
			    return false;}
        }
/*****************************************************************************/

    public static void main(String[] args){
      Scanner stdin = new Scanner (System.in);
      int num= stdin.nextInt(); //numero  de Strings
      String aux = stdin.nextLine();
      String original, reverse="";
      String output=num+"\n";
      for (int i=0;i<num;i++) {
        original = stdin.nextLine(); // ler frase
        reverse= reverse(original);
        original=compilar(original);
        reverse=compilar(reverse);
        //System.out.println(original); //imprimir para teste
        //System.out.println(reverse);
        if (stringCompare(original,reverse)) {
          output=output+"sim\n";
        } else if (!(stringCompare(original,reverse))) {
          output=output+"nao\n";
        }
        original="";
        reverse="";
      }
      System.out.print (output);
    }

}
