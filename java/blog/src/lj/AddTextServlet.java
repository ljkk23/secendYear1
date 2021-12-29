package lj;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "AddTextServlet",value = "/add")
public class AddTextServlet extends HttpServlet {
    private static final long serialVersionUID = 1139723442711986380L;
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";


    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            this.doPost(request,response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String title=request.getParameter("title");
        String author=null;
        String type=request.getParameter("type");
        String content=request.getParameter("content");

        Cookie[] cookies = request.getCookies();
        // 获取与该域相关的 Cookie 的数组
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName());
            if (cookie.getName().equals("login_code")){
                    author=cookie.getValue();
                System.out.println(author);
            }
        }


        // 检测是否为多媒体上传，注意这里一定要加上multiparty和method为post！！
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }


        String pics = "";
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        pics += fileName;
                    } else {
                        if (item.getFieldName().equals("title")) {
                            title = item.getString();
                        }
                        if (item.getFieldName().equals("type")) {
                            type = item.getString();
                        }
                        if (item.getFieldName().equals("content")) {
                            content = item.getString();
                        }
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        String insert_allSql="insert into allcontent(title,author,type,content,pics)"+"values('%s','%s','%s','%s','%s')";
        dbTools.excute(String.format(insert_allSql,title,author,type,content,pics));
        System.out.println("执行完毕！");
        try {
            response.sendRedirect("./blog.html");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
