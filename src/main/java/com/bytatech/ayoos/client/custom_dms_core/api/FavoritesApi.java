/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.custom_dms_core.api;

import com.bytatech.ayoos.client.custom_dms_core.model.Error;
import com.bytatech.ayoos.client.custom_dms_core.model.FavoriteBodyCreate;
import com.bytatech.ayoos.client.custom_dms_core.model.FavoriteEntry;
import com.bytatech.ayoos.client.custom_dms_core.model.FavoritePaging;
import com.bytatech.ayoos.client.custom_dms_core.model.FavoriteSiteBodyCreate;
import com.bytatech.ayoos.client.custom_dms_core.model.FavoriteSiteEntry;
import com.bytatech.ayoos.client.custom_dms_core.model.SiteEntry;
import com.bytatech.ayoos.client.custom_dms_core.model.SitePaging;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-04T15:51:38.542+05:30[Asia/Kolkata]")

@Api(value = "Favorites", description = "the Favorites API")
public interface FavoritesApi {

    @ApiOperation(value = "Create a favorite", nickname = "createFavorite", notes = "Favorite a **site**, **file**, or **folder** in the repository.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user.  **Note:** You can favorite more than one entity by  specifying a list of objects in the JSON body like this:  ```JSON [   {        \"target\": {           \"file\": {              \"guid\": \"abcde-01234-....\"           }        }    },    {        \"target\": {           \"file\": {              \"guid\": \"abcde-09863-....\"           }        }    }, ] ``` If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:  ```JSON {   \"list\": {     \"pagination\": {       \"count\": 2,       \"hasMoreItems\": false,       \"totalItems\": 2,       \"skipCount\": 0,       \"maxItems\": 100     },     \"entries\": [       {         \"entry\": {           ...         }       },       {         \"entry\": {           ...         }       }     ]   } } ``` ", response = FavoriteEntry.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = FavoriteEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **favoriteBodyCreate** invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**personId** does not exist, or the target entity does not exist, or a favorite already exists with the specified id, or an entity exists with the id of the posted object but is not of the same type of the posted object "),
        @ApiResponse(code = 409, message = "The target **guid** has already been favorited"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorites",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<FavoriteEntry> createFavorite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "An object identifying the entity to be favorited. " ,required=true )  @Valid @RequestBody FavoriteBodyCreate favoriteBodyCreate,@ApiParam(value = "Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders)   ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Create a site favorite", nickname = "createSiteFavorite", notes = "**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use `/people/{personId}/favorites` instead.  Create a site favorite for person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user.   **Note:** You can favorite more than one site by  specifying a list of sites in the JSON body like this:  ```JSON [   {     \"id\": \"test-site-1\"   },   {     \"id\": \"test-site-2\"   } ] ``` If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:  ```JSON {   \"list\": {     \"pagination\": {       \"count\": 2,       \"hasMoreItems\": false,       \"totalItems\": 2,       \"skipCount\": 0,       \"maxItems\": 100     },     \"entries\": [       {         \"entry\": {           ...         }       },       {         \"entry\": {           ...         }       }     ]   } } ``` ", response = FavoriteSiteEntry.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = FavoriteSiteEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **favoriteSiteBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have access to the favorite sites for **personId**"),
        @ApiResponse(code = 404, message = "**personId** does not exist "),
        @ApiResponse(code = 409, message = "**id** is already a site favorite "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorite-sites",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<FavoriteSiteEntry> createSiteFavorite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "The id of the site to favorite." ,required=true )  @Valid @RequestBody FavoriteSiteBodyCreate favoriteSiteBodyCreate,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Delete a favorite", nickname = "deleteFavorite", notes = "Deletes **favoriteId** as a favorite of person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user. ", tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**personId** or **favoriteId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorites/{favoriteId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteFavorite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "The identifier of a favorite.",required=true) @PathVariable("favoriteId") String favoriteId);


    @ApiOperation(value = "Delete a site favorite", nickname = "deleteSiteFavorite", notes = "**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use `/people/{personId}/favorites/{favoriteId}` instead.  Deletes site **siteId** from the favorite site list of person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user. ", tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have access to the favorite sites for **personId**"),
        @ApiResponse(code = 404, message = "**personId** or **siteId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorite-sites/{siteId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSiteFavorite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "The identifier of a site.",required=true) @PathVariable("siteId") String siteId);


    @ApiOperation(value = "Get a favorite", nickname = "getFavorite", notes = "Gets favorite **favoriteId** for person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user. ", response = FavoriteEntry.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = FavoriteEntry.class),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**personId** or **favoriteId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorites/{favoriteId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<FavoriteEntry> getFavorite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "The identifier of a favorite.",required=true) @PathVariable("favoriteId") String favoriteId,@ApiParam(value = "Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders)   ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Get a favorite site", nickname = "getFavoriteSite", notes = "**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use `/people/{personId}/favorites/{favoriteId}` instead.  Gets information on favorite site **siteId** of person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user. ", response = SiteEntry.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = SiteEntry.class),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have access to the favorite sites for **personId**"),
        @ApiResponse(code = 404, message = "**personId** or **siteId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorite-sites/{siteId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<SiteEntry> getFavoriteSite(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@ApiParam(value = "The identifier of a site.",required=true) @PathVariable("siteId") String siteId,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List favorite sites", nickname = "listFavoriteSitesForPerson", notes = "**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use `/people/{personId}/favorites` instead.  Gets a list of a person's favorite sites.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user. ", response = SitePaging.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = SitePaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems** or **skipCount** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have access to the favorite sites for **personId**"),
        @ApiResponse(code = 404, message = "**personId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorite-sites",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<SitePaging> listFavoriteSitesForPerson(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List favorites", nickname = "listFavorites", notes = "Gets a list of favorites for person **personId**.  You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user.  You can use the **where** parameter to restrict the list in the response to entries of a specific kind. The **where** parameter takes a value. The value is a single predicate that can include one or more **EXISTS** conditions. The **EXISTS** condition uses a single operand to limit the list to include entries that include that one property. The property values are:  *   `target/file` *   `target/folder` *   `target/site`  For example, the following **where** parameter restricts the returned list to the file favorites for a person:  ```SQL (EXISTS(target/file)) ``` You can specify more than one condition using **OR**. The predicate must be enclosed in parentheses.   For example, the following **where** parameter restricts the returned list to the file and folder favorites for a person:  ```SQL (EXISTS(target/file) OR EXISTS(target/folder)) ``` ", response = FavoritePaging.class, tags={ "favorites", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = FavoritePaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems**, **skipCount**, or **where** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**personId** does not exist or the current user does not have permission to access the favorites of **personId** "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/favorites",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<FavoritePaging> listFavorites(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to restrict the returned objects by using a predicate.") @Valid @RequestParam(value = "where", required = false) String where,@ApiParam(value = "Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders)   ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

}
