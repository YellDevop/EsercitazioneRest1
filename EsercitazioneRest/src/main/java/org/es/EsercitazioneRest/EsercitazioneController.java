package org.es.EsercitazioneRest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsercitazioneController {

	//Questo endpoint restituisce il messaggio personalizzato con nome, cognome e titolo del corso. il LocalDate.now() rappresenta la data attuale.
	@GetMapping("all/ammissione/{nome}/{cognome}/{titolo}")
	public String messaggioAmmissione(@PathVariable String nome, @PathVariable String cognome, @PathVariable String titolo) {
		return "Congratulazioni " + nome + " " + cognome + ", sei stato ammesso al corso di " + titolo + " il " + LocalDate.now();
	}
	
	//Questo endpoint esegue il risultato delle operazioni nello switch tra due numeri passati nei parametri.
	@GetMapping("all/operazione")
	public String operazione(@RequestParam int num1, @RequestParam int num2, @RequestParam String operazione) {
		switch(operazione.toLowerCase()) {
		case "addizione":
			return "Il risultato dell'addizione è " + (num1 + num2);
		case "moltiplicazione":
			return "Il risultato della moltiplicazione è " + (num1 * num2);
		case "sottrazione":
			return "Il risultato della sottrazione è " + (num1 - num2);
		case "divisione":
			if(num2 != 0) {
				return "Il risultato della divisione è " + (num1/num2);
			} else {
				return "ERRORE, NON PUOI DIVIDERE PER ZERO!";
			}
		default:
			return "Operazione non riuscita";
		}
	}
	@GetMapping("all/verificaEmail")
	public String verificaEmail(@RequestParam String email) {
		String[] emailRegistrate = {"lol@lol.it", "asd@asd.it"};
		for(String emailEsistente : emailRegistrate) {
			if(emailEsistente.equals(email)) {
				return "L'email " + email + " è già registrata";
			}
			
		}
		return "L'email " + email + " non è registrata";
	}
	
}
