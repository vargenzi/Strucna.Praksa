package esdnevnik;

public class Ucenici extends Osoba {
	String razred;
	String godina_upisa;
	 Ucenici(String i, String p, String jmg, String dan,String mesec,  String god, String pl, String raz, String gu, String e, String s) {
		ime = i;
		prezime = p;
		jmbg = jmg;
		dan_rodjenja = dan;
		mesec_rodjenja = mesec;
		godina_rodjenja = god;
		pol = pl;
		email = e;
		sifra = s;
		razred = raz;
		godina_upisa = gu;
	
	}
	
}
