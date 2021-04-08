public class LogicaDiGioco {



    public enum Direzioni{ Nord, Sud, Ovest, Est }

    public enum Giocatori{ X, Y }

    private Dado dado = new Dado();
    private Giocatori attivo = Giocatori.X;
    private TavoloDaGioco  tavoloDaGioco;
    private int numeroDado;


    public LogicaDiGioco(TavoloDaGioco tavoloDaGioco) {
        this.tavoloDaGioco = tavoloDaGioco;
    }

    public void lancioDado() {
        numeroDado = dado.TiraDado();

    }

    public int getNumeroDado() {
        return numeroDado;
    }

    /** Finisce il turno di un giocatore, e inizia quello dell'altro */
    public void finisciTurno(){
        if(attivo == Giocatori.X)
            attivo = Giocatori.Y;
        else
            attivo = Giocatori.X;
    }

    /** sposta nella direzione indicata, il giocatore attivo
     *
     *
     */


    public boolean muovi(Direzioni direzioni) {
        Giocatore giocatore = null;
        if (attivo == Giocatori.X) {
            giocatore = tavoloDaGioco.getX();

        }else{
            giocatore = tavoloDaGioco.getY();

        }
        int width = tavoloDaGioco.width();
        int height = tavoloDaGioco.height();

        int aumentoX=0;
        int aumentoY=0;
        if(direzioni==Direzioni.Nord) {
            aumentoX--;
        }
        if(direzioni==Direzioni.Sud) {
            aumentoX++;
        }
        if (direzioni == Direzioni.Ovest) {
            aumentoY--;
        }
        if (direzioni == Direzioni.Est) {
            aumentoY++;
        }
        for (int i = 0; i < numeroDado; i++) {
            int newX = giocatore.getX() + aumentoX;
            if (newX < 0)
                newX = width - 1;
            if (newX >= width)
                newX = 0;
            giocatore.setX(newX);

            int newY = giocatore.getY() + aumentoY;
            if (newY < 0)
                newY = height - 1;
            if (newY >= height)
                newY = 0;
            giocatore.setY(newY);

            // System.out.println("cordinate :" + newX + " " + newY);

            if (tavoloDaGioco.contieneMoneta(newX, newY)) {
                tavoloDaGioco.togliMoneta(newX, newY);
                giocatore.setPatrimonio(giocatore.getPatrimonio() + 1);

            }

            if(tavoloDaGioco.stessaCasella()) {
                if(sfida()) {
                    return true;
                };
            }

        }

        if(giocatore.getPatrimonio() == 10) {
            System.out.println("Il giocatore " + giocatore.getName() + "Ha raccolto tutte le monete e quindi ha vinto");
            return true;
        }

        return false;
    }

    private boolean sfida() {
        System.out.println("C'è una sfida");

        int dadoX = dado.TiraDado();
        int dadoY = dado.TiraDado();
        System.out.println(" X tira" + dadoX + " e Y tira" + dadoY);

        while (dadoX == dadoY) {
            System.out.println("Rilancia");
            dadoX = dado.TiraDado();
            dadoY = dado.TiraDado();
            System.out.println("X tira" + dadoX+ " e Y tira" + dadoY);
        }
        Giocatore X = tavoloDaGioco.getX();
        Giocatore Y = tavoloDaGioco.getY();

        if (dadoX > dadoY) {
            System.out.println("X vince la sfida");

            int monetaY = Y.getPatrimonio();
            if(monetaY>0) {
                Y.setPatrimonio(monetaY - 1);
                X.setPatrimonio(X.getPatrimonio() + 1);
                tavoloDaGioco.resetY();
                System.out.println("Y perde una moneta");
            }else{
                System.out.println("Y non ha monete, quindi X vince");
                return true;
            }

        }else {
            System.out.println("Y vince la sfida");

            int monetaX = X.getPatrimonio();
            if (monetaX > 0) {
                X.setPatrimonio(monetaX - 1);
                Y.setPatrimonio(Y.getPatrimonio() + 1);
                tavoloDaGioco.resetX();
                System.out.println(" X perde una moneta");
            } else {
                System.out.println("X non ha monete, quindi Y vince");
                return true;

            }
        }

        return false;
    }
    public Giocatori getAttivo() {
        return attivo;
    }
}