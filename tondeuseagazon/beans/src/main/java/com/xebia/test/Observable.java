package com.xebia.test;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private List<IObservateur> observateurs = new ArrayList<IObservateur>();
	
	public void notifyObservaters(){
		for(int i=0,taille = observateurs.size();i<taille;i++){
			observateurs.get(i).updateAfterNotification(this);
		}
	}
	
	public void addNewWatcher(IObservateur watcher){
		observateurs.add(watcher);
	}
	
	public void removeWatcher(IObservateur watcher){
		observateurs.remove(watcher);
	}
}
