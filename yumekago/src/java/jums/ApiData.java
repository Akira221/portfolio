package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 *
 * @author hayashi-s
 */
public class ApiData implements Serializable {

    private String key;
    private int num;
    private String name;
    private String address;
    private String tell;
    private int price;
    private String itemCode;
    private int type;
    private String id;
    private String medium;
    private String caption;
    private String rate;
    private Date date;

    public ApiData() {

        this.key = "";//検索キーワード

        this.num = 0;//検索結果数
        this.name = "";//商品名
        this.price = 0;//金額
        this.itemCode = "";//商品コード
        this.type = 0;//配送方法
        this.id = "";//サムネID
        this.medium = "";//サムネサイズ
        this.caption = "";//商品概要
        this.rate = "";//商品評価

    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        //空文字(未入力)の場合空文字をセット
        if (caption.trim().length() == 0) {
            this.rate = "";
        } else {
            this.rate = rate;
        }
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        //空文字(未入力)の場合空文字をセット
        if (caption.trim().length() == 0) {
            this.caption = "";
        } else {
            this.caption = caption;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if (name.trim().length() == 0) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {

        if (key.equals("")) {
            this.key = "";
        } else {
            this.key = key;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price == 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if (type == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        //初期選択状態の場合0をセット
        if (num == 0) {
            this.num = 0;
        } else {
            this.num = num;
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        if (itemCode.equals("")) {
            this.itemCode = "";
        } else {
            this.itemCode = itemCode;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        if (id.equals("")) {
            this.id = "";
        } else {
            this.id = id;
        }
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {

        if (medium.equals("")) {
            this.medium = "";
        } else {
            this.medium = medium;
        }
    }
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        if (total == null) {
//            this.total = 0;
//        } else {
//            this.total = Integer.parseInt(total);
//        }
//    }
//
//    public String getItemCode() {
//        return itemCode;
//    }
//
//    public void setItemCode(String itemCode) {
//        if (itemCode.equals("")) {
//            this.address = "";
//        } else {
//            this.itemCode = itemCode;
//        }
//    }
//
//    public ArrayList<String> chkproperties() {
//        ArrayList<String> chkList = new ArrayList<String>();
//        if (this.name.equals("")) {
//            chkList.add("name");
//        }
//        if (this.password.equals("")) {
//            chkList.add("password");
//        }
//        if (this.mail.equals("")) {
//            chkList.add("mail");
//        }
//        if (this.address.equals("")) {
//            chkList.add("address");
//        }
//
//        return chkList;
//    }
//    public void UD2DTOMapping(UserDataDTO udd) {
//        udd.setName(this.name);
//        udd.setPassword(this.password);
//        udd.setMail(this.mail);
//        udd.setAddress(this.address);
//
//    }
}
