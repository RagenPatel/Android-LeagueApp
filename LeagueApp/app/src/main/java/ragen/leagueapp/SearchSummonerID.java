package ragen.leagueapp;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by Ragen on 1/5/17.
 */

public class SearchSummonerID extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searched_info);

        TextView outputDetails = (TextView) findViewById(R.id.UserInfoTextView);
        TextView outputName = (TextView) findViewById(R.id.summonerNameTextView);

    }

}
