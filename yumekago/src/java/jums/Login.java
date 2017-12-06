/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String pass = request.getParameter("password");
            String pageNum = request.getParameter("pageNum");
            int page = Integer.parseInt(pageNum);
            UserData ud = new UserData();
            ud.setName(name);
            ud.setPassword(pass);

            HttpSession session = request.getSession();
            session.setAttribute("ud", ud);

            UserDataDTO userdata = new UserDataDTO();
            ud.UD2DTOMapping(userdata);

            //DBへデータ呼び出し
//            int id = UserDataDAO.getInstance().searchUserID(userdata);
//            session.setAttribute("userId", id);
            int dao = UserDataDAO.getInstance().searchForLogin(userdata);
            String logCh = "in";
            if (dao != 0) {
                switch (page) {
                    case 1:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/top.jsp").forward(request, response);
                    case 2:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/add.jsp").forward(request, response);
                    case 3:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/search.jsp").forward(request, response);
                    case 4:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/item.jsp").forward(request, response);
                    case 5:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/cart.jsp").forward(request, response);
                    case 6:
                        session.setAttribute("UserID", dao);
                        session.setAttribute("logCh", logCh);
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("/.jsp").forward(request, response);

                }
//                out.print("ログイン成功");
            } else {
                out.print("ログイン失敗");
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
