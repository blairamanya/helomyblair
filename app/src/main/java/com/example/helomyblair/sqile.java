package com.example.helomyblair;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sqile extends AppCompatActivity {

    EditText begin, name,sex, tribe ;
    Button insert, update, delete, view, send;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqile);

        name = findViewById(R.id.name);
        sex = findViewById(R.id.sex);
        tribe = findViewById(R.id.tribe);

        final sqilejava DB;
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);

        DB = new sqilejava(this);

        insert.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String sexTXT = sex.getText().toString();
                String tribeTXT = tribe.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, sexTXT, tribeTXT);
                if (checkinsertdata==true)
                    Toast.makeText(sqile.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sqile.this, "Entry Failed", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String sexTXT = sex.getText().toString();
                String tribeTXT = tribe.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, sexTXT, tribeTXT);
                if (checkupdatedata==true)
                    Toast.makeText(sqile.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sqile.this, "Update Failed", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String sexTXT = sex.getText().toString();
                String tribeTXT = tribe.getText().toString();

                Boolean checkdeletedata = DB.updateuserdata(nameTXT, sexTXT, tribeTXT);
                if (checkdeletedata==true)
                    Toast.makeText(sqile.this, " Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sqile.this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(sqile.this,"No Entry At the Moment", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Project Name:"+res.getString(0)+"\n");
                    buffer.append("Project Manager:"+res.getString(1)+"\n\n");
                    buffer.append("Project Location:"+res.getString(2)+"\n\n\n");
                    buffer.append("Project Budget:"+res.getString(3)+"\n\n\n\n");
                    buffer.append("Project Teams:"+res.getString(4)+"\n\n\n\n\n\n");
                    buffer.append("Project Start:"+res.getString(5)+"\n\n\n\n\n\n\n\n");
                    buffer.append("Project End:"+res.getString(6)+"\n\n\n\n\n\n\n\n\\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(sqile.this);
                builder.setCancelable(true);
                builder.setTitle("project Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });



    }
}

