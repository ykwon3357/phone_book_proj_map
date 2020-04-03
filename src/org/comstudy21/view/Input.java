package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Input implements View {

	@Override
	public void display() {
		System.out.println(inputTitle);
		Dto dto = new Dto();
		System.out.print("이름 입력: ");
		dto.setName(scan.next());
		System.out.print("전화 번호: ");
		dto.setPhone(scan.next());
		
		mapper.put("input", dto);
	}

}
