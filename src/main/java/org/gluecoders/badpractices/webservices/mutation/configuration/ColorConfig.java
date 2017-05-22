package org.gluecoders.badpractices.webservices.mutation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Component
@ConfigurationProperties("config")
@EnableConfigurationProperties
public class ColorConfig {
    private List<ColorProperty> colors = new ArrayList<>();


    public List<ColorProperty> getColors() {
        return colors;
    }

    public void setColors(List<ColorProperty> colors) {
        this.colors = colors;
    }

    public List<ColorProperty> colors(){
        return colors;
    }

    public static class ColorProperty{
        String name;
        List<String> light;
        String hex;
        List<String> dark;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getLight() {
            return light;
        }

        public void setLight(List<String> light) {
            this.light = light;
        }

        public String getHex() {
            return hex;
        }

        public void setHex(String hex) {
            this.hex = hex;
        }

        public List<String> getDark() {
            return dark;
        }

        public void setDark(List<String> dark) {
            this.dark = dark;
        }
    }
}
