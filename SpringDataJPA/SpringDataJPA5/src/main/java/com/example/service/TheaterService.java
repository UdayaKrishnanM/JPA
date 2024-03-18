package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MovieRepository;
import com.example.entity.Movie;

@Service
public class TheaterService {

	@Autowired
    private MovieRepository movieRepository;

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
	
	
}
