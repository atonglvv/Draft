package net.socket.tcp.upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-27 21:02
 */
public class StreamUtils {
    /**
     * @description 将输入流转换成byte[], 即可以把文件的内容读入到byte[]
     * @param is:
     * @return byte[]
     * @author atong
     * @date 2021/4/27 20:56
     * @version 1.0.0.1
     */
    public static byte[] streamToByteArray(InputStream is) throws Exception {
        //创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //字节数组
        byte[] b = new byte[1024];
        int len;
        //循环读取
        while((len = is.read(b)) != -1){
            //把读取到的数据，写入bos
            bos.write(b,0, len);
        }
        //然后将bos转成字节数组
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }


    /**
     * @description  将InputStream转换成String
     * @param is:
     * @return java.lang.String
     * @author atong
     * @date 2021/4/27 20:59
     * @version 1.0.0.1
     */
    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder= new StringBuilder();
        String line;
        while(( line=reader.readLine()) != null){
            builder.append(line + "\r\n");
        }
        return builder.toString();
    }


}
