package core;

import java.io.Serializable;

public class Ocena implements Serializable{

	public String id_profesora;
	public String id_ucenika;
	public String id_ocene;
	public String predmet;
	public String ocena;
	public String opis;
	
	public Ocena(String idp, String idu, String ido, String pr, String oc, String op) {
		id_profesora = idp;
		id_ucenika = idu;
		id_ocene = ido;
		predmet = pr;
		ocena = oc;
		opis = op;
		
	}
}
