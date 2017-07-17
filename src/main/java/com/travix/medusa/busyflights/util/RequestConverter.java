package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public class RequestConverter {

    public static ToughJetRequest convertBusyFlightsToToughJet(BusyFlightsRequest busyFlightsRequest){
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
        //TODO probably need to check that passenger is adult
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());

        return toughJetRequest;
    }


    public static CrazyAirRequest convertBusyFlightsToCrazyAir(BusyFlightsRequest busyFlightsRequest){
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setDestination(busyFlightsRequest.getOrigin());
        crazyAirRequest.setOrigin(busyFlightsRequest.getDestination());
        crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
        crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
        crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());

        return crazyAirRequest;
    }
}
