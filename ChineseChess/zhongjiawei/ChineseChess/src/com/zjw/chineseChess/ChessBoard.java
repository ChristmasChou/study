package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.sun.javafx.css.Rule;

/**
 * ����
 * @author jiawei
 *
 */
public class ChessBoard extends JPanel implements MouseListener{

	private int width;//��������֮��ľ��룻
	boolean focus = false ; //���ӵ�״̬��
	int jiang1_i = 4;//˧��i���ꣻ
	int jiang1_j = 0;//˧��j���ꣻ
	int jiang2_i = 4;//����i���ꣻ
	int jiang2_j = 9;//����j���ꣻ
	int startI = -1;//���ӿ�ʼ��λ�ã�
	int startJ = -1;//
	int endI = -1;//���ӵ���ֹλ�ã�
	int endJ = -1;
	public ChessPiece chessPieces[][];//���ӵ����飻
	ChineseChess chineseChess= null;//������������ã�
	ChineseRule chineseRule ;//���������������ã�
	public ChessBoard(ChessPiece chessPiece[][],int width,ChineseChess chineseChess){
		this.chessPieces = chessPiece;
		this.chineseChess = chineseChess;
		this.width = width;
		chineseRule = new ChineseRule(); 
		this.addMouseListener(this);//Ϊ�����������¼���������
		this.setBounds(0, 0, 700, 700);//�������̵Ĵ�С��
		this.setLayout(null);//����Ϊ�ղ��֣�
	}
	public void paint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;//���Graphics2d����
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//��
		Color color  = g.getColor();//��û��ʵ���ɫ��
		g.setColor(chineseChess.bgColor);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
