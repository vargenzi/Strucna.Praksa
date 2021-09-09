package ui;

import java.io.File;
import java.nio.file.Path;

public class PutanjeSlikaIFajlova {
	public String cwd;
	public String PutanjeOsnovaSlike;
	public String PutanjeOsnovaFajla;
	public String IkonaProzor;
	public String IkonaUcenik;
	public String IkonaProfesor;
	public String IkonaAdmin;
	public String IkonaNazad;
	public String IkonaHome;
	
	public PutanjeSlikaIFajlova(){
		cwd = Path.of("").toAbsolutePath().toString();
		PutanjeOsnovaSlike = cwd+ File.separator + "src" + File.separator + "ui" + File.separator + "Slike" + File.separator;
		PutanjeOsnovaFajla = cwd+ File.separator +"src" + File.separator + "baza podataka" + File.separator;
		IkonaProzor = PutanjeOsnovaSlike + "esdnevnik.png";
		IkonaUcenik = PutanjeOsnovaSlike + "ucenik.png";
		IkonaProfesor = PutanjeOsnovaSlike + "profa.png";
		IkonaAdmin = PutanjeOsnovaSlike + "admin.png";
		IkonaNazad = PutanjeOsnovaSlike + "back.png";
		IkonaHome = PutanjeOsnovaSlike + "home.png";

	}

	
}
