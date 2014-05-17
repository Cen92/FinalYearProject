package com.example.antlrtest;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;
/**
 * Initializes a connection between phone and device. Used for pairing
 * @author cbreathnach
 *
 */
public class ConnectThread extends Thread{
    private BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    
    public ConnectThread(BluetoothDevice device) {
        mmDevice = device;
    }
    
    public void run() {
        setName("ConnectThread");
        mBluetoothAdapter.cancelDiscovery();
        
        try {
            mmSocket = mmDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            mmSocket.connect();
            
        } catch (IOException e) {
	    	e.printStackTrace();
        }
    }
    
    public void cancel() {
        try {
            if (mmSocket != null) {
                mmSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}