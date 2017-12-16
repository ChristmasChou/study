
/**
 * ������¼�
 *
 */

package zf.chinesechess;

import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MouseClickedEvent implements MouseListener{
    ChessRule rule;
    Object[] para;//������������ڷ���

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
	public Object[] mouseClicked(MouseEvent e, ChessPiece chess, JLabel hint, int index, int chessClick, boolean isClick)
	{
		para = new Object[3];
		rule = new ChessRule();
		
		//���ӵ�λ��
		int chessX,chessY;;
		
		//������λ��
		int eX=e.getX();
		int eY=e.getY();
		
		/**   ��������(�ƶ�����)  */
		if (!(e.getSource()instanceof JLabel)){
			/*  �ú��������ʱ��   */
			System.out.println("�������");
			if (chessClick == 2 && chess.chesspiece[index].getName().charAt(0) == '��'){		
				chessX = chess.chesspiece[index].getX();
				chessY = chess.chesspiece[index].getY();
				//�ƶ��䡢��
				if (index > 15 && index < 26){
					rule.soldierMoveRule(chess.chesspiece[index],e);
				}			
				
				//�ƶ���
				else if (index > 25 && index < 30){			
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//�ƶ���
				else if (index >=0 && index < 4){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//�ƶ���
				else if (index > 3 && index < 8){
					rule.horseMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//�ƶ��ࡢ��
				else if (index > 7 && index < 12){
					rule.elephantMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//�ƶ��ˡ�ʿ
				else if (index > 11 && index < 16){
					rule.officerMoveRule(chess.chesspiece[index],e);
				}
				
				//�ƶ�����˧
				else if (index == 30 || index == 31){				
					rule.chiefMoveRule(chess.chesspiece[index],e);
				}
				
				//�Ƿ��������(�Ƿ���ԭ��û�ж�)
				if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
					hint.setText("     ��������");
					chessClick=2;
				}
				
				else {
					hint.setText("     ��������");
					chessClick=1;
				}					
				isClick=false;
			}//if
			
			/*  �ú��������ʱ��   */
			else if (chessClick == 1 && chess.chesspiece[index].getName().charAt(0) == '��'){
				chessX = chess.chesspiece[index].getX();
				chessY = chess.chesspiece[index].getY();
				//�ƶ��䡢��
				if (index > 15 && index < 26){
					rule.soldierMoveRule(chess.chesspiece[index],e);
					}

				//�ƶ���
				else if (index > 25 && index < 30){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
				
				//�ƶ���
				else if (index >=0 && index < 4){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
				
				//�ƶ���
				else if (index > 3 && index < 8){
					rule.horseMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
					
				//�ƶ��ࡢ��
				else if (index > 7 && index < 12){
					rule.elephantMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
					
				//�ƶ��ˡ�ʿ
				else if (index > 11 && index < 16){
					rule.officerMoveRule(chess.chesspiece[index],e);
					}
					
				//�ƶ�����˧
				else if (index == 30 || index == 31){
					rule.chiefMoveRule(chess.chesspiece[index],e);
					}
					
				//�Ƿ��������(�Ƿ���ԭ��û�ж�)
				if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
					hint.setText("     ��������");
					chessClick=1;
					}
				
				else {
					hint.setText("     ��������");
					chessClick=2;
					}					
			}//else if		
			isClick=false;
		}//if
		
		/**  ��������     */
		else{			
			//��һ�ε�������(��˸����)
			if (!isClick){
				System.out.println("��һ�ε������");
				int i;
				for (i=0;i<32;i++){					
					//������������
					if (e.getSource().equals(chess.chesspiece[i])){
						//�����߳��ø�������˸
						//��ǰ�ú�����,������Ҳ�Ǻ���
						if(chessClick==2 && chess.chesspiece[i].getName().charAt(0)=='��'){
							index=i;
							//��ʼ��˸
							isClick=true;
						}
						else if(chessClick==1 && chess.chesspiece[i].getName().charAt(0)=='��'){
							index=i;
							//��ʼ��˸
							isClick=true;
						}
						break;
					}
				}//for
			//	System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+1);
			}//if				
			
			//�ڶ��ε�������(������)
			else if (isClick){
				System.out.println("�ڶ��ε������");
				for (int i=0;i<32;i++){
					//�ҵ����Ե�����
					//System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+2);
					if (e.getSource().equals(chess.chesspiece[i])){						
					//	System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+isClick);
						//�ú�������ʱ��
						if (chessClick == 2 && chess.chesspiece[index].getName().charAt(0) == '��'){
							chessX = chess.chesspiece[index].getX();
							chessY = chess.chesspiece[index].getY();							
							//�䡢���Թ���
							if (index > 15 && index < 26){
								rule.soliderEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//�ڳԹ���
							else if (index > 25 && index < 30){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//���Թ���
							else if (index >=0 && index < 4){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//��Թ���
							else if (index > 3 && index < 8){
								rule.horseEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);	
							}
							
							//�ࡢ��Թ���
							else if (index > 7 && index < 12){
								rule.elephantEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//ʿ���˳������
							else if (index > 11 && index < 16){
								rule.officerEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//����˧�������
							else if (index == 30 || index == 31){
								rule.chiefEatRule(chess.chesspiece[index],chess.chesspiece[i]);
								chess.chesspiece[index].setVisible(true);	
							}
							
							//�Ƿ��������(�Ƿ���ԭ��û�ж�)
							if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
								hint.setText("     ��������");
								chessClick=2;
								}
							
							else {
								hint.setText("     ��������");
								chessClick=1;
								}
							
						}//if
						
						//�ú�������ʱ��
						else if (chessClick == 1 && chess.chesspiece[index].getName().charAt(0) == '��'){
							chessX = chess.chesspiece[index].getX();
							chessY = chess.chesspiece[index].getY();							
							//�䡢���Թ���
							if (index > 15 && index < 26){
								rule.soliderEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//�ڳԹ���
							else if (index > 25 && index < 30){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//���Թ���
							else if (index >=0 && index < 4){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//��Թ���
							else if (index > 3 && index < 8){
								rule.horseEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);	
							}
							
							//�ࡢ��Թ���
							else if (index > 7 && index < 12){
								rule.elephantEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//ʿ���˳������
							else if (index > 11 && index < 16){
								rule.officerEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//����˧�������
							else if (index == 30 || index == 31){
								rule.chiefEatRule(chess.chesspiece[index],chess.chesspiece[i]);
								chess.chesspiece[index].setVisible(true);	
							}
							
							//�Ƿ��������(�Ƿ���ԭ��û�ж�)
							if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
								hint.setText("     ��������");
								chessClick=1;
								}
							
							else {
								hint.setText("     ��������");
								chessClick=2;
								}
							
						}//else if

						//��ǰû�в���(ֹͣ��˸)
						isClick=false;
					}//if
					
				}//for
				
				
				//�Ƿ�ʤ��
				if (!chess.chesspiece[31].isVisible()){
					JOptionPane.showConfirmDialog(
						null,"����ʤ��","��ϲ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//˫������������������
					chessClick=3;
//					text.setText("  ����ʤ��");
					
				}//if 

				else if (!chess.chesspiece[30].isVisible()){
					JOptionPane.showConfirmDialog(
						null,"����ʤ��","��ϲ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					chessClick=3;
//					text.setText("  ����ʤ��");
				}//else if					
			}//else			
		}//else		
		para[0]=index;
		para[1]=chessClick;
		para[2]=isClick;
		return para;
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
