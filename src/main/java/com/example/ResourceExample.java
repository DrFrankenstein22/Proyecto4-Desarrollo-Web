package com.example;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/example")
public class ResourceExample {

    private List<String> data = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getExample() {
        return Response.ok("Hello, World!").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postExample(String json) {
        data.add(json);
        return Response.ok("JSON received: " + json).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putExample(@PathParam("id") int id, String json) {
        data.set(id, json);
        return Response.ok("JSON updated for ID " + id + ": " + json).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteExample(@PathParam("id") int id) {
        data.remove(id);
        return Response.ok("Deleted ID " + id).build();
    }

    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        return Response.ok(data).build();
    }
}