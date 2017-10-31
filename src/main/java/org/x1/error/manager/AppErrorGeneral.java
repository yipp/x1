package org.x1.error.manager;

import io.netty.channel.Channel;
import org.apache.log4j.Logger;
import org.x1.error.data.ErrorTable;
import org.x1.error.dto.ErrorDto;
import org.x1.utils.net.model.Response;
import org.x1.utils.serializer.protostuffer.SerializerUtils;
/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class AppErrorGeneral {
    private static Logger logger;
    static {
        logger = Logger.getLogger(AppErrorGeneral.class);
    }
    private ErrorTable table;
    private Response response;
    public AppErrorGeneral() {
    }
    public AppErrorGeneral(Channel channel,int id) {
        if(table == null)
            table = ErrorTable.get(id);
        if(response == null)
            response = new Response();
        ErrorDto dto = new ErrorDto(id,table.getDiscibe());
        byte[] buf = SerializerUtils.serializer(dto);
        response.setId((short) 400);
        response.setData(buf);
        channel.writeAndFlush(response);
        logger.error(table.getDiscibe()+"#####################################");
        throw new RuntimeException(table.getDiscibe()+"#####################################");
    }
}
