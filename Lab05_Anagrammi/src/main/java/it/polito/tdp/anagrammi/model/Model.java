package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	AnagrammaDAO anagramDao= new AnagrammaDAO();
	public List <String> anagrammiCorretti(String parola) {
		//deve resituire una lista di stringhe
		//questa è l'interfaccia pubblica che usa una funzione ricorsiva
		//interna che fa il lavoro sporco
		List <String> risultatoCorretto= new ArrayList <>();
		List <String> risultatoSbagliato= new ArrayList <>();
		permuta("", parola, 0, risultatoCorretto, risultatoSbagliato); //lancia la ricorsione
		
		return risultatoCorretto;
	}
	
	public List <String> anagrammiSbagliati(String parola) {
		//deve resituire una lista di stringhe
		//questa è l'interfaccia pubblica che usa una funzione ricorsiva
		//interna che fa il lavoro sporco
		List <String> risultatoCorretto= new ArrayList <>();
		List <String> risultatoSbagliato= new ArrayList <>();
		permuta("", parola, 0, risultatoCorretto, risultatoSbagliato); //lancia la ricorsione
		
		return risultatoSbagliato;
	}
	//il livello = lunghezza soluzione parziale
	//il livello iniziale=0
	//gli passo la stringa parziale
	//parziale= stringa che contiene l'anagramma incompleto in fase di costruzione
	//ha anche bisogno di sapere quali sono le lettere rimaste
	//lettere= lettere della parola iniziale che non abbiamo ancora utilizzato
	//       (=== il sotto problema che dobbiamo analizzare)
	
	private void permuta(String parziale,String lettere,int livello, List <String>risultatoCorretti, List <String>risultatoSbagliati) {
		//lo schema è sempre questo
		if(lettere.length()==0)//caso terminale 
		{
			//la soluzione parziale è anche una soluzione completa
			//System.out.println(parziale);
			if(this.anagramDao.isCorrect(parziale)) {
			risultatoCorretti.add(parziale);
			}
			else
				risultatoSbagliati.add(parziale);
		}
		else {
			//fai ricorsione
			//sottoproblema == una lettera (un singolo carattere) di 'lettere'
			for(int pos=0; pos< lettere.length(); pos++) {
				char tentativo= lettere.charAt(pos);
				
				String nuovaParziale= parziale+tentativo;
				//lettere= // togli il carattere pos da lettere;
				String nuoveLettere= lettere.substring(0,pos)+lettere.substring(pos+1);
				permuta(nuovaParziale, nuoveLettere, livello+1,risultatoCorretti, risultatoSbagliati);
				//funzione parziale più lunga e problema piu corto
				//prima o poi arriverà a zero e quindi nel caso terminale
				
				//backtracking(NON SERVE SE FACCIO NUOVAPARZIALE E LETTERE)
				//rimetti a posto parziale (togli ultimo carattere)
				//rimetti a posto 'lettere'
			}
		}
	}
}
