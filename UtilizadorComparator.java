package projetoJunto;

import java.util.Comparator;

public class UtilizadorComparator implements Comparator<Utilizador> {
	
	public int compare(Utilizador u1, Utilizador u2) {
		return u1.getNomeU().compareTo(u2.getNomeU());
	}

}