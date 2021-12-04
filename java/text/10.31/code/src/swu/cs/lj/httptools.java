package swu.cs.lj;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httptools {

    public static String getHtml(String strUrl,String charSet) throws IOException {
        URL url=new URL(strUrl);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        InputStream inputStream=connection.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream,charSet);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String line=null;
        StringBuilder builder=new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            builder.append(line).append("\n");
        }
        bufferedReader.close();
        return builder.toString();//注意必须要tostring
    }

    public static byte[] getimg(String imgUrl) throws IOException {
        byte[] bs=new byte[1024];
        URL url=new URL("https:"+imgUrl);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        InputStream inputStream=connection.getInputStream();
        int len;

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        while ((len=inputStream.read())!=-1){
            byteArrayOutputStream.write(bs);
        }
        byte[] data=byteArrayOutputStream.toByteArray();
        inputStream.close();
        return  data;
    }
}
