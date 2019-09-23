package com.enriquers.flagpp.service.repository;

import com.enriquers.flagpp.service.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesRepository {
    private RESTCountriesService restCountriesService;
    private static CountriesRepository countriesRepository;

    private CountriesRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RESTCountriesService.URL_BASE_REST_COUNTRIES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restCountriesService = retrofit.create(RESTCountriesService.class);
    }

    public synchronized static CountriesRepository getInstance() {
        if (countriesRepository == null) {
            countriesRepository = new CountriesRepository();
        }
        return countriesRepository;
    }

    public List<Country> getCountriesOfRegion(String region) {
        Call<List<Country>>
//        (Call<List<Country>>) restCountriesService.getCountriesOfRegion(region);
         return (List<Country>) restCountriesService.getCountriesOfRegion(region);
    }
}
