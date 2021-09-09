package core;

import java.io.Serializable;

import core.Osoba;

public class Profesor extends Osoba implements Serializable{

	public String predmet;
	
	public Profesor(String i, String p, String idp, String datum, String pl,String e, String s, String pr) {
		ime = i;
		prezime = p;
		id = idp;
		datum_rodjenja = datum;
		pol = pl;
		predmet = pr;
		sifra = s;
		email = e;
		
	}
	
	

}
