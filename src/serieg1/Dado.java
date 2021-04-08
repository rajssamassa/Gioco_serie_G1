package serieg1;

public class Dado {
    public int TiraDado() {
        int r =(int)(Math.random() * 6 + 1);
        if(r>6)
            r=6;
        return r;
    }
}
