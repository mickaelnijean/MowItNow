package com.xebia.test;

public class Pelouse extends Observable implements ISurface{

	private int longueur = 0;
	private int largueur = 0;
	private int hauteur = 10;

	public Pelouse() {
		super();
	}

	public Pelouse(int cote){
		this.largueur = cote;
		this.longueur = cote;
	}

	public Pelouse(int longueur, int largeur){
		this.largueur = largeur;
		this.longueur = longueur;
	}
	
	public Pelouse(int longueur, int largeur, int hauteur){
		this.largueur = largeur;
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargueur() {
		return largueur;
	}

	public void setLargueur(int largueur) {
		this.largueur = largueur;
	}
	
	
}
