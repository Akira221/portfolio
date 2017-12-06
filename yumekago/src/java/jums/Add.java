/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Add extends HttpServlet {

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
        HttpSession session = request.getSession();
        ArrayList<ApiData> cartArray = new ArrayList();
//        初回にはnull二回目には初回の情報が入ることになる
        cartArray = (ArrayList<ApiData>) session.getAttribute("cartArray");
        try (PrintWriter out = response.getWriter()) {
//            キャラクター情報のエンコーディング
            request.setCharacterEncoding("UTF-8");
//            item.jspからのパラ情報取得
            String cartName = request.getParameter("cartName");
            String cartPrice = request.getParameter("cartPrice");
            String cartId = request.getParameter("cartId");
            String cartImage = request.getParameter("cartImage");
            String cartItemCode = request.getParameter("cartItemCode");
//            価格を整数に変換
            int cPrice = Integer.parseInt(cartPrice);

            ApiData ad = new ApiData();
            ad.setName(cartName);
            ad.setPrice(cPrice);
            ad.setId(cartId);
            ad.setMedium(cartImage);
            ad.setItemCode(cartItemCode);

            if (cartArray == null) {
                cartArray = new ArrayList<ApiData>();
                cartArray.add(ad);
            } else {

                cartArray.add(ad);
            }

//           cartArray= ApiDataDAO.getInstance().cartInData(ad);
            //            セッションに格納
            session.setAttribute("cartArray", cartArray);

//            add.jspに遷移
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
