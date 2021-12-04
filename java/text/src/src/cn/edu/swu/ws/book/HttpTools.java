package cn.edu.swu.ws.book;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpTools {

    public static String getHtml(String strUrl, String charset) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = null;
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();

        return builder.toString();
    }
    public static byte[] getImage(String imgUrl) throws IOException {
        // TODO： 完成下载图片的功能
        URL url=new URL("http:"+imgUrl);//构造url,注意要加http
        HttpURLConnection con = (HttpURLConnection) url.openConnection();//不用new
        InputStream inputStream=con.getInputStream();
        //InputStreamReader inputStreamReader=new InputStreamReader(inputStream);reader是处理字符的
        int len;
        byte[] bs=new byte[1024];
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        while ((len=inputStream.read(bs))!=-1){
            stream.write(bs);
        };
        byte[] data=stream.toByteArray();//这里可以用byte[] data=new byte[con.getContentLenth]
        inputStream.close();//可以不用outputstream来缓冲，可以直接用bufferinputstream(data,offset,lenth)，用while循环去读取
        return data;
    }

}
