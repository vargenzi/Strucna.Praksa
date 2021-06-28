package esdnevnik;

public class Profesori extends Osoba{
	String predmet;
	public void Profesor(String i, String p, int jmg, int god, String pl,String e, String s, String pr) {
		ime = i;
		prezime = p;
		jmbg = jmg;
		godina_rodjenja  = god;
		pol = pl;
		predmet = pr;
		sifra = s;
		email = e;
		
	}

}
