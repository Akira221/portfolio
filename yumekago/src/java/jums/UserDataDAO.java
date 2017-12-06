package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)");
            st.setString(1, ud.getName());

            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの更新処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void update(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET name = ?, password = ?, mail = ?, address = ? where userID = ? ");

            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setInt(5, ud.getUserID());

            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public void buyTotalUpdate(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement updateTotal = null;//総購入額を更新
        PreparedStatement getTotal = null;//総購入額を取得
        try {
            con = DBManager.getConnection();
            getTotal = con.prepareStatement("SELECT total from user_t where userID = ? ");
            getTotal.setInt(1, ud.getUserID());

            ResultSet rs = getTotal.executeQuery();
            int total = 0;
            if (rs.next() == true) {
                total = rs.getInt("total");
            } else {

            }
            updateTotal = con.prepareStatement("UPDATE user_t SET total = ? where userID = ? ");
            total = total + ud.getTotal();
            updateTotal.setInt(1, total);

            updateTotal.setInt(2, ud.getUserID());

            updateTotal.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public int searchForLogin(UserDataDTO ud) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * from user_t where name = ? and password =?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next() == true) {
                rs.getInt("userID");
            } else {

            }
            return rs.getInt("userID");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * ユーザーデータの取得処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public UserDataDTO searchUserData(int id) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;
        try {
            UserDataDTO ud = new UserDataDTO();
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * from user_t where userID =?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String pass = rs.getString("password");
                String mail = rs.getString("mail");
                String address = rs.getString("address");
                int total = rs.getInt("total");
                Date date = rs.getTimestamp("newDate");

                ud.setName(name);
                ud.setPassword(pass);
                ud.setMail(mail);
                ud.setAddress(address);
                ud.setTotal(total);
                ud.setDate(date);

            } else {

            }
            return ud;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * 購入データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void buyinsert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setString(2, ud.getItemCode());
            st.setInt(3, ud.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("buy data insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
 /**
     * データの削除処理を行う。
     * 
     *
     * 
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement user = null;//user_t情報削除のためのStatement
      
        try {
            con = DBManager.getConnection();
            user = con.prepareStatement("UPDATE user_t SET deleteFlg = ? where userID = ? ");
            user.setInt(1, 1);
            user.setInt(2, id);
            user.executeUpdate();
            
        
            System.out.println("delete completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public ArrayList<ApiData> searchBuyData(int id) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;
        try {

            ArrayList<ApiData> buyArray = new ArrayList();
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * from buy_t where userID =?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ApiData ad = new ApiData();
                String itemCode = rs.getString("itemCode");
                int type = rs.getInt("type");
                Date date = rs.getTimestamp("buyDate");

                ad.setItemCode(itemCode);
                ad.setType(type);

                ad.setDate(date);

                buyArray.add(ad);

            }
            return buyArray;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    // public void update(UserDataDTO ud) throws SQLException {
//        Connection con = null;
//        PreparedStatement st = null;
//        try {
//            Date d = new Date();
//            con = DBManager.getConnection();
//
//            st = con.prepareStatement("Update user_t Set name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? Where userID =?");
//            st.setString(1, ud.getName());
//            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
//            st.setString(3, ud.getTell());
//            st.setInt(4, ud.getType());
//            st.setString(5, ud.getComment());
//
//            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
//            st.setInt(7, ud.getUserID());
//            st.executeUpdate();
//            System.out.println("update completed");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            throw new SQLException(e);
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//        }
//
//    }
//
//    /**
//     * データの検索処理を行う。
//     *
//     * @param ud 対応したデータを保持しているJavaBeans
//     * @throws SQLException 呼び出し元にcatchさせるためにスロー
//     * @return 検索結果
//     */
//    public ArrayList< UserDataDTO> search(UserDataDTO ud) throws SQLException {
//        Connection con = null;
//        PreparedStatement st = null;
//
//        ArrayList<UserDataDTO> uddArray = new ArrayList<UserDataDTO>();
//
//        try {
//            con = DBManager.getConnection();
//
//            //
//            String sql = "SELECT * FROM user_t";
//            if (!ud.getName().equals("") || ud.getBirthday() != null || ud.getType() != 0) {
//                boolean flag = false;
//                int i = 1;
//                int j = 1;
//                if (!ud.getName().equals("")) {
//                    sql += " WHERE name like ?";
//                    flag = true;
//                    i++;
//                    j++;
//                }
//                if (ud.getBirthday() != null) {
//                    if (!flag) {
//                        sql += " WHERE birthday like ?";
//                        flag = true;
//                    } else {
//                        sql += " AND birthday like ?";
//                    }
//                    j++;
//                }
//                if (ud.getType() != 0) {
//                    if (!flag) {
//                        sql += " WHERE type like ?";
//                    } else {
//                        sql += " AND type like ?";
//                    }
//                }
//                st = con.prepareStatement(sql);
//                if (!ud.getName().equals("")) {
//                    st.setString(1, "%" + ud.getName() + "%");
//                }
//                if (ud.getBirthday() != null) {
//                    st.setString(i, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
//                }
//
//                if (ud.getType() != 0) {
//                    st.setInt(j, ud.getType());
//                }
//
//                ResultSet rs = st.executeQuery();
//
//                while (rs.next()) {
//                    UserDataDTO resultUd = new UserDataDTO();
//
//                    resultUd.setUserID(rs.getInt(1));
//                    resultUd.setName(rs.getString(2));
//                    resultUd.setBirthday(rs.getDate(3));
//                    resultUd.setTell(rs.getString(4));
//                    resultUd.setType(rs.getInt(5));
//                    resultUd.setComment(rs.getString(6));
//                    resultUd.setNewDate(rs.getTimestamp(7));
//
//                    uddArray.add(resultUd);
//                    System.out.println("search completed");
//
//                }
//            } else {
//                st = con.prepareStatement(sql);
//                ResultSet rs = st.executeQuery();
//                while (rs.next()) {
//                    UserDataDTO resultUd = new UserDataDTO();
//                    resultUd.setUserID(rs.getInt(1));
//                    resultUd.setName(rs.getString(2));
//                    resultUd.setBirthday(rs.getDate(3));
//                    resultUd.setTell(rs.getString(4));
//                    resultUd.setType(rs.getInt(5));
//                    resultUd.setComment(rs.getString(6));
//                    resultUd.setNewDate(rs.getTimestamp(7));
//
//                    uddArray.add(resultUd);
//                }
//            }
//            return uddArray;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            throw new SQLException(e);
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//        }
//
//    }
//
//    /**
//     * ユーザーIDによる1件のデータの検索処理を行う。
//     *
//     * @param ud 対応したデータを保持しているJavaBeans
//     * @throws SQLException 呼び出し元にcatchさせるためにスロー
//     * @return 検索結果
//     */
//    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException {
//        Connection con = null;
//        PreparedStatement st = null;
//        try {
//            con = DBManager.getConnection();
//
//            String sql = "SELECT * FROM user_t WHERE userID = ?";
//
//            st = con.prepareStatement(sql);
//            st.setInt(1, ud.getUserID());
//
//            ResultSet rs = st.executeQuery();
//            rs.next();
//            UserDataDTO resultUd = new UserDataDTO();
//            resultUd.setUserID(rs.getInt(1));
//            resultUd.setName(rs.getString(2));
//            resultUd.setBirthday(rs.getDate(3));
//            resultUd.setTell(rs.getString(4));
//            resultUd.setType(rs.getInt(5));
//            resultUd.setComment(rs.getString(6));
//            resultUd.setNewDate(rs.getTimestamp(7));
//
//            System.out.println("searchByID completed");
//
//            return resultUd;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            throw new SQLException(e);
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//        }
//
//    }
    public UserDataDTO delete(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "DELETE FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());

            st.executeUpdate();

            System.out.println("Delete completed");
            UserDataDTO resultUd = new UserDataDTO();
            return resultUd;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

}
