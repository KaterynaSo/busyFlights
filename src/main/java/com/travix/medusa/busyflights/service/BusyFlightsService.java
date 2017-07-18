package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.*;

import static com.travix.medusa.busyflights.util.AirlinesStaticData.HTTP_LOCALHOST_8080_CRAZY_AIR_GETFLIGHT;
import static com.travix.medusa.busyflights.util.AirlinesStaticData.HTTP_LOCALHOST_8080_TOUGH_JET_GETFLIGHT;
import static com.travix.medusa.busyflights.util.RequestConverter.convertBusyFlightsToCrazyAirString;
import static com.travix.medusa.busyflights.util.RequestConverter.convertBusyFlightsToToughJetString;

/**
 * Created by kateryna.sosonna on 7/15/2017.
 */
@Service
public class BusyFlightsService {


    public List<BusyFlightsResponse> getAggregatedData(BusyFlightsRequest busyFlightsRequest) {

        List<BusyFlightsResponse> rsp = new ArrayList<>();

        //get CrazyAir data
        List<CrazyAirResponse> cr = getCrazyAirResponse(busyFlightsRequest);
        cr.forEach(item -> {
            rsp.add(ResponseConverter.crazyAirToBusyFlights(item));
        });


        //get ToughJet data
        List<ToughJetResponse> tj = getToughJetResponse(busyFlightsRequest);
        tj.forEach(item -> {
            rsp.add(ResponseConverter.toughAirToBusyFlights(item));
        });


        Collections.sort(rsp, new BusyFlightsComparator());

        // rsp.forEach(item -> System.out.println());

        return rsp;

    }

    private List<ToughJetResponse> getToughJetResponse(BusyFlightsRequest busyFlightsRequest) {
        //TODO temp data is added
        List<ToughJetResponse> rs = ToughJetDataBuilder.toughJetData();

        RestTemplate restTemplate = new RestTemplate();
        String uri = HTTP_LOCALHOST_8080_TOUGH_JET_GETFLIGHT + convertBusyFlightsToToughJetString(busyFlightsRequest);
        ParameterizedTypeReference<List<ToughJetResponse>> typeRefTJ = new ParameterizedTypeReference<List<ToughJetResponse>>() {
        };
        ResponseEntity<List<ToughJetResponse>> res = restTemplate.exchange(uri, HttpMethod.GET, null, typeRefTJ);

        return res.getBody();

    }


    private List<CrazyAirResponse> getCrazyAirResponse(BusyFlightsRequest busyFlightsRequest) {
        //TODO temp data is added
        List<ToughJetResponse> rs = ToughJetDataBuilder.toughJetData();

        RestTemplate restTemplate = new RestTemplate();
        String uri = HTTP_LOCALHOST_8080_CRAZY_AIR_GETFLIGHT + convertBusyFlightsToCrazyAirString(busyFlightsRequest);
        ParameterizedTypeReference<List<CrazyAirResponse>> typeRefTJ = new ParameterizedTypeReference<List<CrazyAirResponse>>() {
        };
        ResponseEntity<List<CrazyAirResponse>> res = restTemplate.exchange(uri, HttpMethod.GET, null, typeRefTJ);

        return res.getBody();

    }

}
