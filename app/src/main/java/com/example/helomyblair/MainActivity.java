package com.example.helomyblair;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
private Button start,stop;
    EditText mHourEditText, mMinuteEditText;
    Button mSetAlarmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHourEditText = findViewById(R.id.hour_edit_text);
        mMinuteEditText = findViewById(R.id.minute_edit_text);

        mSetAlarmButton = findViewById(R.id.set_alarm_button);
        mSetAlarmButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           int hour = Integer.parseInt(mHourEditText.getText().toString());
           int minutes = Integer.parseInt(mMinuteEditText.getText().toString());

           Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
           intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
           intent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);

           if (hour <= 24 && minutes <= 60){
               startActivity(intent);
           }

       }
   }
);


        Button btn = (Button) findViewById(R.id.biodata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,sqile.class));
            }
        });





        
       

        Button music= (Button)findViewById(R.id.musicbtn);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,blairing.class);
                startActivity(intent);
            }
        });


    }
        public void sendMessage(View view) {
            EditText message;
            message= (EditText)findViewById(R.id.message);
        Toast.makeText (this, "Sending message " + message.getText().toString(),
                Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra("MESSAGE", message.getText().toString());
            startActivity(intent); message.setText(""); }


public boolean onCreateOptionsMenu(Menu Menu2){
    MenuInflater inflateMenu = getMenuInflater();
    inflateMenu.inflate(R.menu.service, Menu2);
    return true;
}
public boolean onOptionItemSelected(MenuItem item){
    switch (item.getItemId()){
        case R.id.jacketid:
            startActivity(new Intent(this,music.class));
            return true;
        case R.id.shoesid:
            startActivity(new Intent(this,music2.class));
            return true;
            default:
                return super.onContextItemSelected(item);

    }
}

}