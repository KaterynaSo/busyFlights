package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.ToughJetService;
import com.travix.medusa.busyflights.util.ToughJetDataBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
@RestController
@RequestMapping("/tough-jet")
public class ToughJetController {

    @Inject
    ToughJetService toughJetService;

    @RequestMapping(value = "/getflight", method = RequestMethod.GET)
    public ResponseEntity<List<ToughJetResponse>> getCrazyAirFlights(@Valid ToughJetRequest toughJetRequest ){
        toughJetRequest.getInboundDate();
        //TODO ToughJetDataBuilder.toughJetData()- temp solution
        List<ToughJetResponse> rsp = toughJetService.getToughJetFlights(toughJetRequest, ToughJetDataBuilder.toughJetData());
        return new ResponseEntity<List<ToughJetResponse>>(rsp, HttpStatus.OK);
    }
}
