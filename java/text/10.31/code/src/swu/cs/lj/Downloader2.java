package swu.cs.lj;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Downloader2 extends Downloader{
   public void download() throws IOException {
       List<String> list=this.getImgUrl();
       int i=0;
       for(String url:list){
           File file=new File(this.getStorepath()+i+".jpg");
           DownloiaderThread task=new DownloiaderThread(url,file);
           (new Thread(task)).start();
           i++;
       }
   }
}
