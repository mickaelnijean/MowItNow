package com.xebia.test;

public class PelouseInstructions implements IInstructions{
	
	private int longeur = 0;
	private int largeur = 0;
	
	public PelouseInstructions() {
		super();
	}
	
	public PelouseInstructions(int longueur, int largeur){
		super();
		this.largeur = largeur; 
		this.longeur = longueur;
	}

	public int getLongeur() {
		return longeur;
	}

	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof PelouseInstructions){
			PelouseInstructions pi = (PelouseInstructions)obj;
			return (this.getLargeur()== pi.getLargeur() && this.getLongeur()==pi.getLongeur());
		}
		else{
			return false;
		}
	}
}
