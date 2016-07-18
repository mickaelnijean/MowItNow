package com.xebia.test;

import java.util.List;

import org.apache.log4j.Logger;

public class PositionConverter {

	private static Logger logger = Logger.getLogger(PositionConverter.class);

	public static String positionsToString(List<Position> positions){
		if(logger.isDebugEnabled()){
			logger.debug("<positionsToString");
		}
		StringBuilder outputString = new StringBuilder();
		for(int i=0, taille= positions.size();i<taille;i++){
			outputString.append(positions.get(i).getX());
			outputString.append(" ");
			outputString.append(positions.get(i).getY());
			outputString.append(" ");
			outputString.append(positions.get(i).getSens().getSymbol());
			outputString.append(System.lineSeparator());
		}
		if(logger.isDebugEnabled()){
			logger.debug("positionsToString>");
		}
		return outputString.toString();
	}

}
