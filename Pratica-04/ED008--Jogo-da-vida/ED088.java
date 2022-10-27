import java.util.Scanner;

class Game{
  private int LINHAS,COLUNAS,INTERACOES;
  private char ronda[][];
  private char nextround[][];

  Game(int lin, int col, int interactions){
    LINHAS=lin;
    COLUNAS=col;
    INTERACOES=interactions;
    ronda= new char[LINHAS][COLUNAS];
    nextround= new char [LINHAS][COLUNAS];
  }

  void read(Scanner in){
    for (int i=0; i<LINHAS;i++){
      String buf = in.next();
      for (int j=0; j<COLUNAS; j++){
        ronda[i][j]=buf.charAt(j);
      }
    }
  }

  boolean isAlive(char a){
    if (a=='O')return true;
    else return false;
  }

  boolean boundries(int i, int j){
    if (i<0 || i>=LINHAS || j<0 || j>=COLUNAS) return false;
    else return true;
  }

  int vizinhosVivos(int i, int j){
    int contador=0;
    if (boundries(i-1,j-1) && isAlive(ronda[i-1][j-1])) contador++;
    if (boundries(i-1,j) && isAlive(ronda[i-1][j])) contador++;
    if (boundries(i-1,j+1) && isAlive(ronda[i-1][j+1])) contador++;
    if (boundries(i,j-1) && isAlive(ronda[i][j-1])) contador++;
    if (boundries(i,j+1) && isAlive(ronda[i][j+1])) contador++;
    if (boundries(i+1,j-1) && isAlive(ronda[i+1][j-1])) contador++;
    if (boundries(i+1,j) && isAlive(ronda[i+1][j])) contador++;
    if (boundries(i+1,j+1) && isAlive(ronda[i+1][j+1])) contador++;
    return contador;
  }

  void deus(){
    for (int i=0;i<LINHAS;i++){
      for (int j=0;j<COLUNAS;j++){
        if (vizinhosVivos(i,j)==3) nextround[i][j]='O';
        else if (vizinhosVivos(i,j)==2)nextround[i][j]=ronda[i][j];
        else nextround[i][j]='.';
      }
    }
  }

  void reset(){
    for (int i=0;i<LINHAS;i++){
      for (int j=0;j<COLUNAS;j++){
        ronda[i][j]=nextround[i][j];
      }
    }
  }

  void jogo(){
    int i=INTERACOES;
    while (i>0){
      deus();
      reset();
      i--;
    }
  }

    public String toString(){
      String output="";
      for (int i=0;i<LINHAS;i++){
        for (int j=0;j<COLUNAS;j++){
          output+=ronda[i][j];
        }
        output+= "\n";
      }
      return output;
    }
}

public class ED088{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int lin = in.nextInt();
    int col = in.nextInt();
    int interactions = in.nextInt();
    Game g = new Game(lin,col,interactions);
    g.read(in);
    g.jogo();
    System.out.print(g);
  }
}

