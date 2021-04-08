public class TavoloDaGioco {

    private static final int DIMENSIONE = 10;
    private Moneta[][] Tavolo = new Moneta[10][10];
    private Giocatore X;
    private Giocatore Y;

    public TavoloDaGioco() {

        X = new Giocatore(DIMENSIONE - 1, 0, 'X');
        Y = new Giocatore(0, DIMENSIONE - 1, 'Y');

        Tavolo[2][0] = new Moneta(2, 0);
        Tavolo[3][0] = new Moneta(3, 0);
        Tavolo[4][2] = new Moneta(4, 2);
        Tavolo[9][3] = new Moneta(9, 3);
        Tavolo[1][5] = new Moneta(1, 5);
        Tavolo[1][7] = new Moneta(1, 7);
        Tavolo[1][7] = new Moneta(1, 7);
        Tavolo[2][7] = new Moneta(2, 7);
        Tavolo[3][7] = new Moneta(3, 7);
        Tavolo[5][7] = new Moneta(5, 7);

        Tavolo[5][9] = new Moneta(5, 9);
    }

    public int width(){
        return DIMENSIONE;
    }
    public int height(){
        return DIMENSIONE;
    }
    public boolean contieneMoneta(int x, int y) {
        return Tavolo [x][y]!= null;
    }
    public Object elementoCella(int x, int y){

        if (X.getX() == x && X.getY() == y){
            return X;
        }
        if (Y.getX() == x && Y.getY() == y){
            return Y;
        }
        return Tavolo[x][y];
    }
    public void togliMoneta(int x, int y) {
        Tavolo[x][y] = null;
    }


    public boolean stessaCasella(){
        return X.getX() == Y.getX() && X.getY() == Y.getY();
    }
    public void resetX(){
        if (X.getX()  == DIMENSIONE - 1 && X.getY() == 0) {
            X.setX(0);
            X.setY(DIMENSIONE - 1);
        } else {
            X.setX(DIMENSIONE -1);
            X.setY(0);
        }
    }

    public void resetY() {
        if (Y.getX() == 0 && Y.getY() == DIMENSIONE - 1) {
            Y.setX(DIMENSIONE - 1);
            Y.setY(0);
        } else {
            Y.setX(0);
            Y.setY(DIMENSIONE - 1);
        }
    }




    public Giocatore getX() {
        return X;
    }

    public Giocatore getY() {
        return Y;
    }
}
