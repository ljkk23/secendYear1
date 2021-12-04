package swu.cs.lj;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Application app=new Application();
        app.run();
    }

    public void run() {
        long start=System.currentTimeMillis();
        String storepath="E:\\java\\text\\10.31\\img\\";
       String weburl="https://sports.sina.com.cn/nba/";

//        Downloader downloader=new Downloader();
//        downloader.setWebUrl(weburl);
//        downloader.setStorepath(storepath);
//        try {
//            downloader.download();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long end=System.currentTimeMillis();
//        System.out.println("TIME:"+(end-start));
        //long start=System.currentTimeMillis();
        Downloader2 downloader2=new Downloader2();
        downloader2.setWebUrl(weburl);
        downloader2.setStorepath(storepath);
        try {
            downloader2.download();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("TIME:"+(end-start));


    }
}
