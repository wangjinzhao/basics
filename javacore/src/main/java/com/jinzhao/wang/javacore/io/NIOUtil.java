package com.jinzhao.wang.javacore.io;

import com.jinzhao.wang.javacore.json.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WANGJINZHAO on 2017/12/13.
 */
public class NIOUtil {

    //遍历当前目录下的文件，不包含子目录下的文件
    public static void findDirectFiles() throws IOException {
        Path dir = Paths.get("D:\\test");
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        List<String> fileNames = new ArrayList();
        List<String> filePaths = new ArrayList();
        List<String> absFilePaths = new ArrayList();
        for (Path path : stream) {
            String fileName = path.getFileName().toString();//获取文件名称
            File file = path.toFile();//转化为File
            String filePath = file.getPath();
            String absFilePath = file.getAbsolutePath();
            filePaths.add(filePath);
            absFilePaths.add(absFilePath);
            fileNames.add(fileName);
        }
        System.out.println(JacksonUtil.object2Json(fileNames));
        System.out.println(JacksonUtil.object2Json(filePaths));
        System.out.println(JacksonUtil.object2Json(absFilePaths));
    }

    public static void walkDirectFiles() throws IOException {
        Path dir = Paths.get("D:\\test");
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        final List<String> fileNames=new ArrayList<>();
        Files.walkFileTree(dir,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                fileNames.add(file.getFileName().toString());
                return super.visitFile(file, attrs);
            }
        });
        System.out.println(JacksonUtil.object2Json(fileNames));
    }

    public static void main(String[] args) throws IOException {
        int h=119001080;
        int len1=15;
        int len2=31;
        System.out.println(h&len1);
        System.out.println(h&len2);

    }

}
