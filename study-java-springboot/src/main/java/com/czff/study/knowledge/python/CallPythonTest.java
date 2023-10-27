package com.czff.study.knowledge.python;


import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author cuidi
 * @description
 * @date 2023/5/11 13:28
 */
public class CallPythonTest {

    public static void main(String[] args) throws IOException {

        String fileDirectory = "script";
//        write2File(fileDirectory);
        runPyFile(fileDirectory);
    }

    private static void runPyFile(String fileDirectory) {
        try {
            // 构建命令和参数列表
            String str1 = "http://10.10.109.234:9090/api";
//            String strJson = "{\"name\": \"崔迪\", \"age\": 30}";
            String strJson = "{\"facilityId\":\"11111111111\",\"ip\":\"2.2.2.2\",\"userName\":\"1111\",\"params\":[\"1.1.1.1\"],\"password\":\"2222\",\"port\":\"222\",\"actionName\":\"API_blackfind\"}";
            String str2 = strJson.replace("\"", "$dq$");
            System.out.println(str2);

            // 这种方式不推荐
//            String rootPath = System.getProperty("user.dir");
//            Path filePath = Paths.get(rootPath, "..", fileName);

            File directory = new File("..");
            String rootPath = directory.getCanonicalPath();

            Path filePath = Paths.get(rootPath, File.separator + fileDirectory, "API_blackfind.py");
//            Path filePath = Paths.get(rootPath, File.separator + fileDirectory, "example.py");
            ProcessBuilder pb = new ProcessBuilder("python", filePath.toString(), str1 ,str2);

            // 启动进程
            Process process = pb.start();

            // 获取Python脚本的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            // 等待Python脚本执行结束
            int exitCode = process.waitFor();
            System.out.println("Python脚本执行完毕，退出码: " + exitCode);
            System.out.println(sb);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void write2File(String fileDirectory) throws IOException {
        // 要写入的文件名
        String fileName = "example.py";
        // 要写入的内容
        String content = "import sys\n" +
                "\n" +
                "# 接收命令行参数\n" +
                "args = sys.argv[1:]  # 忽略第一个参数，因为它是脚本本身的名称\n" +
                "\n" +
                "# 打印参数\n" +
                "for arg in args:\n" +
                "    print(arg)\n";

        // 获取项目根路径
//        String rootPath = System.getProperty("user.dir"); // 不推荐

//        File directory = new File("..");
//        String rootPath = directory.getCanonicalPath();
        String rootPath = FileUtil.getCanonicalPath(new File(".."));

        // 构建文件路径
        Path filePath = Paths.get(rootPath, File.separator + fileDirectory, fileName);

        try {
            Path filePathParent = filePath.getParent();
            if (!Files.exists(filePathParent)) {
                Files.createDirectories(filePathParent);
            }
            // 写入文件
            Files.write(filePath, content.getBytes());

            System.out.println("文件写入成功: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
