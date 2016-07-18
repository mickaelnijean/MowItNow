package com.xebia.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {
	
	@Test
	public void getTheRightSens(){
		Sens sensNorth = Sens.NORTH;
		Sens sensEast = Sens.EAST;
		Sens sensWest = Sens.WEST;
		Sens sensSouth = Sens.SOUTH;
		
		Assert.assertEquals(sensNorth.toTheRight(), sensEast);
		Assert.assertEquals(sensNorth.toTheLeft(), sensWest);
		
		Assert.assertEquals(sensEast.toTheRight(), sensSouth);
		Assert.assertEquals(sensEast.toTheLeft(), sensNorth);
		
		Assert.assertEquals(sensWest.toTheRight(), sensNorth);
		Assert.assertEquals(sensWest.toTheLeft(), sensSouth);
		
		Assert.assertEquals(sensSouth.toTheRight(), sensWest);
		Assert.assertEquals(sensSouth.toTheLeft(), sensEast);
		
		
	}

	@Test
	public void fromSymbol(){
		Assert.assertEquals(Sens.SOUTH, Sens.getSensBySymbol("S"));
		Assert.assertEquals(Sens.NORTH, Sens.getSensBySymbol("n".toUpperCase()));
		Assert.assertEquals(Sens.EAST, Sens.getSensBySymbol("E"));
		Assert.assertEquals(Sens.WEST, Sens.getSensBySymbol("W"));
		
		Assert.assertEquals(Directions.LEFT, Directions.getDirectionBySymbol("G"));
		Assert.assertEquals(Directions.RIGHT, Directions.getDirectionBySymbol("D"));
		
		Assert.assertEquals(Mouvement.GO, Mouvement.getMovementBySymbol("A"));
	}
}
