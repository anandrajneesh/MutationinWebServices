package org.gluecoders.badpractices.webservices.mutation.rest;

import org.gluecoders.badpractices.webservices.mutation.bl.ColorService;
import org.gluecoders.badpractices.webservices.mutation.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/colors")
@Service
public class Colors {

    @Autowired
    @Qualifier("badColorService")
    private ColorService colorService;

    @GET
    @Path("/{color}/shades")
    public List<Color> getShades(@PathParam("color") String color, @QueryParam("shade") String shadeType){
        return colorService.getShades(color, shadeType);
    }

    @GET
    @Path("/{color}")
    public Color getColor(@PathParam("color") String color){
        return colorService.getHex(color);
    }

}
