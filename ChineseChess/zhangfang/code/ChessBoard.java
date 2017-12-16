package zf.chinesechess;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;


public class ChessBoard extends JFrame implements MouseListener, ActionListener{
	Container con;
	//����������
    JToolBar jtool;
    Graphics cg;
    
    //����,����
    JPanel board;
    ChessPiece chess;
    //��ť����ʾ
    JButton start;
    JButton exit;
    JLabel hint;
    
    //��¼����,��һ��������������ӵ��±ꣻ�ڶ�����1��ʾ�������ߣ�2��ʾ�������ߣ������������ӱ����ʱΪtrue
    static Object[] para={0,2,false};
    
    //�߳�
    Thread t; //������˸���ӣ�����ѡ��
    MyThread tm;
    boolean flag;
    
	public ChessBoard(){
		/* ���ô������ʽ */
		this.setTitle("Chinese Chess");
		this.setIconImage(new ImageIcon("images\\�ڽ�.gif").getImage());
        this.setSize(630,720);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); //������ʾ
        
        
        /* ��ȡ��ǰ��� */
        con = this.getContentPane();
        con.setBackground(Color.white);        
    	con.setLayout(null);
    	
    	
        /* ������������������������ӵ���ǰ������*/
        jtool = new JToolBar();
        jtool.setBounds(0, 0, 630, 50);
        jtool.setBackground(Color.white);
        jtool.setPreferredSize(jtool.getSize());
        con.add(jtool);
        
        //�����ؼ�������ӵ���������
        start = new JButton("���¿�ʼ");
        start.setFont(new Font("΢���ź�", Font.BOLD, 15));
        start.setBackground(new Color(255, 250, 250));
        start.setToolTipText("��ʼ��Ϸ");     
        
        exit = new JButton("�˳�");
        exit.setFont(new Font("΢���ź�", Font.BOLD, 15));
        exit.setBackground(new Color(255, 250, 250));
        exit.setToolTipText("�˳���Ϸ");
        
        hint = new JLabel(" ��ӭ������Ϸ:��������  ", JLabel.CENTER);
        hint.setFont(new Font("΢���ź�", Font.BOLD, 15));
        
        jtool.setLayout(new GridLayout(0,3));
        jtool.add(start);
        jtool.add(exit);
        jtool.add(hint);
        
        //ע�ᰴŤ����
        start.addActionListener(this);
      	exit.addActionListener(this);
        
      	/*  �������  */
        chess = new ChessPiece(); 
		for(int i=0;i<32;i++){
			con.add(chess.chesspiece[i]);
			chess.chesspiece[i].addMouseListener(this); //����������¼�
		}
		chess.drawChess();
		
      	/* ��ȡ��ǰ���Ļ�ͼ���󣬲���������*/
//      //	����paint�������Զ����ã�������Ҫ����paintChessBoard�ῴ������ͼ�������Ҫ�ڵ���ǰ֮ǰ����һ�δ��룬�ý��̵ȴ�500����
//      	 try {
//      		 Thread.sleep(100);
//      		 } catch (Exception e) {
//      			 e.printStackTrace();
//      			 }  
		
		/*   ����      */
		board = new JPanel();
		board.setBounds(0, 0, 630, 670);
		board.setBackground(Color.white);
        board.setPreferredSize(board.getSize());
		con.add(board);
      	cg = board.getGraphics();
      //	paintChessBoard(cg);
      	//����һ����ʱ������ʱ���£���ֹ��JFrame��paint���ǵ�
      	Timer t = new Timer(10, new ActionListener() {      		 
            @Override
            public void actionPerformed(ActionEvent e) {
            	paintChessBoard(cg);
            }
        });
        t.start();//��ʼִ��Timer 
        board.addMouseListener(this); //���̼���
        
        /*  ��Ӵ������  */
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
            }  
        });  
    }  
	
	/*  ��������,�÷�����д��JFrame�е�paint�������Զ����� ��Ҳ�������ö�ʱ��,��ʱˢ��      */  
    public void paintChessBoard(Graphics g){ 
    	//super.paint(g);
        Font f=new Font("΢���ź�",Font.BOLD,30);  
        g.setFont(f);
        g.setColor(new Color(185,24,24));         
        g.drawRect(60, 80, 500, 560);  //��Ȧ  
        g.drawRect(70, 90, 480, 540);  //��Ȧ
        
        /*���߲���*/  
        int length=150; 
        for(int i=1;i<9;i++){  
        	g.drawLine(70, length, 550, length);  
        	length += 60;
        	// �м人��  
        	g.drawString("��  ��", 130, 370);
        	g.drawString("��  ��", 400, 370);  
        }  
         
        /*�ϰ벿������*/  
        length=130; 
        for(int i=0;i<7;i++){  
            g.drawLine( length, 90, length, 330);  
            length += 60;  
        }  
        
        /*�°벿������*/  
        length=130;        
        for(int i=0;i<7;i++){  
            g.drawLine( length, 390, length, 630);  
            length += 60;  
        }  
        
        /*�ϰ벿�־Ź���б��*/
        g.drawLine(250, 90, 370, 210);
        g.drawLine(370, 90, 250, 210);  
  
        /*�°벿�־Ź���б��*/
        g.drawLine(250, 510, 370, 630);
        g.drawLine(250, 630, 370, 510);  
        }  
   
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
		System.out.println((int)para[0]+" "+(int)para[1]+" "+(boolean)para[2]);
		para=(new MouseClickedEvent()).mouseClicked(e, chess, hint, (int)para[0], (int)para[1], (boolean)para[2]);
		flag=true;
		//�����߳�
		if (t==null){
//			tm=new MyThread((int)para[0], hint, (boolean)para[2]);
//			t=new Thread(tm);
			t= new Thread(){
				public void run(){
					while (flag){
						//�������ӵ�һ�¿�ʼ��˸
						if ((boolean)para[2]){
							chess.chesspiece[(int)para[0]].setVisible(false);
							//ʱ�����
							try{
								Thread.sleep(200);
								}catch(Exception e){
								}				
							chess.chesspiece[(int)para[0]].setVisible(true);
							}
						
						//��˸��ǰ��ʾ��Ϣ
						else {
							hint.setVisible(false);
							try{
								Thread.sleep(350);
								}catch(Exception e){									
								}		
							hint.setVisible(true);
						//	hint.setForeground(Color.red);
							}
						try{
							Thread.sleep(300);
							}
						catch (Exception e){
						}
						}
					}
				};
				t.start();
				}
		
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
		//System.out.println(e.getSource().equals(start));
		if(e.getSource().equals(start)){
				/*  ��������  */
				chess.drawChess();
				for(int i=0;i<32;i++){
					chess.chesspiece[i].setVisible(true);
					chess.chesspiece[i].addMouseListener(this); //����������¼�
				}
				//������ʼ��
				para[0]=0;
				para[1]=2;
				para[2]=false;
				//��ʾ��Ϣ��ʼ��
				hint.setText("  ��ӭ������Ϸ:��������");
				//hint.setForeground(Color.black);
				//�ر�ǰһ���߳�
				flag=false;
				t=null;
				}
		else{
			int j=JOptionPane.showConfirmDialog(
					null,"���Ҫ�˳���Ϸ��?","�˳�",
					JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
				}
			}
		}

	
	}  
