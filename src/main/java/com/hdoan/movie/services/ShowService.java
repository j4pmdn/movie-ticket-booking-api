package com.hdoan.movie.services;

import com.hdoan.movie.convertor.ShowConvertor;
import com.hdoan.movie.entities.Movie;
import com.hdoan.movie.entities.Show;
import com.hdoan.movie.entities.Theater;
import com.hdoan.movie.exceptions.MovieDoesNotExists;
import com.hdoan.movie.exceptions.TheaterDoesNotExists;
import com.hdoan.movie.repositories.MovieRepository;
import com.hdoan.movie.repositories.ShowRepository;
import com.hdoan.movie.repositories.TheaterRepository;
import com.hdoan.movie.request.ShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest){
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());
        if (movieOpt.isEmpty()){
            throw new MovieDoesNotExists();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

        if (theaterOpt.isEmpty()){
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);
        return "Show has been added Successfully";
    }

}
