package entidades;

public class Persona {
	public int dni;
	public String nombre;
	public String apellido;
	public String email;
	
	public Persona(){
		
	}
	
	public Persona(int dni, String nombre, String apellido, String email){
		setdni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
	}
	
	public void setdni(int dni){
		this.dni=dni;
	}
	public int getdni(){
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
