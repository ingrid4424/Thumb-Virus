import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoUno extends Enemigo {

	public EnemigoUno(PApplet app, int posX, int posY, int sizeX, int sizeY, int vel, PImage img) {
		super(app, posX, posY, sizeX, sizeY, vel, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		setPosY(getPosY() + getVel());
	}

}
