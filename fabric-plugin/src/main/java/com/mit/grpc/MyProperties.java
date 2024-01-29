package com.mit.grpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class MyProperties {
    private static Map<String, Object> map;   
    // grpc.port = parseTools(Integer.class, "grpc","port");
    // fabric.bin = parseTools(String.class,"fabric","bin");
    // fabric.ccp = parseTools(String.class,"fabric","ccp");
    // fabric.channel = parseTools(String.class,"fabric","channel");
    // fabric.user.pk = parseTools(String.class,"fabric","user","pk");
    // fabric.user.cert = parseTools(String.class,"fabric","user","cert");
    // fabric.contract.name = parseTools(String.class,"fabric","contract","name");
    // fabric.contract.query = parseTools(String.class,"fabric","contract","query");
    // fabric.contract.invoke = parseTools(String.class,"fabric","contract","invoke");

    public MyProperties() throws Exception{
        map = new Yaml().load(new FileInputStream("/home/ubuntu/ws/program/plugin/application.yaml"));
    }

    public static <T> T get(Class<T> type,String ... args ){
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

    // public void test(){
    //     System.out.println(grpc.port);
    //     System.out.println(fabric.bin);;
    // }
}