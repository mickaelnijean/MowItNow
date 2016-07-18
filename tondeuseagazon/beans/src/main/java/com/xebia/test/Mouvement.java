package com.xebia.test;

import java.util.HashMap;
import java.util.Map;

public enum Mouvement {

	GO("A");
	
	private String symbol;
	private static Map<String,Mouvement> movementBySymbol  = new HashMap<String, Mouvement>();
	
	private Mouvement(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	static{
		for(Mouvement movement : values()){
			movementBySymbol.put(movement.getSymbol(), movement);
		}
	}
		
	public static Mouvement getMovementBySymbol(String symbol){
		Mouvement result = movementBySymbol.get(symbol);
		if(result!=null){
			return result;
		}
		else{
			throw new IllegalArgumentException("Symbole incconu : " + symbol);
		}
	}
}
