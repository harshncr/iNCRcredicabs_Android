package com.example.push.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pg250235 on 3/5/2018.
 */

public class Approve extends BroadcastReceiver {

    String url = "http://192.168.43.213:8080/DemoProject/login/doLogin";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Approve", Toast.LENGTH_SHORT).show();

        JSONObject jsonBodyRequest = new JSONObject();
        try {
            jsonBodyRequest.put("request_id", "32");
            jsonBodyRequest.put("Approval","Approved");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Request.Method.POST,
                url,
                jsonBodyRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("VOLLEY", "inside onResponse method:login");
                        Log.i("VOLLEY", response.toString());


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Log.d("VOLLEY", "Something went wrong");
                        error.printStackTrace();                            }
                });

        RESTService.getInstance(context).addToRequestQueue(jsonObjRequest);

    }



}