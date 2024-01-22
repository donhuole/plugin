package com.mit;

import com.mit.HelloGrpc;
import com.mit.HelloOuterClass.HelloRequest;
import com.mit.HelloOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;
import io.grpc.BindableService;
import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class GrpcServer {
    private Server server;
    private void start() throws IOException {
        int port = 44444;
        server = ServerBuilder.forPort(port)
                .addService((BindableService) new HelloImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // jvm关闭前执行
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                GrpcServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * 阻塞等待主线程终止
     * @throws InterruptedException
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class HelloImpl extends HelloGrpc.HelloImplBase{

        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            HelloResponse helloResponse = HelloResponse.newBuilder().setMessage("Hello "+request.getName()+", I'm Java grpc Server").build();
            responseObserver.onNext(helloResponse);
            responseObserver.onCompleted();
        }
    }
    
}
