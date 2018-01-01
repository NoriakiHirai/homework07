package model;

import java.io.Serializable;

public class Equipment implements Serializable{
	
	// フィールド
	private int id;
	private String name;
	private String category;
	private int strength;
	private int agility;
	private int hp;
	
	public Equipment(){}
	
	public Equipment(int id, String name, String category,
			int strength, int agility, int hp) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.strength = strength;
		this.agility = agility;
		this.hp = hp;
	}

	// アクセッサ
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getStrength() {
		return strength;
	}

	public int getAgility() {
		return agility;
	}

	public int getHp() {
		return hp;
	}
	
}
