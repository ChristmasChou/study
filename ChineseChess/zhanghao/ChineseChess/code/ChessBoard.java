package zh;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessBoard extends JFrame implements ActionListener,MouseListener,Runnable{

	//32������
	JLabel play[] = new JLabel[32];
	ChessPieces chessPieces;//����ͼƬ
	//����
	JLabel image;	
	//����
	Container con;
	
	//���������,���������ƶ��Լ����ӣ���Ӯ�ȹ���
	ChessRule rule;
	
	/**
	** ��������
	** chessManClick = true ��˸���� �����߳���Ӧ
	** chessManClick = false ������ ֹͣ��˸  �����߳���Ӧ
	*/
	boolean chessManClick;
	
	/**
	** �����������
	** chessPlayClick=1 ��������
	** chessPlayClick=2 ��������
	** chessPlayClick=3 ˫������������
	*/
	int chessPlayClick=2;//Ĭ�Ϻ��忪ʼ����
	
	//����������˸���߳�
	static Thread tmain;
	//�ѵ�һ�εĵ������Ӹ��߳���Ӧ
	static int Man,i;
	

	ChessBoard() throws IOException{
		new ChessBoard("�й�����");
	}
	//�вι��캯��
	ChessBoard(String Title) throws IOException{
		//��ȡ��������
		con = this.getContentPane();
		con.setLayout(null);
		chessPieces=new ChessPieces();
		//ʵ����������
		rule = new ChessRule();
		
		//�������
	    drawChessMan();
	    //ע�������ƶ�����
	    for (int i=0;i<32;i++){
	  		con.add(play[i]);
	  		play[i].addMouseListener(this);
	  	}
	    //������̱�ǩ
	    con.add(image = new JLabel(chessPieces.getTable()));
	    image.setBounds(0,30,558,620);//�������̴�С
	    image.addMouseListener(this);//ע�����̼����¼�
	    
	    //ע�ᴰ��رռ���
	  	this.addWindowListener(
	  		new WindowAdapter() {
	  			public void windowClosing(WindowEvent we){
	  				System.exit(0);
	  			}
	  		}
	  	);
	  	
		//�������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
	
		//����
		//this.setIconImage(chessPieces.getRedgenera().getImage());
		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(558,670);
		this.setVisible(true);
	}
	
	//������ӷ���
	public void drawChessMan() {
		//���̿���
		int i,k;
		//ͼ��
		Icon in;
						
		//��ɫ����		
		//��
		in = chessPieces.getBlackcar();
		for (i=0,k=24;i<2;i++,k+=456){		
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);	
			play[i].setName("��1");			
		}	
				
		//��
		in = chessPieces.getBlackhorse();
		for (i=4,k=81;i<6;i++,k+=342){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("��1");
		}
				
		//��
		in = chessPieces.getBlackelephant();
		for (i=8,k=138;i<10;i++,k+=228){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("��1");
		}
				
		//ʿ
		in = chessPieces.getBlackofficia();
		for (i=12,k=195;i<14;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("ʿ1");
		}
				
		//��
		in = chessPieces.getBlacksoldier();
		for (i=16,k=24;i<21;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,227,55,55);
			play[i].setName("��1");
		}
				
		//��
		in = chessPieces.getBlackcannon();			
		for (i=26,k=81;i<28;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,170,55,55);
			play[i].setName("��1");
		}
				
		//��
		in = chessPieces.getBlackgenera();
		play[30] = new JLabel(in);
		play[30].setBounds(252,56,55,55);
		play[30].setName("��1");

		//��ɫ����
		//��
		in = chessPieces.getRedcar();
		for (i=2,k=24;i<4;i++,k+=456){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
				
		//��
		in = chessPieces.getRedhorse();
		for (i=6,k=81;i<8;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
				
		//��
		in = chessPieces.getRedelephant();			
		for (i=10,k=138;i<12;i++,k+=228){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
				
	    //ʿ
		in = chessPieces.getRedofficia();
		for (i=14,k=195;i<16;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("ʿ2");
		}
				
		//��
		in = chessPieces.getRedsoldier();
		for (i=21,k=24;i<26;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,398,55,55);
			play[i].setName("��2");
		}
				
		//��
		in = chessPieces.getRedcannon();
		for (i=28,k=81;i<30;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,455,55,55);
			play[i].setName("��2");
		}
				
		//˧
		in = chessPieces.getRedgenera();			
		play[31] = new JLabel(in);
		play[31].setBounds(252,569,55,55);		
		play[31].setName("˧2");
	}
	
	/**
	** �̷߳�������������˸
	*/
	@Override
	public void run() {
		while (true){
			//�������ӵ�һ�¿�ʼ��˸
			if (chessManClick){
				play[Man].setVisible(false);

				//ʱ�����
				try{
					tmain.sleep(200);
				}
				catch(Exception e){
				}
				
				play[Man].setVisible(true);
			}
			
			try{
				tmain.sleep(350);
			}
			catch (Exception e){
			}
		}
	}

	
	/**
	** �������ӷ���,����ƶ����ӣ������ӵ��߼�
	*/
	@Override
	public void mouseClicked(MouseEvent me) {
		//��ǰ����
		int Ex=0,Ey=0;
				
		//�����߳�
		if (tmain == null){
			tmain = new Thread(this);
			tmain.start();
		}
		
		//��������ƶ�����
		if (me.getSource().equals(image)){
			//�ú��������ʱ��
			if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){	
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				//�ƶ��䡢��
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}
				//��������������
				chessPlayClick = 1;
			}
			//�ú��������ʱ��
			else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				//�ƶ��䡢��
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}
				//��������������
				chessPlayClick = 2;
			}
			//��ǰû�в���(ֹͣ��˸)
			chessManClick=false;
		}
		
		//�������
		else{
			//��һ�ε�������(��˸����)
			if (!chessManClick){
				for (int i=0;i<32;i++){
					//������������
					if (me.getSource().equals(play[i])){
						//�����߳��ø�������˸
						Man=i;
						//��ʼ��˸
						chessManClick=true;
						break;
					}//if
				}//for
			}//if
			
			//�ڶ��ε�������(����Ҫ�Ե�������)
			else if (chessManClick){
				//��ǰû�в���(ֹͣ��˸)
				chessManClick=false;
				
				for (i=0;i<32;i++){
					//�ҵ����Ե�����
					if (me.getSource().equals(play[i])){
						//�ú�������ʱ��
						if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							
							//�䡢���Թ���
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}
							//������������ɺ�������
							chessPlayClick=1;
							break;
						}
						
						//�ú�������ʱ��
						else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
													
							//��Թ���
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}
							//������������ɺ�������
							chessPlayClick=2;
							break;
						}
					}//if
				}//for
			}//else if
		}//else
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

