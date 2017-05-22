package org.gluecoders.badpractices.webservices.mutation.bl.bad;

import org.gluecoders.badpractices.webservices.mutation.bl.ColorService;
import org.gluecoders.badpractices.webservices.mutation.externals.HexService;
import org.gluecoders.badpractices.webservices.mutation.externals.ShadeService;
import org.gluecoders.badpractices.webservices.mutation.externals.remotes.DarkShadeService;
import org.gluecoders.badpractices.webservices.mutation.externals.remotes.LightShadeService;
import org.gluecoders.badpractices.webservices.mutation.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Component("badColorService")
public class DefaultColorService implements ColorService {

    @Autowired
    private LightShadeService lightShadeService;
    @Autowired
    private DarkShadeService darkShadeService;
    @Autowired
    private HexService hexService;

    private String color;
    private ShadeService shadeService;



    public List<Color> getShades(String color, String shadeType) {
        this.color = color;
        switch (shadeType){
            case "light":
                shadeService = lightShadeService;
                break;
            case "dark":
                shadeService = darkShadeService;
                break;
            default:
                shadeService = arg -> Collections.emptyList();
                break;
        }
        return getShadesFromRemoteService();
    }

    private List<Color> getShadesFromRemoteService(){
        try {
            Thread.sleep((long) (Math.random()*10000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return this.shadeService.getShades(this.color);
    }

    public Color getHex(String color) {
        this.color = color;
        return getHexFromRemoteService();
    }

    private Color getHexFromRemoteService(){
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return hexService.getHex(this.color);
    }

}
