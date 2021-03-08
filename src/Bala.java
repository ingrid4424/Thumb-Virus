import processing.core.PApplet;

public class Bala {
	private int posX, posY, sizeX, sizeY;
	private int direccion;
	private int bala;
	private PApplet app;
	
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

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getBala() {
		return bala;
	}

	public void setBala(int bala) {
		this.bala = bala;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public Bala (PApplet app, int posX, int posY, int sizeX, int sizeY, int direccion){
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.sizeX=sizeX;
		this.sizeY=sizeY;
		this.direccion=direccion;
		
	}
	
public void pintarBala() {
	this.app.circle(this.posX, this.posY, this.sizeX);
	//this.app.image ( this.posX, this.posY,this.sizeX,this.sizeY);
}

public void moverBala() {
	this.posY = this.posY+this.direccion;
}
}
