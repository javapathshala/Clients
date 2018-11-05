package com.jp.client.soap;

import in.gov.gem.order.ws.OrderCountResponse;
import in.gov.gem.order.ws.OrderRequest;
import in.gov.gem.order.ws.OrderService;
import in.gov.gem.order.ws.OrderServicesSoap;
import java.net.URL;

/*
 * Copyright (c) Java Pathshala
 * Wisdom Being Shared
 * All rights reserved.
 *
 * No parts of this source code can be reproduced without written consent from
 * Java Pathshala
 * JavaPathshala.com
 *
 */
/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class SoapClient
{

    public static final String SERVICE_URL = "http://100.70.177.137:4014/services/v1?wsdl";

    public static void main(String[] args)
    {
        SoapClient soapClient = new SoapClient();
        try
        {
            soapClient.soapTester();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void soapTester() throws Exception
    {
        //Service URL
        URL url = new URL(SERVICE_URL);

        //Create Service
        OrderService service = new OrderService(url);
        OrderServicesSoap orderEndPoint = service.getOrderServicesSoapPort();

        //Create Service Request
        OrderRequest request = new OrderRequest();
        request.setClientCode("CRPF");
        request.setAuthToken("D4BB69B86A7FE71CA30C45CC5D2419C7");
        request.setFromDate("2017-12-11");
        request.setToDate("2018-05-18");
        request.setTransactionId("CRPF:12345:2172198713928");

        //Invoke Service method
        OrderCountResponse response = orderEndPoint.countOrders(request);
        System.out.println(response);

    }
}
