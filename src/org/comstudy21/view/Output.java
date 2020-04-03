package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Output implements View {

	@Override
	public void display() {
		Dto[] dtoArr=(Dto[])mapper.get("output");
		if(dtoArr.length==0){
			System.out.println("출력할 데이터가 없습니다!");
			return;
		}
		for(Dto d: dtoArr){
			System.out.println(d);
		}
	}

}
