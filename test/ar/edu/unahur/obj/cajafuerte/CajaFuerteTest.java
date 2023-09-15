package ar.edu.unahur.obj.cajafuerte;

import org.junit.Assert;
import org.junit.Test;

public class CajaFuerteTest {

	@Test
	//asegurar que se importo correctamente la libreria
	public void pruebaJunit() {}
	
	@Test
	public void alCrearUnaCajaFuerteLaPuertaEstaAbierta() {
		//Preparacion
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		valorObtenido = miCajaFuerte.laPuertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alCerrarLaCajaFuertaDeberiaQuedarCerrada() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		//Ejecucion
		miCajaFuerte.cerrar();
		valorObtenido = miCajaFuerte.laPuertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alAbrirUnaCajaFuerteDeberiaQuedarAbierta() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		//Ejecucion
		miCajaFuerte.cerrar();
		miCajaFuerte.abrir();	
		valorObtenido = miCajaFuerte.laPuertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alAbrirUnaCajaFuerteLaContraseniaDeberiaSer1234() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		int valorEsperado = 1234;
		int valorObtenido = 0;
		//Ejecucion
		miCajaFuerte.abrir();
		valorObtenido = miCajaFuerte.contraseniaActual();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void cambiarLaContraseniaA4321() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		int valorEsperado = 4321;
		int valorObtenido = 0;
		//Ejecucion
		miCajaFuerte.cambiarContrasenia(4321);
		valorObtenido = miCajaFuerte.contraseniaActual();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alIngresarLaContraseniaCorrectaLaPuertaDebeQuedarBloqueada() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		miCajaFuerte.cambiarContrasenia(4321);
		miCajaFuerte.cerrar(4321);
		valorObtenido = miCajaFuerte.laPuertaEstaBloqueada();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alIngresarLaContraseniaIcorrectaLaPuertaNoDebeDesbloquearse() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		//Ejecucion
		miCajaFuerte.abrir(1235);
		valorObtenido = miCajaFuerte.laPuertaEstaBloqueada();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alEstarBloqueadaLaPuertaNoDebePoderAbrirse() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		//Ejecucion
		miCajaFuerte.cerrar(1234);
		miCajaFuerte.abrir();
		valorObtenido = miCajaFuerte.laPuertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alEstarDesbloqueadaLaPuertaDebePoderAbrirse() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		miCajaFuerte.abrir();
		valorObtenido = !miCajaFuerte.laPuertaEstaBloqueada();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alAbrirseLaPuertaLaContraseniaDebeVolverAlValor1234() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		int valorEsperado = 1234;
		int valorObtenido = 0;
		//Ejecucion
		miCajaFuerte.cambiarContrasenia(3333);
		miCajaFuerte.cerrar(3333);
		miCajaFuerte.abrir(3333);
		valorObtenido = miCajaFuerte.contraseniaActual();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alUsarLaLlaveMaestraLaPuertaDebeQuedarDesbloqueada() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		int valorEsperado = 1234;
		int valorObtenido = 0;
		//Ejecucion
		miCajaFuerte.cerrar(1234);
		miCajaFuerte.abrirConLlave();
		valorObtenido = miCajaFuerte.contraseniaActual();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alUsarLaLlaveMaestraLaPuertaDebeQuedarAbierta() {
		//Preparacion
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		int valorEsperado = 1234;
		int valorObtenido = 0;
		//Ejecucion
		miCajaFuerte.cerrar(1234);
		miCajaFuerte.abrirConLlave();
		valorObtenido = miCajaFuerte.contraseniaActual();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//cleanCode
	private CajaFuerte dadoQueExisteUnaCajaFuerte() {
		return new CajaFuerte();
	}
	
}
