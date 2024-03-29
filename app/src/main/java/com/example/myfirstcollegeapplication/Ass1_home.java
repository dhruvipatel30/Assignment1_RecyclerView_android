package com.example.myfirstcollegeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ass1_home extends AppCompatActivity {

    private RecyclerView response_recycler_view;
    private MaterialButton retrieve_data_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass1_home);

        response_recycler_view = findViewById(R.id.response_recycler_view);

        response_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        volleyGet();
    }
    public void volleyGet() {
        String url = "https://reqres.in/api/users?page=1";
        List<DataPOJO> jsonResponses = new ArrayList<>();


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        String email = jsonObject.getString("email");
                        String firstName = jsonObject.getString("first_name");
                        String lastName = jsonObject.getString("last_name");

                        jsonResponses.add(new DataPOJO(id, email, firstName, lastName));
                        response_recycler_view.setAdapter(new RecyclerViewAdapter(jsonResponses, Ass1_home.this));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }

}
