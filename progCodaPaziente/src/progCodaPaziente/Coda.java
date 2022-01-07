package progCodaPaziente;

import java.util.Vector;

public class Coda {
    private Vector pazienti;

    public Coda() {
        pazienti = new Vector();
    }

    public void addPaziente(Object obj) {
        pazienti.addElement(obj);
    }

    public Object removePaziente() {
        Object obj = null;
        int size = pazienti.size();

        if (size > 0) {
            obj = pazienti.elementAt(0);
            pazienti.removeElementAt(0);
        }
        return obj;
    }

    public boolean voidPaziente() {
        if (pazienti.size() > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public int sizePazienti() {
        return pazienti.size();
    }
}
