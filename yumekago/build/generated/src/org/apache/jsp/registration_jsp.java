package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import java.util.ArrayList;
import jums.UserData;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    HttpSession hs = request.getSession();
    UserData ud = (UserData) hs.getAttribute("ud");
    boolean reinput = false;
    if (request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")) {
        reinput = true;
        ud = (UserData) hs.getAttribute("ud");
    }



      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>会員登録画面</h1>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"Registration\" method=\"POST\"> \n");
      out.write("            ユーザー名:<input type=\"text\" name=\"name\" value=\"");
 if (reinput) {
                                 out.print(ud.getName()); }
      out.write("\"><br>\n");
      out.write("            パスワード:<input type=\"password\" name=\"password\" value=\"");
 if (reinput) {
                                 out.print(ud.getPassword()); }
      out.write("\"><br>\n");
      out.write("            メールアドレス<input type=\"text\" name=\"mail\" value=\"");
 if (reinput) {
                                 out.print(ud.getMail()); }
      out.write("\"><br>\n");
      out.write("               \n");
      out.write("                住所:<textarea  name=\"address\" style=\"resize: none\" wrap=\"hard\">");
 if (reinput) {
                    out.print(ud.getAddress());
                }
      out.write("</textarea><br>\n");
      out.write("            <input type=\"submit\" value=\"登録確認\">\n");
      out.write("        </form>\n");
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
