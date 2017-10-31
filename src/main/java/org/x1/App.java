package org.x1;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.x1.executor.ExecutorUtils;
import org.x1.sqlmapper.SqlExecutorUpdate;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.TcpUtils;
import org.x1.utils.net.manager.ProtocolManager;
import org.x1.utils.serializer.excel.ExcelUtils;
import org.x1.utils.serializer.excel.StaticConfigMessage;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SpringUtils springUtils = new SpringUtils();
        ExcelUtils.init();
        ExecutorUtils.timerTask.scheduleAtFixedRate(new SqlExecutorUpdate(), 1, 3, TimeUnit.SECONDS);
        TcpUtils.start(1024);
    }
}
