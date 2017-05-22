package org.gluecoders.badpractices.webservices.mutation.bl;

import org.gluecoders.badpractices.webservices.mutation.models.Color;

import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
public interface ColorService {

    List<Color> getShades(String color, String shadeType);

    Color getHex(String color);
}
