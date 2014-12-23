package com.example.fyf;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationActivity extends Activity {

	public NotificationActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private Button mButton;
	private Button mButton2;
	
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
		mButton2 = (Button)findViewById(R.id.button2);
		mButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				clearNotification();
			}
		});
	};
	
	private static final int INTENT1 = 0;
	
	private void clearNotification() {
		NotificationManager nManager = (NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE);
		nManager.cancel(INTENT1);
		
		Toast toast = Toast.makeText(this,
                "clear!", Toast.LENGTH_SHORT);
        LinearLayout toastView = (LinearLayout) toast.getView();
        TextView toastMessage = new TextView(this);
        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.drawable.bender03pb);
        toastMessage.setText("I will clear");
        toastView.addView(toastMessage, LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        toastView.addView(img, MeasureSpec.makeMeasureSpec(50, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(50, MeasureSpec.EXACTLY));
        toast.show();
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		try {
			
//			Log.e("FYF", "get new Intent " + intent.getExtras().getString("NAME"));
			Log.e("FYF", "get new Intent " + intent.getStringExtra("NAME"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		super.onNewIntent(intent);
	}
	
	private void scheduleNotification() {
		CharSequence title = "Hello world";
		CharSequence text = "I am detail";
		int icon = R.drawable.home;
		long when = System.currentTimeMillis();
		RemoteViews remoteView = new RemoteViews(this.getPackageName(), R.layout.notification);
//		remoteView.setImageViewResource(R.id.imageView1, R.drawable.bender03pb);
		PendingIntent settingsIntent = PendingIntent.getActivity(
				NotificationActivity.this, 0, new Intent("android.settings.SETTINGS"), 0);
		Intent myIntent = new Intent(this, NotificationActivity.class);
//		Bundle c = new Bundle();
//		c.putString("NAME", "FYF");
//		myIntent.putExtras(c);
		myIntent.putExtra("NAME", "FYF");
//		myIntent.put
		// Note: PendingIntent 4th FLAG
		PendingIntent contentIntent = PendingIntent.getActivity(NotificationActivity.this,
					0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//		NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder(this);
		remoteView.setOnClickPendingIntent(R.id.button1, settingsIntent);
		Notification noti = new NotificationCompat.Builder(this).setSmallIcon(icon)
					.setAutoCancel(true).setStyle(new NotificationCompat.BigPictureStyle())
					.setWhen(System.currentTimeMillis() + 10000).setContentTitle(title).setContentText(text)
					.setContent(remoteView).setContentIntent(contentIntent).build();
		NotificationManager mnotiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
        mnotiManager.notify(INTENT1, noti);
		
	}
}
