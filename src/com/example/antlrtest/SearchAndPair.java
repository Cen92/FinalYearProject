package com.example.antlrtest;


import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Search and Pair activity
 * Searches for an NXT device for pairing
 * @author cbreathnach
 *
 */
public class SearchAndPair extends Activity {
		private static final int REQUEST_ENABLE_BT = 1;
	   private Button findBtn;
	   private BluetoothAdapter myBluetoothAdapter;
	   private Set<BluetoothDevice> pairedDevices;
	   private ListView myListView;
	   private ArrayAdapter<String> BTArrayAdapter;
	   private ConnectThread connectThread;
	   private boolean needToUnregister;

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_search_and_pair);
	      setupActionBar();
	      final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	      alertDialog.setTitle("Check Mindstorm Device");
	      alertDialog.setMessage("Please Enter the PIN on the Mindstorm");
	      alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	         public void onClick(DialogInterface dialog, int which) {
	        	 dialog.dismiss();
	         }
	      });
	      // Set the Icon for the Dialog
	      // take an instance of BluetoothAdapter - Bluetooth radio
	      myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	      if(myBluetoothAdapter == null) {
	    	  findBtn.setEnabled(false);	    	  
	    	  Toast.makeText(getApplicationContext(),"Your device does not support Bluetooth",
	         		 Toast.LENGTH_LONG).show();
	      } 
		      findBtn = (Button)findViewById(R.id.search);
		      findBtn.setOnClickListener(new OnClickListener() {
		  		@Override
		  		public void onClick(View v) {
		  			// TODO Auto-generated method stub
		  			find(v);
		  		}
		      });
		     myListView = (ListView)findViewById(R.id.listView1);
		
		      // create the arrayAdapter that contains the BTDevices, and set it to the ListView
		      BTArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		      myListView.setAdapter(BTArrayAdapter);
		      myListView.setOnItemClickListener(new OnItemClickListener() {

	              @Override
	              public void onItemClick(AdapterView<?> parent, View view,
	                 int position, long id) {
		       	      alertDialog.show();
	            	  myBluetoothAdapter.cancelDiscovery();
	                  String  itemValue    = (String) BTArrayAdapter.getItem(position);
	                  String address = itemValue.substring(itemValue.length() - 17);
	             	 BluetoothDevice device = myBluetoothAdapter.getRemoteDevice(address);
	             	 connectThread = new ConnectThread(device);
	                 connectThread.start();

	             }
	        }); 
	      }
	   

	   
	  
	  
	   
	   @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		   // TODO Auto-generated method stub
		   if(requestCode == REQUEST_ENABLE_BT){
			   if(myBluetoothAdapter.isEnabled()) {
			   } else {   
			   }
		   }
	   }

	   
	   final BroadcastReceiver bReceiver = new BroadcastReceiver() {
		    public void onReceive(Context context, Intent intent) {
		        String action = intent.getAction();
		        // When discovery finds a device
		        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
		             // Get the BluetoothDevice object from the Intent
		        	 BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
		        	 // add the name and the MAC address of the object to the arrayAdapter
		             BTArrayAdapter.add(device.getName() + "\n" + device.getAddress());
		             BTArrayAdapter.notifyDataSetChanged();
		        }
		    }
		};
		
	   public void find(View view) {
		   if (myBluetoothAdapter.isDiscovering()) {
			   // the button is pressed when it discovers, so cancel the discovery
			   myBluetoothAdapter.cancelDiscovery();
		   }
		   else {
				BTArrayAdapter.clear();
				myBluetoothAdapter.startDiscovery();
				needToUnregister = true;
				registerReceiver(bReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));	
			}    
	   }
	   

	   
	   @Override
	   protected void onDestroy() {
		   // TODO Auto-generated method stub
		   super.onDestroy();
		   if(needToUnregister){
			   unregisterReceiver(bReceiver);
		   }
	   }
	   
	   @TargetApi(Build.VERSION_CODES.HONEYCOMB)
		private void setupActionBar() {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
}
