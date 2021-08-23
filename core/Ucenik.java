package core;

import java.io.Serializable;

import core.Osoba;

public class Ucenik extends Osoba implements Serializable{
	/**
	 * 
	 */
	public String razred;
	public String godina_upisa;
	 public Ucenik(String i, String p, String jmg, String datum, String pl, String raz, String gu, String e, String s) {
		ime = i;
		prezime = p;
		id = jmg;
		datum_rodjenja = datum;
		pol = pl;
		email = e;
		sifra = s;
		razred = raz;
		godina_upisa = gu;
	
	}
	
}
