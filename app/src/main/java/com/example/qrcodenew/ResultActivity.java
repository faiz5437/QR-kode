package com.example.qrcodenew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.qrcodenew.API.ApiRequestData;
import com.example.qrcodenew.API.RetroServer;
import com.example.qrcodenew.Model.ModelData;
import com.example.qrcodenew.Model.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {
    private static Retrofit retro;

    private TextView tvHasil;
    String TAG = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvHasil = findViewById(R.id.tv_hasil);

        String result = getIntent().getStringExtra("result");
        Log.d( "retrofitcek: ","hasil "+ result);

        RetroServer.endpoint(result).ardRetrieveData()
                .enqueue(new Callback<ModelData>() {
                    @Override
                    public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                        if (response.isSuccessful()){
                            Log.d(TAG, "onResponse: responee " + response);
                            String results = response.body().getMeta().getMessages();
//                            List<ModelData.Data> results = response.body().getData();
                            Log.d(TAG, "onResponse: hasil33 : " + results.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelData> call, Throwable t) {
                        Log.d(TAG, "onFailure: tete " + t.toString());
                    }
                });
//        if (retro == null){
//            retro = new Retrofit.Builder()
//                    .baseUrl(result.toString())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        retro.newBuilder();
//        Log.d(TAG, "onCreate: retrocek "+ retro);


//        ApiRequestData ardData = retro.create(ApiRequestData.class);
//        Log.d(TAG, "onCreate: ard " + ardData);
//        Call<ModelData> tampilData = ardData.ardRetrieveData();


//        WebView myWebView = (WebView) findViewById(R.id.wv);
//        myWebView.loadUrl(result);
        tvHasil.setText(result);
        tvHasil.setMovementMethod(LinkMovementMethod.getInstance());



    }
}