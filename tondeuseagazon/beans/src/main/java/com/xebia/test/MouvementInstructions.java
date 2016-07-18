package com.xebia.test;

import java.util.ArrayList;
import java.util.List;

public class MouvementInstructions implements IInstructions {

	private List<String> mouvement = new ArrayList<String>();

	public MouvementInstructions() {
		super();
	}

	public MouvementInstructions(List<String> mouvement) {
		super();
		this.mouvement = mouvement;
	}

	public List<String> getMouvement() {
		return mouvement;
	}

	public void setMouvement(List<String> mouvement) {
		this.mouvement = mouvement;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof MouvementInstructions){
			MouvementInstructions mi = (MouvementInstructions)obj;
			return (this.getMouvement().equals(mi.getMouvement()));
		}
		else{
			return false;
		}
	}
}
