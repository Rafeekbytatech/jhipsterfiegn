package com.bytatech.ayoos.web.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.ayoos.client.dms_core.api.SitesApi;
import com.bytatech.ayoos.client.dms_core.model.SiteBodyCreate;
import com.bytatech.ayoos.client.dms_core.model.SiteBodyCreate.VisibilityEnum;
import com.bytatech.ayoos.client.dms_core.model.SiteEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api")
public class CommandResource {
	
	@Autowired
	SitesApi siteApi;
	
	@GetMapping("/")
	public String test() {
		return "success";
		}
	@PostMapping("/site/{siteId}")
	public String createSite(@PathVariable String siteId) {
		SiteBodyCreate siteBodyCreate = new SiteBodyCreate();
		siteBodyCreate.setTitle(siteId);
		siteBodyCreate.setId(siteId);
		siteBodyCreate.setVisibility(VisibilityEnum.MODERATED);
		ResponseEntity<SiteEntry> entry = siteApi.createSite(siteBodyCreate, false, false, new ArrayList());
		return entry.getBody().getEntry().getId();
	}
	
	
	
}
