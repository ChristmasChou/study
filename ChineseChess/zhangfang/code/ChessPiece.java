
/**
 * ������ӵ������У����ڵ���
 *
 */

package zf.chinesechess;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessPiece {
	public JLabel chesspiece[] = new JLabel[32];   //����
	 //i������,k��������λ��
	 int i,k; 		 
	 //����
	 Icon piece;
	 //���ӿ�ߵ�һ��
	 int half=55/2;
	 
	ChessPiece(){
		//��
		 piece = new ImageIcon("piece\\�ڳ�.gif");
		 for (i=0;i<2;i++){		
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("�ڳ�" + i);
			 }	
		 
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=4;i<6;i++){			 
				chesspiece[i] = new JLabel(piece);
				chesspiece[i].setName("����" + i);
				}
		 
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=8;i<10;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			}
		 
		 //ʿ
		 piece = new ImageIcon("piece\\��ʿ.gif");
		 for (i=12;i<14;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("��ʿ" + i);
			 }
			
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=16;i<21;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			 }
			
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=26;i<28;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			 }
		
		 //��
		 piece = new ImageIcon("piece\\�ڽ�.gif");
		 chesspiece[30] = new JLabel(piece);
		 chesspiece[30].setName("�ڽ�");

		 //��ɫ����
		 //��
		 piece = new ImageIcon("piece\\�쳵.gif");
		 for (i=2;i<4;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("�쳵" + i);
			}
			
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=6;i<8;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			}
			
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=10;i<12;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			}
			
		 //��
		 piece = new ImageIcon("piece\\��ʿ.gif");
		 for (i=14;i<16;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("����" + i);
			}
			
		 //��
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=21;i<26;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("���" + i);
			}
		 
		 //�h
		 piece = new ImageIcon("piece\\����.gif");
		 for (i=28;i<30;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("��h" + i);
			}
			
		 //˧
		 piece = new ImageIcon("piece\\�콫.gif");
		 chesspiece[31] = new JLabel(piece);
		 chesspiece[31].setName("��˧");
	}
	
	//��ʼ��λ��
	 public void drawChess(){		 	
		 // ����
		 //��
		 for (i=0,k=70-half;i<2;i++,k+=480){		
			 chesspiece[i].setBounds(k,90-half,55,55); 
			 }	
		 
		 //��
		 for (i=4,k=130-half;i<6;i++,k+=360){			 
			 chesspiece[i].setBounds(k,90-half,55,55);  
			}
		 
		 //��
		 for (i=8,k=190-half;i<10;i++,k+=240){
			 chesspiece[i].setBounds(k,90-half,55,55); 
			}
		 
		 //ʿ
		 for (i=12,k=250-half;i<14;i++,k+=120){
			 chesspiece[i].setBounds(k,90-half,55,55); 
			 }
			
		 //��
		 for (i=16,k=70-half;i<21;i++,k+=120){
			 chesspiece[i].setBounds(k,270-half,55,55);
			 }
			
		 //��
		 for (i=26,k=130-half;i<28;i++,k+=360){
			 chesspiece[i].setBounds(k,210-half,55,55);
			 }
		
		 //��
		 chesspiece[30].setBounds(310-half,90-half,55,55);		
		 

		 //��ɫ����
		 //��
		 for (i=2,k=70-half;i<4;i++,k+=480){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //��
		 for (i=6,k=130-half;i<8;i++,k+=360){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //��
		 for (i=10,k=190-half;i<12;i++,k+=240){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //��
		 for (i=14,k=250-half;i<16;i++,k+=120){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //��
		 for (i=21,k=70-half;i<26;i++,k+=120){
			 chesspiece[i].setBounds(k,450-half,55,55);
			}
		 
		 //�h
		 for (i=28,k=130-half;i<30;i++,k+=360){
			 chesspiece[i].setBounds(k,510-half,55,55);
			}
			
		 //˧
		 piece = new ImageIcon("piece\\�콫.gif");
		 chesspiece[31].setBounds(310-half,630-half,55,55);
		}
	
}
