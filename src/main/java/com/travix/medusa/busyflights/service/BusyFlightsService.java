package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.Request;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by kateryna.sosonna on 7/15/2017.
 */
@Service
public class BusyFlightsService {
    public static final String HTTP_LOCALHOST_8080_CRAZY_AIR_GETFLIGHT = "http://localhost:8080/crazy-air/getflight";
    @Inject
    CrazyAirService crazyAirService;
    @Inject
    ToughJetService toughJetService;

    public List<BusyFlightsResponse> getAggregatedData(BusyFlightsRequest busyFlightsRequest) {
        //TODO instead f service call HTTP request should be called here
        //  TODO supplierRequest(HTTP_LOCALHOST_8080_CRAZY_AIR_GETFLIGHT);
        List<CrazyAirResponse> crr = CrazyAirDataBuilder.crazyAirData();
        List<CrazyAirResponse> cr
                = crazyAirService.getCrazyAirFlights(RequestConverter.convertBusyFlightsToCrazyAir(busyFlightsRequest), crr);

        //TODO temporary data builder
        List<ToughJetResponse> rs = ToughJetDataBuilder.toughJetData();
        List<ToughJetResponse> tj
                = toughJetService.getToughJetFlights(RequestConverter.convertBusyFlightsToToughJet(busyFlightsRequest), rs);


        List<BusyFlightsResponse> rsp = new ArrayList<>();

        //add search results to the main list and sort by price
        cr.forEach(item -> {
            rsp.add(ResponseConverter.crazyAirToBusyFlights(item));
        });

        tj.forEach(item -> {
            rsp.add(ResponseConverter.toughAirToBusyFlights(item));
        });


        Collections.sort(rsp, new BusyFlightsComparator());

        // rsp.forEach(item -> System.out.println());

        return rsp;

    }

    private String supplierRequest(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    private String supplierRequestBuilder(String baseUri, Request request) {
        //   String uri = baseUri + "?" +  ;
        //TODO proper URI should be retorned here with parameter for the reuest
        return null;
    }
/*    public ResponseEntity<List<BusyFlightsResponse>> findAll(){
        List<BusyFlightsResponse> lst = Arrays.asList( new BusyFlightsResponse(10));
        return new ResponseEntity<List<BusyFlightsResponse>>(lst, HttpStatus.OK);
      /// Page<BusyFlightsResponse> page =  busyFlightsRepository.findAll(pageble);
    //    return new ResponseEntity<>(page.getContent(),HttpStatus.OK);
    }*/
}
