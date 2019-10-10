package com.bytatech.ayoos.client.custom_dms_core.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytatech.ayoos.client.custom_dms_core.model.PersonPaging;
import com.bytatech.ayoos.client.custom_dms_core.model.SiteBodyCreate;
import com.bytatech.ayoos.client.custom_dms_core.model.SiteEntry;
import com.bytatech.ayoos.client.custom_dms_core.model.SitePaging;

import io.swagger.annotations.ApiParam;

@FeignClient(name="FlightClient", url= "https://i0rezn.trial.alfresco.com/api/-default-/public/alfresco/versions/1")
public interface FlightClient {
 /*@RequestMapping(method = RequestMethod.GET, value = "/flight/FRA/departure")
    List<FlightWrapper> getDepartingFlights();
    
    
 
 
 
 
    @RequestMapping(method = RequestMethod.GET, value = "/flightDetails/{airlineCode}/{flightNumber}/")
    List<FlightWrapper> getFlightDetails(@PathVariable("airlineCode") String airlineCode, @PathVariable("flightNumber") Integer flightNumber);
 */
    
    @RequestMapping(method = RequestMethod.GET, value = "/sites", produces = "application/json")
    ResponseEntity<SitePaging> listSites();
    @RequestMapping(value = "/people",
            produces = "application/json", 
            method = RequestMethod.GET)
    ResponseEntity<PersonPaging> listPeople();
    
    
    @RequestMapping(value = "/sites",
            produces = "application/json", 
            consumes = "application/json",
            method = RequestMethod.POST)
	 ResponseEntity<SiteEntry> createSite(SiteBodyCreate siteBodyCreate);
    
    
    
    
    

}
