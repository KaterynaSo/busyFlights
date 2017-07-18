package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public class ResponseConverter {



    public static BusyFlightsResponse crazyAirToBusyFlights(CrazyAirResponse crazyAirResponse) {
        BusyFlightsResponse bf = new BusyFlightsResponse();
        bf.setAirline(crazyAirResponse.getAirline());
        bf.setSupplier(AirlinesStaticData.CRAZY_AIR);
        bf.setFare(crazyAirResponse.getPrice());
        bf.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
        bf.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        bf.setDepartureDate(crazyAirResponse.getDepartureDate());
        bf.setArrivalDate(crazyAirResponse.getArrivalDate());

        return bf;

    }

    public static BusyFlightsResponse toughAirToBusyFlights(ToughJetResponse toughJetResponse) {
        BusyFlightsResponse bf = new BusyFlightsResponse();
        bf.setAirline(toughJetResponse.getCarrier());
        bf.setSupplier(AirlinesStaticData.TOUGH_JET);
        bf.setFare(toughJetResponse.getBasePrice() + toughJetResponse.getTax() - toughJetResponse.getDiscount());
        bf.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
        bf.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
        bf.setDepartureDate(toughJetResponse.getOutboundDateTime());
        bf.setArrivalDate(toughJetResponse.getInboundDateTime());
        return bf;

    }
}
