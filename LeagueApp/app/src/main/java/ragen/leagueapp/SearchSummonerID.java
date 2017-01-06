package ragen.leagueapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

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

        final TextView outputDetails = (TextView) findViewById(R.id.UserInfoTextView);
        TextView outputName = (TextView) findViewById(R.id.summonerNameTextView);

        outputName.setText(summonerID);

        String riotAPI = getResources().getString(R.string.riotAPI);


        String url ="https://" + region + ".api.pvp.net/api/lol/" + region +
                "/v1.4/summoner/by-name/" + summonerID + "?api_key=" + riotAPI;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        outputDetails.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

    }

}
