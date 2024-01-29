package com.mit.grpc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSafety {
    
    


    private Map<String,Object> map = new HashMap<>();

    public void run(){
        //测试数据是否是加密的
        List<String> answer = Util.shellCommand("test_fabric/test_data_crypt.sh");
        map.put("test_data_crypt", answer);

        //测试是否使用了微服务架构
        map.put("test_docker_architecture", Util.shellCommand("test_fabric/test_docker_architecture.sh"));
        System.out.println("OK");
        //测试基础的query和invoke
        // String queryList = MyProperties.get(String.class, "fabric","query");
        // System.out.println(queryList);
        // map.put("test_query_or_invoke", Util.shellCommand("test_fabric/test_docker_architecture.sh 1 mychannel basic ReadAsset asset6"));
        
        //测试交易幂等性、持久性
        map.put("test_data_duration", Util.shellCommand("test_fabric/test_data_duration.sh"));
        System.out.println("OK");
        map.put("detect_encryption_method", Util.shellCommand("test_fabric/detect_encryption_method.sh"));
        
        // 测试peer高可用性
        map.put(null, Util.shellCommand("test_fabric/test_peer_high_available.sh invoke 1 mychannel basic TransferAsset asset6 Amy"));
        System.out.println(map.toString());





    }

}
