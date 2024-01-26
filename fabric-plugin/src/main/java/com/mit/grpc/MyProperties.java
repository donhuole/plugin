package com.mit.grpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class MyProperties {
    private static class grpc {
        private static int port;
    }
    static Map<String, Object> map;
    private static class fabric {
        private static String bin;
        private static String ccp;
        private static class user {
            private static String pk;
            private static String cert;
        }
        private static String channel;
        private static class contract {
            private static String name;
            private static String query;
            private static String invoke;
        }
        
    }

    public MyProperties(){
        Yaml yaml = new Yaml();
        try {
            FileInputStream inputStream = new FileInputStream("/home/ubuntu/ws/program/plugin/application.yaml");
            map = yaml.load(inputStream);
            grpc.port = parseTools(Integer.class, "grpc","port");
            fabric.bin = parseTools(String.class,"fabric","bin");
            fabric.ccp = parseTools(String.class,"fabric","ccp");
            fabric.channel = parseTools(String.class,"fabric","channel");
            fabric.user.pk = parseTools(String.class,"fabric","user","pk");
            fabric.user.cert = parseTools(String.class,"fabric","user","cert");
            fabric.contract.name = parseTools(String.class,"fabric","contract","name");
            fabric.contract.query = parseTools(String.class,"fabric","contract","query");
            fabric.contract.invoke = parseTools(String.class,"fabric","contract","invoke");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <T> T parseTools(Class<T> type,String ... args ){
        int paraNum = args.length;
        Object object;
        Map<String,Object> tmpMap = map;
        for(int i=0;i<paraNum;i++){
            object = tmpMap.get(args[i]);
            if(i==paraNum-1){
                 return type.cast(object);
            }
            else
                tmpMap = (Map<String,Object>) object;
        }
        return null;
    }

    public void test(){
        System.out.println(grpc.port);
        System.out.println(fabric.bin);;
    }
}