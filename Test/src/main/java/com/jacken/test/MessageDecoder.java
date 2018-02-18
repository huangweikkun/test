package com.jacken.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @author jacken
 * @date 2017/12/23
 */
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        byte[] bytes;
        bytes = new byte[msg.readableBytes()];
        MessagePack messagePack = new MessagePack();
        msg.getBytes(msg.readerIndex(),bytes, 0, msg.readableBytes());
        out.add(messagePack.read(bytes));
    }
}
