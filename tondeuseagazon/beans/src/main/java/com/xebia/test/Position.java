package com.xebia.test;

public class Position {
	
	private int x = 0;
	private int y = 0;
	private Sens sens = Sens.NORTH;
	
	public Position() {
		super();
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Position(int x, int y, Sens sens) {
		super();
		this.x = x;
		this.y = y;
		this.sens = sens;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void decX() {
		this.x = this.x-1;
	}
	
	public void incX() {
		this.x = this.x+1;
	}
	
	public void decY() {
		this.y = this.y-1;
	}
	
	public void incY() {
		this.y = this.y+1;
	}

	public Sens getSens() {
		return sens;
	}

	public void setSens(Sens sens) {
		this.sens = sens;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Position){
			Position po = (Position)obj;
			if(this.getX() == po.getX() && this.getY() == po.getY()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}
