package com.jesdan.pcbuilder;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	double TOTAL = 0.0;
	String PROCESADOR ="";
	String VIDEO = "";
	String MADRE = "";
	String RANDOM = "";
	String DISK = "";
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText PRECIO = (EditText)findViewById(R.id.editText1);
		PRECIO.setFocusable(false);
		
        
        Calendar c = Calendar.getInstance();
        double horas = c.getTime().getHours();
        if(horas<=12){
        	Toast.makeText(getApplicationContext(),"Buenos dias", Toast.LENGTH_SHORT).show();
        }else if(horas>12 && horas<=18){
        	Toast.makeText(getApplicationContext(),"Buenas tardes", Toast.LENGTH_SHORT).show();
        }else if(horas>18){
        	Toast.makeText(getApplicationContext(),"Buenas noches", Toast.LENGTH_SHORT).show();
        }
        
        Button CREA = (Button)findViewById(R.id.button1);
        Button MANDAR = (Button)findViewById(R.id.button2);
        Button HACERCA = (Button)findViewById(R.id.button3);
        
        CREA.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent PC = new Intent(getApplicationContext(),Crear.class);
				startActivityForResult(PC,1);
			}
        });
       
    }
    
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	
    	if(requestCode==1){
    		if(resultCode==RESULT_OK){
    			TOTAL = data.getDoubleExtra("TOTAL", -1);
    			PROCESADOR= data.getStringExtra("PROCESADOR");
    			VIDEO = data.getStringExtra("VIDEO");
    			MADRE = data.getStringExtra("MADRE");
    			RANDOM = data.getStringExtra("RANDOM");
    			DISK = data.getStringExtra("DISK");
    		}
    	}
    	
}  	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
