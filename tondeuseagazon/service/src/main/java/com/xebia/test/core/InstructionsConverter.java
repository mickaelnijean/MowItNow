package com.xebia.test.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.xebia.test.IInstructions;
import com.xebia.test.MouvementInstructions;
import com.xebia.test.PelouseInstructions;
import com.xebia.test.Position;
import com.xebia.test.Sens;
import com.xebia.test.TondeuseInstructions;

public class InstructionsConverter {

	private static Logger logger = Logger.getLogger(InstructionsConverter.class);

	private final static Pattern pelousePattern = Pattern.compile("[[0-9]{2}]");
	private final static Pattern tondeusePattern = Pattern.compile("[0-9]{2}[a-zA-Z]{1}");
	private final static Pattern mouvementPattern = Pattern.compile("[a-zA-Z]*");


	public static IInstructions getInstructionFromString(String line){
		if(logger.isDebugEnabled()){
			logger.debug("<getInstructionFromString");
		}

		//on supprime tous les espaces pour faciliter la suite
		line = line.replaceAll(" ", "");
		IInstructions result;

		Matcher tondeuseMatcher = tondeusePattern.matcher(line);
		if(tondeuseMatcher.find()){
			//si on match alors le caractere 0,1 et 2 existent
			Position position = new Position(Integer.parseInt(line.charAt(0)+""), Integer.parseInt(line.charAt(1)+""), Sens.getSensBySymbol(line.charAt(2)+""));
			result = new TondeuseInstructions(position);
		}else{
			//si on match alors le caractere 0 et 1 existent
			Matcher pelouseMatcher = pelousePattern.matcher(line);
			if(pelouseMatcher.find()){
				result = new PelouseInstructions(Integer.parseInt(line.charAt(0)+""), Integer.parseInt(line.charAt(1)+""));
			}
			else{
				Matcher mouvementMatcher = mouvementPattern.matcher(line);
				List<String> mouvement = new ArrayList<String>();
				if(mouvementMatcher.find()){
					for(int i=0, taille = line.length();i<taille;i++){
						mouvement.add(line.charAt(i)+"");
					}
				}
				result = new MouvementInstructions(mouvement);
			}
		}

		if(logger.isDebugEnabled())
			logger.debug("getInstructionFromString>");

		return result;
	}


}
