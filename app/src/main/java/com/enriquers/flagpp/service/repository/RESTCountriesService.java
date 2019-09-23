package com.enriquers.flagpp.service.repository;

import com.enriquers.flagpp.service.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface RESTCountriesService {

    String URL_BASE_REST_COUNTRIES = "https://restcountries.eu/rest/v2/";

    @GET("alpha/{code}")
    Call<Country> getCountryByCod(@Path("code") String code);

    @GET("region/{region}")
    Call<List<Country>> getCountriesOfRegion(@Path("region") String region);
}
