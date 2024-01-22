package com.mit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class shelltest {

    public static void main(String[] args) {
        try {
            // 创建进程构建器
            ProcessBuilder processBuilder = new ProcessBuilder("your_shell_command_here");

            // 设置工作目录（可选）
            // processBuilder.directory(new File("your_working_directory"));

            // 启动进程
            Process process = processBuilder.start();

            // 获取进程输出流
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 读取输出
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待进程执行完成
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
