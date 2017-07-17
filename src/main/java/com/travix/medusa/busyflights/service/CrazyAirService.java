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


    public List<CrazyAirResponse> getCrazyAirFlights(CrazyAirRequest crazyAirRequest,List<CrazyAirResponse>  rsp ){

        List<CrazyAirResponse>  lst =  rsp.stream()
                .filter(it -> crazyAirRequest.getOrigin().equals(it.getDepartureAirportCode()))
                .filter(it -> crazyAirRequest.getDestination().equals(it.getDestinationAirportCode()))
                .filter(it -> crazyAirRequest.getDepartureDate().equals(it.getDepartureDate()))
                .filter(it -> crazyAirRequest.getReturnDate().equals(it.getArrivalDate()))
                .collect(Collectors.toList());
        return lst;

    }




}
