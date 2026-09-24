package com.example.myapplication.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domain.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface MovieUiState {
    data object Loading : MovieUiState
    data class Success(val movies: List<Movie>) : MovieUiState
    data class Error(val message: String) : MovieUiState
}

class MovieViewModel(
    private val repository: MovieRepository = MovieRepository(),
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val uiState: StateFlow<MovieUiState> = _uiState.asStateFlow()

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            _uiState.value = MovieUiState.Loading
            repository.getPopularMovies()
                .onSuccess { movies ->
                    _uiState.value = MovieUiState.Success(movies)
                }
                .onFailure { error ->
                    _uiState.value = MovieUiState.Error(
                        error.localizedMessage ?: "An unexpected error occurred",
                    )
                }
        }
    }
}
