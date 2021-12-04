package cn.edu.swu.ws.book;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        return null;
    }

    @Override
    public void saveNewBook(Book book) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        String filePath = this.directory + "/" + date+"/" + UUID.randomUUID() + ".txt";
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

    @Override
    public Book getBookByCode(String code) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        File[] files = new File(this.directory+ "/" + date ).listFiles();//如果file是个文件，则返回的是null，如果file是空目录，返回的是空数组，如果file不是空目录，则返回的是该目录下的文件和目录
        String line;
        Book bookbycode=new Book();
        for(File file : files) {
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            /*FileReader readerfile = new FileReader(file);
            BufferedReader reader=new BufferedReader(readerfile);*/
            int i=0;
            while ((line=reader.readLine())!=null){//这里注意不能用(len = reader.read()) != -1来判断，因为这里的reader自动跳了一个指针
                if(line.contains(code)) {
                    bookbycode.setCode(code);
                    bookbycode.setName(reader.readLine());
                    bookbycode.setPrice(Float.parseFloat(reader.readLine()));
                    bookbycode.setImageUrl(reader.readLine());
                    bookbycode.setImageFile(reader.readLine());
                    }
                }
            reader.close();
            };
        return bookbycode;
    }

    @Override
    public List<Book> findBookByName(String Name) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        File[] files = new File(this.directory+ "/" + date ).listFiles();//如果file是个文件，则返回的是null，如果file是空目录，返回的是空数组，如果file不是空目录，则返回的是该目录下的文件和目录
        List<Book> books=new ArrayList<>();
        String line;
        String code;
        //Book bookbycode=new Book();
        for(File file : files) {
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            /*FileReader readerfile = new FileReader(file);
            BufferedReader reader=new BufferedReader(readerfile);*/
            Book bookbycode=new Book();
            code=reader.readLine();
            while ((line=reader.readLine())!=null){//这里注意不能用(len = reader.read()) != -1来判断，因为这里的reader自动跳了一个指针

                if(line.contains(Name)) {

                    bookbycode.setCode(code);

                    bookbycode.setName(line);
                    bookbycode.setPrice(Float.parseFloat(reader.readLine()));
                    bookbycode.setImageUrl(reader.readLine());
                    bookbycode.setImageFile(reader.readLine());
                    books.add(bookbycode);
                }
            }
            reader.close();

        };


        return books;
    }

    @Override
    public void deleteBookByCode(String code) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        File[] files = new File(this.directory+ "/" + date ).listFiles();//如果file是个文件，则返回的是null，如果file是空目录，返回的是空数组，如果file不是空目录，则返回的是该目录下的文件和目录
        String line;
        for(File file: files) {
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            /*FileReader readerfile = new FileReader(file);
            BufferedReader reader=new BufferedReader(readerfile);*/

            while ((line=reader.readLine())!=null){//这里注意不能用(len = reader.read()) != -1来判断，因为这里的reader自动跳了一个指针
                //line=reader.readLine();
                //System.out.println(line);
                if(line.contains(code)) {
                    reader.close();
                    file.delete();//delAllFile删除文件夹
                    System.out.println("DELETE!");
                    break;
                }
            }
        };

    }

    @Override
    public List<Book> findBookByPrice(float minPrice, float maxPrice) throws IOException {
        String date = this.simpleDateFormat.format(new Date());
        File[] files = new File(this.directory+ "/" + date ).listFiles();//如果file是个文件，则返回的是null，如果file是空目录，返回的是空数组，如果file不是空目录，则返回的是该目录下的文件和目录
        String pricestr = null;
        String code = null;
        String name = null;
        List<Book> books=new ArrayList<>();
        float price;
        for(File file : files) {
            Book book=new Book();
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            /*FileReader readerfile = new FileReader(file);
            BufferedReader reader=new BufferedReader(readerfile);*/
            code=reader.readLine();
            name=reader.readLine();
            pricestr=reader.readLine();
            price=Float.parseFloat(pricestr);
            if (price>=minPrice && price<=maxPrice){
                String imageUrl = reader.readLine();
                String imageFile=reader.readLine();
                book.setCode(code);
                book.setPrice(price);
                book.setName(name);
                book.setImageUrl(imageUrl);
                book.setImageFile(imageFile);
                books.add(book);



            }
            reader.close();
        }
        return books;
    }


    private String downloadImage(Book book) throws IOException {
        byte[] data = HttpTools.getImage(book.getImageUrl());//图片是二进制文件
        String imageFilePath = this.generateImageFilePath(book);
        this.saveImage(data, imageFilePath);
        return imageFilePath;
    }

    private String generateImageFilePath(Book book) {
        // TODO: 随机或者根据 book 类生成一个存储图片的文件路径
        String date = this.simpleDateFormat.format(new Date());
        String filePath1 = this.directory + "/" + date +"img"+ "/" + UUID.randomUUID()+".jpg" ;
        File file = new File(filePath1);
        file.getParentFile().mkdirs();
        return filePath1;
    }

    private void saveImage(byte[] data, String filePath) throws IOException {
        // TODO: 保存图片到指定的文件路径
        int len;
        File file=new File(filePath);
        OutputStream os=new FileOutputStream(file);//input、output都是二进制的读取，而reader和write是文本文件的操作
        os.write(data);
        os.close();

    }

}




