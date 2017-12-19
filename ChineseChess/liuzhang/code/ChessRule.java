package lz.ChineseChess;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ChessRule {
	//���䡢����ƶ�����,����ʵ���ƶ������ؾ���ķ�Χȷ���ƶ����ĵ�
	public void soldiesMoveRule(int i,JLabel chess,MouseEvent me){
		//����
		if(i>10 && i<16){
			//����
			if((me.getY()-chess.getY()) > 27 
					&& (me.getY()-chess.getY()) < 86 
					&& (me.getX()-chess.getX()) < 55 
					&& (me.getX()-chess.getX() > 0)){
				chess.setBounds(chess.getX(),chess.getY()+57,55,55);
			}//�������ң��������
			else if(chess.getY()>284 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//�������󣬱������
			else if(chess.getY()>284 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}
		
		//���
		else if(i>26 && i<32){
			//����
			if((chess.getY()-me.getY())>27 
					&& (chess.getY()-me.getY()) < 86 
					&& (me.getX()-chess.getX()) >= 0 
					&& (me.getX()-chess.getX()) <= 55 ){
				chess.setBounds(chess.getX(), chess.getY()-57, 55, 55);
			}//������ң��������
			else if(chess.getY()<341 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//������󣬱������
			else if(chess.getY()<341 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}	
	}
	
	///���䡢����Թ���
	public void soldiesKillRule(JLabel chess1, JLabel chess2){
		//���ҳ���
		if ((chess2.getX()-chess1.getX()) <= 112 
				&& (chess2.getX()-chess1.getX()) >= 57 
				&& (chess1.getY() - chess2.getY()) < 22 
				&& (chess1.getY() - chess2.getY()) > -22 
				&& chess2.isVisible() 
				&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//����������ҳ���
			if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
				//�Ǳ��Ե����ӡ���ʧ�����ú��ó������ŵ����Ե����ӵ�λ��
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}//����������ҳԺ���
			else if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//���������
		else if ((chess1.getX()-chess2.getX()) <= 112 
				&& (chess1.getX()-chess2.getX()) >= 57 
				&& (chess1.getY()-chess2.getY()) < 22 
				&& (chess1.getY()-chess2.getY()) > -22 
				&& chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//����Ҫ���Ӳ�����Ժ���
			if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//����Ҫ���Ӳ��������
			else if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//�������³Ժ��壬�������ϳԺ���
		else if (chess1.getX() - chess2.getX() >= -22 
				&& chess1.getX() - chess2.getX() <= 22 
				&& chess1.getY() - chess2.getY() >= -112 
				&& chess1.getY() - chess2.getY() <= 112){
			//�������³Ժ���
			if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() < chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//�������ϳԺ���
			else if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() > chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}	
		}
	}
}
