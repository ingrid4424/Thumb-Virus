import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Personaje {
	private int posX, posY, sizeX, sizeY;
	private int vida;
	private PApplet app; // llave que le permite acceder a la librería
	private PImage img;
	private ArrayList<Bala> balas;

	public Personaje(PApplet app, int posX, int posY, int sizeX, int sizeY, PImage img) {
		this.posX = posX;
		this.posY = posY;
		this.vida = vida;
		this.app = app;
		this.img = img;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		balas = new ArrayList<Bala>();
	}

	public void mover(int key) {
		if(key == PConstants.LEFT) {
			this.posX = this.posX-4;
			System.out.println(this.posX);
		}
		if(key == PConstants.RIGHT) {
			this.posX = this.posX+4;
			System.out.println(this.posX);

		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PImage getImg() {
		return img;
	}

	public void setImg(PImage img) {
		this.img = img;
	}

	public ArrayList<Bala> getBalas() {
		return balas;
	}

	public void setBalas(ArrayList<Bala> balas) {
		this.balas = balas;
	}

	public void pintarPersonaje() {
		this.app.image(this.img, this.posX, this.posY, this.sizeX, this.sizeY);
		for(int i = 0; i< balas.size(); i++) {
			balas.get(i).pintarBala();
			balas.get(i).moverBala();
		}
	}

	public void pintarVidas(int posX, int posY, int sizeX, int sizeY, PImage img) {
//this.app.imageMode(this.app.CENTER); imageMode(CENTER);
		this.app.image(img, posX, posY, sizeX, sizeY);
	}

	public void disparar(int key) {
		if(key == 32) {
			balas.add(new Bala(app, posX+(sizeX/2), posY, 15, 15, -2));
		}
		System.out.println(balas.size());
	}

}
