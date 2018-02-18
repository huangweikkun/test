package com.jacken.test;

import com.google.common.primitives.Ints;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @author jacken
 * @date 2017/12/22
 */
public class EchoClient {

    public void connect(String address, Integer port) {
        EventLoopGroup workGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .group(workGroup)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MessageDecoder());
                        ch.pipeline().addLast("message pack encoder",new MsgEncoder());
                        ch.pipeline().addLast(new EchoClientHandler());
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(address, port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0) {
            port = Ints.tryParse(args[0]);
        }

        new EchoClient().connect("127.0.0.1", port);
    }
}

class  EchoClientHandler extends ChannelHandlerAdapter {

    private Integer count = 0;

    private static final String msg = "Hi, Jacken, welcome to netty$_";

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (UserInfo userInfo : UserInfo.getUserInfos()) {
            ctx.write(userInfo);
        }

        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("this is count:" + ++count + "receive pack message from server" + msg.toString());
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
       ctx.flush();
    }
}
