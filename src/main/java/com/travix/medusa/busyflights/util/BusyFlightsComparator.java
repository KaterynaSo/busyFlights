package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.Comparator;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public class BusyFlightsComparator implements Comparator<BusyFlightsResponse> {

    @Override
    public int compare(BusyFlightsResponse r1, BusyFlightsResponse r2){
        return r1.getFare().compareTo(r2.getFare());
    }
}
