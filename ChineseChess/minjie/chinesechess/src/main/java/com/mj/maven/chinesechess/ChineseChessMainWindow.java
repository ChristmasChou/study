package com.mj.maven.chinesechess;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mj.maven.exceptions.InvalidChoosenCommand;
/**
*@auther minjie 
*@E-mail jie_min_jimmy@163.com
*@version 创建时间：2017年12月10日
**/

public class ChineseChessMainWindow implements ActionListener{

	private JFrame mainFrame;
	private JPanel gameModeChoosenPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChineseChessMainWindow mainWindow = new ChineseChessMainWindow();
					mainWindow.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChineseChessMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setMainFrame();
		
		//添加主界面的背景图
		addBackground();
		
		//添加游戏选项
		addGameModeChoosenPanel();
		addBattelToComputerButton();
		addBattelToPlayerButton();
		addSetUpButton();
		addHelpButton();
	}

	private void setMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setTitle("中国象棋v1.0");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setBounds(200, 50, 1100, 750);
		mainFrame.setResizable(false);
	}
	
	private void addBackground() {
		ImageIcon img=new ImageIcon("src/main/resources/images/background.jpg");
		JLabel imageLabel=new JLabel(img);
		imageLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		mainFrame.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
	//	System.out.println(img.getIconWidth());
	//	System.out.println(img.getIconHeight());
		Container cp=mainFrame.getContentPane();
		((JPanel)cp).setOpaque(false);
	}

	private void addGameModeChoosenPanel() {
		gameModeChoosenPanel = new JPanel();
		gameModeChoosenPanel.setOpaque(false);
		gameModeChoosenPanel.setBounds(53, 428, 216, 244);
		mainFrame.getContentPane().add(gameModeChoosenPanel);
		gameModeChoosenPanel.setLayout(new GridLayout(4, 1, 0, 0));
	}
	
	private void addBattelToComputerButton() {
		JButton battelToComputerButton = new JButton("对战电脑");
		battelToComputerButton.setFont(new Font("宋体", Font.BOLD, 18));
		battelToComputerButton.setBackground(Color.LIGHT_GRAY);
		battelToComputerButton.setOpaque(false);
		battelToComputerButton.setBorder(null);
		battelToComputerButton.addActionListener(this);
		gameModeChoosenPanel.add(battelToComputerButton);
	}
	
	private void addBattelToPlayerButton() {
		JButton battelToPlayerButton = new JButton("双人对战");
		battelToPlayerButton.setFont(new Font("宋体", Font.BOLD, 18));
		battelToPlayerButton.setBackground(Color.LIGHT_GRAY);
		battelToPlayerButton.setOpaque(false);
		battelToPlayerButton.setBorder(null);
		battelToPlayerButton.addActionListener(this);
		gameModeChoosenPanel.add(battelToPlayerButton);		
	}
	
	private void addSetUpButton() {
		JButton setUpButton = new JButton("设置");
		setUpButton.setFont(new Font("宋体", Font.BOLD, 18));
		setUpButton.setBackground(Color.LIGHT_GRAY);
		setUpButton.setOpaque(false);
		setUpButton.setBorder(null);
		setUpButton.addActionListener(this);
		gameModeChoosenPanel.add(setUpButton);		
	}
	
	private void addHelpButton() {
		JButton helpButton = new JButton("帮助");
		helpButton.setFont(new Font("宋体", Font.BOLD, 18));
		helpButton.setBackground(Color.LIGHT_GRAY);
		helpButton.setOpaque(false);
		helpButton.setBorder(null);
		helpButton.addActionListener(this);
		gameModeChoosenPanel.add(helpButton);		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		switch(e.getActionCommand()){
		case "对战电脑":
			//to do
			break;
		case "双人对战":
			startBattleToPlayerWindow();
			break;
		case "设置":
			//to do
			break;
		case "帮助":
			//to do
			break;
		default:
			try {
				throw new InvalidChoosenCommand("该选择还未完成");
			} catch (InvalidChoosenCommand e1) {
				e1.printStackTrace();
			}
		}
	}

	private void startBattleToPlayerWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleToPlayerWindow battleToPlayerwindow = new BattleToPlayerWindow();
					battleToPlayerwindow.getBattleToPlayerFrame().setVisible(true);
					mainFrame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

}
