package com.example.myapplication.data

import com.example.myapplication.domain.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiService {
    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "873f982a7eb8d5c468abdf2d102d0f4c",
        @Query("page") page: Int = 1,
    ): MovieResponse
}
