package swu.cs.lj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DownloiaderThread implements Runnable{
    private String url=null;
    private File file=null;
     public DownloiaderThread(String url, File file){
         this.url=url;
         this.file=file;

     }
    @Override
    public void run() {
        try {
            byte[] data=httptools.getimg(this.url);
            FileOutputStream fileOutputStream=new FileOutputStream(this.file);
            fileOutputStream.write(data);
            System.out.println("down img:"+file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
