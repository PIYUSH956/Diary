package com.piyushjaiswal121.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {
private EditText etTask,etTaskdesc,etTaskComment;
private Button button;
String e1,e2,e3;
int a =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setId();
    }

    private void setId() {
        etTask = findViewById(R.id.etTask);
        etTaskComment =findViewById(R.id.etComment);
        etTaskdesc = findViewById(R.id.etTaskdescr);
        button = findViewById(R.id.bsubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidation())
                {
                    button.setEnabled(false);
                    button.setText("wait...");
                  new saveTask().execute();
           }
                else
                {

                }
            }
        });
    }

    private boolean isValidation() {
        e1 = etTaskdesc.getText().toString().trim();
        e2=etTask.getText().toString().trim();
        e3=etTaskComment.getText().toString().trim();
        if(e1==null || e2==null ||e3==null)
        {Toast.makeText(this,"Empty field",Toast.LENGTH_SHORT).show(); return false;}
        return true;
    }
    class saveTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {

            String date;
            date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(0));
            Task task = new Task();
            task.setTask_name(e2);
            task.setComment(e3);
            task.setTask_desc(e1);
            task.setId(0);
            task.setActivate("yes");
            task.setId(a);
            a++;
            DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().taskDao().insert(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            button.setEnabled(true);
            button.setText("Submit");
            Toast.makeText(getApplicationContext(),"Complete",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddTaskActivity.this,MainActivity.class));
        }
    }

}
