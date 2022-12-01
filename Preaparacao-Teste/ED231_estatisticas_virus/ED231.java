import java.util.Scanner;

class Casos {
  private int n;
  private int m[];
  //construtor da lista-------------------------------------------------
  Casos(int n){
    this.n=n;
    m=new int[n];
  }
  //leitura de casos confirmados----------------------------------------
  void read(Scanner stdin){
    for (int i=0;i<n;i++){
        m[i]=stdin.nextInt();
    }
  }
  //flag1---------------------------------------------------------------
  public String minMax(int[] novosCasos){
    int min=novosCasos[0],max=novosCasos[0];
    for (int i=1;i<n-1;i++){
      if (novosCasos[i]<min) min=novosCasos[i];
      if (novosCasos[i]>max) max=novosCasos[i];
    }
    return (min + " " + max + "\n");
  }
  //lista com todos novos casos diarios para flag1------
  public int[] novosCasos(){
    int dif;
    int novo[]= new int[n-1];
    for (int i=0;i<n-1;i++){
        dif=m[i+1]-m[i];
        novo[i]=dif;
    }
    return novo;
  }
  //flag2---------------------------------------------------------------
  public String flag2(){
    int count_periods=0,count_streak=0;
    int ongoing=0;
    for (int i=0;i<n-1;i++){
      if (baixaprop(m[i],m[i+1])){
        ongoing+=1;
        if (ongoing==1) count_periods+=1;
        if (ongoing>count_streak) count_streak=ongoing;
      }
      else{
        ongoing=0;
      }
    }
    return (count_periods + " " + count_streak + "\n");
  }
  //baixa propagacao para flag2-------
  public boolean baixaprop(int a,int b){
    double out=(((b-a)/(double)a)*100);
    return (out<=5.0);
  }
  //flag 3---------------------------------------------------------------
  //maxima altura para flag3--------
  public int maxi(int[] m){
    int max=m[0];
    for (int i=1; i<n;i++){
      if (max<m[i]) max=m[i];
    }
    int out=max/100;
    return out;
  }
  //lista de carateres com # por cada 100 casos confirmados---
  public char[][] grafico(){
    char out[][]=new char[n][maxi(m)];
    for (int i=0;i<n;i++){
      int sharp=m[i]/100;
      for(int j=0;j<maxi(m);j++){
          if (sharp==0) out[i][j]='.';
          else if (sharp>0) {out[i][j]='#';sharp--;}
      }
    }
    return out;
  }
  public String flag3(char[][] graph){
    String out=new String();
    for (int i=maxi(m)-1;i>=0;i--){
      for (int j=0;j<n;j++){
        out+=graph[j][i];
      }
      out+='\n';
    }
    return out; //reagrupar metodo grafico para corresponder ao resultado
  }
  //escolha de flags----------------------------------------------------
  public String eflag(int flag){
    if (flag==1) {
      return (minMax(novosCasos()));
    }
    else if (flag==2){
      return flag2();
    }
    else if (flag==3){
      return flag3(grafico());
    }
    return "Escolha flag entre 1 e 3";
  }
}
//class com main---------------------------------------------------------
public class ED231{
  public static void main(String[] args){
      Scanner stdin = new Scanner(System.in);
    int n=stdin.nextInt();
    Casos c= new Casos(n);
    c.read(stdin);
    int flag=stdin.nextInt();
    System.out.print(c.eflag(flag));
  }
}