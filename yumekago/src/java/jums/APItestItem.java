/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import net.arnx.jsonic.JSON;

/**
 *
 * @author user
 */
public class APItestItem extends HttpServlet {

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
            StringBuilder builder = new StringBuilder();//StringBuilderを使って可変長の文字列を扱う
            URL url = new URL("https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup"
                    + "?appid=dj00aiZpPXNnUjY3V1ZqZmJrcSZzPWNvbnN1bWVyc2VjcmV0Jng9YjU-&"
                    + "itemcode=suisainet_mac60r&responsegroup=large");
            Object content = url.getContent();
            if (content instanceof InputStream) {
                BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream) content));
                String line;
//              line = bf.readLine();

                while ((line = bf.readLine()) != null) {
//                 out.print(line);
//Json形式をPOJO（Plain　Old　Java　Object）にJSONICを使いデコード
                    Map<String, Map<String, Object>> root = (Map) JSON.decode(line);
//欲しい情報のKeyまで掘る
                    Map<String, Map<String, Object>> resultset0 = (Map) root.get("ResultSet").get("0");
                    Map<String, Map<String, Object>> result2 = (Map) resultset0.get("Result");
                    Map<String, Map<String, Object>> result3 = (Map) result2.get("0");
                    Map<String, Map<String, Object>> result4 = (Map) result3.get("Store");
                    Map<String, Map<String, Object>> result5 = (Map) result4.get("Ratings");
                     // ResultSetの値から情報全体を表示
                            //                  out.println(root.get("ResultSet").get("0"));
                            out
                    .println(result5.get("Rate"));
//                    out.println(result3.get("Image"));
//                    out.println("totalResultsReturned");
//                    @SuppressWarnings("rawtypes")
//                    Map zero = (Map) root.get("0");
//                    out.print(root);
                }
            } else {
                out.println(content.toString());
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet APItest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet APItest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("引数にURLを指定してください");
            System.exit(-1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
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
