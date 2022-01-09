package progGuasti;

import java.util.Vector;

public class Coda {
    private Vector interventi;

    public Coda() {
        interventi = new Vector();
    }

    public void addIntervento(Object obj) {
        interventi.addElement(obj);
    }

    public Object removeIntervento() {
        Object obj = null;
        int size = interventi.size();

        if (size > 0) {
            obj = interventi.elementAt(size-1);
            interventi.removeElementAt(size-1);
        }
        return obj;
    }
    public int sizeInterventi() {
        return interventi.size();
    }

}
