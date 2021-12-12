package lj;

public class Pagetools {
    public static String getHeader(){
        StringBuffer sb=null;
        String header="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "  <style>\n" +
                "    body{\n" +
                "      background: #373B44; /* fallback for old browsers */\n" +
                "      background: -webkit-linear-gradient(to right, #4286f4, #373B44); /* Chrome 10-25, Safari 5.1-6 */\n" +
                "      background: linear-gradient(to right, #4286f4, #373B44); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n" +
                "    }\n" +
                "    .menu {font-weight:bold; font-size:1em; padding:2em}\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n";
        sb.append(header);
//        sb.append("<td><img width='100px' src='/myapp/upload/").append(book.getPics().replaceAll(",", "")).append("'></img></td>");

        sb.append(
                "<div style='text-align:center;padding:0.7em'><h1>首页</h1></div>\n" +
                "<div style='text-align:center;padding:0.7em'>\n" +
                "  <span class='menu'><a href='add.html' style=\"color: bisque\">发表</a></span>\n" +
                "  <span class='menu'><a href='./logout' style=\"color: bisque\">退出</a></span>\n" +
                "  </div>");
        return sb.toString();
    }
    public static String getEnd(){
        String end="</body>\n" +
                "</html>";
        return end;
    }

}
