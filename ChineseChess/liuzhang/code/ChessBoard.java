package lz.ChineseChess;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
public class ChessBoard extends JFrame implements ActionListener,MouseListener,Runnable{
	public static void main(String[] args){
		new ChessBoard("���������սϵͳ");
	}
	//32������
	JLabel[] chess=new JLabel[32];
	//������ͼƬ����ʽǶ�봰����
	JLabel image;
	//����
	Container con;
	//������
	JToolBar menu;
	//���������ť(��ʼ���˳�)
	JButton start;
	JButton restart;
	JButton exit;
	//ϵͳ��ʾ��Ϣ
	JLabel st;
	/**
	 **�����Ƿ񱻵��
	 **chessClick = true ������˸
	 **
	 */
	boolean chessClick;
	//����������˸���߳�
	Thread t1;
	static int play,i;
	//���캯����ʼ��һ������
	public ChessBoard(String title){
		ChessPiece chessPiece;
		//��ô�������
		con = this.getContentPane();
		con.setLayout(null);
		
		//��������������ʼ����ť
		menu = new JToolBar();
		st = new JLabel("��ӭʹ�ã�ף����죡");
		st.setToolTipText("��Ϣ��ʾ");
		start = new JButton(" ��ʼ����Ϸ");
		start.setToolTipText("��ʼһ���µ���Ϸ");
		//restart = new JButton(" ���¿�ʼ ");
		//restart.setToolTipText("���¿�ʼ�µ���Ϸ");
		exit = new JButton(" �� �� ");
		exit.setToolTipText("�˳���Ϸ");
		
		//�Ѱ�ť��ӵ��˵���
		menu.setLayout(new GridLayout(0,3));
		menu.add(start);
		//menu.add(restart);
		menu.add(exit);
		menu.add(st);
		menu.setBounds(0,0,538,30);
		con.add(menu);
		
		//ע�ᰴť����
		start.addActionListener(this);
		//restart.addActionListener(this);
		exit.addActionListener(this);
		
		//������ӱ�ǩ,ע��Ҫ���������������̣�JLabel�����˳���Ǵ������ڣ������ӵ������ڵײ㲻���ڵ�����
		chessPiece = new ChessPiece(con,chess);
		
		//ע�����Ӽ���
		for(int i=0;i<32;i++){
			chess[i].addMouseListener(this);
		}
		
		//������̱�ǩ��ע���ļ�·�����ʹ��File.separator����ʽ���зָ��֤·����Ϣ�����ִ�λ
		
		image = new JLabel(new ImageIcon("src"+File.separator+"image"+File.separator+"main.gif"));
		//image = new JLabel(new ImageIcon("..\\lz.ChineseChese\\src\\image\\main.gif"));
		con.add(image);
		image.setBounds(0, 30, 558, 620);
		
		//�رմ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		//���ھ�����ʾ
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=this.getSize();
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
		//���ô������ԣ����ڱ�Ӧ�ò���ͼƬ��Ϊ���̣����Դ��ڲ�������
		this.setResizable(true);
		this.setTitle(title);
		this.setSize(558, 670);
		this.show();
	}
	
	@Override
	public void actionPerformed(ActionEvent button) {
		//�����ʼ����Ϸ��ť,
		if(button.getSource().equals(start)){
			//��ʼ������λ��
			int i,k;
			//��------����-------��
			//��
			for(i=0, k=24;i<2;i++,k+=456){
				chess[i].setBounds(k,56,55,55);
			}
			//��
			for(i=2, k=81;i<4;i++,k+=342){
				chess[i].setBounds(k,56,55,55);
			}
			//��
			for(i=4, k=138;i<6;i++,k+=228){
				chess[i].setBounds(k,56,55,55);
			}
			//ʿ
			for(i=6, k=195;i<8;i++,k+=114){
				chess[i].setBounds(k,56,55,55);
			}
			//�� 
			chess[8].setBounds(252,56,55,55);
			//��
			for(i=9, k=81;i<11;i++,k+=342){
				chess[i].setBounds(k,170,55,55);
			}
			//��
			for(i=11, k=24;i<16;i++,k+=114){
				chess[i].setBounds(k,227,55,55);
			}
			//��------����------��
			//��
			for(i=16, k=24;i<18;i++,k+=456){
				chess[i].setBounds(k,569,55,55);
			}
			//��
			for(i=18, k=81;i<20;i++,k+=342){
				chess[i].setBounds(k,569,55,55);
			}
			//��
			for(i=20, k=138;i<22;i++,k+=228){
				chess[i].setBounds(k,569,55,55);
			}
			//ʿ
			for(i=22, k=195;i<24;i++,k+=114){
				chess[i].setBounds(k,569,55,55);
			}
			//˧
			chess[24].setBounds(252,569,55,55);
			//��
			for(i=25, k=81;i<27;i++,k+=342){
				chess[i].setBounds(k,455,55,55);
			}
			//��
			for(i=27, k=24;i<32;i++,k+=114){
				chess[i].setBounds(k,398,55,55);
			}
			
		}
		if(button.getSource().equals(exit)){
			int x=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳�����Ϸ��","�˳�",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(x==JOptionPane.YES_OPTION) System.exit(0);
		}
	}
	@Override
	//���������Ƿ񱻵��
	public void mouseClicked(MouseEvent me) {
		System.out.println("mouse");
		//��ǰ����
		int x,y;
		//��귢�������ʼ�߳�
		if(t1==null){
			t1 = new Thread(this);
			t1.start();
		}
		if(!chessClick){
			for(int i=0;i<32;i++){
				if(me.getSource().equals(chess[i])){
					play=i;
					//������˸����
					//int x1=chess[i].getX();
					//int y1=chess[i].getY();
					//System.out.println(x1+" "+ y1);
					//System.out.println(chess[i].getName().charAt(0));
					chessClick=true;
					break;
				}
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 ** ��д���̷߳���������������˸
	 */
	public void run() {
		while(true){
			//�������ʱ������˸
			if(chessClick){
				chess[play].setVisible(false);
				//������˸ʱ����
				try{
					t1.sleep(200);
				}catch(Exception e){
				}
				System.out.println("��ʼ��˸");
				chess[play].setVisible(true);			
			}
			//�����߶���ϵͳ��Ϣ��ʾ�Է�����
			else{
				st.setVisible(false);
				try {
					t1.sleep(200);
				} catch (Exception e) {	
				}
				st.setVisible(true);
			}
		}
		
	}

}
