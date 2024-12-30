package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification,
                           FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);        //Will proceeed the request to server and gets back response
        logResponse(response);      //Perform response filter
        return response;        //Sending response back to tests for assertions
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("Base URI         : "+requestSpec.getBaseUri());
        logger.info("Request Header   : "+requestSpec.getHeaders());
        logger.info("Request Payload  : "+requestSpec.getBody());
    }

    public void logResponse(Response response){
        logger.info("Response Status Code : "+response.getStatusCode());
        logger.info("Response Header      : "+response.getHeaders());
        logger.info("Response Payload     : "+response.getBody().asPrettyString());
    }
}
