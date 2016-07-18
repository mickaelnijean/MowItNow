package com.xebia.test;

import java.util.HashMap;
import java.util.Map;

public enum Directions {
	RIGHT("D") {
		@Override
		public Position process(Position position) {
			position.setSens(position.getSens().toTheRight());
			return position;
		}
	},LEFT("G") {
		@Override
		public Position process(Position position) {
			position.setSens(position.getSens().toTheLeft());
			return position;
		}
	},GO("A") {
		@Override
		public Position process(Position position) {
			return go(position);
		}
	};
	
	private final String symbol;
	private static Map<String,Directions> directionsBySymbol = new HashMap<String, Directions>();
	
	private Directions(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	static{
		for(Directions direction : values()){
			directionsBySymbol.put(direction.getSymbol(), direction);
		}
	}
	
	public static Directions getDirectionBySymbol(String symbol){
		final Directions result = directionsBySymbol.get(symbol);
		if(result!=null){
			return result;
		}
		else{
			throw new IllegalArgumentException("Symbole incconu : " + symbol);
		}
	}
	
	public abstract Position process(Position position);
	
	private static Position go(Position po){
		switch(po.getSens()){
		case NORTH: po.incY(); return po ;
		case EAST: po.incX(); return po;
		case SOUTH: po.decY();return po;
		case WEST: po.decX(); return po;
		default:throw new NullPointerException("Cette direction n'est pas atteignable");
		}
	}
}
