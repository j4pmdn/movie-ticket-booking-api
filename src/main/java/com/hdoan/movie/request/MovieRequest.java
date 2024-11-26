package com.hdoan.movie.request;

import com.hdoan.movie.enums.Genre;
import com.hdoan.movie.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
