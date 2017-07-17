package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.Airlines;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
@Service
public class ToughJetService {

    List<ToughJetResponse> rsp = new ArrayList<>();
    public ToughJetService(){
        ToughJetResponse rs = new ToughJetResponse();
        rs.setCarrier(Airlines.TOUGH_JET);
        rs.setBasePrice(10.0);
        rs.setDiscount(0);
        rs.setTax(0.0);
        rs.setDepartureAirportName(Airlines.AIRPORT_CODE_AMS);
        rs.setArrivalAirportName(Airlines.AIRPORT_CODE_LHR);
        rs.setOutboundDateTime(Airlines.DEPARTURE_DATE_17);
        rs.setInboundDateTime(Airlines.ARRIVAL_DATE_18);

        rsp.add(rs);

        rs = new ToughJetResponse();
        rs.setCarrier(Airlines.TOUGH_JET);
        rs.setBasePrice(20.0);
        rs.setDiscount(0);
        rs.setTax(0.0);
        rs.setDepartureAirportName(Airlines.AIRPORT_CODE_AMS);
        rs.setArrivalAirportName(Airlines.AIRPORT_CODE_LHR);
        rs.setOutboundDateTime(Airlines.DEPARTURE_DATE_18);
        rs.setInboundDateTime(Airlines.ARRIVAL_DATE_19);

        rsp.add(rs);

        rsp.add(rs);

    }

        public List<ToughJetResponse> getToughJetFlights(ToughJetRequest toughJetRequest){

        // TODO toughJetRequest.getInboundDate().equals(it.getInboundDateTime())) - can't be compred directly without conversion to one format
            //TODO number of passanger are nor included to the logcic yet
        List<ToughJetResponse>  lst =  rsp.stream()
                .filter(it -> toughJetRequest.getFrom().equals(it.getDepartureAirportName()))
                .filter(it -> toughJetRequest.getTo().equals(it.getArrivalAirportName()))
                .filter(it -> toughJetRequest.getOutboundDate().equals(it.getOutboundDateTime()))
                .filter(it -> toughJetRequest.getInboundDate().equals(it.getInboundDateTime()))
                .collect(Collectors.toList());
        return lst;

    }

}
