package org.acme.quarkus.sample;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.acme.quarkus.service.DietService;

@Path("/dietplan")
public class DietResource {
	
	@Inject
	DietService dietService ;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addYourFood")
    public String getdietaryJournal(@QueryParam("foods") String nameOftheFood , @QueryParam("weight") int amountOfFood, @QueryParam("userid") int userid) {
    	
    	return dietService.addFoodDiet(nameOftheFood, userid, amountOfFood) ;
    	
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteYourFood")
    public String deleteYourFood(@QueryParam("userid") int userid , @QueryParam("foodName") String foodName) {
    	return dietService.deleteFoodItem(userid, foodName) ;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/list")
    public List<Object> listYourFood(@QueryParam("userid") int userid , @QueryParam("foodName") String foodName) {
    	return dietService.listFoodItems(userid);
    }
}