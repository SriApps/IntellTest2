package com.test.sri.intelltest2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Srikanth .
 */

public class RetrofitClient {

    private static final String ROOT_URL = "http://express-it.optusnet.com.au";

        /**
         * Get Retrofit Instance
         */
        private static Retrofit getRetrofitInstance() {
            return new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        /**
         * Get API Service
         *
         * @return API Service
         */
        public static RetrofitApiService getApiService() {
            return getRetrofitInstance().create(RetrofitApiService.class);
        }
    }

