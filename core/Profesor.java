package core;

import core.Osoba;

public class Profesor extends Osoba{
	public String predmet;
	public Profesor(String i, String p, String jmg, String dan, String mesec, String god, String pl,String e, String s, String pr) {
		ime = i;
		prezime = p;
		jmbg = jmg;
		dan_rodjenja = dan;
		mesec_rodjenja = mesec;
		godina_rodjenja  = god;
		pol = pl;
		predmet = pr;
		sifra = s;
		email = e;
		
	}
	
	

}
