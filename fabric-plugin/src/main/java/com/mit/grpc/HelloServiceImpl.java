package com.mit.grpc;

import com.mit.proto.HelloRequest;
import com.mit.proto.HelloResponse;
import io.grpc.stub.StreamObserver;
import com.mit.proto.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void sayHello (HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    // 处理请求并生成响应
    String message = "Received: " + request.getName();
    if (message.equals("run")) {
        DataSafety dataSafety = new DataSafety();
        dataSafety.run();
    }
    HelloResponse response= HelloResponse.newBuilder().setMessage("OK").build();
    // 发送响应给客户端
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}