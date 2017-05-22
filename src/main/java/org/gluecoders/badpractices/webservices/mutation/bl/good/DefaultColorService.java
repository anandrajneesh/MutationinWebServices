package org.gluecoders.badpractices.webservices.mutation.bl.good;

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
@Component("goodColorService")
public class DefaultColorService implements ColorService {

    @Autowired
    private LightShadeService lightShadeService;
    @Autowired
    private DarkShadeService darkShadeService;
    @Autowired
    private HexService hexService;

    /*
    private String color;
    private ShadeService shadeService;
    */


    public List<Color> getShades(String color, String shadeType) {
        /*
        this.color = color;
         */
        switch (shadeType){
            case "light":
                /*
                 shadeService = lightShadeService;
                break;
                 */
                return getShadesFromRemoteService(lightShadeService, color);
            case "dark":
                /*
                 shadeService = darkShadeService;
                break;
                 */
                return getShadesFromRemoteService(darkShadeService, color);
            default:
                /*
                 shadeService = arg -> Collections.emptyList();
                break;
                 */
                return getShadesFromRemoteService(arg -> Collections.emptyList(), color);
        }
        /*
        return getShadesFromRemoteService();
         */
    }

    /*
    private List<Color> getShadesFromRemoteService(){
     */
    private List<Color> getShadesFromRemoteService(ShadeService shadeService, String color){
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        /*
        return this.shadeService.getShades(this.color);
         */
        return shadeService.getShades(color);
    }

    public Color getHex(String color) {
        /*
         * this.color = color;
         return getHexFromRemoteService();
         */
         return getHexFromRemoteService(color);
    }

    /*
    private Color getHexFromRemoteService(){
     */
    private Color getHexFromRemoteService(String color){
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        /*
        return hexService.getHex(this.color);
         */
        return hexService.getHex(color);
    }

}

