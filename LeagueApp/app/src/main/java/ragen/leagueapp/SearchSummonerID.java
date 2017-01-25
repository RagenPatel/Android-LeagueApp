package ragen.leagueapp;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Ragen on 1/5/17.
 */

public class SearchSummonerID extends MainActivity {

    String summonerID, region, riotAPI;
    TextView outputDetails, outputName;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searched_info);

        requestQueue = Volley.newRequestQueue(this);

        Intent intent = getIntent();

        summonerID = intent.getExtras().getString("summonerID");
        region = intent.getExtras().getString("region");
        riotAPI = getResources().getString(R.string.riotAPI);


        System.out.println("SID: " + summonerID);

        outputDetails = (TextView) findViewById(R.id.UserInfoTextView);
        outputName = (TextView) findViewById(R.id.summonerNameTextView);

        outputName.setText(summonerID);

        getOperation();


        /*
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOperation();
            }
        });
        */


    }

    protected void getOperation() {
        String url = "https://" + region + ".api.pvp.net/api/lol/" + region +
                "/v1.4/summoner/by-name/" + summonerID + "?api_key=" + riotAPI;

        System.out.println("region: " + region + "  sID: " + summonerID);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        System.out.println("Entered GET request");
                        outputDetails.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                        System.out.println("Error: " + error.getMessage());


                    }
                });

        requestQueue.add(jsObjRequest);
    }

}
