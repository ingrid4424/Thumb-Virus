import processing.core.PApplet;
import processing.core.PImage;

public class Escenarios {
private int posX, posY,sizeX, sizeY;
private int pantalla;
private PApplet app;
private PImage img;

public Escenarios (PApplet app,int posX, int posY, int sizeX, int sizeY, PImage img) {
	this.posX=posX;
	this.posY=posY;
	this.sizeX=sizeX;
	this.sizeY=sizeY;
	this.app = app;
	this.img = img;
}
public void pintarEscenarios () {
	//pintar img
	this.app.image(this.img, this.posX, this.posY);
}

public void pintarBoton(int posX,int posY, int sizeX, int sizeY, PImage img) {
	
	this.app.image(img, posX, posY, sizeX, sizeY);
}

public int sgtePantalla(int currentPantalla) {
	return currentPantalla+1;
	
}

//lista, 5 clases o 5 instancias de esta clase
//abstracto 
//public abstract void mover();

}
