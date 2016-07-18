package com.xebia.test;

public class Tondeuse implements IObservateur {

	private Position position = new Position();
	private int maxX = 0;
	private int maxY = 0;

	public Tondeuse() {
		super();
	}

	public Tondeuse(Position position) {
		super();
		this.position = position;
	}

	public void updateAfterNotification(Observable observable) {
		Pelouse pelouse = (Pelouse) observable;
		this.maxX = pelouse.getLargueur();
		this.maxY = pelouse.getLongueur();

	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxInt(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void move(MouvementInstructions mi){
		Position po = null;
		for(int i=0, taille = mi.getMouvement().size();i<taille;i++){
			po = Directions.getDirectionBySymbol(mi.getMouvement().get(i)).process(this.position);
			if(checkPosition(po)){
				this.position = po;
			}
		}
	}
	
	private boolean checkPosition(Position po){
		boolean result = false;
		if(po.getX()<=this.maxX && po.getY()<=this.maxY && po.getX()>=0 && po.getY()>=0){
			result = true;
		}
		return result;
	}
}

