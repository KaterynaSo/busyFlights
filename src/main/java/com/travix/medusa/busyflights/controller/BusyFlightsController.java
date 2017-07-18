package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/16/2017.
 */

@RestController
@RequestMapping("/busy-flights")
public class BusyFlightsController {

    @Inject
    BusyFlightsService busyFlightsService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<BusyFlightsResponse>> getCrazyAirFlights(@Valid BusyFlightsRequest busyFlightsRequest ){
        List<BusyFlightsResponse> rsp = busyFlightsService.getAggregatedData(busyFlightsRequest);
        return new ResponseEntity<List<BusyFlightsResponse>>(rsp, HttpStatus.OK);
    }

}
