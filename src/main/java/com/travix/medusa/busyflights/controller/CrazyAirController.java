package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.service.CrazyAirService;
import com.travix.medusa.busyflights.util.CrazyAirDataBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/16/2017.
 */

@RestController
@RequestMapping("/crazy-air")
public class CrazyAirController {

    @Inject
    CrazyAirService crazyAirService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<CrazyAirResponse>> getCrazyAirFlights(@Valid CrazyAirRequest crazyAirRequest ){
        crazyAirRequest.getDestination();
        //TODO CrazyAirDataBuilder.crazyAirData()- temp solution
        List<CrazyAirResponse> rsp = crazyAirService.getCrazyAirFlights(crazyAirRequest, CrazyAirDataBuilder.crazyAirData());
        return new ResponseEntity<List<CrazyAirResponse>>(rsp, HttpStatus.OK);
    }

}
