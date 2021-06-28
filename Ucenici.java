package esdnevnik;

public class Ucenici extends Osoba {
	int razred;
	int godina_upisa;
	public void Ucenik(String i, String p, int jmg, int god, String pl, int raz, int gu, String e, String s) {
		ime = i;
		prezime = p;
		jmbg = jmg;
		godina_rodjenja = god;
		pol = pl;
		email = e;
		sifra = s;
		razred = raz;
		godina_upisa = gu;
	
	}
	
}
