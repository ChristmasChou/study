
/** 
 * ����������
 * 
 */

package zf.chinesechess;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ChessRule {
	 int half=55/2; //55Ϊ���ӵĸ߽����
	 
	 /**  ��,���ƶ�����      */
	 public void soldierMoveRule(JLabel chess, MouseEvent e){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 //��ɫ������ �������е��±귶Χ16-20
		 if(chess.getName().charAt(0)=='��'){
			 //�����ƶ� 
			 if (eY < 640 && ((eY-chessY) > 50 && (eY-chessY) < 70) && ((eX-chessX) < 5 && (eX-chessX) > -5)){
				 chess.setBounds(chessX-half, chessY-half + 60, 55, 55); 
				 }
			 //�����ƶ���������ӣ�
			 else if (chessY >= 390 && eX < 570 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((eX-chessX)> 50 && (eX-chessX) < 70)){
				 chess.setBounds(chessX-half + 60, chessY-half, 55, 55);
				 }
			 //�����ƶ���������ӣ�
			 else if (chessY >= 390 && eX > 80 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((chessX-eX)> 50 && (chessX-eX) < 70)){
				 chess.setBounds(chessX - half - 60, chessY -half, 55, 55);
				 }
			 }
		 
		 //��ɫ�ı� 21-25
		 else{
			//�����ƶ�
			 if (eY > 70 && ((chessY-eY) > 50 && (chessY-eY) < 70) && ((eX-chessX) < 5 && (eX-chessX) > -5)){
				 chess.setBounds(chessX-half, chessY-half - 60, 55, 55); 
				 }
			 //�����ƶ���������ӣ�
			 else if (chessY <= 330 && eX < 570 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((eX-chessX)> 50 && (eX-chessX) < 70)){
				 chess.setBounds(chessX-half + 60, chessY-half, 55, 55);
				 }
			 //�����ƶ���������ӣ�
			 else if (chessY <= 330 && eX > 70 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((chessX-eX)> 50 && (chessX-eX) < 70)){
				 chess.setBounds(chessX-half - 60, chessY -half, 55, 55);
				 }
			 }
		 }
	 
	 
	 /**  ��,���������  */
	 public void soliderEatRule(JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 boolean com=(chess1.getName().charAt(0)!=chess2.getName().charAt(0));		 
//		 System.out.println(com);
//		 System.out.println(chessX1 + " " + chessY1);
//		 System.out.println(chessX2 + " " + chessY2);
		 //���岻�����ϳ��壬���岻�����³���
		 //���ҳ���
		 if ((chessX2 - chessX1) <= 65 && (chessX2 - chessX1) >= 55 
				 && (chessY1 - chessY2) < 5 && (chessY1 - chessY2) > -5 
				 && chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			 //����Ҫ����
			 if (chess1.getName().charAt(0) == '��' && chessY1 >= 390 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 //�ѶԷ���λ�ø��Լ�
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //����Ҫ����
			 else if (chess1.getName().charAt(0) == '��' && chessY1 <=330 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 //�ѶԷ���λ�ø��Լ�
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);	
				 }
			 }
			
		 //������
		 else if ((chessX1 - chessX2) <= 65 && (chessX1 - chessX2) >= 55 
				 && (chessY1 - chessY2) < 5 && (chessY1 - chessY2) > -5 
				 && chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			 //����Ҫ����
			 if (chess1.getName().charAt(0) == '��' && chessY1 >= 390 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //����Ҫ����
			 else if (chess1.getName().charAt(0) == '��' && chessY1 <=330 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);	
				 }
			 }
			
		 //���ϻ������߳���
		 else if (chessX1 - chessX2 >=-5 && chessX1 - chessX2 <=5 && chessY1 - chessY2 >= -60 && chessY1 - chessY2 <= 60){
			 //���岻�����ϳ���
			 if (chess1.getName().charAt(0) == '��' && chessY1 < chessY2 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //���岻�����³���
			 else if (chess1.getName().charAt(0) == '��' && chessY1 > chessY2 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }			
			 }
		 }
	 
	 
	 /** ��,���ƶ�����   : �ƶ�������������     */
	 public void cannonMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		//��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
		 
		 int Move=0;
		 
		//���ϻ����ƶ�: �ж������յ����û������
		 if (chessX - eX >=-5 && chessX - eX <= 5){
			 for (int j=0;j<32;j++){
				 //�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
				 int pieceX=chesspiece[j].getX()+half;
				 int pieceY=chesspiece[j].getY()+half;
				 if (pieceX - chessX >=-5 && pieceX - chessX <=5 && chesspiece[j].getName()!=chess.getName() && chesspiece[j].isVisible()){
						//����㵽�յ�(���ϵ���)
						for (int k= chessY+60;k<eY;k+=60){
							//������㡢С���յ������Ϳ���֪���м��Ƿ�������
							if (pieceY < eY && pieceY > chessY){
								//�м���һ�����ӾͲ����Դ��������߹�ȥ
								Move++;
								break;
								}
							}//for
						//����㵽�յ�(���µ���)
						for (int k=eY+60;k<chessY;k+=60){
							//�������յ������
							if (pieceY > eY && chessY > pieceY ){
								Move++;
								break;
								}
							}//for
						}
				 }
			 //�м�û�����ӣ������ƶ�
//			 System.out.println();
//			 System.out.println(count+" "+eX+"  "+eY);
			 for(int i=90;i<=630;i+=60){
				 if (Move == 0 && (eY-i) >=-5 && (eY-i) <=5){
					 chess.setBounds(chessX-half,eY-half,55,55); 
					 break;
					 }
				 }
			 }
		 
		//��������ƶ�: �ж������յ����û������
		 else if (chessY - eY >=-5 &&  chessY - eY <= 5){
			 for (int j=0;j<32;j++){
				 //�ҳ���ͬһ���ߵ��������ӡ����������Լ�
				 int pieceX=chesspiece[j].getX()+half;
				 int pieceY=chesspiece[j].getY()+half;
				 if (pieceY - chessY >=-5 && pieceY - chessY <=5 && chesspiece[j].getName()!=chess.getName() && chesspiece[j].isVisible()){
						//����㵽�յ�(������)
						for (int k= chessX+60;k<eX;k+=60){
							//������㡢С���յ������Ϳ���֪���м��Ƿ�������
							if (pieceX < eX && pieceX > chessX){
								//�м���һ�����ӾͲ����Դ������߹�ȥ
								Move++;
								break;
								}
							}//for
						//����㵽�յ�(���ҵ���)
						for (int k=eX+60;k<chessX;k+=60){
							//�������յ������
							if (pieceX > eX && pieceX < chessX){
								Move++;
								break;
								}
							}//for
						}
				 }
//			 System.out.println(count);
			 //�м�û�����ӣ������ƶ�
			 for(int i=70;i<=560;i+=60){
				 if (Move == 0 && (eX-i) >=-5 && (eX-i) <=5){
					 chess.setBounds(eX-half,chessY-half,55,55); 
					 break;
					 }
				 }
			 }		 
		 }
	 
	 /** ��,���������   */
	 public void cannonEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 System.out.println(chessX1+"  "+chessY1);
//		 System.out.println(chessX2+"  "+chessY2);
		 int count = 0;
		 for (int j=0;j<32;j++){
			 int pieceX=chesspiece[j].getX()+half;
			 int pieceY=chesspiece[j].getY()+half;
			 /*   ���³���    */
			 if (pieceX - chessX1>=-5 && pieceX - chessX1<=5 && chesspiece[j].getName()!=chess1.getName() && chesspiece[j].isVisible()){
					//chess1���(���ϵ���)
					for (int k=chessY1+60;k<chessY2;k+=60){
						if (chessY1 < chessY2 && pieceY > chessY1 && pieceY <chessY2){
								//���������յ��м��������
								count++;			
								break;							
						}
					}//for								
					//���µ���
					for (int k=chessY2+60;k<chessY1;k+=60){
						if (chessY2 < chessY1 && pieceY > chessY2 && pieceY <chessY1){
								count++;			
								break;							
						}
					}//for	
					
				}//if
			 
			 /*   ���ҳ���     */
			 else if (pieceY - chessY1>=-5 &&  pieceY - chessY1<=5 && chesspiece[j].getName()!=chess1.getName() && chesspiece[j].isVisible()){
					//chess1���(������)
					for (int k=chessX1+60;k<chessX2;k+=60){
						if (chessX1 < chessX2 && pieceX > chessX1 && pieceX<chessX2){
								count++;			
								break;							
						}
					}//for								
					//���ҵ���
					for (int k=chessX2+60;k<chessX1;k+=60){
						if (chessX2 < chessX1 && pieceX > chessX2 && pieceX<chessX1){
								count++;			
								break;							
						}
					}//for	
				}//if	
			 }	
		    if(chessX1-chessX2>=-5 && chessX1-chessX2<=5 ||chessY1-chessY2>=-5 && chessY1-chessY2<=5){
			//������
			 if(chess1.getName().charAt(1)== '��' && count==0 && chess2.getName().charAt(0) != chess1.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
			 }	 
			 //�ڳ���
			 else if(chess1.getName().charAt(1)== '��'&& count==1 && chess2.getName().charAt(0) != chess1.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
			 }
		    }		
	 }
	 
	 
	 /** ���ƶ����� : ������  ,8������  */
	 public void horseMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 int Move=0;			
		 boolean tag=false;
		 /* ���ơ���ߣ������ƶ�������һ�� */
		 if (chessX - eX >= 55 && chessX - eX <= 65 && chessY - eY >= 115 && chessY - eY <= 125){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  ���ơ��ұ�   */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && chessY - eY >= 115 && chessY -eY <= 125){

			 System.out.println(Move);
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
			
		 /* ���ơ��ϱ� */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && chessY - eY >= 55 && chessY -eY <= 65){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && chessX - pieceX >=55 && chessX - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			}
		 
		 
		 /*  ���ơ��ϱ�   */
		 else if (eX-chessX >= 115 && eX-chessX<= 125 && chessY - eY >= 55 && chessY - eY <= 65){
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && pieceX - chessX >=55 && pieceX - chessX <= 65){
//					 System.out.println(pieceX+" "+pieceY);
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }		 
		 
		 /* ���ơ����  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY>= 115 && eY - chessY <= 125){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && pieceY - chessY>=55 && pieceY - chessY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  ���ơ��ұ�   */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && eY - chessY >= 115 && eY - chessY <= 125){

			 System.out.println(Move);
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && pieceY - chessY>=55 && pieceY - chessY <= 65){
					 Move = 1;
					 break;
					 }
				 } 		
			 tag=true;
			 }
			
		 /* ���ơ��±� */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && eY - chessY>= 55 && eY - chessY <= 65){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && chessX - pieceX >=55 && chessX - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			}
		 
		 /*  ���ơ��±�   */
		 else if (eX - chessX >= 115 && eX - chessX <= 125 && eY - chessY >= 55 && eY - chessY <= 65){
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessY - pieceY>=-5 && pieceX - chessX >=55 && pieceX - chessX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
			
		 //�����ƶ�������
		 if (Move == 0 && tag){
			 chess.setBounds(eX-half,eY-half,55,55);
			 }
			
		}

	 
	 /**  ��������    */
	 public void horseEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 System.out.println(chessX1 + " " + chessY1);
//		 System.out.println(chessX2 + " " + chessY2);
		 
		 int Move=0;			
		 boolean tag=false;
		 
		 /* ���ơ���ߣ������ƶ�������һ�� */
		 if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 		
			 tag=true;
			}
		 
		 /*  ���ơ��ұ�   */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY1 - chessY2 >= 115 && chessY1 -chessY2 <= 125){
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
			
		 /* ���ơ��ϱ� */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY1 - chessY2 >= 55 && chessY1 -chessY2 <= 65){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && chessX1 - pieceX >=55 && chessX1 - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 
		 /*  ���ơ��ϱ�   */
		 else if (chessX2-chessX1 >= 115 && chessX2-chessX1<= 125 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && pieceX - chessX1 >=55 && pieceX - chessX1 <= 65){
					 System.out.println(pieceX+" "+pieceY);
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }		 
		 
		 /* ���ơ����  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1>= 115 && chessY2 - chessY1 <= 125){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && pieceY - chessY1>=55 && pieceY - chessY1 <= 65){
					 Move = 1;
					 break;
					 }
				 }
			 tag=true;
			}
		 
		 /*  ���ơ��ұ�   */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){

			 System.out.println(Move);
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && pieceY - chessY1>=55 && pieceY - chessY1 <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
			
		 /* ���ơ��±� */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY2 - chessY1>= 55 && chessY2 - chessY1 <= 65){
			//��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && chessX1 - pieceX >=55 && chessX1 - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  ���ơ��±�   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1 <= 125 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 //��ǰ���Ƿ��б������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessY1 - pieceY>=-5 && pieceX - chessX1 >=55 && pieceX - chessX1 <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
		 
		 //����
//		 
		 if(tag && Move==0 && chess1.getName().charAt(0)!= chess2.getName().charAt(0)){
			 //System.out.println(Move);
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half,chessY2-half, 55, 55);
		 }
		 
	 }
	 
	 
	 /** �ࣨ���ƶ�����   : �����ҽ����ڱ����� */
	 public void elephantMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 int Move=0;			
		 boolean tag=false;
		 /* ���ơ���ߣ������ƶ����������� */
		 if (chessX - eX >= 115 && chessX - eX <= 125 && chessY - eY >= 115 && chessY - eY <= 125){
			//�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=55 && chessX - pieceX<=65 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /* ���ơ����   */
		 else if (eX - chessX >= 115 && eX - chessX <= 125 && chessY - eY >= 115 && chessY - eY <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX>=55 && pieceX - chessX<=65 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* ���ơ��ұ�   */
		 else if (eX - chessX >= 115 && eX - chessX<= 125 && eY - chessY >= 115 && eY - chessY <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=55 && chessX - pieceX<=65 && pieceY - chessY >=55 && pieceY - chessY<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* ���ơ����   */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && eY - chessY >= 115 && eY - chessY <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX>=55 && pieceX - chessX<=65 && pieceY - chessY >=55 && pieceY - chessY<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
//		 System.out.println(Move+" "+tag);
		 //����
		 if(chess.getName().charAt(0)=='��' && eY<=335 && tag && Move==0){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//����
		 if(chess.getName().charAt(0)=='��' && eY>=395 && tag && Move==0){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
	 }
	 

	 /** �ࣨ�󣩳������   */
	 public void elephantEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 //��ȡ�������ڵ�λ��
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 int Move=0;			
		 boolean tag=false;
		 /* ���ơ���ߣ������ƶ����������� */
		 if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			//�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=55 && chessX1 - pieceX<=65 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /* ���ơ����   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1 <= 125 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX1>=55 && pieceX - chessX1<=65 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* ���ơ��ұ�   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1<= 125 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=55 && chessX1 - pieceX<=65 && pieceY - chessY1 >=55 && pieceY - chessY1<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* ���ơ����   */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){
			 //�Խ��ߴ��Ƿ�������
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX1>=55 && pieceX - chessX1<=65 && pieceY - chessY1 >=55 && pieceY - chessY1<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
//		 System.out.println(Move+" "+tag);
//		 System.out.println(chess1.getName().charAt(0)+" "+ chess2.getName().charAt(0));
		 //����
		 if((chess1.getName().charAt(0)!= chess2.getName().charAt(0)) && chess1.getName().charAt(0)=='��' && chessY2<=335 && tag && Move==0){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//����
		 else if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='��' && chessY2>=395 && tag && Move==0){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
	 }
	 
	 
	 /** ʿ�ƶ�����  : �Ź���б�����ߣ������� */
	 public void officerMoveRule(JLabel chess, MouseEvent e){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 boolean tag=false;
		 /* ���ϣ������ƶ�һ����һ�� */
		 if (chessX - eX >= 55 && chessX - eX <= 65 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			}
		 
		 /* ����  */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			 }
		 
		 /* ����  */
		 else if (eX - chessX >= 55 && eX - chessX<= 65 && eY - chessY >= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 /* ����  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY >= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 //����
		 if(chess.getName().charAt(0)=='��' && eX>=245 && eX<=375 && eY>=85 && eY<=205 && tag){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//����
		 if(chess.getName().charAt(0)=='��' && eX>=245 && eX<=375 && eY>=505 && eY<=635 && tag){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }		 
	 }
	 
	 /** ʿ�������   */
	 public void officerEatRule(JLabel chess1, JLabel chess2){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 boolean tag=false;
		 /* ���ϣ������ƶ�һ����һ�� */
		 if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			}
		 
		 /* ����  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			 }
		 
		 /* ����  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1<= 65 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 /* ����  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 //����
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='��'
				 && chessX2>=245 && chessX2<=375 && chessY2>=85 && chessY2<=205 && tag){	
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//����
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='��' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=505 && chessY2<=635 && tag){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }		 
	 }
	 
	 
	 /** ����˧�ƶ�����  : �Ź���ֱ������һ�� */
	 public void chiefMoveRule(JLabel chess, MouseEvent e){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //��ȡ�������λ��
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 boolean tag=false;
		 /* ��  */
		 if (chessX - eX >= -5 && chessX - eX <= 5 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			}
		 
		 /* �� */
		 else if (eX - chessX >= -5 && eX - chessX <= 5 && eY - chessY>= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 /* ��  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY >= -5 && eY - chessY <= 5){
			 tag=true;
			 }
		 
		 /* ��  */
		 else if (eX - chessX >= 55 && eX - chessX<= 65 && eY - chessY >= -5 && eY - chessY <= 5){
			 tag=true;
			 }		
		 
		 //����
		 if(chess.getName().charAt(0)=='��' && eX>=245 && eX<=375 && eY>=85 && eY<=205 && tag){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//����
		 if(chess.getName().charAt(0)=='��' && eX>=245 && eX<=375 && eY>=505 && eY<=635 && tag){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }		 
	 }
	 
	 /** ����˧�ƶ�����  : �Ź���ֱ������һ�� */
	 public void chiefEatRule(JLabel chess1, JLabel chess2){
		 //��ȡ��ǰ�������ڵ�λ��
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 
		 boolean tag=false;
		 /* ��  */
		 if (chessX1 - chessX2 >= -5 && chessX1 - chessX2 <= 5 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			}
		 
		 /* �� */
		 else if (chessX2 - chessX1 >= -5 && chessX2 - chessX1 <= 5 && chessY2 - chessY1>= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 /* ��  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1 >= -5 && chessY2 - chessY1 <= 5){
			 tag=true;
			 }
		 
		 /* ��  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1<= 65 && chessY2 - chessY1 >= -5 && chessY2 - chessY1 <= 5){
			 tag=true;
			 }		
		 
		 //����
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='��' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=85 && chessY2<=205 && tag){	
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//����
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='��' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=505 && chessY2<=635 && tag){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }		 
	 }
}

