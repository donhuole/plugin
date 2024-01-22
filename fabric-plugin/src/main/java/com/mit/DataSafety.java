package com.mit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSafety {
    
    private Map<String,Object> map = new HashMap<>();

    public void run(){
        List<String> answer = Util.shellCommand("test_fabric/test_data_crypt.sh");
        map.put("test_data_crypt", answer);
        System.out.println(map.toString());

    }
}
