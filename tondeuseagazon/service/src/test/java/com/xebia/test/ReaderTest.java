package com.xebia.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;




import org.junit.Assert;
import org.junit.Test;

import com.xebia.test.file.FileReader;

public class ReaderTest {

	@Test
	public void getInstructionsFromFile(){
		List<IInstructions> instructions = null;
		String path = "";
		try{
			FileReader.getInstructionsFromFile(path);
			Assert.fail("file dosent exist");
		}catch(FileNotFoundException e){

		} catch (IOException e) {

		}

		path = "C:\\tools\\test.txt";
		try{
			instructions = FileReader.getInstructionsFromFile(path);
			Assert.assertTrue(instructions.get(0) instanceof PelouseInstructions);
		}catch(FileNotFoundException e){
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
