package com.jacken.test.io;

import com.google.common.primitives.Ints;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author jacken
 * @date 2017/12/14
 */
public class TimeClient {

    public void contect(Integer port, String host) {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap clientBootstrap = new Bootstrap();
        clientBootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>(){

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TimeClientHandler());
                ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                ch.pipeline().addLast(new StringDecoder());
            }
        });
        try {
           ChannelFuture future = clientBootstrap.connect(host, port).sync();
           future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Ints.tryParse(args[0]);
        }
        TimeClient timeClient = new TimeClient();
        timeClient.contect(port, "127.0.0.1");
    }
}

class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf byteBuf;

    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        byteBuf = Unpooled.buffer(req.length);
        byteBuf.writeBytes(req);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        try {
            super.channelActive(ctx);
            ctx.writeAndFlush(byteBuf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf inMsg = (ByteBuf)msg;
        byte[] bytes = new byte[inMsg.readableBytes()];
        inMsg.readBytes(bytes);
        String respMsg = new String(bytes, "UTF-8");
        System.out.println("Now Time is:" + respMsg);

    }
}
