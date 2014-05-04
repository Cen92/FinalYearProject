package com.example.antlrtest;

import java.util.ArrayList;


public class BluetoothManager {
	public ArrayList<byte[]> codeToSend;
	private static BluetoothManager instance;
	private BluetoothManager(){ //private for singleton
		codeToSend = new ArrayList<byte[]>();
	}
	
	public static BluetoothManager getInstance() { //quick and dirty way to instanciate var. 
	    if (instance == null) {
	        instance = new BluetoothManager();
	    }
	    return instance;
	}
	
	public  void addToArray(byte[] array){
		codeToSend.add(array);	
		System.out.println(codeToSend);
	}	

}
