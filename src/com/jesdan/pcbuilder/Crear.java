package com.jesdan.pcbuilder;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Crear extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear);
		
		final EditText PRECIO = (EditText)findViewById(R.id.editText1);
		PRECIO.setFocusable(false);

		final Button CPU = (Button)findViewById(R.id.button1);
		final Button GPU = (Button)findViewById(R.id.button2);
		final Button MOTHERBOARD = (Button)findViewById(R.id.button3);
		final Button RAM = (Button)findViewById(R.id.button4);
		final Button DISCO = (Button)findViewById(R.id.button5);
		
		Button SALVAR = (Button)findViewById(R.id.button6);
		
		
		SALVAR.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent precio = new Intent();
				precio.putExtra("TOTAL",Double.parseDouble(PRECIO.getText().toString()));
				if(CPU.getText().toString().equals("CPU")){
					precio.putExtra("PROCESADOR", "No escogio CPU");
				}else{
					precio.putExtra("PROCESADOR",CPU.getText().toString());
				}
				if(GPU.getText().toString().equals("Tarjeta de Video")){
					precio.putExtra("VIDEO", "No escogio tarjeta de video");
				}else{
					precio.putExtra("VIDEO",GPU.getText().toString());
				}
				if(MOTHERBOARD.getText().toString().equals("Tarjeta Madre")){
					precio.putExtra("MADRE", "No escogio tarjeta madre");
				}else{
					precio.putExtra("MADRE",MOTHERBOARD.getText().toString());
				}
				if(RAM.getText().toString().equals("Memoria")){
					precio.putExtra("RANDOM", "No escogio memoria");
				}else{
					precio.putExtra("RANDOM",RAM.getText().toString());
				}
				if(DISCO.getText().toString().equals("Disco Duro")){
					precio.putExtra("DISK", "No escogio disco duro");
				}else{
					precio.putExtra("DISK",DISCO.getText().toString());
				}
				setResult(RESULT_OK,precio);
				finish();
			}
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear, menu);
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
