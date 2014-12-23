package com.example.fyf;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class NotificationActivity extends Activity {

	public NotificationActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private Button mButton;
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		mButton = (Button)findViewById(R.id.button1);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				scheduleNotification();
			}
		});
	};
	
	private void scheduleNotification() {
		CharSequence title = "Hello world";
		CharSequence text = "I am detail";
		int icon = R.drawable.home;
		long when = System.currentTimeMillis();
		RemoteViews remoteView = new RemoteViews(this.getPackageName(), R.layout.notification);
//		remoteView.setImageViewResource(R.id.imageView1, R.drawable.bender03pb);
		PendingIntent contentIntent = PendingIntent.getActivity(
				NotificationActivity.this, 0, new Intent("android.settings.SETTINGS"), 0);
//		NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder(this);
		Notification noti = new NotificationCompat.Builder(this).setSmallIcon(icon)
					.setWhen(when).setContentTitle(title).setContentText(text)
					.setContent(remoteView).setContentIntent(contentIntent).build();
		NotificationManager mnotiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
        mnotiManager.notify(0, noti);
		
	}
}
