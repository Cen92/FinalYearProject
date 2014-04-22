package com.example.antlrtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FilesTableActivity extends Activity {
	
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files_table);
		listView = (ListView) findViewById(R.id.filesList);

		setupActionBar();
		
		final ArrayList<String> arrayList = new ArrayList<String>();//init list
		System.out.println("Listing files");
    	String [] allFiles = this.fileList();
    		for(int i = 0;i<allFiles.length;i++){
    			System.out.println(allFiles[i].toString());

    			arrayList.add(allFiles[i].toString());

		    }

    		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		          android.R.layout.simple_list_item_1, allFiles);


		        // Assign adapter to ListView
		        listView.setAdapter(adapter); 
		        
		        // ListView Item Click Listener
		        listView.setOnItemClickListener(new OnItemClickListener() {

		              @Override
		              public void onItemClick(AdapterView<?> parent, View view,
		                 int position, long id) {
		            	  System.out.println("Clicked row: "+ arrayList.get(position).toString());
		            	  String fileName = null;
		            	  FileInputStream fis;
						try{
							fileName = arrayList.get(position).toString();
							fis = openFileInput(fileName);
				            StringBuilder sb = new StringBuilder();
				            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		                    String line = null;
		                    while ((line = reader.readLine()) != null) {
		                          sb.append(line).append("\n");
		                      }
		                      fis.close();
		                      String code = sb.toString();
			                  System.out.println(code);
			                  loadStringToCodeEditor(fileName, code);
		                  } catch(OutOfMemoryError om){
		                      om.printStackTrace();
		                  } catch(Exception ex){
		                      ex.printStackTrace();
		                  }
		                 
		             }
		        }); 

	}

	protected void loadStringToCodeEditor(String fileName, String code) {
        System.out.println("Doing intent");
		Intent data = new Intent();
		data.putExtra("myFilename", fileName);
		data.putExtra("myCode", code);
		setResult(RESULT_OK, data);
		finish();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.files_table, menu);
		return true;
	}
	
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
		
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
