package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.discountDto;
import dto.memberDto;
import dto.productDto;
import utills.DBConnecter;

public class productDaoImpl implements productDao {
	Connection conn; // DB와 연결된 객체
	PreparedStatement pstm; // SQL문을 담는 객체
	ResultSet rs; // SQL문 결과를 담는 객체

	public List<productDto> productList(){  // 상품 리스트
		List<productDto> productList = new ArrayList<>();
	    try {
	        conn = DBConnecter.getConnection();
	        pstm = conn.prepareStatement(pListSql);
	        rs = pstm.executeQuery();
	        
	        while(rs.next()) {
	        	productDto product = new productDto();
	        	product.setPno(rs.getInt("pno"));
	            product.setPname(rs.getString("pname"));
	            product.setPrice(rs.getInt("price"));
	            productList.add(product);
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("product sql문 오류");
	    } finally {
	    	try {
				if(rs!=null) {
					rs.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	    }	
		return productList;
	}
	
	public List<discountDto> discountList(){
		List<discountDto> disList = new ArrayList<>();
	    try {
	        conn = DBConnecter.getConnection();
	        pstm = conn.prepareStatement(dListSql);
	        rs = pstm.executeQuery();

	        while(rs.next()) {
	        	discountDto dis = new discountDto();
	        	dis = new discountDto();
	        	dis.setRank(rs.getInt("rank"));
	            dis.setDc(rs.getFloat("dc"));
	            disList.add(dis);
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("discount sql문 오류");
	    } finally {
	    	try {
				if(rs!=null) {
					rs.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	    }	
		return disList;
	}

}
