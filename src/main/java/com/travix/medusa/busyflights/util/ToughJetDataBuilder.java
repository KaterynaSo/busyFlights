package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public class ToughJetDataBuilder {


    public static List<ToughJetResponse> toughJetData(){
        List<ToughJetResponse> rsp = new ArrayList<>();
        ToughJetResponse rs = new ToughJetResponse();
        rs.setCarrier(AirlinesStaticData.TOUGH_JET);
        rs.setBasePrice(10.0);
        rs.setDiscount(0);
        rs.setTax(0.0);
        rs.setDepartureAirportName(AirlinesStaticData.AIRPORT_CODE_AMS);
        rs.setArrivalAirportName(AirlinesStaticData.AIRPORT_CODE_LHR);
        rs.setOutboundDateTime(AirlinesStaticData.DEPARTURE_DATE_17);
        rs.setInboundDateTime(AirlinesStaticData.ARRIVAL_DATE_18);

        rsp.add(rs);

        rs = new ToughJetResponse();
        rs.setCarrier(AirlinesStaticData.TOUGH_JET);
        rs.setBasePrice(20.0);
        rs.setDiscount(0);
        rs.setTax(0.0);
        rs.setDepartureAirportName(AirlinesStaticData.AIRPORT_CODE_AMS);
        rs.setArrivalAirportName(AirlinesStaticData.AIRPORT_CODE_LHR);
        rs.setOutboundDateTime(AirlinesStaticData.DEPARTURE_DATE_18);
        rs.setInboundDateTime(AirlinesStaticData.ARRIVAL_DATE_19);

        rsp.add(rs);

        rsp.add(rs);
        return rsp;
    }
}
