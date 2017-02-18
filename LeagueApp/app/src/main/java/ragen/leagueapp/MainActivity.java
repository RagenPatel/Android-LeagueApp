package ragen.leagueapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String region = "NA";
    Intent intent;
    Spinner spinner;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);


        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.regions_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setSelection(0);

        Button submitButton = (Button) findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get username
                TextView textBox = (TextView) findViewById(R.id.userText);
                String summonerID = textBox.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(progressBar.getContext(), "Searching", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }, 5000);

                intent = new Intent(progressBar.getContext(), SearchSummonerID.class);
                intent.putExtra("summonerID", summonerID);
                System.out.println("MainActivity: " + region);
                intent.putExtra("region", region);
                startActivity(intent);
            }
        });


        //Changes region based on which item is selected in the spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // An item was selected. You can retrieve the selected item using
                Button submitButton = (Button) findViewById(R.id.submitButton);
                submitButton.setEnabled(true);
                region = spinner.getSelectedItem().toString();
                System.out.println("New region set to: " + region);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Button submitButton = (Button) findViewById(R.id.submitButton);
                submitButton.setEnabled(false);
            }
        });


    }
}

