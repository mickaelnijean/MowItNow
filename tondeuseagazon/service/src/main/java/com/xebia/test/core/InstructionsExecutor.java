package com.xebia.test.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xebia.test.IInstructions;
import com.xebia.test.MouvementInstructions;
import com.xebia.test.Pelouse;
import com.xebia.test.PelouseInstructions;
import com.xebia.test.Position;
import com.xebia.test.Tondeuse;
import com.xebia.test.TondeuseInstructions;
import com.xebia.test.core.interfaces.IExecutor;

public class InstructionsExecutor implements IExecutor {

	private Logger logger = Logger.getLogger(InstructionsExecutor.class);
	
	public List<Position> process(List<IInstructions> instructions){
		if(logger.isDebugEnabled()){
			logger.debug("<process");
		}
		List<Position> positions = new ArrayList<Position>();
		List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
		if(instructions == null || (instructions!=null && (instructions.size()<1) ) ){
			return null;
		}
		else{
			if(instructions.size()>0 && !(instructions.get(0) instanceof PelouseInstructions) ){
				throw new NullPointerException("No Pelouse declared !! The First Instruction has to be a PelouseInstructions");
			}
			else if(instructions.size()==1|| (instructions.size()>1 && !(instructions.get(1) instanceof TondeuseInstructions)) ){
				throw new NullPointerException("No Tondeuse declared !! The Second Instruction has to be a TondeuseInstructions");
			}
			else if(instructions.size()==2) {
				TondeuseInstructions ti = (TondeuseInstructions) instructions.get(1);
				positions.add(ti.getPosition());
			}
			else{
				PelouseInstructions pi = (PelouseInstructions) instructions.get(0);
				Pelouse pelouse = new Pelouse(pi.getLongeur(), pi.getLargeur());
				
				TondeuseInstructions ti = (TondeuseInstructions) instructions.get(1);
				Tondeuse actualTondeuse = new Tondeuse(ti.getPosition());
				
				pelouse.addNewWatcher(actualTondeuse);
				pelouse.notifyObservaters();
				
				MouvementInstructions mi;
				
				for(int i=2, taille=instructions.size();i<taille;i++){
					if(instructions.get(i) instanceof PelouseInstructions){
						pi = (PelouseInstructions) instructions.get(i);
						pelouse = new Pelouse(pi.getLongeur(), pi.getLargeur());
						pelouse.notifyObservaters();
					}
					else if(instructions.get(i) instanceof MouvementInstructions){
						mi = (MouvementInstructions)instructions.get(i);
						actualTondeuse.move(mi);
						positions.add(actualTondeuse.getPosition());
					}
					else if(instructions.get(i) instanceof TondeuseInstructions){
						ti = (TondeuseInstructions)instructions.get(i);
						tondeuses.add(actualTondeuse);
						actualTondeuse = new Tondeuse(ti.getPosition());
						pelouse.addNewWatcher(actualTondeuse);
						pelouse.notifyObservaters();
					}
					else{
						logger.error("ce cas ,n'est pas encore géré");
					}
				}
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug("process>");
		}
		return positions;
	}
}
