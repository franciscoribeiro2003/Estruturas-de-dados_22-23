import java.util.Scanner;
import java.lang.Math;  // utilizar pow "expoente"

public class ED005{
  public static MyStack<Integer> numbers;  //pilha

  public static int read_Line(Scanner in) {  //metodo le e calcula uma so expressao
    String linha=in.nextLine();       // ler a linha completa com scanner de System.in da main
    Scanner stdin=new Scanner(linha); //Scanner criado para o loop seguinte poder parar visto q e composto por uma string
    int flag=0;

    while (stdin.hasNext()){  
        String s=stdin.next();
        if (isNumber(s)){
          numbers.push(converter(s));
          flag=1;
        }
        else if (isMult(s)){
            if (numbers.size()>=2) {
              int a = (numbers.pop());
              int b = (numbers.pop());
              numbers.push(a*b);
              flag=0;
            }
            
          }
        else if (isDiv(s)){
          if (numbers.size()>=0) {
              int a = (numbers.pop());
              int b = (numbers.pop());
              numbers.push(b/a);
              flag=0; 
              }
              
          }
        else if (isAdd(s)){
            if (numbers.size()>=2) {
              int a = (numbers.pop());
              int b = (numbers.pop());
              numbers.push(a+b);
              flag=0;
            }
            
        }
        else if (isSub(s)){
            if (numbers.size()>=2) {
              int a = (numbers.pop());
              int b = (numbers.pop());
              numbers.push(b-a);
              flag=0;
            }
        }
    }
    return flag;
  }

  public static boolean isMult(String operador){   // verificar se é multiplicacao
    if (operador.charAt(0)=='*') return true;
    return false;
  }
  public static boolean isAdd(String operador){   // verificar se é adicao
    if (operador.charAt(0)=='+') return true;
    return false;
  }
  public static boolean isSub(String operador){   // verificar se é Subtracao
    if (operador.charAt(0)=='-') return true;
    return false;
  }
  public static boolean isDiv(String operador){   // verificar se é divisao
    if (operador.charAt(0)=='/') return true;
    return false;
  }
  public static boolean isNumber(String operador){   // verificar se é numero
    if (operador.charAt(0)>='0' && operador.charAt(0)<='9') return true;
    return false;
  }
  public static int converter(String operador){   //converter string para inteiro
    int resultado=0,exponente=0;
    for (int i=0;i<operador.length();i++){
      exponente=(int)Math.pow(10, operador.length()-1-i);
      if      (operador.charAt(i)=='0') resultado += 0*exponente;
      else if (operador.charAt(i)=='1') resultado += 1*exponente;
      else if (operador.charAt(i)=='2') resultado += 2*exponente;
      else if (operador.charAt(i)=='3') resultado += 3*exponente;
      else if (operador.charAt(i)=='4') resultado += 4*exponente;
      else if (operador.charAt(i)=='5') resultado += 5*exponente;
      else if (operador.charAt(i)=='6') resultado += 6*exponente;
      else if (operador.charAt(i)=='7') resultado += 7*exponente;
      else if (operador.charAt(i)=='8') resultado += 8*exponente;
      else if (operador.charAt(i)=='9') resultado += 9*exponente;
    }
    return resultado;
  }

  //--main------------------------------------------------------------------------------------
  public static void main(String[] args){
    Scanner stdin= new Scanner(System.in);
    int c=stdin.nextInt();  // numero de expressoes
    int flag=0;             //flag para identificar casos com uma operacao so para um numero (retorno do metodo read)
    stdin.nextLine();       //ler paragrafo
    numbers = new LinkedListStack<>();  // Criacao da pilha
    for (int i=0;i<c;i++){
      flag=read_Line(stdin);
      if (numbers.size()>1 || flag==1) System.out.println("Expressao Incorrecta");
      else System.out.println(numbers.top());
      while(numbers.size()>0) numbers.pop();  //esvaziar pilha
    }
  }
}

//Francisco-Ribeiro-2022-------------------------------------