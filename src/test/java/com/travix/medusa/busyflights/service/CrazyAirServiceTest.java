package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.BusyFlightsApplication;
import com.travix.medusa.busyflights.controller.CrazyAirController;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.util.AirlinesStaticData.*;
import static com.travix.medusa.busyflights.util.AirlinesStaticData.ARRIVAL_DATE_19;
import static com.travix.medusa.busyflights.util.AirlinesStaticData.DEPARTURE_DATE_18;
import static org.junit.Assert.assertEquals;

/**
 * Created by kateryna.sosonna on 7/18/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusyFlightsApplication.class)
public class CrazyAirServiceTest {

    @Inject
    CrazyAirService crazyAirService;

    private List<CrazyAirResponse> cr;

    private MockMvc restMvc;

    @Before
    public void setup() {
        cr = crazyAirData();
        CrazyAirController crazyAirController = new CrazyAirController();
        ReflectionTestUtils.setField(crazyAirController, "crazyAirService", crazyAirService);
        this.restMvc = MockMvcBuilders.standaloneSetup(crazyAirController)
                .setMessageConverters().build();
    }


    @Test
    public void crazyAirServiceTest(){
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin(AIRPORT_CODE_AMS);
        crazyAirRequest.setDestination(AIRPORT_CODE_LHR);
        crazyAirRequest.setDepartureDate(DEPARTURE_DATE_17);
        crazyAirRequest.setReturnDate(ARRIVAL_DATE_18);
        crazyAirRequest.setPassengerCount(1);
        List<CrazyAirResponse>  lst =  cr.stream()
                .filter(it -> crazyAirRequest.getOrigin().equals(it.getDepartureAirportCode()))
                .filter(it -> crazyAirRequest.getDestination().equals(it.getDestinationAirportCode()))
                .filter(it -> crazyAirRequest.getDepartureDate().equals(it.getDepartureDate()))
                .filter(it -> crazyAirRequest.getReturnDate().equals(it.getArrivalDate()))
                .collect(Collectors.toList());

        List<CrazyAirResponse> res = crazyAirService.getCrazyAirFlights(crazyAirRequest,cr);

        assertEquals(lst.size(), res.size());

    }

    private  List<CrazyAirResponse> crazyAirData(){
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
