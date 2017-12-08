package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * �������ࣻ
 * @author jiawei
 *
 */
public class ChineseChess  extends JFrame implements ActionListener{
	public static  final Color bgColor = new Color(245,250,160);//���̵ı�����ɫ��
	public static final Color focusbg = new Color(242,242,242);//����ѡ�к�ı�����ɫ��
	public static final Color focuschar = new Color(96,95,91);//����ѡ�к���ַ���ɫ��
	public static final Color color1 = new Color(249,183,173);
	public static final Color color2 = Color.white;//�׷�����ɫ��
	JLabel jstartGame = new JLabel("��Ϸ��ʼ");
	int width = 60; //������������֮��ľ��룻
	ChessPiece[][] chessPiece = new ChessPiece[9][10];//�����������飻
	ChessBoard jpz = new ChessBoard(chessPiece, width, this);//��������
	JPanel jpy  = new JPanel();//����һ��JPanel��
	JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpz, jpy);
	
	boolean caipan = false ;//�ɷ�����ı�־λ��
	int color = 0;//0������죬1������壻
	
	public ChineseChess() throws HeadlessException {
		super();
	}
	public void initialComponent(){
		jpy.setLayout(null);
		this.jstartGame.setBounds(10, 10, 50, 20);
		jpy.add(this.jstartGame);
		jpz.setLayout(null);
		jpz.setBounds(0, 0, 700, 700);
	}
	public void initialState(){
		
	}
	public void initialChessPiece(){
		//��ʼ���������ӣ�
		chessPiece[0][0]=new ChessPiece(color1, "��", 0, 0);
		chessPiece[1][0]=new ChessPiece(color1, "��", 1, 0);
		chessPiece[2][0]=new ChessPiece(color1, "��", 2, 0);
		chessPiece[3][0]=new ChessPiece(color1, "��", 3, 0);
		chessPiece[4][0]=new ChessPiece(color1, "˧", 4, 0);
		chessPiece[5][0]=new ChessPiece(color1, "��", 5, 0);
		chessPiece[6][0]=new ChessPiece(color1, "��", 6, 0);
		chessPiece[7][0]=new ChessPiece(color1, "��", 7, 0);
		chessPiece[8][0]=new ChessPiece(color1, "��", 8, 0);
		chessPiece[1][2]=new ChessPiece(color1, "��", 1, 2);
		chessPiece[7][2]=new ChessPiece(color1, "��", 7, 2);
		chessPiece[0][3]=new ChessPiece(color1, "��", 0, 3);
		chessPiece[2][3]=new ChessPiece(color1, "��", 2, 3);
		chessPiece[4][3]=new ChessPiece(color1, "��", 4, 3);
		chessPiece[6][3]=new ChessPiece(color1, "��", 6, 3);
		chessPiece[8][3]=new ChessPiece(color1, "��", 8, 3);
		
		chessPiece[0][9]=new ChessPiece(color2, "��", 0, 9);
		chessPiece[1][9]=new ChessPiece(color2, "��", 1, 9);
		chessPiece[2][9]=new ChessPiece(color2, "��", 2, 9);
		chessPiece[3][9]=new ChessPiece(color2, "��", 3, 9);
		chessPiece[4][9]=new ChessPiece(color2, "��", 4, 9);
		chessPiece[5][9]=new ChessPiece(color2, "��", 5, 9);
		chessPiece[6][9]=new ChessPiece(color2, "��", 6, 9);
		chessPiece[7][9]=new ChessPiece(color2, "��", 7, 9);
		chessPiece[8][9]=new ChessPiece(color2, "��", 8, 9);
		chessPiece[1][7]=new ChessPiece(color2, "��", 1, 7);
		chessPiece[7][7]=new ChessPiece(color2, "��", 7, 7);
		chessPiece[0][6]=new ChessPiece(color2, "��", 0, 6);
		chessPiece[2][6]=new ChessPiece(color2, "��", 2, 6);
		chessPiece[4][6]=new ChessPiece(color2, "��", 4, 6);
		chessPiece[6][6]=new ChessPiece(color2, "��", 6, 6);
		chessPiece[8][6]=new ChessPiece(color2, "��", 8, 6);
	}
	public void initialFrame(){
		this.setTitle("�й�����");
		Image image = new ImageIcon("ico.gif").getImage();
		this.setIconImage(image);//����ͼ�ꣻ
		this.add(this.jSplitPane);
		jSplitPane.setDividerLocation(730);//���÷ָ���λ�ü���ȣ�
		jSplitPane.setVisible(true);//���ÿɼ��ԣ�
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(){
				System.exit(0);//�˳���
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jstartGame){
			this.jstartGame_event();
		}
	}
	public void jstartGame_event(){
		
	}
	public void next(){ //���������鶼�ÿգ�
		for (int i = 0; i < 9; i++) {
			for (int j =0;j<10;j++){
				this.chessPiece[i][j]=null;
			}
		}
		this.caipan = false;
		this.initialChessPiece();//���³�ʼ�����ӣ�
		repaint();//���»��ƣ�
	}
	public static void main (String args[]){
		
	}
}
