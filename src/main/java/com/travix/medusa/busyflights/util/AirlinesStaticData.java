package com.travix.medusa.busyflights.util;

/**
 * Created by kateryna.sosonna on 7/17/2017.
 */
public interface AirlinesStaticData {

    //TODO all thisdata should parametriseid or used some data source, database, for instance

    public static final String HTTP_LOCALHOST_8080_CRAZY_AIR_GETFLIGHT = "http://localhost:8080/crazy-air/getAll";
    public static final String HTTP_LOCALHOST_8080_TOUGH_JET_GETFLIGHT = "http://localhost:8080/tough-jet/getAll";

    public static final String CRAZY_AIR = "CrazyAir";
    public static final String TOUGH_JET = "ToughJet";

    public static final String AIRPORT_CODE_AMS = "AMS";
        public static final String AIRPORT_CODE_LHR = "LHR";

    public static final double PRICE_122_1 = 122.1;
    public static final double PRICE_60_1 = 60.1;



    public static final String DEPARTURE_DATE_17 = "2017-07-17";
    public static final String DEPARTURE_DATE_18 = "2017-07-18";

    public static final String ARRIVAL_DATE_18 = "2017-07-18";
    public static final String ARRIVAL_DATE_19 = "2017-07-19";




}
