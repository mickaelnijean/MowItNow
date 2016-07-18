package com.mowitnow.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.xebia.test.IInstructions;
import com.xebia.test.Position;
import com.xebia.test.core.InstructionsExecutor;
import com.xebia.test.file.FileReader;
import com.xebia.test.file.WriterFile;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args){
		BasicConfigurator.configure();
		List<IInstructions> instructions = null;
		if(args.length<2){
			logger.error("Il manque un ou plusieurs arguments, le jar prends 2 arguments en entrée, le 1er est le nom du fichier d'entrée et le deuxième le nom du fichier de sortie");
		}
		else{
			try {
				instructions = FileReader.getInstructionsFromFile(args[0]);
			} catch (FileNotFoundException e) {
				System.out.println("File not Found");
			} catch (IOException e) {
				System.out.println("File is not readable");
			}

			InstructionsExecutor ie = new InstructionsExecutor();

			List<Position> positions = ie.process(instructions);

			WriterFile.writeResult(args[1], positions);
		}

	}


}
