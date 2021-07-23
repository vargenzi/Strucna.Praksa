package core;

import java.io.Serializable;

import core.Osoba;

public class Profesor extends Osoba implements Serializable{

	public String predmet;
	
	public Profesor(String i, String p, String idp, String dan, String mesec, String god, String pl,String e, String s, String pr) {
		ime = i;
		prezime = p;
		id = idp;
		dan_rodjenja = dan;
		mesec_rodjenja = mesec;
		godina_rodjenja  = god;
		pol = pl;
		predmet = pr;
		sifra = s;
		email = e;
		
	}
	
	

}
