package com.test.sri.intelltest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.test.sri.intelltest2.Model.JsonData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView resulttextview;
    private Button navigate;
    Double latitude = null;
    Double longitude = null;
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<JsonData> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulttextview = findViewById(R.id.resultTextview);
        navigate =  findViewById(R.id.navigateButton);


            RetrofitApiService api = RetrofitClient.getApiService();
            Call<ArrayList<JsonData>> call = api.getMyJSON();
            call.enqueue(new Callback<ArrayList<JsonData>>() {
                @Override
                public void onResponse(Call<ArrayList<JsonData>> call, Response<ArrayList<JsonData>> response) {

                    if(response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        for (int i = 0; i <response.body().size() ; i++) {
                            name.add(response.body().get(i).getName());
                            list.add(response.body().get(i));

                        }

                        /**
                         * Binding that List to Adapter
                         */

                        Spinner sp =  findViewById(R.id.spinner);
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,name);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp.setAdapter(adapter);
                        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                resulttextview.setText(" Mode of Transport:\n Car: "+list.get(i).getFromcentral().getCar()+"\n Train: "+list.get(i).getFromcentral().getTrain());
                                latitude=list.get(i).getLocation().getLatitude();
                                longitude=list.get(i).getLocation().getLongitude();

                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                    else {
                        Toast.makeText(MainActivity.this, "please check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
               public void onFailure(Call<ArrayList<JsonData>> call, Throwable t) {
                }
            });



        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (latitude != null && longitude != null) {
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("latitude", latitude);
                    intent.putExtra("Longitude", longitude);
                    startActivity(intent);
                } else
                    Toast.makeText(MainActivity.this, "Data is not avaliable", Toast.LENGTH_SHORT).show();
            }
        });

        }
    }
