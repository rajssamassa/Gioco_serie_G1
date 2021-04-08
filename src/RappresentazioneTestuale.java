import java.util.Scanner;

public class RappresentazioneTestuale {

    public int displayMenu(){

        System.out.println("0. Esci");
        System.out.println("1. Mostra Griglia");
        System.out.println("2. Muovi");
        System.out.println("3. Mostra info giocatori");

        Scanner tastiera = new Scanner(System.in);
        int codice = tastiera.nextInt();

        return codice;
    }
    public void displayInfoGiocatori(TavoloDaGioco Tavolo) {
    Giocatore X = Tavolo.getX();
    Giocatore Y = Tavolo.getY();
        System.out.println("Giocatore X. ");
        System.out.println(" \t riga : " + X.getX() + "colonna" + X.getY() + "patrimonio" + X.getPatrimonio());
        System.out.println("Giocatore Y. ");
        System.out.println(" \t riga : " + Y.getX() + "colonna" + Y.getY() + "patrimonio" + Y.getPatrimonio());
}


    public void displayGrid(TavoloDaGioco Tavolo){

            for(int i=0;i < Tavolo.width() * 4 + 1; i++){
                System.out.print("-");
            }
            System.out.print("\n");
           for (int i = 0; i < Tavolo.height(); i++){
               System.out.print(" | ");
               for (int j = 0; j <Tavolo.width(); j++){
                   Object cella = Tavolo.elementoCella(i, j);
                   if(cella == null){
                       System.out.print(" ");
                   }else if(cella instanceof Giocatore){
                       Giocatore g =(Giocatore) cella;
                       System.out.print(""+ g.getName());
                   }else{
                       System.out.print("$");
                   }
                   System.out.print(" | ");
               }
               System.out.print("\n");

               for(int j = 0; j < Tavolo.width() * 4 + 1; j++){
                   System.out.print("-");
               }
                System.out.print("\n");


           }

    }
}
