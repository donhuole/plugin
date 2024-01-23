package com.mit.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

//监听端口，发布服务
public class LoginServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //绑定端口
        ServerBuilder serverBuilder = ServerBuilder.forPort(8888);
        //添加服务
        serverBuilder.addService(new HelloServiceImpl());
        //添加拦截器
        // serverBuilder.intercept(new ServerLogInterceptor());
        //创建服务对象
        Server server = serverBuilder.build();
        
        server.start();
        server.awaitTermination();
    }
}
