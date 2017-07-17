package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.Airlines;
import com.travix.medusa.busyflights.util.ToughJetDataBuilder;
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

        public List<ToughJetResponse> getToughJetFlights(ToughJetRequest toughJetRequest,List<ToughJetResponse> rsp ){

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
