package org.gluecoders.badpractices.webservices.mutation.configuration;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@FunctionalInterface
public interface ColorAccessor<R> {

    R accessProperty(String color);
}
