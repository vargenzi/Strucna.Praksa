package ui;

import java.io.File;
import java.nio.file.Path;

public class PutanjeSlikaIFajlova {
	
	String cwd = Path.of("").toAbsolutePath().toString();
	public String PutanjeOsnovaSlike = cwd+ File.separator + "src" + File.separator + "ui" + File.separator + "Slike" + File.separator;
	public String PutanjeOsnovaFajla = cwd+ File.separator +"src" + File.separator + "baza podataka" + File.separator;
	public String IkonaProzor = PutanjeOsnovaSlike + "esdnevnik.png";
	public String IkonaUcenik = PutanjeOsnovaSlike + "ucenik.png";
	public String IkonaProfesor = PutanjeOsnovaSlike + "profa.png";
	public String IkonaAdmin = PutanjeOsnovaSlike + "admin.png";
	public String IkonaNazad = PutanjeOsnovaSlike + "back.png";
	public String IkonaHome = PutanjeOsnovaSlike + "home.png";
	public String PutanjaAdmin = PutanjeOsnovaFajla + "admin_info.txt";
	public String PutanjaUcenik = PutanjeOsnovaFajla + "Podaci_o_ucenicima.txt";
	public String PutanjaProfesor = PutanjeOsnovaFajla + "Podaci_o_profesorima.txt";
	public String PutanjaJmbg = PutanjeOsnovaFajla + "Popis_jmbg.txt";
	public String PutanjaOcene = PutanjeOsnovaFajla + "Podaci_o_ocenama.txt";
	public String LogoviProf = PutanjeOsnovaFajla + "logovi.txt";
	public String LogoviUc = PutanjeOsnovaFajla + "logovi_ucenici.txt";
	
}
