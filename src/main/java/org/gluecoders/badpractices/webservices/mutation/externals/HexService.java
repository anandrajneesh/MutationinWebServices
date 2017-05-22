package org.gluecoders.badpractices.webservices.mutation.externals;

import org.gluecoders.badpractices.webservices.mutation.models.Color;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
public interface HexService {

    Color getHex(String color);
}
