package org.gluecoders.badpractices.webservices.mutation.externals;

import org.gluecoders.badpractices.webservices.mutation.models.Color;

import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
public interface ShadeService {

    List<Color> getShades(String color);
}
