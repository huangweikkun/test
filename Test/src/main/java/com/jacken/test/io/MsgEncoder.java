package com.jacken.test.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @author jacken
 * @date 2017/12/23
 */
public class MsgEncoder extends MessageToByteEncoder<Object> {

    private MessagePack messagePack = new MessagePack();

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte[] bytes = messagePack.write(msg);
        out.writeBytes(bytes);
    }
}
