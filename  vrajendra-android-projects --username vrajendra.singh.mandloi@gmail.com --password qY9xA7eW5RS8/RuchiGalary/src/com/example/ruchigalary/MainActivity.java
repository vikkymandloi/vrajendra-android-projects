package com.example.ruchigalary;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	static List<String> allpath = new ArrayList<String>();
	ImageView image1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		File file= new File("/sdcard/Images/Ruchi/"); 
		for(File f1 : file.listFiles())
		{	
			allpath.add(f1.getAbsolutePath());
		}
		getFromSdcard();
	}

	public void getFromSdcard()
	{	
		image1 = (ImageView) findViewById(R.id.imageView1);
		image1.setImageDrawable(Drawable.createFromPath("/sdcard/Images/Ruchi/photoRuchi.jpg"));
		
		image1.setOnClickListener(new OnClickListener() {
			Iterator<String> it1 = allpath.iterator();		
			@Override
			public void onClick(View v) {
				if(it1.hasNext())
					image1.setImageDrawable(Drawable.createFromPath((String) it1.next()));
				else
				{
					 it1 = allpath.iterator();	
					 image1.setImageDrawable(Drawable.createFromPath((String) it1.next()));
				}
			}
		});	
	}
}
