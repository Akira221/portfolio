package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserData;
import javax.servlet.http.HttpSession;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-8\" style=\"background-color:blue;\">Blue</div>\n");
      out.write("            </div>\n");
      out.write("            <h1>Kagoyumeトップページ</h1>\n");
      out.write("\n");
      out.write("            好きなものを好きなだけ買ったきになれる通販サイトです。<br><br>\n");
      out.write("\n");
      out.write("            <form action=\"Search\" method=\"GET\">\n");
      out.write("                商品検索<input type=\"text\" name=\"key\" >\n");
      out.write("                <input type=\"submit\" value=\"検索\">\n");
      out.write("\n");
      out.write("            </form><br><br>\n");
      out.write("            ");


                String logCh = (String) session.getAttribute("logCh");
                String name = (String) session.getAttribute("name");
            
      out.write(" \n");
      out.write("            ");
 if ("in".equals(logCh)) {
                out.print(name + "さん" + "ようこそ!" + "<br>"); 
      out.write("\n");
      out.write("            <form action=\"Myhistry\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" value=\"購入履歴\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"Myupdate\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" value=\"登録情報更新\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"Mydelete\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" value=\"登録情報削除\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"Logout\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" value=\"ログアウト\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"login.jsp\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"pageNum\" value=\"1\">\n");
      out.write("                <input type=\"submit\" value=\"ログイン\" class=\"btn btn-{primary}\">\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
