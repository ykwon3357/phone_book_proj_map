package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Update implements View {

	@Override
	public void display() {
		System.out.println(updateTitle);
		System.out.print("수정할 idx 입력: ");
		int idx = scan.nextInt();
		boolean flag =false;
		Dto[] dtoArr = (Dto[])mapper.get("update");
		for(int i=0;i<dtoArr.length;i++){
			if(dtoArr[i].getIdx()==idx){
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println("잘못된 idx를 입력했습니다");
			Dto dto = new Dto(0,null,null);
			mapper.put("update2", dto);
		}else{
			System.out.print("새 이름: ");
			String name = scan.next();
			System.out.print("새 번호: ");
			String phone = scan.next();
			
			Dto dto=new Dto(idx,name,phone);
			mapper.put("update2", dto);
		}
	}

}
