/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Buycomplete extends HttpServlet {

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
        JumsHelper jh = JumsHelper.getInstance();
        HttpSession session = request.getSession();
        ArrayList<ApiData> cartArray = (ArrayList<ApiData>) session.getAttribute("cartArray");
        request.setCharacterEncoding("UTF-8");
        ArrayList<UserDataDTO> buyArray = new ArrayList();
        try (PrintWriter out = response.getWriter()) {

            int id = (int) session.getAttribute("UserID");
            String total = request.getParameter("total");
            int totalNum = Integer.parseInt(total);
            String type = request.getParameter("type");
            int typeNum = Integer.parseInt(type);
            String itemCode = "";
            for (int i = 0; i < cartArray.size(); i++) {
                UserDataDTO ud = new UserDataDTO();
                itemCode = cartArray.get(i).getItemCode();
                ud.setUserID(id);
                ud.setItemCode(itemCode);
                ud.setTotal(totalNum);
                ud.setType(typeNum);
                buyArray.add(ud);
                UserDataDAO.getInstance().buyinsert(ud);
                UserDataDAO.getInstance().buyTotalUpdate(ud);
            }
//           カート内の削除 
             for (int i = 0; i < cartArray.size(); i++) {
                  cartArray.remove(i);
             }
            request.getRequestDispatcher("/buycomplete.jsp?pageNum=2").forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Buycomplete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Buycomplete at " + request.getContextPath() + "</h1>");
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
