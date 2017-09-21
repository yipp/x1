package org.x1;

import org.x1.utils.net.model.ISerializer;

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
