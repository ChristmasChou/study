package zh;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ChessRule {

	//���������ƶ�����
	public void armsRule(int Man, JLabel play, MouseEvent me) {
		//�������£�ÿһ���Ĵ�С��57����
		if (Man < 21){
			//�����ƶ����õ��յ������ģ���ɺϷ�������
			if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){
				play.setBounds(play.getX(),play.getY()+57,55,55);
			}
			
			//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������				
			else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);	
			}
			
			//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
			else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58){
				//ģ������
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
		
		//�������ϣ�ÿһ���Ĵ�С��57����
		else{
			
			//�����ƶ����õ��յ������ģ���ɺϷ�������
			if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86){
				play.setBounds(play.getX(),play.getY()-57,55,55);
			}
			
			//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
			else if (play.getY() <= 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);
			}				
			
			//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
			else if (play.getY() <= 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58){
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
	}//���ƶ�����
    
	//������������,play2�Ǳ��Ե�����
	public void armsRule(JLabel play1, JLabel play2) {
		//������,��Ҫ��������ֻ�ܳԵ����ڵ����ӣ��Ҳ��ܳ��Լ��ҵ�����
		if ((play2.getX() - play1.getX()) <= 112 && (play2.getX() - play1.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//����Ҫ���Ӳ����ҳ���
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
                //����ʵ�����öԷ������ӡ�����
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//����Ҫ���Ӳ����ܳ���
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//������
		else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//����Ҫ���Ӳ��������
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//����Ҫ���Ӳ����ҳ���
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//������
		else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112){
			//���岻�����ϳ���
			if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//���岻�����³���
			else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//�ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}			
		}	
	}//��������
    
}
