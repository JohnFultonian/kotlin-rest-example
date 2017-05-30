package com.tablesagas.resource

import com.tablesagas.model.Campaign
import com.tablesagas.service.lookup 
import com.tablesagas.service.all

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/campaign")
@Produces(MediaType.APPLICATION_JSON)
class Campaign {

  @GET
  fun retrieveCampaigns() = all()

  @Path("/{id}")
  @GET
  fun retrieveCampaign(@PathParam("id") id: Int) = lookup(id)

}
