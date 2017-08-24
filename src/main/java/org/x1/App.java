package org.x1;

import org.x1.springUtils.SpringUtils;

import javax.xml.soap.Text;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Test test = SpringUtils.getBean(Test.class);
        System.out.println( "Hello World!" );
    }
}
