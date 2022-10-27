import java.util.Scanner;
import java.util.Arrays;
public class Estatisticas_ED183 {

    public static void main(String[] args) {
      Scanner texto = new Scanner (System.in); //obter input
      int n = texto.nextInt();
      int [] lst = new int[n];
      float media;
      int max=0;
      int min=0;
      lst[0]=texto.nextInt();
      max=lst[0];
      min=lst[0];
      int soma=lst[0];
      for(int i=1;i<n;i++){
        lst[i] = texto.nextInt();
        soma+=lst[i];
        if(lst[i]>max){
          max=lst[i];
        }
        if (lst[i]<min){
          min=lst[i];
        }
      }
      media=(float)soma/n;
      int ampl;
      ampl=max-min;
      System.out.printf("%.2f\n",media);
      System.out.println(ampl);
    }
}
