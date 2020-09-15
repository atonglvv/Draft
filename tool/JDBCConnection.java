package tool;
import java.sql.*;
import  java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {
    private static List<Map<String,Object>>list =new ArrayList<Map<String,Object>>();

    public void queryall(){
        Connection conn =null;
        Statement  stmt =null;
        ResultSet  rs   =null;

        //mysql的的JDBC连接语句
        // URL编写格式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://39.96.209.176:8080/wangxiao?user=global_read&password=Wd3Ivijt2Y6G";

        //数据库执行的语句
        String sql =" SELECT\n" +
                "\tSTART_TIME,\n" +
                "\tb.NAME AS course_name,\n" +
                "\ta.NAME AS lesson_name,\n" +
                "\tbjy_room_id \n" +
                "FROM\n" +
                "\t( SELECT START_TIME, COURSE_ID, NAME, bjy_room_id FROM lesson WHERE datediff( START_TIME, now( ) ) = 0 ) a\n" +
                "\tLEFT JOIN course b ON a.course_id = b.id;";
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动

            conn = DriverManager.getConnection(url); // 获取数据库连接

            stmt = conn.createStatement(); // 创建执行环境

            // 读取数据

            rs = stmt.executeQuery(sql); // 执行查询语句，返回结果数据集

            rs.last(); // 将光标移到结果数据集的最后一行，用来下面查询共有多少行记录

            System.out.println("共有" + rs.getRow() + "行记录：");

            rs.beforeFirst(); // 将光标移到结果数据集的开头

            ResultSetMetaData md =rs.getMetaData();//获得结果集的结构信息，元数据

            int columnCount =md.getColumnCount();   //获得列数

            while (rs.next()) { // 循环读取结果数据集中的所有记录
                        /* System.out.println(rs.getRow() + "start_time:" + rs.getString("start_time")
                                                 + "\t course_name:" + rs.getString("course_name") + "\t等级:"
                                                 + rs.getString("lesson_name")+"\t百家云房间号:"

                                                 + rs.getString("bjy_room_id"));*/
                Map<String,Object>rowData = new HashMap<String, Object>();

                for (int i=1; i<=columnCount;i++){
                    rowData.put(md.getColumnName(i),rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库异常");
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close(); // 关闭结果数据集
                if (stmt != null)
                    stmt.close(); // 关闭执行环境
                if (conn != null)
                    conn.close(); // 关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
