import java.util.Scanner;

class ED243{
  public static void main(String[] args) {
    Scanner stdin=new Scanner(System.in);
    int contatore=0;
    int flag=0;
    int n = stdin.nextInt(); //numero de ingredientes q Mario nao gosta
    int ingredientes[]= new int[n];  //lista q guarda os tais ingredientes
    for (int i=0;i<n;i++){
        ingredientes[i]=stdin.nextInt();
    }
    int p=stdin.nextInt(); // numero de pizzas no menu
    for (int j=0;j<p;j++){
        int k=stdin.nextInt();  //numero de ingredientes por pizza
        for (int l=0;l<k;l++){
            int temp=stdin.nextInt(); // ingrediente na pizza 
            for (int i=0;i<n;i++){
                if (temp==ingredientes[i]) flag=1;
            }
        }
        if (flag==0) contatore+=1;
        flag=0;
    }
    System.out.println(contatore);
    stdin.close();
  }
}