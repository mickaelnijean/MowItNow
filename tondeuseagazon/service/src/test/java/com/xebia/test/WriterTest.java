package com.xebia.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.test.file.WriterFile;

public class WriterTest {

	@Test
	public void writeAPositionFile(){
		String path = "C:\\tools\\fileout.txt";
		List<Position> positions = new ArrayList<Position>();
		positions.add(new Position(0, 0, Sens.EAST));
		positions.add(new Position(1, 2, Sens.NORTH));
		
		WriterFile.writeResult(path, positions);
		
		File file = new File(path);
		Assert.assertTrue(file.canRead());		
	}
}
