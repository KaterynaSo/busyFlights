package com.travix.medusa.busyflights.rest;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/15/2017.
 */

@RestController
@RequestMapping("/api")
public class BusyFlightsResource {
    private final Logger log = LoggerFactory.getLogger(BusyFlightsResource.class);

    @Inject
    BusyFlightsService busyFlightsService;


    @GetMapping("/busy-flights")
    public ResponseEntity<List<BusyFlightsResponse>> findAll(Pageable pageble){
       // Page<BusyFlightsResponse> page =  busyFlightsService.findAll(pageble);
        return busyFlightsService.findAll(pageble);
    }

}
