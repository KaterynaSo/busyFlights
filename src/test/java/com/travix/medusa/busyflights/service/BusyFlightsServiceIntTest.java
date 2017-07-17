package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.BusyFlightsApplication;
import com.travix.medusa.busyflights.controller.BusyFlightsController;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.Airlines;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.travix.medusa.busyflights.util.Airlines.*;
import static com.travix.medusa.busyflights.util.Airlines.ARRIVAL_DATE_19;
import static com.travix.medusa.busyflights.util.Airlines.DEPARTURE_DATE_18;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusyFlightsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BusyFlightsServiceIntTest {

    @Inject
    CrazyAirService crazyAirService;

    @Inject
    ToughJetService toughJetService;

    @Inject
    BusyFlightsService busyFlightsService;

    private MockMvc restMvc;

    @Before
    public void setup(){
        List<CrazyAirResponse> cr = crazyAirData();
        List<ToughJetResponse> tj = toughJetData();

        BusyFlightsController busyFlightsController = new BusyFlightsController();
//        ReflectionTestUtils.setField(busyFlightsController, "busyFlightsController", busyFlightsController);
        MockitoAnnotations.initMocks(this);
        this.restMvc = MockMvcBuilders.standaloneSetup(busyFlightsController)
                .setMessageConverters().build();

    }



    @Test
    @Ignore
    public void busyServiceTest() throws Exception {

        // Get all the simCardList
        restMvc.perform(get("http://localhost:8080/busy-flights/getagg?origin=AMS&destination=LHR&departureDate=2017-07-17&returnDate=2017-07-18&numberOfPassengers=1"))
                .andExpect(status().isOk());

    }
    public  List<CrazyAirResponse> crazyAirData(){
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


    public  List<ToughJetResponse> toughJetData(){
        List<ToughJetResponse> rsp = new ArrayList<>();
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
        return rsp;
    }
}
