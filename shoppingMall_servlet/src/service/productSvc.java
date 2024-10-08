package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.productDaoImpl;
import dto.discountDto;
import dto.memberDto;
import dto.productDto;

public class productSvc {

	public static Scanner sc = new Scanner(System.in);
	public static productDaoImpl pc = new productDaoImpl();
	
	public static List<productDto> printList() {
		List<productDto> pList = new ArrayList<productDto>();
		for (productDto row : pc.productList()) {	
			row.setPrice(dis_pro(row.getPrice()));
			
			pList.add(row);
		}
		return pList;
	}
	
	public static List<productDto> search(String word) {
		String serchWord = word;
		List<productDto> sList = new ArrayList<productDto>();
		for (productDto sword : pc.productList()) {
			sword.setPrice(dis_pro(sword.getPrice()));
            if (sword.getPname().contains(word)) {
            	sList.add(sword);
            }
		}
		
		return sList;
	}
	
	public static int dis_pro(int price) {
		int total = price;
		for (discountDto dis : pc.discountList()) {
			int rank = dis.getRank();
			float dc = dis.getDc();
			
			if(rank == memberDto.getRank()) {
				total = (int)(total * dc);
			}
		}
		return total;
	}
	
//	public static productDto productSearch(String product) {
//		for (productDto word : pc.productList()) {
//            if (word.getPname().contains(product)) {
//                return word;
//            }
//        }
//		return null;
//	}
}
