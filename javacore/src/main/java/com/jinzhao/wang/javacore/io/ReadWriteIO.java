package com.jinzhao.wang.javacore.io;

import java.io.*;

/**
 * Created by WANGJINZHAO on 2018/3/7.
 * https://www.cnblogs.com/dreamyu/p/6551137.html
 */
public class ReadWriteIO {

    public static void fileTofile(String sourcePaht, String targetPath) {
        FileInputStream fis = null;
        FilterOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(sourcePaht));
            fos = new FilterOutputStream(new BufferedOutputStream(new FileOutputStream(targetPath)));
            byte[] buffered = new byte[1024];
            int length;
            while ((length = fis.read(buffered)) != -1) {
                fos.write(buffered, 0, length);
                fos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] stream2bytes(String path) {
        byte[] data = null;
        BufferedInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(path));
            bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            data = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException IOE) {

        } finally {
            try {
                bos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void byte2file(String sourcePath, String targetPath) {
        byte[] bytes = stream2bytes(sourcePath);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(targetPath)));
            bufferedOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        fileTofile("E:/httputil.pdf", "E:/test1.pdf");
        byte[] bytes = stream2bytes("E:/httputil.pdf");
        System.out.println(bytes.length);
        byte2file("E:/httputil.pdf", "E:/test2.pdf");
    }

}
