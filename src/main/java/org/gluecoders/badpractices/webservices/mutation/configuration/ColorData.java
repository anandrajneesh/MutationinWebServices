package org.gluecoders.badpractices.webservices.mutation.configuration;

import org.gluecoders.badpractices.webservices.mutation.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Component
public class ColorData {

    private Map<String, List<Color>> lightShadesMap = new HashMap<>();
    private Map<String, List<Color>> darkShadesMap = new HashMap<>();
    private Map<String, Color> colorMap = new HashMap<>();

    @Autowired
    public ColorData(ColorConfig colorConfig){
        for(ColorConfig.ColorProperty cp : colorConfig.colors()){
            String color = cp.name;
            colorMap.put(color, new Color.Builder().hex(cp.hex).of(color).build());

            darkShadesMap.put(color, cp.dark.stream()
                    .map(shadeHex -> new Color.Builder().hex(shadeHex.substring(1)).of(color).build())
                    .collect(Collectors.toList()));

            lightShadesMap.put(color, cp.light.stream()
                    .map(shadeHex -> new Color.Builder().hex(shadeHex.substring(1)).of(color).build())
                    .collect(Collectors.toList()));
        }
    }

    public ColorAccessor<List<Color>> lightShadesOfColor = color -> lightShadesMap.getOrDefault(color, Collections.emptyList());
    public ColorAccessor<List<Color>> darkShadesOfColor = color -> darkShadesMap.getOrDefault(color, Collections.emptyList());
    public ColorAccessor<Color> hexOfColor = color -> colorMap.get(color);
}
