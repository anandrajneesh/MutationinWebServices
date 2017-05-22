package org.gluecoders.badpractices.webservices.mutation.externals.remotes;

import org.gluecoders.badpractices.webservices.mutation.configuration.ColorData;
import org.gluecoders.badpractices.webservices.mutation.externals.ShadeService;
import org.gluecoders.badpractices.webservices.mutation.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Component("darkShadeService")
public class DarkShadeService implements ShadeService {

    @Autowired
    private ColorData colorData;

    @Override
    public List<Color> getShades(String color) {
        return colorData.darkShadesOfColor.accessProperty(color);
    }
}
