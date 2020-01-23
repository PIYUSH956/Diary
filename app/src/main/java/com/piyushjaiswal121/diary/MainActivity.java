package com.piyushjaiswal121.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.ivAdd);
        recyclerView = findViewById(R.id.rvTask);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddTaskActivity.class));
            }
        });
    new newTask().execute();
    }
    class newTask extends AsyncTask<Void,Void, List<Task>>
    {
        @Override
        protected List<Task> doInBackground(Void... voids) {

            List<Task> tasks = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().taskDao().getAll();

            return  tasks;
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {
            super.onPostExecute(tasks);
            TaskAdapter taskAdapter = new TaskAdapter(MainActivity.this,tasks);
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(taskAdapter);
            Toast.makeText(getApplicationContext(),tasks.get(1).getTask_name(),Toast.LENGTH_SHORT).show();

        }
    }

}
