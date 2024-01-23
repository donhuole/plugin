package com.mit.grpc;

import java.util.Scanner;

import com.mit.proto.HelloRequest;
import com.mit.proto.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LoginClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub HelloService = HelloServiceGrpc.newBlockingStub(managedChannel);
        HelloRequest.Builder builder;
        while(true){
            String input = scanner.nextLine();
            builder = HelloRequest.newBuilder();
            HelloRequest request = builder.setName(input).build();
            System.out.println(HelloService.sayHello(request).getMessage());
        }
    }
    
}
