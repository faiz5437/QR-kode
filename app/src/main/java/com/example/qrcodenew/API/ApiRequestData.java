package com.example.qrcodenew.API;

import com.example.qrcodenew.Model.ModelData;
import com.example.qrcodenew.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiRequestData {
    @GET("banner-list/")
    Call<ModelData> ardRetrieveData();
}
