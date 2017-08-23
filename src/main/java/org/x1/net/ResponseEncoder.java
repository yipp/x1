package org.x1.net;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.x1.net.model.Response;

public class ResponseEncoder extends MessageToByteEncoder<Response> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Response response, ByteBuf buffer) throws Exception {
        buffer.writeInt(-777888);//包头:请使用一个不常用到的int类型数据
        buffer.writeShort(response.getId());
        if (response.getDataLength() <= 0 || response.getDATA() == null) {
            buffer.writeShort(response.getDataLength());
        } else {
            buffer.writeShort(response.getDataLength());
            buffer.writeBytes(response.getDATA());//数据
        }
    }
}
