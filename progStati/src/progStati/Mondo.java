/*
 * Copyright (c) 2022. Alessandro Zangrandi.
 * Tutti i diritti riservati.
 */

package progStati;

import java.util.LinkedList;
import java.util.List;

// Lista degli stati.
public class Mondo {
    public static List<Stato> mondo = new LinkedList<>();

    public static List<Stato> getMondo() {
        return mondo;
    }
}
