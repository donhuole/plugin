package com.mit;

import io.grpc.stub.StreamObserver;
import com.example.MyRequest;
import com.example.MyResponse;
import com.example.MyServiceGrpc;

public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

  @Override
  public void myMethod(MyRequest request, StreamObserver<MyResponse> responseObserver) {
    // 处理请求并生成响应
    String message = "Received: " + request.getSomeField();
    MyResponse response = MyResponse.newBuilder().setResult(message).build();

    // 发送响应给客户端
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}