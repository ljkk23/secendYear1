package src.src.cn.edu.swu.ws.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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


    public static byte[] getImage(String imgUrl) {
        // TODO： 完成下载图片的功能
        return null;
    }

}
