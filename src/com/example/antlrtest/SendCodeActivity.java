package com.example.antlrtest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SendCodeActivity extends Activity {
	BluetoothManager bm;
	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	ListView listView;
	private ArrayList<String> pdArrayList;
	private ConnectThread connectThread;
	private ConnectedThread connectedThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_code);
		// Show the Up button in the action bar.
		setupActionBar();
		bm = BluetoothManager.getInstance();
        listView = (ListView) findViewById(R.id.list);

		ArrayList<String> pdArrayList = new ArrayList<String>();//init list
        Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices();
		// If there are paired devices
		if (bondedDevices.size() > 0) {
		    // Loop through paired devices
		    for (BluetoothDevice device : bondedDevices) {
		        // Add the name and address to an array to show in a ListView
		    	pdArrayList.add(device.getName() + "\n" + device.getAddress());
		    }
		}
		Button moveButton = (Button) findViewById(R.id.sendCode_button);
		moveButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	sendCommand(0);
            }
        });
		
		Button clearButton = (Button) findViewById(R.id.clear_button);
		clearButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	bm.codeToSend.clear();
            }
        });
		
		// Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, pdArrayList);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
            	  mBluetoothAdapter.cancelDiscovery();
                  String  itemValue    = (String) listView.getItemAtPosition(position);
                  String address = itemValue.substring(itemValue.length() - 17);
             	 BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
             	 connectThread = new ConnectThread(device);
                 connectThread.start();
             }
        }); 
	}
	public void sendCommand(int i){
		
    		byte [] command = bm.codeToSend.get(i);
    		System.out.println(command);
    		write(command);
    	if(i >= bm.codeToSend.size()){
    		bm.codeToSend.clear();
    	}
		
		
	}
	private void write(byte[] data){
    	ConnectedThread ct;
    	ct = connectedThread;
    	ct.write(data);
    }
    
    private class ConnectThread extends Thread {
        private BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;
        
        public ConnectThread(BluetoothDevice device) {
            mmDevice = device;
        }
        
        public void run() {
            setName("ConnectThread");
            mBluetoothAdapter.cancelDiscovery();
            
            try {
                mmSocket = mmDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                mmSocket.connect();
                connectedThread = new ConnectedThread(mmSocket); 
                connectedThread.start();
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
    
    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        
        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }
        
        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;
            int i=0;
            while (true) {
                try {
                	i++;
                	System.out.println("Reply recieved");
                	bytes = mmInStream.read(buffer);
                	sendCommand(i);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
         public void write(byte[] buffer) {
            try {
                mmOutStream.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_code, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
   }

