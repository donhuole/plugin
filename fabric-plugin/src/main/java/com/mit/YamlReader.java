package com.mit;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class YamlReader {

    
    public YamlReader() {
        Yaml yaml = new Yaml();
        try {
            FileInputStream inputStream = new FileInputStream("path/to/your/file.yaml");
            Map<String, Object> map = yaml.load(inputStream);

            // 处理解析后的数据
            // ...

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}