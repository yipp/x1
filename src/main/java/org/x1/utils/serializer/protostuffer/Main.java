package org.x1.utils.serializer.protostuffer;


import org.x1.utils.net.model.ISerializer;

import java.util.Arrays;

/**
 * Created by CL-PC202 on 2017/7/3.
 */
public class Main {
    public static void main(String[] args) {
        Test test = new Test(100000, null);
        ISerializer s = new SerializerTest("易","",23,"理工");
        byte[] buf = SerializerUtils.serializer(test);
        System.out.println(Arrays.toString((byte[]) buf));
        ISerializer test1 = SerializerUtils.deserializer((byte[]) buf, Test.class);
        System.out.println(test1);
    }
}
