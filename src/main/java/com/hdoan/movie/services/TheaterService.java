package com.hdoan.movie.services;

import com.hdoan.movie.convertor.TheaterConvertor;
import com.hdoan.movie.entities.Theater;
import com.hdoan.movie.exceptions.TheaterIsExist;
import com.hdoan.movie.repositories.TheaterRepository;
import com.hdoan.movie.request.TheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterRequest theaterRequest) throws TheaterIsExist {
        if (theaterRepository.findByAddress(theaterRequest.getAddress()) != null) {
            throw new TheaterIsExist();
        }

        Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);

        theaterRepository.save(theater);
        return "Theater has been saved Successfully";
    }
}
