package serieg1;

import java.util.Scanner;

public class Partita {

    private TavoloDaGioco Tavolo;
    private RappresentazioneTestuale Testuale;
    private LogicaDiGioco logica;

    public Partita() {
        Tavolo = new TavoloDaGioco();
        Testuale = new RappresentazioneTestuale();
        logica = new LogicaDiGioco(Tavolo);
    }

    public void gioca() {

        int codice = -1;
        do {
            codice = Testuale.displayMenu();

            if (codice == 1) {
                Testuale.displayGrid(Tavolo);
            } else if (codice == 2) {
                if(muovi()) {
                    System.out.println("La partita è terminata!");
                    return;
                }

            }else if (codice == 3) {
                Testuale.displayInfoGiocatori(Tavolo);
            }
        } while (codice != 0);
    }

    public boolean muovi() {
        logica.lancioDado();
        System.out.println("Tocca al giocatore" + logica.getAttivo());
        System.out.println("E' stato lanciato il dado con numero" + logica.getNumeroDado());
        System.out.println("Inserire Direzione : 1.Nord, 2.Sud 3.Ovest 4.Est");

        Scanner tastiera = new Scanner(System.in);
        int direzione = tastiera.nextInt();

        boolean vittoria = false;
        if (direzione == 1) {
            vittoria = logica.muovi(LogicaDiGioco.Direzioni.Nord);
        }
        if (direzione == 2) {
            vittoria  = logica.muovi(LogicaDiGioco.Direzioni.Sud);
        }
        if (direzione == 3) {
            vittoria  = logica.muovi(LogicaDiGioco.Direzioni.Ovest);
        }
        if (direzione == 4) {
            vittoria = logica.muovi(LogicaDiGioco.Direzioni.Est);
        }
        if(vittoria)
            return true;
        logica.finisciTurno();
        return false;



    }
}

