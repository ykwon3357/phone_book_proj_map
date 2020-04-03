package org.comstudy21.model;
import static org.comstudy21.resource.R.*;
public class Dao {
	public static final int MAX=100;
	private int seq=1;
	private int top=0;
	private Dto[] dtoArr=new Dto[MAX];
	{
		dtoArr[top++]=new Dto(seq++,"Kim","010-1111-1111");
		dtoArr[top++]=new Dto(seq++,"You","010-2222-2222");
		dtoArr[top++]=new Dto(seq++,"Kim","010-3333-3333");
		dtoArr[top++]=new Dto(seq++,"Park","010-4444-4444");
		dtoArr[top++]=new Dto(seq++,"Lee","010-5555-5555");
				
	}
	private Dao(){
		
	}
	
	public static Dao instance;
	public static Dao getInstance(){
		if(instance==null){
			instance = new Dao();
		}
		return instance;
	}
	
	public void insert(Dto dto){
		if(top>=MAX){
			System.out.println("더 이상 입력 불가합니다!");
			return;
		}
		dtoArr[top]=dto;
		dtoArr[top++].setIdx(seq++);
		System.out.println("입력 완료!");
	}
	public Dto[] selectAll(){
		Dto[] newArr = new Dto[top];
		for(int i=0;i<top;i++){
			newArr[i]=new Dto();
			newArr[i].setIdx(dtoArr[i].getIdx());
			newArr[i].setName(dtoArr[i].getName());
			newArr[i].setPhone(dtoArr[i].getPhone());
		}
		
		return newArr;
	}
	
	public Dto[] select(Dto dto){
		Dto[] newArr = new Dto[top];
		int cnt =0;
		for(int i=0;i<top;i++){
			if(dtoArr[i].getName().toUpperCase().equals(dto.getName().toUpperCase())){
				newArr[cnt]=new Dto();
				newArr[cnt].setIdx(dtoArr[i].getIdx());
				newArr[cnt].setName(dtoArr[i].getName());
				newArr[cnt++].setPhone(dtoArr[i].getPhone());
			}
		}
		Dto[] arr = new Dto[cnt];
		for(int i=0;i<cnt;i++){
			arr[i]=newArr[i];
		}
		mapper.put("update", arr);
		return arr;
	}
	public void update(Dto dto){
		boolean flag = false;
		for(int i=0;i<top;i++){
			if(dtoArr[i].getIdx()==dto.getIdx()){
				dtoArr[i]=dto;
				flag=true;
				break;
			}
		}
		if(!flag){
			System.out.println("수정 실패!");
		}else{
			System.out.println("수정 성공!");
		}
		
	}
	public void delete(Dto dto){
		boolean flag = false;
		for(int i=0;i<top;i++){
			if(dtoArr[i].getIdx()==dto.getIdx()){
				for(int j=i;j<top-1;j++){
					dtoArr[j]=dtoArr[j+1];
				}
				dtoArr[--top]=null;
				flag=true;
				break;
			}
		}
		if(!flag){
			System.out.println("삭제 실패!");
		}else{
			System.out.println("삭제 성공!");
		}
		
	}

}
