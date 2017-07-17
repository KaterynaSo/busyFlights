package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.util.Airlines;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.util.Airlines.*;

/**
 * Created by kateryna.sosonna on 7/16/2017.
 */
@Service
public class CrazyAirService {




    List<CrazyAirResponse> rsp = new ArrayList<>();
    public CrazyAirService(){
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline(CRAZY_AIR);
        crazyAirResponse.setPrice(PRICE_122_1);
        crazyAirResponse.setDepartureAirportCode(AIRPORT_CODE_AMS);
        crazyAirResponse.setDestinationAirportCode(AIRPORT_CODE_LHR);
        crazyAirResponse.setDepartureDate(DEPARTURE_DATE_17);
        crazyAirResponse.setArrivalDate(ARRIVAL_DATE_18);

        rsp.add(crazyAirResponse);

        crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline(CRAZY_AIR);
        crazyAirResponse.setPrice(PRICE_60_1);
        crazyAirResponse.setDepartureAirportCode(AIRPORT_CODE_AMS);
        crazyAirResponse.setDestinationAirportCode(AIRPORT_CODE_LHR);
        crazyAirResponse.setDepartureDate(DEPARTURE_DATE_18);
        crazyAirResponse.setArrivalDate(ARRIVAL_DATE_19);
        rsp.add(crazyAirResponse);

    }

    public List<CrazyAirResponse> getCrazyAirFlights(CrazyAirRequest crazyAirRequest){

        List<CrazyAirResponse>  lst =  rsp.stream()
                .filter(it -> crazyAirRequest.getOrigin().equals(it.getDepartureAirportCode()))
                .filter(it -> crazyAirRequest.getDestination().equals(it.getDestinationAirportCode()))
                .filter(it -> crazyAirRequest.getDepartureDate().equals(it.getDepartureDate()))
                .filter(it -> crazyAirRequest.getReturnDate().equals(it.getArrivalDate()))
                .collect(Collectors.toList());
        return lst;

    }




}
