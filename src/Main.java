import java.lang.reflect.Array;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	// PImage variable solamente vive en PApplet
	PImage img;
	// Instancia de la clase escenarios
	Escenarios escenarioInicial;
	Escenarios escenarioInstruccion;
	Escenarios escenarioJuego;
	Escenarios escenarioResumen;
	Escenarios escenarioContexto;

	// Instancis de personaje
	Personaje personaje;

	EnemigoUno[] enemigosUno;
	ArrayList<EnemigoUno[]> listEnemigoUno;

	int pantallaActual;
	int moverpersonaje;

	public void settings() {
		size(965, 726);
	}

	public void setup() {
		escenarioInicial = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Portada.png"));
		escenarioContexto = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Contexto.png"));
		escenarioInstruccion = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Instrucción.png"));
		escenarioJuego = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Juego.png"));
		escenarioResumen = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Resumen.png"));
		personaje = new Personaje(this, width / 2 - 45, height / 2 + 250, 90, 90, loadImage("./images/Estrella.png"));
		pantallaActual = 3;
		moverpersonaje = 0;
		enemigosUno = new EnemigoUno[7];
		for (int i = 0; i < enemigosUno.length; i++) {
			enemigosUno[i] = new EnemigoUno(this, (i * 80) + 60, -50, 80, 80, 1,
					loadImage("./images/Enemigo Chuspa.png"));
		}
		listEnemigoUno = new ArrayList<>();
	}

	public void draw() {
		switch (pantallaActual) {

		case 0:
			escenarioInicial.pintarEscenarios();
			break;
		case 1:
			escenarioContexto.pintarEscenarios();
			escenarioContexto.pintarBoton(width / 2 - 100, height / 2 + 150, 200, 100,
					loadImage("./images/Botón sgte.png"));

			break;
		case 2:
			escenarioInstruccion.pintarEscenarios();
			escenarioInstruccion.pintarBoton(width / 2 - 100, height / 2 + 220, 200, 100,
					loadImage("./images/Botón sgte.png"));

			break;
		case 3:
			escenarioJuego.pintarEscenarios();
			personaje.pintarPersonaje();
			personaje.pintarVidas(799, 45, 30, 30, loadImage("./images/Vida.png"));
			personaje.pintarVidas(844, 45, 30, 30, loadImage("./images/Vida.png"));
			personaje.pintarVidas(888, 45, 30, 30, loadImage("./images/Vida.png"));


			agregarEnemigos();
			
			for(int i = 0; i< listEnemigoUno.size(); i++) {
				
				for(int j  = 0; j<listEnemigoUno.get(i).length; j++) {
					listEnemigoUno.get(i)[j].pintarEnemigo();
					listEnemigoUno.get(i)[j].mover();
				}
				
			}
			break;
		case 4:
			escenarioResumen.pintarEscenarios();

			break;
		default:
			break;

		}
		fill(0, 0, 0);
		text(mouseX + "    " + mouseY, mouseX, mouseY);
	}

	public void keyPressed() {
		switch (pantallaActual) {
		case 0:

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:
			personaje.mover(keyCode);
			personaje.disparar(keyCode);
			break;
		case 4:

			break;
		default:
			break;
		}
	}

	public void mousePressed() {

		switch (pantallaActual) {
		case 0:
			if (dist(470, 400, mouseX, mouseY) < 50) {
				pantallaActual = escenarioInicial.sgtePantalla(pantallaActual);
			}
			break;
		case 1:
			if (dist(width / 2 + 50, height / 2 + 200, mouseX, mouseY) < 75) {
				pantallaActual = escenarioContexto.sgtePantalla(pantallaActual);
			}
			break;
		case 2:
			if (dist(478, 632, mouseX, mouseY) < 70) {
				pantallaActual = escenarioInstruccion.sgtePantalla(pantallaActual);
			}
			break;
		case 3:

			break;
		case 4:

			break;
		default:
			break;
		}
	}

	public void agregarEnemigos() {
		if (frameCount % 180 == 0) {
			listEnemigoUno.add(enemigosUno);
			System.out.println(listEnemigoUno.size());
		}
	}

}
