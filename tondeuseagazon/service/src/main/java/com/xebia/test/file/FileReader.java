package com.xebia.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xebia.test.IInstructions;
import com.xebia.test.core.InstructionsConverter;
import com.xebia.test.file.interfaces.IReader;

public class FileReader implements IReader{

	private static Logger logger = Logger.getLogger(FileReader.class);

	public static List<IInstructions> getInstructionsFromFile(String path) throws FileNotFoundException,IOException{
		if(logger.isDebugEnabled())
			logger.debug("<getInstructionsFromFile");

		List<IInstructions> instructions = new ArrayList<IInstructions>();
		File file = null;
		InputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			file = Paths.get(path).toFile();
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			// on lit toutes les lignes du fichier d'entrée
			String line;
			while( (line = br.readLine())!=null){
				instructions.add(InstructionsConverter.getInstructionFromString(line));
			}
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		finally{
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		if(logger.isDebugEnabled())
			logger.debug("getInstructionsFromFile>");

		return instructions;
	}

}
