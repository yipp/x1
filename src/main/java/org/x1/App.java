package org.x1;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.TcpUtils;
import org.x1.utils.net.manager.ProtocolManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  SpringUtils springUtils = new SpringUtils();
        TcpUtils.start(1024);
    }
}
