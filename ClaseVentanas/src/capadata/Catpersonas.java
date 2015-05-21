package capadata;

import java.util.ArrayList;
import entidades.Persona;

public class Catpersonas {
ArrayList<Persona> lista = new ArrayList<Persona>();
	
	public Persona updatePersona(int dni, String nombre, String apellido, String email){
		for (Persona p: lista){
			if (p.getdni() == dni){
				p.setNombre(nombre);
				p.setApellido(apellido);
				p.setEmail(email);
				return p;
			}
		}
		return null;
	}
	public String deletePersona(int dni){
		String message = "Persona no encontrada";
		for(Persona p: lista){
			if (p.getdni() == dni){
				lista.remove(p);
				return (message = "Persona elimina");
			}
		}
		return message;	
	}
	public void addPersona(int dni,String nombre, String apellido, String email){
		Persona npers = new Persona( dni , nombre , apellido , email );
		lista.add(npers);
	}
	
	public Persona searchPersona(int dni){
		Persona pers = new Persona();
		for(Persona p: lista){
			if (p.getdni() == dni){
				pers= p;
				return pers;
			}
		}
		return null;
	}
	
}
