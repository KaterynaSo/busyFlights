package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

import java.util.ArrayList;
import java.util.List;

import static com.travix.medusa.busyflights.util.Airlines.*;
import static com.travix.medusa.busyflights.util.Airlines.ARRIVAL_DATE_19;
import static com.travix.medusa.busyflights.util.Airlines.DEPARTURE_DATE_18;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public class CrazyAirDataBuilder {

    public static List<CrazyAirResponse> crazyAirData(){
        List<CrazyAirResponse> rsp = new ArrayList<>();
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline(CRAZY_AIR);
        crazyAirResponse.setPrice(PRICE_122_1);
        crazyAirResponse.setDepartureAirportCode(AIRPORT_CODE_LHR);
        crazyAirResponse.setDestinationAirportCode(AIRPORT_CODE_AMS);
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

        return rsp;
    }
}
