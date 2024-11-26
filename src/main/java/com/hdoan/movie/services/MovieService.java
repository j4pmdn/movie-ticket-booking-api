package com.hdoan.movie.services;

import com.hdoan.movie.convertor.MovieConvertor;
import com.hdoan.movie.entities.Movie;
import com.hdoan.movie.exceptions.MovieAlreadyExist;
import com.hdoan.movie.repositories.MovieRepository;
import com.hdoan.movie.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest){
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());
        if(movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())){
            throw new MovieAlreadyExist();
        }

        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }



}
