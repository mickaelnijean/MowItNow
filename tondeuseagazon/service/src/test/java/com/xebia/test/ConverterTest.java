package com.xebia.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.test.core.InstructionsConverter;

public class ConverterTest {

	@Test
	public void getTheRightListOfInstructions(){
		String taillePelouse = "5 5";
		String tondeuseInstance = "1 2 N";
		String mouvementSequences = "GA";
		
		IInstructions i1 = InstructionsConverter.getInstructionFromString(taillePelouse);
		IInstructions i2 = InstructionsConverter.getInstructionFromString(tondeuseInstance);
		IInstructions i3 = InstructionsConverter.getInstructionFromString(mouvementSequences);
		
		PelouseInstructions pi = new PelouseInstructions(5, 5);
		
		Position position = new Position(1, 2, Sens.NORTH);
		TondeuseInstructions ti = new TondeuseInstructions(position);
		
		List<String> mouvement = new ArrayList<String>();
		mouvement.add("G");
		mouvement.add("A");
		MouvementInstructions mi = new MouvementInstructions(mouvement);
		
		Assert.assertEquals(pi, (PelouseInstructions)i1);
		Assert.assertEquals(ti, (TondeuseInstructions)i2);
		Assert.assertEquals(mi, (MouvementInstructions)i3);
	}
	
	@Test
	public void getStringFromPositions(){
		List<Position> positions = new ArrayList<Position>();
		String result = PositionConverter.positionsToString(positions);
		StringBuilder test = new StringBuilder();
		Assert.assertNotNull(result);
		positions.add(new Position(0, 0, Sens.EAST));
		test.append("0 0 E").append("\r\n");
		result = PositionConverter.positionsToString(positions);
		Assert.assertEquals(test.toString(), result);
		positions.add(new Position(1, 2, Sens.NORTH));
		test.append("1 2 N").append("\r\n");
		result = PositionConverter.positionsToString(positions);
		Assert.assertEquals(test.toString(), result);
		positions.add(new Position(-5, 0, Sens.SOUTH));
		test.append("-5 0 S").append("\r\n");
		result = PositionConverter.positionsToString(positions);
		Assert.assertEquals(test.toString(), result);
		positions.add(new Position(10, -6, Sens.WEST));
		test.append("10 -6 W").append("\r\n");
		result = PositionConverter.positionsToString(positions);
		Assert.assertEquals(test.toString(), result);
		
		
		
	}
}
