package cn.edu.swu.ws.book;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        // 初始化一个应用程序对象
        Application application = new Application();

        // 通过 run 方法启动运行的逻辑
        application.run();
    }

    public void run() throws IOException {
        // 定义数据源
        BookDataSource webSource = new WebBookDataSource( "http://book.dangdang.com/");
        BookDataSource fileSource = new FileBookDataSource("E:\\java");

        // 下载并保存数据
        List<Book> newBooks = webSource.getNewBooks();
        //System.out.println(newBooks);
        for(int i=0; i<newBooks.size(); i++) {
            Book book = newBooks.get(i);
            fileSource.saveNewBook(book);
            System.out.println(String.format("保存第 %s 本书", i));
        }

        // 对保存的数据做增、删，改，查的操作
        String code = "29298826";
        this.log(fileSource.getBookByCode(code));
        this.log(fileSource.findBookByName("哲学"));
        // this.log(fileSource.getNewBooks());
         fileSource.deleteBookByCode("29298826");
        this.log(fileSource.findBookByPrice(10, 40));//

    }


    /**
     * 打印图书列表的日志输出类
     * @param books
     */
    public void log(List<Book> books) {
        for(Book book : books) {
            System.out.println(book.toString());
        }
    }

    /**
     * 打印图书的日志输出类
     * @param book
     */
    public void log(Book book) {
        System.out.println(book.toString());
    }



}
