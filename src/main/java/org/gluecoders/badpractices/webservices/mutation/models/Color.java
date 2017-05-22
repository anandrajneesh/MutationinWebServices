package org.gluecoders.badpractices.webservices.mutation.models;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
public class Color {

    private String hex;
    private String name;

    public Color(String hex, String name) {
        this.hex = hex;
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        private String name;
        private String hex;
        public Builder hex(String hex){
            this.hex = hex;
            return this;
        }
        public Builder of(String colorName){
            this.name = colorName;
            return this;
        }
        public Color build(){
            return new Color(hex, name);
        }
    }
}
