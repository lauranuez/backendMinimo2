package edu.upc.dsa.services;

import edu.upc.dsa.Minimo2;
import edu.upc.dsa.Minimo2Impl;
import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Minimo2", description = "Endpoint to authentication service")
@Path("/Minimo2")
public class Minimo2Service {

    private Minimo2 m2;

    public Minimo2Service() {

        this.m2 = Minimo2Impl.getInstance();
        if (!this.m2.isDirty() ) {
            Insignia i1 = new Insignia("El mas jugon", "http://localhost:8080/img/meteorr.png");
            Insignia i2 = new Insignia("El mas lento", "http://localhost:8080/img/sun.png");
            Insignia i3 = new Insignia("El mas epico", "http://localhost:8080/img/avatar.png");
            Insignia i4 = new Insignia("El mas sostenible", "http://localhost:8080/img/avatar.png");
            Insignia i5 = new Insignia("El mas legendario", "http://localhost:8080/img/avatar.png");

            m2.addInsignia(i1);
            m2.addInsignia(i2);
            m2.addInsignia(i3);
            m2.addInsignia(i4);
            m2.addInsignia(i5);

            User user = new User("lau22", "Laura" ,"Nuez","1234", 22  );
            User user1 = new User("Juangar", "Juan" ,"Garcia","1234", 32  );

            user.addInsignias(i1);
            user.addInsignias(i2);
            user.addInsignias(i3);

            user1.addInsignias(i2);
            user1.addInsignias(i5);

            m2.addUser(user);
            m2.addUser(user1);
            m2.dirty();
        }


    }

    @GET
    @ApiOperation(value = "get insignias", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Insignia.class, responseContainer="List"),
    })
    @Path("/insignias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsignias() {

        List<Insignia> insigniaList = this.m2.getInsignias();

        GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(insigniaList) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get insignia by user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Insignia.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/userInsignias/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsigniasByUser(@PathParam("name") String id) {
        List<Insignia> listInsignias = m2.getInsigniasByUser(id);

        if (listInsignias == null) return Response.status(404).build();
        else {
            GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(listInsignias) {};
            return Response.status(201).entity(entity).build();
        }
    }

    @GET
    @ApiOperation(value = "get info user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoUser(@PathParam("name") String id) {
        User u = m2.getUser(id);

        if (u == null) return Response.status(404).build();
        else {
            GenericEntity<User> entity = new GenericEntity<User>(u) {};
            return Response.status(201).entity(entity).build();
        }
    }

}
