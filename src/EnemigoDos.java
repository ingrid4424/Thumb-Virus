import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoDos extends Enemigo {

	public EnemigoDos(PApplet app, int posX, int posY, int sizeX, int sizeY, int vel, PImage img) {
		super(app, posX, posY, sizeX, sizeY, vel, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
	setPosY(getPosY()+ getVel());
		// TODO Auto-generated method stub
		
	}

}
