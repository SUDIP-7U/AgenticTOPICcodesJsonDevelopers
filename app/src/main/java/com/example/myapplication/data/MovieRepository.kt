package com.example.myapplication.data

import com.example.myapplication.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(
    private val apiService: TmdbApiService = RetrofitClient.apiService,
) {
    suspend fun getPopularMovies(page: Int = 1): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                apiService.getPopularMovies(page = page).results
            }
        }
    }
}
