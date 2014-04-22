package com.example.antlrtest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import main.tl.Main;
import main.tl.TLValue;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public BluetoothManager bm;
	public AutoCompleteTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.input_text);
        textView.setAdapter(adapter);
        

        
    }

    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain", "moveForward();", "moveBackward()"
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void prettify(View view){
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.input_text);

        String code = textView.getText().toString();
    	PrettifyHighlighter highlighter = new PrettifyHighlighter();
    	String highlighted = highlighter.highlight("java", code);
    	textView.setText(Html.fromHtml(highlighted));
    	
    }
    
    public void saveFile(View view){
    	EditText textView = (EditText)findViewById(R.id.editText_filename);
    	String FILENAME = textView.getText().toString();
    	
    	AutoCompleteTextView codeEditor = (AutoCompleteTextView)findViewById(R.id.input_text);
        String code = codeEditor.getText().toString();
    	FileOutputStream fos;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(code.getBytes());
	    	fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void loadFile(View view){
        Intent intent = new Intent(this, FilesTableActivity.class);
        startActivityForResult(intent, 0);	
    }
    
    public void sendMessage(View view) {
        Main object = new Main();
        //BluetoothManager bm = new BluetoothManager();
        		try {
        	EditText in = (EditText)findViewById(R.id.input_text);
            String source = in.getText().toString();
            TLValue parserOutput = object.main(source);
            
            Intent intent = new Intent(this, SendCodeActivity.class);
            startActivity(intent);
            
        		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (data.hasExtra("myFilename")) {
            	EditText textView = (EditText)findViewById(R.id.editText_filename);
            	textView.setText(data.getExtras().getString("myFilename"));
            }
            if (data.hasExtra("myCode")) {
            	AutoCompleteTextView codeEditor = (AutoCompleteTextView)findViewById(R.id.input_text);
            	codeEditor.setText(data.getExtras().getString("myCode"));
            }
        }
    }
    
}
