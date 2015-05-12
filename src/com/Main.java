package com;

import com.jtattoo.*;
import javax.swing.UIManager;
public class Main {
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel("com.jtatto.plaf.smartLookAndFeel");
		}catch (Exception e){
			
		}
		new StartFrame();
	}
	
}
