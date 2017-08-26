package org.x1;

import org.x1.net.model.ISerializer;
import org.x1.serializer.protostuffer.SerializerUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<Integer,ISerializer> map = new HashMap<>();

        System.out.println(map.get(1));
    }
}
