import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemigo {
	private int posX, posY, sizeX, sizeY;
	private int vel;
	private PApplet app;
	private PImage img;
	
	public Enemigo(PApplet app, int posX, int posY, int sizeX, int sizeY,int vel,PImage img) {
		this.app=app;
		this.img=img;
		this.posX=posX;
		this.posY=posY;
		this.sizeX=sizeX;
		this.sizeY=sizeY;
		this.vel=vel;
		
	}
	
	public void pintarEnemigo () {
		this.app.image(img,posX,posY,sizeX,sizeY);
	}
	
	public abstract void mover();

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

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
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
	
}
