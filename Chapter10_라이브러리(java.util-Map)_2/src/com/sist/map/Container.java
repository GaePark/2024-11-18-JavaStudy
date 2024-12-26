package com.sist.map;
import java.util.*;
public class Container {
	private Map<String,Model> clsMap= new HashMap<String,Model>();
	
	public Container() {
		// TODO Auto-generated constructor stub
		clsMap.put("board", new BoardMoel());
		clsMap.put("recipe", new RecipeModel());
		clsMap.put("mypage", new MypageModel());
		clsMap.put("food", new FoodModel());
		clsMap.put("member", new MemberModel());
	}
	public Model getBean(String key) {
		return clsMap.get(key);
	}
}
