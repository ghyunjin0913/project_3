package utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 연결에 필요한 정보
			String user = "dst09";
			String pw = "dst09";
			String url = "jdbc:oracle:thin:@192.168.10.11:1521:DB19";

			// 드라이버를 메모리에 할당
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 연결된 객체 가져오기
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");// 드라이버 주소가 잘못됨
		} catch (SQLException e) {
			System.out.println("연결 실패");// url이 잘못됨
		} catch (Exception e) {
			System.out.println("알수 없는 오류");
		}
		return conn;
	}
}
