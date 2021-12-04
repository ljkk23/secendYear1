package cn.edu.swu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class EditBookServlet extends HttpServlet {

    private static final long serialVersionUID = 119876388866686380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        String sql = "SELECT * FROM books WHERE id=" + id;
        try {
            List<Book> books = DBUtils.getBooks(sql);
            if (books.size() == 0) {
                response.sendRedirect("./listBook");
                return;
            }

            Book book = books.get(0);

            StringBuilder sb = new StringBuilder();
            sb.append(PageUtils.getAdminHeader());
            sb.append(buildBookForm(book));
            sb.append(PageUtils.getEnd());

            response.setCharacterEncoding("UTF-8");
            try (Writer writer = response.getWriter()) {
                writer.write(sb.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String buildBookForm(Book book) {
        String html = String.format("<center>\n" +
            "<br>\n" +
            "<form action='./updateBook' method='POST''>\n" +
            "<input type='hidden' name='id' value='%s'>" +
            "<table style='background-color:#dddddd;padding:2em'>\n" +
            "\t<tr><td>书 名:</td><td><input type='text' name=name value='%s'></td></tr>\n" +
            "\t<tr><td>作者:</td><td><input type='text' name=author  value='%s'></td></tr>\n" +
            "\t<tr><td>价格: </td><td><input type='text' name=price  value='%s'></td></tr>\n" +
            "\t<tr><td>类别: </td><td>\n" +
            "\t\t<select name='type'>\n" +
            "\t\t\t<option value='math'>数学\n" +
            "\t\t\t<option value='computer'>计算机\n" +
            "\t\t\t<option value='culture'>文学\n" +
            "\t\t\t<option value='fiction'>小说\n" +
            "\t\t</select>\t\n" +
            "\t</td></tr>\n" +
            "\t<tr><td>描述: </td><td><textarea name='describe' cols='50' rows='5'>%s</textarea></td></tr>\n" +
            "\t<tr><td colspan='2' align='center'><br><input type='submit' value='提交修改'></td></tr>\n" +
            "</table>\t\n" +
            "</form>\n" +
            "</div>\n" +
            "</center>",
            book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getDescribe()
        );

        html = html.replace("'" + book.getType() + "'", "'" + book.getType() + "' selected" );

        return html;
    }
}
