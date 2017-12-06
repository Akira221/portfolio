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
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;

/**
 *
 * @author user
 */
public class Apitest2 extends HttpServlet {

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
            ApiData ad = new ApiData();
            ArrayList uddArray = new ArrayList<ApiData>();
            HttpSession session = request.getSession();
            String api = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch"
                    + "?appid=dj00aiZpPXNnUjY3V1ZqZmJrcSZzPWNvbnN1bWVyc2VjcmV0Jng9YjU-&query=book";
            URL url = new URL(api);
            Object content = url.getContent();

            if (content instanceof InputStream) {
                BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream) content));
                String line;
                while ((line = bf.readLine()) != null) {
//POJOにデコード
                    Map<String, Map<String, Object>> root = (Map) JSON.decode(line);
//欲しい情報のKeyまで掘る
                    Map<String, Map<String, Object>> resultset0 = (Map) root.get("ResultSet").get("0");
                    Map<String, Map<String, Object>> result2 = (Map) resultset0.get("Result");//ここまでで商品の一覧が取得可能
//                
                    Map<String, String> totalResult = (Map) root.get("ResultSet");
                    String num = totalResult.get("totalResultsAvailable");
                    out.print(num);
                    for (int i = 0; i < 10; i++) {
                        String item = String.valueOf(i);
                        Map<String, String> result3 = (Map) result2.get(item);

                        ad.setName(result3.get("Name"));
                        ad.setItemCode(result3.get("Code"));
//Priceから_valueとImageからIdとMediumを取得するためもう一階層掘る
                        Map<String, Map<String, Object>> result4 = (Map) result2.get(item);
                        Map<String, String> resultValue = (Map) result4.get("Price");
                        int price = Integer.parseInt(resultValue.get("_value"));
                        ad.setPrice(price);
                        Map<String, String> resultImage = (Map) result4.get("Image");
                        String id = resultImage.get("Id");
                        String medium = resultImage.get("Medium");

                        ad.setId(id);
                        ad.setMedium(medium);
                        uddArray.add(ad);
                        System.out.println("search completed");
//                        out.print("No," + (i + 1));
//                        out.print(result3.get("Name") + "<br>");
//
                    }

                }
                session.setAttribute("resultData", ad);

            } else {
                out.println(content.toString());
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Apitest2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Apitest2 at " + request.getContextPath() + "</h1>");
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
