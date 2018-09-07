package timepost;

import com.sgt.timepost.untils.DbUtil;
import com.sgt.timepost.untils.MysqlConnPool;
import com.sgt.timepost.untils.MysqlHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${sgt} on 2018/8/21 0021.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //jsoup ------------------------test-------------------
//        URL uri = new URL("http://hi2future.com/Mail/showlist2/page/5.html");
//        Document document = Jsoup.parse(uri,3000);
//        Elements emailInfos = document.getElementsByClass("mail-item");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        for(Element emailInfo : emailInfos){
//            String email=emailInfo.child(0).child(0).text();
//            String[] timeArr=emailInfo.child(1).text().split("寄往");
//            Date timeStart= sdf.parse(timeArr[0]) ;
//            Date timeEnd = sdf.parse(timeArr[1]);
//            String content=emailInfo.child(2).html();
//            String ss="";
//        }

        Connection connection = MysqlConnPool.getInstance().getConnection();
        ResultSet rs = MysqlHelper.executeQuery(connection, "select * from student");
        try {
            if (rs.next()) {
                String str = rs.getString(1);
                System.out.println(str);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        //这里也可以继续使用connection这个连接，只要上面不关闭即可
        Connection connection1 = MysqlConnPool.getInstance().getConnection();
        int exeCount = 0;
        try {
            exeCount = MysqlHelper.executeUpdate(connection1, "update student set name='hhhsss' where id = 2");
            connection1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("受影响的行数为：" + exeCount);

    }
}
