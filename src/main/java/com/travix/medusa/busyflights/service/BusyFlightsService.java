package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/15/2017.
 */
@Service
public class BusyFlightsService {



    public ResponseEntity<List<BusyFlightsResponse>> findAll(Pageable pageble){
        List<BusyFlightsResponse> lst = Arrays.asList( new BusyFlightsResponse(10));
        return new ResponseEntity<List<BusyFlightsResponse>>(lst, HttpStatus.OK);
      /// Page<BusyFlightsResponse> page =  busyFlightsRepository.findAll(pageble);
    //    return new ResponseEntity<>(page.getContent(),HttpStatus.OK);
    }
}
