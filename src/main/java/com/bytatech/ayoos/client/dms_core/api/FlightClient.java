package com.bytatech.ayoos.client.dms_core.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bytatech.ayoos.client.dms_core.model.SitePaging;

@FeignClient(name="FlightClient", url= "https://i0rezn.trial.alfresco.com/api/-default-/public/alfresco/versions/1")
public interface FlightClient {
 /*@RequestMapping(method = RequestMethod.GET, value = "/flight/FRA/departure")
    List<FlightWrapper> getDepartingFlights();
    
    
 
 
 
 
    @RequestMapping(method = RequestMethod.GET, value = "/flightDetails/{airlineCode}/{flightNumber}/")
    List<FlightWrapper> getFlightDetails(@PathVariable("airlineCode") String airlineCode, @PathVariable("flightNumber") Integer flightNumber);
 */
    
    @RequestMapping(method = RequestMethod.GET, value = "/sites", produces = "application/json")
    ResponseEntity<SitePaging> listSites();
    
    
}
