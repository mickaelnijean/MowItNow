package com.xebia.test.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;

import com.xebia.test.Position;
import com.xebia.test.PositionConverter;
import com.xebia.test.file.interfaces.IWriter;

public class WriterFile implements IWriter{
	
	private static Logger logger = Logger.getLogger(WriterFile.class);
	
	public static void writeResult(String path, List<Position> positions){
		if(logger.isDebugEnabled()){
			logger.debug("<writeResult");
		}
		PrintWriter pw = null;
		BufferedWriter bw = null;
		FileWriter fileout = null;
		try{
			fileout = new FileWriter(new File(path));
			bw = new BufferedWriter(fileout);
			pw = new PrintWriter(bw);
			pw.write(PositionConverter.positionsToString(positions));
			pw.flush();

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		finally{
			try {
				if(fileout!=null)
				fileout.close();
				if(bw!=null)
					bw.close();
				if(pw!=null)
					pw.close();
				
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("writeResult>");
		}
	}

}
