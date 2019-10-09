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

import com.bytatech.ayoos.client.custom_dms_core.ApiKeyRequestInterceptor;
import com.bytatech.ayoos.client.custom_dms_core.api.NodesApi;
import com.bytatech.ayoos.client.custom_dms_core.model.NodeBodyCreate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/dms")
public class DmsResource {
	
	
	/*@Autowired
	ApiKeyRequestInterceptor apiKeyRequestInterceptor;*/
	@Autowired
	NodesApi nodesApi;
	
	@GetMapping("/")
	public String test() {
		return "success";
		}
	
	
	@PostMapping("/createNode")
		public String createNodes(/*@PathVariable String nodeId,@RequestBody NodeBodyCreate nodeBodyCreateString name,String dmsId*/ ) {
				  System.out.println("+++++++++++++success++++++++++");
				  NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
					nodeBodyCreate.setName("dummmm");
					nodeBodyCreate.setNodeType("cm:content");
					//nodeBodyCreate.setRelativePath("Sites/"+dmsId);

				//	NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();
				  nodesApi.createNode("-my-", nodeBodyCreate, true, null, null);
				  
				 return "succes";
				  
				  }
	

	
}
