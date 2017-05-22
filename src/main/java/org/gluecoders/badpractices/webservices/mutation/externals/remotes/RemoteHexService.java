package org.gluecoders.badpractices.webservices.mutation.externals.remotes;

import org.gluecoders.badpractices.webservices.mutation.configuration.ColorData;
import org.gluecoders.badpractices.webservices.mutation.externals.HexService;
import org.gluecoders.badpractices.webservices.mutation.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Component
public class RemoteHexService implements HexService{

    @Autowired
    private ColorData colorData;

    @Override
    public Color getHex(String color) {
        return colorData.hexOfColor.accessProperty(color);
    }
}
