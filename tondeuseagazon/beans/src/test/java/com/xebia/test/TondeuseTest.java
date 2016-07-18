package com.xebia.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TondeuseTest {
	
	@Test
	public void moveTest(){
		Position position = new Position(1, 2, Sens.NORTH);
		Tondeuse t = new Tondeuse(position);
		List<String> mouvement = new ArrayList<String>();
		mouvement.add("G");
		mouvement.add("A");
		mouvement.add("G");
		mouvement.add("A");
		mouvement.add("G");
		mouvement.add("A");
		mouvement.add("G");
		mouvement.add("A");
		mouvement.add("A");
		MouvementInstructions mi = new MouvementInstructions(mouvement);
		t.move(mi);
		System.out.println(t.getPosition().getX());
		System.out.println(t.getPosition().getY());
		System.out.println(t.getPosition().getSens().getSymbol());
	}

}
