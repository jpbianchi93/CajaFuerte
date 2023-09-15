package ar.edu.unahur.obj.cajafuerte;

public class CajaFuerte {
	private Boolean estaAbierta = Boolean.TRUE;
	private int contrasenia = 1234;
	private Boolean estaBloqueada = Boolean.FALSE;

	private void bloquearPuerta() {
		estaBloqueada = Boolean.TRUE;
	}
	private void desbloquearPuerta() {
		estaBloqueada = Boolean.FALSE;
	}

	public Boolean laPuertaEstaAbierta() {
		return estaAbierta;
	}
	public int contraseniaActual() {
		return this.contrasenia;
	}
	public Boolean laPuertaEstaBloqueada() {
		return estaBloqueada;
	}
	
	public void abrir() {
		if(!this.laPuertaEstaBloqueada()) {			
			this.estaAbierta = Boolean.TRUE;
			this.cambiarContrasenia(1234);
		}
	}
	public void abrir(int contrasenia) {
		if(this.contraseniaActual() == contrasenia) {
			this.desbloquearPuerta();
			this.abrir();
		}
	}
	public void cerrar() {
		this.estaAbierta = Boolean.FALSE;
	}
	public void cerrar(int contrasenia) {
		this.cerrar();
		this.cambiarContrasenia(contrasenia);
		this.bloquearPuerta();
	}
	public void cambiarContrasenia(int contraseniaNueva) {
		this.contrasenia = contraseniaNueva;
	}
	public void abrirConLlave() {
		this.abrir(this.contraseniaActual());
	}
	
}
