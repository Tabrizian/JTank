package com;

import java.util.EventObject;

public class CollisionEvent extends EventObject {
	private int state;
	
	public CollisionEvent(Object panel,int state){
		super(panel);
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	
	
}
