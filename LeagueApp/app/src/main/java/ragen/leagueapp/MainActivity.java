package ragen.leagueapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get username
                TextView textBox = (TextView) findViewById(R.id.userText);
                String summonerID = textBox.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(progressBar.getContext() , "Searching", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }, 5000);

                Intent intent = new Intent(progressBar.getContext() , SearchSummonerID.class);
                intent.putExtra("summonerID", summonerID);
                startActivity(intent);
            }
        });
    }
}
