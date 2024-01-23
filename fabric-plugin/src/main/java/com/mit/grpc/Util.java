package com.mit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Util {
    
    public static List<String> shellCommand(String command){
        List<String> list = new LinkedList<>();
        try {
            // 执行Shell命令
            Process process = Runtime.getRuntime().exec(command);
            
            // 获取命令执行的输出流
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // 读取输出
            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                list.add(line);
            }

            
            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("命令执行:"+command+"完成，退出码：" + exitCode);
            
            // 关闭流
            reader.close();
            inputStream.close();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        return list;
    }

}
