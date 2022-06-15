package com.vast.iot.common.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServerImpl implements IotServer {

    private EventLoopGroup parentGroup;
    private EventLoopGroup childGroup;
    private ChannelFuture channelFuture;

    private ServerAttribute serverAttribute;

    public TcpServerImpl(ServerAttribute serverAttribute){
        this.serverAttribute=serverAttribute;
    }

    @Override
    public boolean start() {
        try {
            init();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        if (channelFuture != null) {
            channelFuture.channel().close();
        }
        if (childGroup != null) {
            childGroup.shutdownGracefully();
        }
        if (parentGroup != null) {
            parentGroup.shutdownGracefully();
        }
    }

    private void init() throws InterruptedException {
        parentGroup = new NioEventLoopGroup();
        childGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(parentGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(serverAttribute.getChannelInitializer())
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        channelFuture = serverBootstrap.bind(serverAttribute.getPort()).sync();
    }
}
