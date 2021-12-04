package fileio;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String filepath="E:\\java\\text\\51.html";
        getfile downfile=new getfile(filepath);
        downfile.readfile(filepath);

    }
}
