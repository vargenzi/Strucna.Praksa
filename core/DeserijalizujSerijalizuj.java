package core;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import ui.PutanjeSlikaIFajlova;

public class DeserijalizujSerijalizuj implements Serializable{

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ucenik> DeserijalizujUcenika() throws Exception {		
		ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
		File file = new File(pf.PutanjaUcenikUc);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = null;
	    try {
	    	ois = new ObjectInputStream(fis);
	    	alu = (ArrayList<Ucenik>)ois.readObject();
	    }catch(EOFException e) {
	    	System.out.println("End of file.");
	    }
	    try {
	        ois.close();
	        fis.close();
	    }catch(NullPointerException e) {
	    	System.out.println("");
	    }
	    return alu;
	}
	
	public void SerijalizujUcenika(Ucenik objekat, ArrayList<Ucenik> alu, boolean indikator) throws Exception{
        File file = new File(pf.PutanjaUcenikUc);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream aoos = new ObjectOutputStream(fos);
        if(indikator == true) {
            alu.add(objekat);
        }else {}
        aoos.writeObject(alu);
        aoos.close();
        fos.close();
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Profesor> DeserijalizujProfesora() throws Exception {	
		ArrayList<Profesor> alp = new ArrayList<Profesor>();
		File file = new File(pf.PutanjaProfesorPr);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = null;
	    try {
	    	ois = new ObjectInputStream(fis);
	    	alp = (ArrayList<Profesor>)ois.readObject();
	    }catch(EOFException e) {
	    	System.out.println("End of file.");
	    }
	    try {
	        ois.close();
	        fis.close();
	    }catch(NullPointerException e) {
	    	System.out.println("");
	    }
	    return alp;
	}
	
	public void SerijalizujProfesora(Profesor objekat, ArrayList<Profesor> alp, boolean indikator) throws Exception{
        File file = new File(pf.PutanjaProfesorPr);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream aoos = new ObjectOutputStream(fos);
        if(indikator == true) {   
        	alp.add(objekat);
        	}
        aoos.writeObject(alp);
        aoos.close();
        fos.close();
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ocena> DeserijalizujOcenu() throws Exception {	
		ArrayList<Ocena> alo = new ArrayList<Ocena>();
		File file = new File(pf.PutanjaOceneOc);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = null;
	    try {
	    	ois = new ObjectInputStream(fis);
	    	alo = (ArrayList<Ocena>)ois.readObject();
	    }catch(EOFException e) {
	    	System.out.println("End of file.");
	    }
	    try {
	        ois.close();
	        fis.close();
	    }catch(NullPointerException e) {
	    	System.out.println("");
	    }
	    return alo;
	}
	
	public void SerijalizujOcenu(Ocena objekat, ArrayList<Ocena> alo, boolean indikator) throws Exception{
        File file = new File(pf.PutanjaOceneOc);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream aoos = new ObjectOutputStream(fos);
        if(indikator == true) {
            alo.add(objekat);
        }else {}
        aoos.writeObject(alo);
        aoos.close();
        fos.close();
    }
	
}
