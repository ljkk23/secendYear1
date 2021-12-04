package fileio;

import java.io.*;
import java.lang.String;

public class getfile {
     private String filepath;


    public getfile(String filepath){
        this.filepath=filepath;
    }
    public void readfile(String filepath) throws IOException {
        File file=new File(filepath);
        InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line+"\n");

        }
    }

}
