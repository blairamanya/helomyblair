package com.example.helomyblair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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