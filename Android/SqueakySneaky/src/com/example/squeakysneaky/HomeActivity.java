package com.example.squeakysneaky;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        Button getStartedButton = (Button) findViewById(R.id.homeButton1);
        getStartedButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(HomeActivity.this, SecondaryActivity.class);
				startActivity(intent);
			}
		});
        
        Button ipButton = (Button) findViewById(R.id.homeButton2);
        ipButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
				alert.setTitle("My IP");
				alert.setMessage(getIP());
				alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.cancel();
					}
				});
				
				alert.show();
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
    private String getIP(){
    	String ipAddress = "null";
        
    	WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
    	ipAddress = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        
		return ipAddress;
    }
    
    
    
}
