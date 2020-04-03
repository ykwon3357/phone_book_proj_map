package org.comstudy21.view;

public class Menu implements View {

	@Override
	public void display() {
		for(int i=1;i<menuArr.length;i++){
			System.out.printf("%d.%s ",i,menuArr[i]);
		}
		System.out.println();
		System.out.print("Choice: ");
		try {
			int no=Integer.parseInt(scan.next());
			mapper.put("no", no);
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다!");
		}
	}

}
