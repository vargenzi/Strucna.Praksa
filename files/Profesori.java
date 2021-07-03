package esdnevnik;

public class Profesori extends Osoba{
	String predmet;
	Profesori(String i, String p, String jmg, String dan, String mesec, String god, String pl,String e, String s, String pr) {
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
