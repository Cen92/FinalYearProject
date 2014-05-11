/**
 * MainActivity.java
 * Created by Cionnat Breathnach on 28/03/2014.
 * Copyright (c) 2014 Cionnat Breathnach. All rights reserved.
 * MainActivity.java is the Main Activity class for Mind Coder. Here all the UI elements are
 * set up for editing code and the user has access to all buttons for accessing other views.
 */

package com.example.antlrtest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.tl.Main;
import main.tl.TLValue;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public BluetoothManager bm;
	public MultiAutoCompleteTextView textView;
	public boolean prettifyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] suggestions = getResources().getStringArray(R.array.list_of_suggestions);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,suggestions);
        final MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
        textView.addTextChangedListener(mTextEditorWatcher);
        textView.setAdapter(adapter);
        textView.setTokenizer(new SColonTokenizer());
        textView.setOnItemClickListener(new OnItemClickListener ()
        {
        	 @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id)           
             {
              textView.setSelection(textView.getText().length()-1);//set cursor to inside parenthesis
             }
        });
        
    }
    
    public final TextWatcher  mTextEditorWatcher = new TextWatcher() {
        
    	String old;
    	
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        	//do nothing method is needed by textWatcher
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        	//do nothing method is needed by textWatcher
//        	if(s.toString().contains(";")){
//        		old=s.toString();
//        		char lastChar = old.charAt(old.length()-1);
//        		if(lastChar == ';'){
//        			prettifyCode();
//        		}
//        			
//           }

        }

        public void afterTextChanged(Editable s)
        {
        	if(s.toString().contains(";")){
        		old=s.toString();
        		char lastChar = old.charAt(old.length()-1);
        		if(lastChar == ';'){
        			prettifyCode();
        		}
        			
           }
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent intent = null;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
            	System.out.println("Clicked on Menu");
            	
            	break;
            case R.id.menu_documentation:
            	intent = new Intent(this, MethodListActivity.class);
            	startActivity(intent);
                break;
                
            case R.id.menu_file_browser:
            	intent = new Intent(this, FilesTableActivity.class);
            	startActivity(intent);
                break;    
            default:
                return super.onOptionsItemSelected(item);
        }
    	return true;
    }
    
    public void documentation(View view){
    	Intent intent = new Intent(this, MethodListActivity.class);
    	startActivity(intent);
    }
    
    
    
    public void prettify(View view){
    	MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
        String code = textView.getText().toString();
    	PrettifyHighlighter highlighter = new PrettifyHighlighter();
    	String highlighted = highlighter.highlight("bcr", code);
    	String newSTR = highlighted.replace(";",";<br>");
    	textView.setText(Html.fromHtml(newSTR));
    	textView.setSelection(textView.getText().length());
    }
    
    public void addToSuggestions(String[] words){
    	
    }
    
    /**
     * prettifyCode
     * Called From: TextWatcher.OnTextChanged()
     * Converts the code in the code editor to code with HTML tags wrapped around for 
     * syntax highlighting.
     */
    
    public void prettifyCode(){
    	MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
        String code = textView.getText().toString();
    	PrettifyHighlighter highlighter = new PrettifyHighlighter();
    	String highlighted = highlighter.highlight("bcr", code);
    	String newSTR = highlighted.replace(";",";<br>");

    	textView.setText(Html.fromHtml(newSTR));
    	textView.setSelection(textView.getText().length());//set  cursor to end
    	//scan all words in file and add to words array
    	String[] words = code.split(" ");
    	String[] newSuggestions = new String[words.length];
        String[] suggestions = getResources().getStringArray(R.array.list_of_suggestions);
		int nextIndex = 0;

        
    	for(int i=0;i<words.length;i++){
    		if(words[i].toString().contains("(") || words[i].toString().contains(")")){
    			//do nothing
    		}
    		if(words[i].toString().contains(";")){
    			String newWordWithoutSemiColon = words[i];
    			newWordWithoutSemiColon = newWordWithoutSemiColon.replace(";", "");
    			newSuggestions[nextIndex] = newWordWithoutSemiColon;
    			nextIndex++;
    		}
    		else{
                newSuggestions[nextIndex] = words[i];
                nextIndex++;
            }
    	}
    	
    	List list = new ArrayList(Arrays.asList(suggestions));
    	list.addAll(Arrays.asList(newSuggestions));
    	Object[] results = list.toArray(); 
    	System.out.println(Arrays.toString(results));
    	ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,results);
        textView.setAdapter(adapter);
    }
    
    public void saveFile(View view){
    	EditText textView = (EditText)findViewById(R.id.editText_filename);
    	String FILENAME = textView.getText().toString();
    	
    	MultiAutoCompleteTextView codeEditor = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
        String code = codeEditor.getText().toString();
    	FileOutputStream fos;
		try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(code.getBytes());
				fos.close();
				Toast.makeText(getApplicationContext(), "File saved: " + FILENAME, Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	Toast.makeText(getApplicationContext(), "Error saving file enter a filename " + FILENAME, Toast.LENGTH_LONG).show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	Toast.makeText(getApplicationContext(), "Error saving file" + FILENAME, Toast.LENGTH_LONG).show();

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
        	MultiAutoCompleteTextView in = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
            String source = in.getText().toString();
            
            TLValue parserOutput = object.main(source);
            Intent intent = new Intent(this, SendCodeActivity.class);
            startActivity(intent);
            
        		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

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
            	MultiAutoCompleteTextView codeEditor = (MultiAutoCompleteTextView)findViewById(R.id.code_text);
            	codeEditor.setText(data.getExtras().getString("myCode"));
            }
        }
    }
}

