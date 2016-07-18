package com.xebia.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.test.core.InstructionsExecutor;

public class ExecutorTest {

	@Test
	public void instructionsTest(){
		List<IInstructions> instructions = new ArrayList<IInstructions>();

		InstructionsExecutor ie = new InstructionsExecutor();

		PelouseInstructions pi = new PelouseInstructions(5, 5);

		Position position = new Position(1, 2, Sens.NORTH);
		TondeuseInstructions ti = new TondeuseInstructions(position);

		List<String> mouvement = new ArrayList<String>();
		mouvement.add("D");
		mouvement.add("A");
		MouvementInstructions mi = new MouvementInstructions(mouvement);

		instructions.add(mi);
		try{
			ie.process(instructions);
			Assert.fail("No Pelouse declared !! The First Instruction has to be a PelouseInstructions");
		}catch(NullPointerException e){

		}

		instructions.remove(mi);
		instructions.add(pi);
		try{
			ie.process(instructions);
			Assert.fail("No Tondeuse declared !! The First Instruction has to be a TondeuseInstructions");
		}catch(NullPointerException e){

		}
		instructions.add(ti);
		Assert.assertEquals(position, ie.process(instructions).get(0));

		Position finalPosition = new Position(2, 2, Sens.EAST);
		instructions.add(mi);
		Assert.assertEquals(finalPosition, ie.process(instructions).get(0));


	}

}
