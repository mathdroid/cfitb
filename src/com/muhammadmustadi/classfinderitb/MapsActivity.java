package com.muhammadmustadi.classfinderitb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends ActionBarActivity {
	
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng ITB = new LatLng(-6.8905327,107.610585);

	private GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		Context context = getApplicationContext();
		CharSequence text = message;
		getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red_500)));
		
		int duration = Toast.LENGTH_SHORT;
		Toast.makeText(context, text, duration).show();
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(ITB, 15));
		//Create text view
		//TextView dispText = new TextView(this);
		//dispText.setText(message);
		//setContentView(dispText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maps, menu);
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
