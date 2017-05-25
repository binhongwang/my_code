package com.example.kobedemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener {
    NotificationManager mNotificationManager;

    private TextView txtA;
    private TextView txtR;
    private TextView txtG;
    private TextView txtB;
    private SeekBar seekBarA;
    private SeekBar seekBarR;
    private SeekBar seekBarG;
    private SeekBar seekBarB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.currentTimeMillis();
        findViewById(R.id.btn).setOnClickListener(this);
        mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        seekBarA = (SeekBar) findViewById(R.id.seek_bar_a);
        seekBarA.setOnSeekBarChangeListener(this);
        txtA = (TextView) findViewById(R.id.txt_a);

        seekBarR = (SeekBar) findViewById(R.id.seek_bar_r);
        seekBarR.setOnSeekBarChangeListener(this);
        txtR = (TextView) findViewById(R.id.txt_r);

        seekBarG = (SeekBar) findViewById(R.id.seek_bar_g);
        seekBarG.setOnSeekBarChangeListener(this);
        txtG = (TextView) findViewById(R.id.txt_g);

        seekBarB = (SeekBar) findViewById(R.id.seek_bar_b);
        seekBarB.setOnSeekBarChangeListener(this);
        txtB = (TextView) findViewById(R.id.txt_b);

        updateARGBValue();
    }

    private void updateARGBValue() {
        txtA.setText(this.getString(R.string.alpha) + String.valueOf(seekBarA.getProgress()));
        txtR.setText(this.getString(R.string.red) + String.valueOf(seekBarR.getProgress()));
        txtG.setText(this.getString(R.string.green) + String.valueOf(seekBarG.getProgress()));
        txtB.setText(this.getString(R.string.blue) + String.valueOf(seekBarB.getProgress()));
    }

    private void sendNotification() {
        int ledARGB = seekBarA.getProgress() * 256 * 256 * 256 + seekBarR.getProgress() * 256 * 256
                + seekBarG.getProgress() * 256 + seekBarB.getProgress();
        Notification.Builder b = new Notification.Builder(this);
        b.setLights(ledARGB, 1000, 0);
        b.setSmallIcon(R.drawable.ic_launcher);
        b.setContentText("test");
        mNotificationManager.notify("com.example.kobedemo", 100,b.build());
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

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        sendNotification();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // TODO Auto-generated method stub
        updateARGBValue();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
        sendNotification();
    }
}
