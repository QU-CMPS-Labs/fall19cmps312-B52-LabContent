package com.cmps312.myclosecontacts.httpRequests;

import com.cmps312.myclosecontacts.models.Result;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersClients {

    String BASE_URL = "https://randomuser.me";


    //GET , PUT , POST , DELETE

    @GET("/api")
    Result getUsers(@Query("results") String results,
                    @Query("format") String format);
}
