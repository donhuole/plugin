package com.mit.grpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;

//监听端口，发布服务
public class LoginServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //绑定端口
        ServerBuilder serverBuilder = ServerBuilder.forPort(55555);
        //添加服务
        serverBuilder.addService(new HelloServiceImpl());
        //添加拦截器
        // serverBuilder.intercept(new ServerLogInterceptor());
        //创建服务对象
        Server server = serverBuilder.build();
        
        server.start();
        server.awaitTermination();
    }


//     @SneakyThrows
//     public static void reflect(String[] args) {
//         // 构建 Server
//         Server server = NettyServerBuilder.forAddress(new InetSocketAddress(44444))
//                                           // 添加服务
//                                           .addService(new HelloServiceImpl())
//                                           // 添加反射服务
// +                                         .addService(ProtoReflectionService.newInstance())
//                                           .build();

//         // 启动 Server
//         server.start();

//         Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//             try {
//                 server.awaitTermination(10, TimeUnit.SECONDS);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }));

//         // 保持运行
//         server.awaitTermination();
//     }
}
