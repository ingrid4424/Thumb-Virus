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

	ArrayList<ArrayList <EnemigoUno>> listEnemigoUno;

	ArrayList<ArrayList <EnemigoDos>>listEnemigoDos;

	int pantallaActual;
	int moverpersonaje;
	int temporizador;
	int puntaje;

	public void settings() {
		size(965, 726);
	}

	public void setup() {
		escenarioInicial = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Portada.png"));
		escenarioContexto = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Contexto.png"));
		escenarioInstruccion = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Instrucción.png"));
		escenarioJuego = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Juego.png"));
		escenarioResumen = new Escenarios(this, 0, 0, 925, 726, loadImage("./images/Pantalla Resumen.png"));
		personaje = new Personaje(this, width / 2 - 45, height / 2 + 250, 90, 90, loadImage("./images/Estrella.png"),
				3);
		pantallaActual = 3;
		moverpersonaje = 0;
		temporizador = 0;
		puntaje = 0;

		listEnemigoUno = new ArrayList<>();

		listEnemigoDos = new ArrayList<>();

	}

	public void draw() {
		switch (pantallaActual) {

		case 0:
			escenarioInicial.pintarEscenarios();
			reset();
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
			for (int i = 0; i < personaje.getVida(); i++) {
				personaje.pintarVidas(799 + (i * 40), 45, 30, 30, loadImage("./images/Vida.png"));
			}
			/*
			 * personaje.pintarVidas(799, 45, 30, 30, loadImage("./images/Vida.png"));
			 * personaje.pintarVidas(844, 45, 30, 30, loadImage("./images/Vida.png"));
			 * personaje.pintarVidas(888, 45, 30, 30, loadImage("./images/Vida.png"));
			 */
			textSize(18);
			text(temporizador, 112, 70);
			text(puntaje, 68, 130);

			for (int i = 0; i < listEnemigoUno.size(); i++) {

				for (int j = 0; j < listEnemigoUno.get(i).size(); j++) {
					listEnemigoUno.get(i).get(j).pintarEnemigo();
					listEnemigoUno.get(i).get(j).mover();
					}
			}

			for (int a = 0; a < listEnemigoDos.size(); a++) {

				for (int k = 0; k < listEnemigoDos.get(a).size(); k++) {
					listEnemigoDos.get(a).get(k).pintarEnemigo();
					listEnemigoDos.get(a).get(k).mover();

				}
			}

			agregarEnemigos();
			eliminarEnemigo();
			temporizador();
			perderVidas();

			if (gameOver()) {
				pantallaActual++;
			}
			break;
		case 4:
			escenarioResumen.pintarEscenarios();
			fill(255);
			textSize(50);
			text(temporizador, 468, 426);
			text(puntaje, 486, 266);
			escenarioResumen.pintarBoton(width / 2 - 100, height / 2 + 220, 200, 100,
					loadImage("./images/Boton reiniciar.png"));

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
			if (dist(478,634, mouseX, mouseY) < 75) {
				pantallaActual = escenarioContexto.sgtePantalla(pantallaActual=-1);}
			break;
		default:
			break;
		}
	}

	public void agregarEnemigos() {
		ArrayList<EnemigoUno> enemigosUno = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			enemigosUno.add( new EnemigoUno(this, (i * 100) + 120, -60, 80, 80, 1,
					loadImage("./images/Enemigo Chuspa.png")));
		}
		if (frameCount % 180 == 0) {
			listEnemigoUno.add(enemigosUno);
		}

		ArrayList<EnemigoDos> enemigosDos = new ArrayList<>();
		for (int a = 0; a < 7; a++) {
			enemigosDos.add( new EnemigoDos(this, (a * 100) + 100, -80, 80, 80, 1,
					loadImage("./images/Enemigo Botella.png")));
	
		}
		if (frameCount % 90 == 0) {
			listEnemigoDos.add(enemigosDos);

		}

	}

	public void eliminarEnemigo() {
		for (int a = 0; a < personaje.getBalas().size(); a++) {
			// eliminar enmigos dos
			for (int i = 0; i < listEnemigoDos.size(); i++) {

				for (int j = 0; j < listEnemigoDos.get(i).size(); j++) {
					//dist(x,y,x2,y2);
					if (dist(personaje.getBalas().get(a).getPosX(),
							personaje.getBalas().get(a).getPosY(),
							listEnemigoDos.get(i).get(j).getPosX()+(listEnemigoDos.get(i).get(j).getSizeX()/2),
							listEnemigoDos.get(i).get(j).getPosY()+(listEnemigoDos.get(i).get(j).getSizeY()/2))
							< personaje.getBalas().get(a).getSizeX()) {
						listEnemigoDos.get(i).remove(j);
						puntaje = puntaje + 1;
						System.out.println("entr");
					}
				}
			}
			
			for (int i = 0; i < listEnemigoUno.size(); i++) {

				for (int j = 0; j < listEnemigoUno.get(i).size(); j++) {
					//dist(x,y,x2,y2);
					if (dist(personaje.getBalas().get(a).getPosX(),
							personaje.getBalas().get(a).getPosY(),
							listEnemigoUno.get(i).get(j).getPosX()+(listEnemigoUno.get(i).get(j).getSizeX()/2),
							listEnemigoUno.get(i).get(j).getPosY()+(listEnemigoUno.get(i).get(j).getSizeY()/2))
							< personaje.getBalas().get(a).getSizeX()) {
						listEnemigoUno.get(i).remove(j);
						puntaje = puntaje + 1;
						//System.out.println("entr");
					}
				}
			}

		}

	}

	public void temporizador() {
		if (frameCount % 60 == 0) {
			temporizador++;
		}
	}

	public void perderVidas() {
		for (int i = 0; i < listEnemigoDos.size(); i++) {

			for (int j = 0; j < listEnemigoDos.get(i).size(); j++) {
				if(listEnemigoDos.get(i).get(j).getPosY()>730) {
					listEnemigoDos.remove(i);
					personaje.setVida(personaje.getVida() - 1);
				}
			}
		}
		/*
		 * if (frameCount % 60 == 0) {  }
		 */
	}

	public boolean gameOver() {
		if (personaje.getVida() == 0) {
			return true;

		}
		return false;

	}
	
	public void reset() {
		personaje.setVida(3);
		listEnemigoDos.removeAll(listEnemigoDos);
		listEnemigoUno.removeAll(listEnemigoUno);
		temporizador = 0;
		puntaje=0;
		personaje.getBalas().removeAll(personaje.getBalas());
	
		
	}
}