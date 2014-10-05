package com.muhammadmustadi.classfinderitb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {
	//STATICS HERE BRO
	public final static String EXTRA_MESSAGE = "com.muhammadmustadi.ClassFinderITB.MESSAGE";

	//DECLARE VARIABLES HERE
	//Button bNextPage;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        //get view objects here
        //bNextPage = (Button) findViewById (R.id.button1);
        

        //create Listeners
        //createListeners();
    }
	/*
	private void createListeners(){
		bNextPage.setOnClickListener(new OnClickListener() {
			public void onClick(View v){
				//OPEN MapsActivity pls
				Intent intent = new Intent (this, MapsActivity.class);
				startActivity(intent);
			}
		});
	}*/
	

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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	
    	private Button btn;
    	private EditText srchBar;
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            //DECLARE View in Fragments here
            btn = (Button) rootView.findViewById(R.id.button1);
            srchBar = (EditText) rootView.findViewById(R.id.editText1);
            //Create Listeners
            createListeners();
            
            return rootView;
        }
        //Create individual listeners here.
        private void createListeners(){
        	btn.setOnClickListener(new OnClickListener(){
        		public void onClick(View V){
        			Intent iMaps = new Intent(getActivity(), MapsActivity.class);
        			String message = srchBar.getText().toString();
        			iMaps.putExtra(EXTRA_MESSAGE, message);
        			startActivity(iMaps);
        		}
        	});
        }
        
    }
}
