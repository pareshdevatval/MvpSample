/*
 * Copyright (c) 2016.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.mvpstructure.rest;

import com.mvpstructure.models.SampleResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * @author Harsh
 * @version 1.0
 */
public interface RestClient {

  String ENDPOINT = "http://jsonplaceholder.typicode.com/";


  @GET("posts") Call<List<SampleResponse>> getJsonData();
  @GET("posts") Call<List<SampleResponse>> login();



  /******** Helper class that sets up a new services *******/
  class Creator {
    public static RestClient getClient() {
      Retrofit retrofit = new Retrofit.Builder().baseUrl(RestClient.ENDPOINT)
          .addConverterFactory(new ToStringConverterFactory())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      return retrofit.create(RestClient.class);
    }
  }
}
