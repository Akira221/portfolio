/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;

/**
 *
 * @author user
 */
public class ApiDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static ApiDataDAO getInstance() {
        return new ApiDataDAO();
    }

    /**
     * 商品の検索処理を行う。
     *
     * @param ad 対応したデータを保持しているJavaBeans
     * @throws IOException 呼び出し元にcatchさせるためにスロー
     *
     * @return 検索結果
     */
    public ArrayList<ApiData> search(ApiData ad) throws IOException {
        ArrayList list = new ArrayList<ApiData>();

        try {
            String api = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch"
                    + "?appid=dj00aiZpPXNnUjY3V1ZqZmJrcSZzPWNvbnN1bWVyc2VjcmV0Jng9YjU-&query=";
            URL url = new URL(api + ad.getKey());
            Object content = url.getContent();

            if (content instanceof InputStream) {
                BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream) content));
                String line = bf.readLine();
//                while ((line = bf.readLine()) != null) {
                //POJOにデコード
                Map<String, Map<String, Object>> root = (Map) JSON.decode(line);
                //欲しい情報のKeyまで掘る
                Map<String, Map<String, Object>> resultset0 = (Map) root.get("ResultSet").get("0");
                Map<String, Map<String, Object>> result2 = (Map) resultset0.get("Result");//ここまでで商品の一覧が取得可能

//                
                for (int i = 0; i < 10; i++) {
                    ApiData add = new ApiData();
                    String itemNum = String.valueOf(i);
                    Map<String, String> item = (Map) result2.get(itemNum);

                    //Priceから_valueとImageからIdとMediumを取得するためもう一階層掘る
                    Map<String, Map<String, Object>> itemForGettingFromImage = (Map) result2.get(itemNum);
                    Map<String, String> resultValue = (Map) itemForGettingFromImage.get("Price");
                    int price = Integer.parseInt(resultValue.get("_value"));

                    Map<String, String> resultImage = (Map) itemForGettingFromImage.get("Image");
                    String id = resultImage.get("Id");
                    String medium = resultImage.get("Medium");

                    //値のセット
                    add.setName(item.get("Name"));
                    add.setItemCode(item.get("Code"));
                    add.setPrice(price);
                    add.setId(id);
                    add.setMedium(medium);

                    list.add(add);
                }

            } else {
//            何もしない
            }
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IOException(e);
        }
    }

    /**
     * 商品の検索数を示す処理を行う。
     *
     * @param ad 対応したデータを保持しているJavaBeans
     * @throws IOException 呼び出し元にcatchさせるためにスロー
     *
     * @return 検索結果数
     */
    public int totalResultsSarch(ApiData ad) throws IOException {
        int tRsult = 0;
        try {
            String api = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch"
                    + "?appid=dj00aiZpPXNnUjY3V1ZqZmJrcSZzPWNvbnN1bWVyc2VjcmV0Jng9YjU-&query=";
            URL url = new URL(api + ad.getKey());
            Object content = url.getContent();

            if (content instanceof InputStream) {
                BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream) content));
                String line = bf.readLine();
//                while ((line = bf.readLine()) != null) {
                //POJOにデコード
                Map<String, Map<String, Object>> root = (Map) JSON.decode(line);
                //欲しい情報のKeyまで掘る
                Map<String, Map<String, Object>> resultset0 = (Map) root.get("ResultSet").get("0");
                Map<String, Map<String, Object>> result2 = (Map) resultset0.get("Result");//ここまでで商品の一覧が取得可能
                Map<String, String> totalResult = (Map) root.get("ResultSet");
                String result = totalResult.get("totalResultsAvailable");
                tRsult = Integer.parseInt(result);
//            

            } else {
//            何もしない
            }
            return tRsult;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IOException(e);
        }
    }

    /**
     * 商品の検索処理を行う。
     *
     * @param item
     * @param ad 対応したデータを保持しているJavaBeans
     * @throws IOException 呼び出し元にcatchさせるためにスロー
     *
     * @return 検索結果
     */
    public ApiData itemSearch(ApiData ad) throws IOException {
        ApiData add = new ApiData();
        try {
            String api = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup"
                    + "?appid=dj00aiZpPXNnUjY3V1ZqZmJrcSZzPWNvbnN1bWVyc2VjcmV0Jng9YjU-&itemcode=";
            String rg = "&responsegroup=large";
            URL url = new URL(api + ad.getItemCode() + rg);
            Object content = url.getContent();

            if (content instanceof InputStream) {

                BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream) content));
                String line = bf.readLine();
//                while ((line = bf.readLine()) != null) {
                //POJOにデコード
                Map<String, Map<String, Object>> root = (Map) JSON.decode(line);
                //欲しい情報のKeyまで掘る
                Map<String, Map<String, Object>> resultset0 = (Map) root.get("ResultSet").get("0");
                Map<String, Map<String, Object>> result2 = (Map) resultset0.get("Result");
                Map<String, String> item = (Map) result2.get("0");
//                

                //Priceから_valueとImageからIdとMediumを取得するためもう一階層掘る
                Map<String, Map<String, Object>> itemForGettingFromImage = (Map) result2.get("0");
                Map<String, String> resultValue = (Map) itemForGettingFromImage.get("Price");
                int price = Integer.parseInt(resultValue.get("_value"));

                Map<String, String> resultImage = (Map) itemForGettingFromImage.get("Image");
                String id = resultImage.get("Id");
                String medium = resultImage.get("Small");

                Map<String, Map<String, Object>> resultRate = (Map) itemForGettingFromImage.get("Store");

                Map<String, String> result5 = (Map) resultRate.get("Ratings");
                String rate = result5.get("Rate");

                //値のセット
                add.setName(item.get("Name"));
                add.setItemCode(item.get("Code"));
                add.setCaption(item.get("Caption"));
                add.setRate(rate);
                add.setPrice(price);
                add.setId(id);
                add.setMedium(medium);

            } else {
//            何もしない
            }
            return add;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IOException(e);
        }
    }

    public ArrayList<ApiData> cartInData(ApiData ad) {
        ArrayList list = new ArrayList<ApiData>();

        try {

            if (list == null) {
                
                  
               ApiData adc = new ApiData();
                  list.add(adc);
                

        }else {
            for (int i = 0; i < list.size(); i++) {
                    ApiData adc = new ApiData();
                  
                   

                    list.set(i,adc);
            }
                    }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return list;
    }
}
