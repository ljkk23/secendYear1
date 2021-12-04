package cn.edu.swu.ws.book;
import javax.swing.text.html.HTML;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

// TODO: 将 BookDataSource 中定义的新增接口通过抛出异常的方式实现
public class WebBookDataSource implements BookDataSource {

    private String url = null;//?有什么用

    public WebBookDataSource(String url) {
        this.setUrl(url);
    }

    @Override
    public List<Book> getNewBooks() throws IOException {
        List<Book> books = new ArrayList<>();//每个book对象都要重新new
        String html = HttpTools.getHtml(this.getUrl(), "GB2312");
        String[] lines = html.split("\n");
        boolean start = false;
        for(String line : lines) {
            if (line.contains("rollitem")) {
                start = true;
            }

            if (start) {
                if (line.contains("title")) {
                    Book book = this.parseBookFromLine(line);
                    books.add(book);
                }
            }

            if (line.contains("</ul>")) {
                start = false;
            }
        }

        return books;
    }

    @Override
    public void saveNewBook(Book book) {
        throw new java.lang.UnsupportedOperationException("不能保存书");
    }

    @Override
    public Book getBookByCode(String code) {
        throw new java.lang.UnsupportedOperationException("不能通过code找到书");}

    @Override
    public List<Book> findBookByName(String code) {
        throw new java.lang.UnsupportedOperationException("不能通过名字找到书");
    }

    @Override
    public void deleteBookByCode(String code) {
        throw new java.lang.UnsupportedOperationException("不能通过code删除书");

    }

    @Override
    public List<Book> findBookByPrice(float minPrice, float maxPrice) {

        throw new java.lang.UnsupportedOperationException("不能通过价格找到书");
    }

    private Book parseBookFromLine(String line) {
        String html = line.substring(line.indexOf("<a  title=\"") + "<a  title=\"".length());
        String name = html.substring(0, html.indexOf("\"  class="));


        // TODO: 获取书的编码信息
        String html1 = line.substring(line.indexOf("ddt-src=\"")+"ddt-src=\"".length());
        String code = html1.substring(0,html1.indexOf("\"><a  title=\""));



        // TODO : 这里获取的是书的详细页地址，不是图片地址，需要修改
        String html2 = line.substring(line.indexOf("<img src='")+ "<img src='".length());
        String ImageUrl = html2.substring(0, html2.indexOf("' alt"));

        //System.out.println(bookUrl);

        html = html.substring(html.indexOf("<span class=\"num\">") + "<span class=\"num\">".length());
        String price = html.substring(0, html.indexOf("</span>"));

        Book book = new Book();//作为一个容器来装东西

        book.setName(name);
        book.setCode(code);
        book.setPrice(Float.parseFloat(price));
        book.setImageUrl(ImageUrl);
        return book;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
