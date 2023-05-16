package com.example.tomcattraining.web.rest;

import com.example.tomcattraining.beans.Personne;
import com.example.tomcattraining.beans.PersonneRest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static java.lang.System.out;

@Path("personne/")
public class PersonneServices {
    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public Object getPersonne(@PathParam("id") int id)
    {
        PersonneRest objet= new PersonneRest("BENJAMIN","POIRROT");
        out.println(objet);
        return objet;
    }

    @POST
    @Path("/{id}")
    @Produces("application/xml")
    public Response postPersonne(@PathParam("id") int id, final Personne personne)
    {
        //Appel à la DAO
        return Response.status(Response.Status.CREATED).entity(personne).build();
    }




}
