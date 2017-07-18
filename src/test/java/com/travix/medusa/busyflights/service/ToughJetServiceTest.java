package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.BusyFlightsApplication;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.AirlinesStaticData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.util.AirlinesStaticData.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by kateryna.sosonna on 7/18/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusyFlightsApplication.class)
public class ToughJetServiceTest {

    @Inject
    ToughJetService toughJetService;
    private List<ToughJetResponse> tj;
    private MockMvc restMvc;

    @Before
    public void setup() {
        tj = toughJetData();
    }

    @Test
    public void ToughJetServiceTest() {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(AIRPORT_CODE_AMS);
        toughJetRequest.setTo(AIRPORT_CODE_LHR);
        toughJetRequest.setOutboundDate(DEPARTURE_DATE_17);
        toughJetRequest.setInboundDate(ARRIVAL_DATE_18);
        toughJetRequest.setNumberOfAdults(1);

        List<ToughJetResponse> lst = tj.stream()
                .filter(it -> toughJetRequest.getFrom().equals(it.getDepartureAirportName()))
                .filter(it -> toughJetRequest.getTo().equals(it.getArrivalAirportName()))
                .filter(it -> toughJetRequest.getOutboundDate().equals(it.getOutboundDateTime()))
                .filter(it -> toughJetRequest.getInboundDate().equals(it.getInboundDateTime()))
                .collect(Collectors.toList());

        List<ToughJetResponse> res = toughJetService.getToughJetFlights(toughJetRequest, tj);

        assertEquals(lst.size(), res.size());


    }

    private List<ToughJetResponse> toughJetData() {
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
