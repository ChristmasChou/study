package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
		g.setColor(chineseChess.bgColor);//����������Ϊ������ɫ��
		g.fill3DRect(60, 30, 580, 630, false);//����һ���������̣�
		g.setColor(Color.black);//������ɫ����Ϊ��ɫ��
		for(int i=80;i<=620;i=i+60){
			g.drawLine(110, i, 590, i);//���ƺ��򣻣�ǰ��������Ϊ������꣬����������Ϊ�յ����ꣻ
		}
		g.drawLine(110,80,110,620);//���������
		g.drawLine(590,80,590,620);//�����ұ���
		for(int i=170;i<=530;i=i+60){//�����м������
			g.drawLine(i,80,i,320);
			g.drawLine(i,380,i,620);
		}
		g.drawLine(290,80,410,200);//�������ߵ�б��
		g.drawLine(290,200,410,80);
		g.drawLine(290,500,410,620);
		g.drawLine(290,620,410,500);
		this.smallLine(g,1,2);//���ƺ�������λ�õı�־
		this.smallLine(g,7,2);//���ƺ�������λ�õı�־
		this.smallLine(g,0,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,2,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,4,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,6,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,8,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,0,6);//����������λ�õı�־
		this.smallLine(g,2,6);//����������λ�õı�־
		this.smallLine(g,4,6);//����������λ�õı�־
		this.smallLine(g,6,6);//����������λ�õı�־
		this.smallLine(g,8,6);//����������λ�õı�־
		this.smallLine(g,1,7);//���ư�������λ�õı�־
		this.smallLine(g,7,7);//���ư�������λ�õı�־
		g.setColor(Color.black);
		Font font1=new Font("����",Font.BOLD,50);//��������
		g.setFont(font1);
		g.drawString("�� ��",170,365);//���Ƴ��Ӻ���
		g.drawString("�h ��",400,365);
		Font font=new Font("����",Font.BOLD,30);
		g.setFont(font);//��������
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){//��������
				if(chessPieces[i][j]!=null){
					if(this.chessPieces[i][j].isFocus()!=false){//�Ƿ�ѡ��
						g.setColor(chineseChess.focusbg);//ѡ�к�ı���ɫ
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//���Ƹ�����,������ǻ�Բ�ĺ�����
						//��һ��������Ҫ�����Բ�����Ͻǵ�x���꣬�ڶ���������Ҫ�����Բ�����Ͻǵ�y���꣬3����-Ҫ�����Բ�Ŀ�ȣ�4����-Ҫ�����Բ�ĸ߶ȣ�
						g.setColor(chineseChess.focuschar);//�ַ�����ɫ
					}
					else{
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//���Ƹ����ӣ�110�����ӵ����ĵ㣬���Ͻǣ�x��ȥ��25
						g.setColor(chessPieces[i][j].getColor());//���û�����ɫ
					}
					//�������ӵ�λ�ã�����˼�ˣ��ڽ�������ʾ��i��j�йأ�
				    g.drawString(chessPieces[i][j].getName(),110+i*60-15,80+j*60+10);//�������е���
				    g.setColor(Color.black);//��Ϊ��ɫ
				}
			}
		}
		g.setColor(color);//��ԭ������ɫ

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.chineseChess.caipan == true){//�ж��Ƿ��ֵ���������壻
			int i = -1,j = -1;
			int[] pos = getPos(e);
			i = pos[0];j=pos[1];
			if (i>=0&&i<=8&&j>=0&&j<=9) { //�����̷�Χ��
				if (focus == false) {//���û��ѡ�����ӣ�
					
				}
				else {//���ѡ�����ӣ�
					if(chessPieces[i][j] != null){//����ô������ӣ�
						if(chessPieces[i][j].getColor() == chessPieces[startI][startJ].getColor()){
							chessPieces[startI][startJ].setFocus(false);//��֮ǰ������Ϊ���ܲ�����
							chessPieces[i][j].setFocus(true);//����ѡ�ж���
							startI = i; startJ = j ;//�����޸ģ�
							System.out.println(i+";"+j);
						}
						else {//����ǶԷ����ӣ���ʾ�Է����壻
							
						}
					
					}
					else {//���û�����ӣ�
						
					}
				}
			}
		}
	}
	public int [] getPos(MouseEvent e){
		int [] pos = new int[2];
		pos[0] = -1;
		pos[1] = -1;
		Point p = e.getPoint(); //����¼�����������㣻
		double x = p.getX();
		double y = p.getY();
		if (Math.abs((x-110)/1%60)<=25) {  //��ö�Ӧ�������±��λ�ã���Ϊ���ӵİ뾶��25
			pos[0] = Math.round((float)(x-110))/60;//math.round���������ǰ�һ����������һ����ӽ����������
		}else if (Math.abs((x-110)/1%60)>=35){//����35�����ұߵ������ˣ�
			pos[0] = Math.round((float)(x-110))/60+1;
		}if (Math.abs((y-80)/1%60)<=25) {  //��ö�Ӧ�������±��λ�ã���Ϊ���ӵİ뾶��25
			pos[1] = Math.round((float)(y-80))/60;//math.round���������ǰ�һ����������һ����ӽ����������
		}else if (Math.abs((y-80)/1%60)>=35){//����35�����ұߵ������ˣ�
			pos[1] = Math.round((float)(y-80))/60+1;
		}
		return pos;
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
	public void smallLine(Graphics2D g,int i,int j){
		int x=110+60*i;//��������
		int y=80+60*j;
		if(i>0){//�������Ϸ��ı�־
			g.drawLine(x-3,y-3,x-20,y-3);g.drawLine(x-3,y-3,x-3,y-20);
		}
		if(i<8){//�������Ϸ��ı�־
			g.drawLine(x+3,y-3,x+20,y-3);g.drawLine(x+3,y-3,x+3,y-20);
		}
		if(i>0){//�������·��ı�־
			g.drawLine(x-3,y+3,x-20,y+3);g.drawLine(x-3,y+3,x-3,y+20);
		}
		if(i<8){//�������·��ı�־
			g.drawLine(x+3,y+3,x+20,y+3);g.drawLine(x+3,y+3,x+3,y+20);
		}
	}
	
}
