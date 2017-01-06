package ragen.leagueapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ragen on 1/5/17.
 */

public class SearchSummonerID extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searched_info);

        Intent intent = getIntent();

        String summonerID = intent.getExtras().getString("summonerID");

        System.out.println("SID: " + summonerID);

        TextView outputDetails = (TextView) findViewById(R.id.UserInfoTextView);
        TextView outputName = (TextView) findViewById(R.id.summonerNameTextView);

        outputName.setText(summonerID);
        outputDetails.setText("Summoner Name: " + summonerID);
    }

}
