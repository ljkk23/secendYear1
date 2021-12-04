package src.src.cn.edu.swu.ws.book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.io.File;

// TODO: 实现 BookDataSource 中定义的所有接口函数
public class FileBookDataSource implements BookDataSource {

    // 用来存储图书的目录
    private String directory;

    // 格式化日期的类。把格式化的日期作为文件夹名称
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public FileBookDataSource(String directory) {
        this.directory = directory;
    }

    @Override
    public List<Book> getNewBooks() throws IOException {
        File[] files = new File(this.directory).listFiles();
        for(File file : files) {
            FileReader reader = new FileReader(file);

        }
        return null;
    }

    @Override
    public void saveNewBook(Book book) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        String filePath = this.directory + "/" + date + "/" + UUID.randomUUID() + ".txt";
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        String imageFilePath = this.downloadImage(book);
        book.setImageFile(imageFilePath);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(book.getCode() + "\n");
        fileWriter.write(book.getName() + "\n");
        fileWriter.write(String.valueOf(book.getPrice()) + "\n");
        fileWriter.write(book.getImageUrl() + "\n");
        fileWriter.write(book.getImageFile());
        fileWriter.close();
    }


    private String downloadImage(Book book) {
        byte[] data = HttpTools.getImage(book.getImageUrl());
        String imageFilePath = this.generateImageFilePath(book);
        this.saveImage(data, imageFilePath);
        return imageFilePath;
    }

    private String generateImageFilePath(Book book) {
        // TODO: 随机或者根据 book 类生成一个存储图片的文件路径
        return null;
    }

    private void saveImage(byte[] data, String filePath) {
        // TODO: 保存图片到指定的文件路径
    }

}




