package lz.ChineseChess;

import java.awt.Container;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessPiece {
	//ʹ��i��k���������Ӱڷŵ�������
	int i;
	int k;
	//����ͼ��
	Icon in;
	//���ӵĹ��캯����ʼ������λ��,����ÿ�����ӵ�λ����ͨ�����̴�С�����Ӵ�С��������ģ�ÿһ���������57
	public ChessPiece(Container con,JLabel[] chess){
		//��------����-------��
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"�ڳ�.gif");
		for(i=0, k=24;i<2;i++,k+=456){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("�ڳ�"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=2, k=81;i<4;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("����"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=4, k=138;i<6;i++,k+=228){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("����"+i);
		}
		//ʿ
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"��ʿ.gif");
		for(i=6, k=195;i<8;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("��ʿ"+i);
		}
		//�� 
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"�ڽ�.gif");
		chess[8] = new JLabel(in);
		con.add(chess[8]);
		chess[8].setBounds(252,56,55,55);
		chess[8].setName("�ڽ�"+8);
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=9, k=81;i<11;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,170,55,55);
			chess[i].setName("����"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=11, k=24;i<16;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,227,55,55);
			chess[i].setName("����"+i);
		}
		//��------����------��
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"�쳵.gif");
		for(i=16, k=24;i<18;i++,k+=456){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("�쳵"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=18, k=81;i<20;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("����"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=20, k=138;i<22;i++,k+=228){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("����"+i);
		}
		//ʿ
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"��ʿ.gif");
		for(i=22, k=195;i<24;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("��ʿ"+i);
		}
		//˧
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"�콫.gif");
		chess[24] = new JLabel(in);
		con.add(chess[24]);
		chess[24].setBounds(252,569,55,55);
		chess[i].setName("��˧"+24);
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=25, k=81;i<27;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,455,55,55);
			chess[i].setName("����"+i);
		}
		//��
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"����.gif");
		for(i=27, k=24;i<32;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,398,55,55);
			chess[i].setName("���"+i);
		}
		/*
		 * chess�е����ӷֲ�Ϊ{0�ڳ�0��1�ڳ�1��2����2��3����3��4����4��5����5��6��ʿ6��7��ʿ7��8�ڽ�8��9����9��10����10��11����11��12����12��13����13��14����14��15����15
		 *                  16�쳵16��17�쳵17��18����18��19����19��20����20��21����21��22��ʿ22��23��ʿ23��24��˧24��25����25��26����26��27���27��28���28��29���29��30���30��31���31}
		 */
	}
}
