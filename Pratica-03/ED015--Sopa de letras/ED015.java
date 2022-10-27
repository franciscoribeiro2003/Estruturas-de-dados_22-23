import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.*;

class Game{
  private int LINS, COLS;
  private char sopa[][];
  private char out[][];
  private String words[];

  Game(int lin, int col){
    LINS=lin;
    COLS=col;
    sopa= new char[LINS][COLS]; // cria lista que guarda a sopa
    out= new char[LINS][COLS];
    output();
  }

  void output(){
    for (int i=0; i<LINS; i++){
      for (int j=0; j<COLS; j++){
        out[i][j]='.';
      }
    }
  }

  void read(Scanner in){ //lê e guarda a sopa
    for (int i=0;i<LINS;i++){
      String buf=in.next(); //lê frase
      for (int j=0;j<COLS;j++){
        sopa[i][j]=buf.charAt(j);
      }
    }
  }

  void read2(Scanner in, int n){
    words=new String[n];
    for (int i=0; i<n; i++){
      String buf=in.next(); //lê frase
      words[i]=buf;
    }
  }

  void todaspalavras(int size){
    for(int i=0; i<size;i++){
      String word=words[i];
      firstletter(word,1,0);
      firstletter(word,-1,0);
      firstletter(word,0,1);
      firstletter(word,0,-1);
    }
  }

  void firstletter(String word, int incry, int incrx){
    for (int i=0; i<LINS; i++){
      for(int j=0; j<COLS;j++){
        if (word.charAt(0)==sopa[i][j] && verify(i,j,incry,incrx,word)){
          colocarpalavra(i,j,incry,incrx,word,word.length());
        }
      }
    }
  }

  boolean verify(int y, int x, int incry, int incrx, String word){
    for (int i=0 ;i<word.length(); y+=incry, x+= incrx, i++){
      if (!boundries(y,x)) return false;
      if (word.charAt(i)!=sopa[y][x]) return false;
    }
    return true;
  }

  boolean boundries(int y, int x){
    if((LINS-y)>0 && ((LINS-y)<=LINS) && (COLS-x>0) && ((COLS-x)<=COLS)) return true;
    else return false;
  }

  void colocarpalavra(int y, int x,int incry, int incrx, String word, int size){
    for(int i=0;i<size;i++){
      out[y][x]=word.charAt(i);
      x+=incrx;
      y+=incry;
    }
  }

  void print_out(ArrayList<Character> n){
    for (int i=0; i<LINS; i++){
      for (int j=0; j<COLS; j++){
        n.add(out[i][j]);
        //System.out.print(out[i][j]);
      }
      n.add('\n');
      //System.out.println();
    }
  }
}

public class ED015{
  public static void main(String[] args){
    ArrayList<Character> output = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    int lin= in.nextInt();
    int col= in.nextInt();
    Integer i=1;
    while (lin!=0 && col!=0){
      input_print(i,output);
      loop(lin, col, in, output);
      lin= in.nextInt();
      col= in.nextInt();
      i++;
    }
    int ss=output.size();
    String str = output.toString()
     .replaceAll(", ", "")
     .replace("[", "")
     .replaceAll("]", "");
    for (int b=0; b<str.length();b++) System.out.print(str.charAt(b));

  }
  public static ArrayList<Character> loop(int lin,int col,Scanner in,ArrayList<Character> output){
    Game g = new Game(lin,col);
    g.read(in);
    int n= in.nextInt();
    g.read2(in, n);
    g.todaspalavras(n);
    g.print_out(output);
    return output;
  }

  public static ArrayList<Character> input_print(Integer i,ArrayList<Character> output){
    String inp = new String("Input #");
    String ind;
    for(int a = 0; a<inp.length(); a++){
      output.add(inp.charAt(a));}
    ind=i.toString();
    for(int a = 0; a<ind.length(); a++){
      output.add(ind.charAt(a));}
    output.add('\n');
    return output;
  }
}
