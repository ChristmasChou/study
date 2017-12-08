package com.zjw.chineseChess;

import java.awt.Color;

/**
 * �����ࣻ
 * @author jiawei
 *
 */
public class ChessPiece {
	private Color color ;//���ӵ���ɫ��
	private String name ;//���ӵ����֣�
	private int x;
	private int y;
	private boolean focus = false;//���ӵ�״̬���Ƿ�ѡ�У�
	
	public ChessPiece() {
		super();
	}
	//���ɹ��캯����
	public ChessPiece(Color color, String name, int x, int y) {
		super();
		this.color = color;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	//����setget������
	public Color getColor() { 
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isFocus() {
		return focus;
	}
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	
}
