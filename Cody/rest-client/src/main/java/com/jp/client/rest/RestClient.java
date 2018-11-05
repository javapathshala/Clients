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
package com.jp.client.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class RestClient
{

    private static final String SERVICE_URL = "http://localhost:4008/bis/verify";

    private static final String REQUEST_JSON = "{\"clientCode\":\"CRPF\",\"transactionId\":\"CRPF:12345:2172198713928\",\"fromDate\":\"2017-12-11\",\"toDate\":\"2018-05-18\",\"authToken\":\"D4BB69B86A7FE71CA30C45CC5D2419C7\"}";

    public static void main(String[] args)
    {
        RestClient restClient = new RestClient();
        try
        {
            restClient.restTester();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void restTester() throws Exception
    {
        //Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Create HTTP entity with request JSON & Headers
        HttpEntity<String> entity = new HttpEntity<>(REQUEST_JSON, headers);

        //Create REST Template
        RestTemplate restTemplate = new RestTemplate();

        //Invoke Service method
        ResponseEntity<String> responseEntity = restTemplate.exchange(SERVICE_URL, HttpMethod.POST, entity, String.class);

        System.out.println("Response Status Code --> " + responseEntity.getStatusCode());
        if (responseEntity.getStatusCode() == HttpStatus.OK)
        {
            System.out.println("Response is --> " + responseEntity.getBody());
        }
        else
        {
            System.out.println("Response is --> BAD");
        }
    }
}
