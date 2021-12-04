package swu.cs.lj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Downloader {
    public String storepath;

    public String webUrl=null;
    public String imgurl=null;
    public List<String> getImgUrl() throws IOException {
        List<String> list=new ArrayList<String>();
        String line1=null;
        String htmlPage=httptools.getHtml(this.getWebUrl(),"UTF-8");
        //System.out.println(htmlPage);
        String[] lines=htmlPage.split("\n");
        boolean start=false;

        for (String line:lines){
            if (line.contains("<img width=\"140px")) {
                start = true;
            }
            if (start) {
                if (line.contains("src=\"")) {
                    line1 = line.substring(line.indexOf("src=\"") + "src=\"".length());
                    imgurl = line1.substring(0, line1.indexOf("\">"));

                    list.add(imgurl);
                }
            }
            if (line.contains("<span class=\"mask\"></span>")){
                start=false;
            }
        }
        return list;
    }
    public void download() throws IOException {
        List<String> imgurllist=this.getImgUrl();
        for (int i=0;i<imgurllist.size();i++) {
            File file=new File(this.getStorepath()+i+".jpg");

            byte[] imgdata = httptools.getimg(imgurllist.get(i));
            try (FileOutputStream fileOutputStream=new FileOutputStream(file)){
                fileOutputStream.write(imgdata);
            }
            System.out.println("down"+file.getAbsolutePath());

        }
    }

    public String getStorepath() {
        return this.storepath;
    }

    public void setStorepath(String storepath) {
        this.storepath = storepath;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
