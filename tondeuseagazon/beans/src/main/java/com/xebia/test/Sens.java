package com.xebia.test;

import java.util.HashMap;
import java.util.Map;

public enum Sens {

	NORTH("N"),EAST("E"),WEST("W"),SOUTH("S");

	private final String symbol;
	private static final Map<String,Sens> symbols = new HashMap<String, Sens>();

	private Sens(String symbol){
		this.symbol=symbol;
	}

	public String getSymbol(){
		return this.symbol;
	}

	static {
		for (Sens sens : values()) {
			symbols.put(sens.getSymbol(), sens);
		}
	}

	public static Sens getSensBySymbol(String symbol) {
		final Sens result = symbols.get(symbol);
		if (result != null) {
			return result;
		}
		throw new IllegalArgumentException("Symbole incconu : " + symbol);
	}

	public Sens toTheRight(){
		switch(this){
		case NORTH: return Sens.EAST;
		case EAST: return Sens.SOUTH;
		case WEST: return Sens.NORTH;
		case SOUTH: return Sens.WEST;
		default:throw new NullPointerException("Cette direction n'est pas atteignable");
		}
	}

	public Sens toTheLeft(){
		switch(this){
		case NORTH: return Sens.WEST;
		case EAST: return Sens.NORTH;
		case SOUTH: return Sens.EAST;
		case WEST: return Sens.SOUTH;
		default:throw new NullPointerException("Cette direction n'est pas atteignable");
		}
	}

}
