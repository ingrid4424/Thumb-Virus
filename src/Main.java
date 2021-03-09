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

	ArrayList<EnemigoUno[]> listEnemigoUno;

	ArrayList<EnemigoDos[]> listEnemigoDos;

	int pantallaActual;
	int moverpersonaje;
	int temporizador;

	public void settings() {
		size(965, 726);
	}

	public void setup() {
		escenarioInicial = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Portada.png"));
		escenarioContexto = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Contexto.png"));
		escenarioInstruccion = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Instrucción.png"));
		escenarioJuego = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Juego.png"));
		escenarioResumen = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Resumen.png"));
		personaje = new Personaje(this, width / 2 - 45, height / 2 + 250, 90, 90, loadImage("./images/Estrella.png"),3);
		pantallaActual = 3;
		moverpersonaje = 0;
		temporizador = 0;
		
		listEnemigoUno = new ArrayList<>();

	
		listEnemigoDos = new ArrayList<>();

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
			for(int i=0; i<personaje.getVida(); i++) {
				personaje.pintarVidas(799 +(i*40), 45, 30, 30, loadImage("./images/Vida.png"));
			}
			/*personaje.pintarVidas(799, 45, 30, 30, loadImage("./images/Vida.png"));
			personaje.pintarVidas(844, 45, 30, 30, loadImage("./images/Vida.png"));
			personaje.pintarVidas(888, 45, 30, 30, loadImage("./images/Vida.png"));*/
			textSize(18);
			text(temporizador, 120, 70);


			for (int i = 0; i < listEnemigoUno.size(); i++) {

				for (int j = 0; j < listEnemigoUno.get(i).length; j++) {
					listEnemigoUno.get(i)[j].pintarEnemigo();
					listEnemigoUno.get(i)[j].mover();
				}
			}

			for (int a = 0; a < listEnemigoDos.size(); a++) {

				for (int k = 0; k < listEnemigoDos.get(a).length; k++) {
					listEnemigoDos.get(a)[k].pintarEnemigo();
					listEnemigoDos.get(a)[k].mover();               

				}
			}

			agregarEnemigos();
			temporizador();
			perderVidas();
			
			if(gameOver()) {
				pantallaActual ++;
			}
			break;
		case 4:
			escenarioResumen.pintarEscenarios();
			textSize(50);
			text(temporizador, 460, 420);
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
		EnemigoUno[] enemigosUno = new EnemigoUno[7];
		for (int i = 0; i < enemigosUno.length; i++) {
			enemigosUno[i] = new EnemigoUno(this, (i * 80) + 60, -50, 80, 80, 1,
					loadImage("./images/Enemigo Chuspa.png"));
		}
		if (frameCount % 180 == 0) {
			listEnemigoUno.add(enemigosUno);
			System.out.println(listEnemigoUno.size());
		}

		EnemigoDos[] enemigoDos = new EnemigoDos[7];
		for (int a = 0; a < enemigoDos.length; a++) {
			enemigoDos[a] = new EnemigoDos(this, (a * 100) + 100, -30, 80, 80, 3,
					loadImage("./images/Enemigo Botella.png"));
		}
		if (frameCount % 90 == 0) {
			listEnemigoDos.add(enemigoDos);
			System.out.println(listEnemigoDos.get(0)[0]);

		}

	}
	
	public void temporizador() {
		if(frameCount %60 == 0) {
			temporizador ++;
		}
	}
	
	public void perderVidas() {
		if(frameCount %60 == 0){
			personaje.setVida(personaje.getVida()-1);
		}
	}
	
	public boolean gameOver() {
		if (personaje.getVida() == 0) {
			return true;

		}
		return false;
		
	}
}