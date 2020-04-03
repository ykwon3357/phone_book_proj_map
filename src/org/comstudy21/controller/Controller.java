package org.comstudy21.controller;
import static org.comstudy21.resource.R.*;

import org.comstudy21.model.Dto;
import org.comstudy21.view.Search;
public class Controller {

	public static void search(){
		viewArr[3].display();
		Dto[] dtoArr=dao.select((Dto)mapper.get("search"));
		((Search)viewArr[3]).display(dtoArr);
	}
	public static void service(){
		viewArr[0].display();
		int no = (Integer)mapper.get("no");
		try {
			switch(no){
			case 1:
				viewArr[no].display();
				dao.insert((Dto)mapper.get("input"));
				break;
			case 2:
				mapper.put("output",dao.selectAll());
				viewArr[no].display();
				break;
			case 3:
				search();
				break;
			case 4:
				search();
				viewArr[no].display();
				if(((Dto)mapper.get("update2")).getIdx()!=0){
					dao.update((Dto)mapper.get("update2"));
				}
				break;
			case 5:
				search();
				viewArr[no].display();
				if(((Dto)mapper.get("update2")).getIdx()!=0){
					dao.delete((Dto)mapper.get("update2"));
				}
				break;
			case 6:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
				default:
					System.out.println("해당 메뉴 없습니다.");
			}
		} catch (Exception e) {
			System.out.println();
		}
		
		service();
	}
}
