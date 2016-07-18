package com.xebia.test;


public class TondeuseInstructions implements IInstructions{

	private Position position;
	
	public TondeuseInstructions() {
		super();
	}
	
	public TondeuseInstructions(Position position) {
		super();
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof TondeuseInstructions){
			TondeuseInstructions ti = (TondeuseInstructions)obj;
			return (this.getPosition().equals(ti.getPosition()));
		}
		else{
			return false;
		}
	}
}
