package com.java.matchman;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MatchMan extends JFrame{
	/**
	 * Ϊ�˷�����ı���ֵ
	 */
	public JTextField[] matchManAngles1;
	/**
	 * Ϊ�˷�����ı���ֵ
	 */
	public JTextField[] matchManAngles2;
	/**
	 * ���浱ǰ��Ҫ�ı��Matchstick
	 */
	public Matchstick matchstick;
	/**
	 * ���ֱ�ߵİ��᳤
	 */
	public int testLineWidth = 8;
	/**
	 * ��ת�������
	 */
	public int rotateDirection = 0;
	/**
	 * ���ڿ����ƶ���ͷ
	 */
	public Head head;
	/**
	 * ����ѡ���ĸ���
	 */
	public int chooseMan;
	/**
	 * ����ı���
	 */
	JTextArea showDateTextArea = null;

	private static final long serialVersionUID = 1L;
	/**
	 * ��������,�������
	 */
	public Man widthman1;
	public Man widthman2;
	public Man[] widthMan;
	/**
	 * �����ṩȫ�ֵ������޸ģ���Ҫ�ǰ������ʱ��Ĳ�������
	 */
	Matchstick[] matchsticks;
	/**
	 * ���ű�־
	 */
	public boolean movieFlag;
	/**
	 * ��������Ҫ�����ж���
	 */
	public ArrayList<double[]> actionArrays;
	/**
	 * �������,�������ʱʹ��
	 */
	public int counter = 0;
	/**
	 * ���������
	 */
	public int frameCounter = 0;
	public Man movieMan = new Man(1024/2-250, 768/2);
	public MatchMan() {
		
		widthman1 = new Man(1024/2-400, 768/2);
		widthman2 = new Man(1024/2-100, 768/2);
		double[] angles1 = {-176, 72.0, 30.0, 72.0, -30.0, -72.0, 30.0, -171, -132, -30.0, 30.0};
		double[] angles2 = {-176, 72.0, 30.0, 72.0, -30.0, -72.0, 30.0, -171, -132, -30.0, 30.0};
		widthman1.changedAngle(Man.FOOT_HEAD, 0, angles1);
		widthman2.changedAngle(Man.FOOT_HEAD, 0, angles2);
		widthman1.changedAngle(Man.FOOT_HEAD, 11, 30);
		widthMan = new Man[]{widthman1,widthman2};
		//Ĭ�ϲ���widthman1
		matchsticks = widthman1.matchsticks;
		actionInit();
//		for (int i = 0; i < widthman1.matchsticks.length; i++) {
//			System.out.print(widthman1.matchsticks[i].angle+"\t");
//		}
//		System.out.println();
		addMatchManJPanel();
		addRightJPanel();
		setJFrame();
	}
	private void actionInit() {
		actionArrays = new ArrayList<double[]>();
		double[] angles0 = {-176.0, 72.0, 30.0, 72.0, -30.0, -72.0, 30.0, -171.0, -132.0, -30.0, 30.0};
		double[] angles1 = {-176.0, 72.0, 43.2, 72.0, -30.0, -72.0, 30.0, -171.0, -132.0, -30.0, 30.0};
		double[] angles2 = {-176.0, 72.0, 58.57043438516149, 72.0, -45.97102193107917, -72.0, 30.0, -154.72227776444703, -132.0, -61.260204708311974, 30.0};
		double[] angles3 =  {-176.0, 72.0, 78.11134196037203, 81.02737338510362, -57.99461679191652, -72.0, 30.0, -138.81407483429035, -132.0, -61.260204708311974, -8.583621480113925};
		double[] angles4 =   {-176.0, 88.63607246839709, 90.0, 101.30993247402021, -72.64597536373867, -72.0, 30.0, -103.09189306434685, -96.3401917459099, -59.036243467926475, -62.7004277886672};
		double[] angles5 =  {353.6598082540901, 88.63607246839709, 90.0, 101.30993247402021, -72.64597536373867, -72.0, -163.30075576600638, -103.09189306434685, -110.13630342824814, -59.036243467926475, -49.39870535499554};
		double[] angles6 = {353.6598082540901, 88.63607246839709, 90.0, 100.56101069119637, -58.62699485989154, -53.53076560994813, -163.30075576600638, -103.09189306434685, -131.6335393365702, -48.65222278030633, -74.35775354279127};
		double[] angles7 = {353.6598082540901, 88.63607246839709, 90.0, 100.56101069119637, -19.093492000485607, 45.00000000000001, -60.94539590092286, -120.37912601136834, -165.61860540890942, -20.77225468204584, -97.4314079711725};
		double[] angles8 = {353.6598082540901, 88.63607246839709, 90.0, 113.86017519134235, 23.962488974578182, 45.00000000000001, -60.94539590092286, -120.37912601136834, 158.1985905136482, 23.198590513648202, -63.43494882292201};
		actionArrays.add(angles0);
		actionArrays.add(angles1);
		actionArrays.add(angles2);
		actionArrays.add(angles3);
		actionArrays.add(angles4);
		actionArrays.add(angles5);
		actionArrays.add(angles6);
		actionArrays.add(angles7);
		actionArrays.add(angles8);
	}
	/**
	 * ��������
	 */
	private void addRightJPanel() {
		JPanel rightJPanel = new JPanel();
		rightJPanel.setLayout(new BorderLayout());
		rightJPanel.add(BorderLayout.NORTH, addButton());
		rightJPanel.add(dataJPanel());
		
		add(BorderLayout.EAST, rightJPanel);
	}
	/**
	 * ������
	 * @return
	 */
	private JPanel dataJPanel() {
		JPanel dataJPanel = new JPanel();
		dataJPanel.setLayout(new GridLayout(17, 3, 2, 2));
		addLabelAndTextField(dataJPanel);
		return dataJPanel;
	}
	/**
	 * �������
	 * @return
	 */
	private JPanel addButton() {
		JPanel buttonJPanel = new JPanel(new BorderLayout());
		JPanel changeJPanel = new JPanel();
		JPanel getSetJPanel = new JPanel();
		
		JButton no_1 = new JButton("No.1");
		JButton no_2 = new JButton("No.2");
		JButton setAngle = new JButton("setAngle");
		JButton getAngle = new JButton("getAngle");
		JButton movie = new JButton("movie");
		JButton saveFile = new JButton("saveFile");
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String string = ((JButton)e.getSource()).getText();
				if ("No.1".equals(string)) {
					movieFlag = false;
					chooseMan = 0;
					matchsticks = widthMan[chooseMan].matchsticks;
				}else if ("No.2".equals(string)) {
					movieFlag = false;
					chooseMan = 1;
					matchsticks = widthMan[chooseMan].matchsticks;
				}else if ("setAngle".equals(string)) {
					movieFlag = false;
					setAngle();
				}else if ("getAngle".equals(string)) {
					movieFlag = false;
					getAngle();
				}else if ("movie".equals(string)) {
					movieFlag = true;
				}else if ("saveFile".equals(string)) {
					saveFile();
				}
			}		
		};
		no_1.addMouseListener(mouseAdapter);
		no_2.addMouseListener(mouseAdapter);
		setAngle.addMouseListener(mouseAdapter);
		getAngle.addMouseListener(mouseAdapter);
		movie.addMouseListener(mouseAdapter);
		saveFile.addMouseListener(mouseAdapter);
		
		changeJPanel.add(no_1);
		changeJPanel.add(no_2);
		getSetJPanel.add(setAngle);
		getSetJPanel.add(getAngle);
		changeJPanel.add(saveFile);
		getSetJPanel.add(movie);
		buttonJPanel.add(BorderLayout.NORTH, changeJPanel);
		buttonJPanel.add(BorderLayout.SOUTH, getSetJPanel);
		return buttonJPanel;
	}
	private void saveFile() {		
		try {
			String string = showDateTextArea.getText();
			if (string.length() > 0) {
				PrintWriter printWriter = new PrintWriter("/home/soft1/AnglesFile.txt");	
				printWriter.write(string);
				printWriter.flush();
				printWriter.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	private void setAngle() {
		double[] angle1 = new double[widthman1.matchsticks.length];
		double[] angle2 = new double[widthman1.matchsticks.length];
		for (int i = 0; i < angle2.length; i++) {
			angle1[i] = Double.parseDouble(matchManAngles1[i].getText());
			angle2[i] = Double.parseDouble(matchManAngles2[i].getText());
		}
		widthman1.changedAngle(Man.FOOT_HEAD, 0, angle1);
		widthman2.changedAngle(Man.FOOT_HEAD, 0, angle2);
	}
	
	/**��ȡ��Ϣ,����ʾ*/
	private void getAngle() {
		/**
		 * ���ڼ���������
		 */
		int firstFootX = 0;
		int firstFootY = 0;
		int secondFootX = 0;
		int secondFootY = 0;
		/**
		 * ���������ַ�
		 */
		StringBuilder stringBuilder = new StringBuilder();
		/**
		 * ��{��Ҫ��Ϊ�˷����ڴ��������ʱ�����ֱ�Ӹ��ơ�ճ��}
		 */
		stringBuilder.append("double[] angles"+counter+" = {");
		String string;
		for (int i = 0; i < widthman1.matchsticks.length; i++) {
			//����Ļ���ϵת�����ѿ������ϵ
			string = Double.toString(-widthman1.matchsticks[i].angle);
			matchManAngles1[i].setText(string);
			stringBuilder.append(string).append(", ");
		}
		stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
		stringBuilder.append("};\n\tNO.1��ͷX,Y���: int[] head"+counter+" = {");
		string = Integer.toString(widthman1.head.headPositionX);
		matchManAngles1[matchManAngles1.length-4].setText(string);
		stringBuilder.append(string+", ");
		
		string = Integer.toString(widthman1.head.headPositionY);
		matchManAngles1[matchManAngles1.length-3].setText(string);
		stringBuilder.append(string+"};\n\tNO.1�����X,Y���: int[] leftFoot"+counter+" = {");
		
		firstFootX = widthman1.matchsticks[0].firstPositionX;
		string = Integer.toString(firstFootX);
		matchManAngles1[matchManAngles1.length-2].setText(string);
		stringBuilder.append(string+", ");
		
		firstFootY = widthman1.matchsticks[0].firstPositionY;
		string = Integer.toString(firstFootY);
		matchManAngles1[matchManAngles1.length-1].setText(string);
		stringBuilder.append(string+"};\n");
		showDateTextArea.append(stringBuilder.toString());
		
		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.append("double[] angles"+counter+"= {");
		for (int i = 0; i < widthman2.matchsticks.length; i++) {
			string = Double.toString(-widthman2.matchsticks[i].angle);
			matchManAngles2[i].setText(string);
			stringBuilder.append(string).append(", ");
		}
		stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
		stringBuilder.append("};\n\tNO.2��ͷX,Y���: int[] head"+counter+" = {");
		string = Integer.toString(widthman2.head.headPositionX);
		matchManAngles2[matchManAngles2.length-4].setText(string);
		stringBuilder.append(string+",  ");
		
		string = Integer.toString(widthman2.head.headPositionY);
		matchManAngles2[matchManAngles2.length-3].setText(string);
		stringBuilder.append(string+"};\n\tNO.2�����X,Y���: int[] leftFoot"+counter+" = {");
		
		secondFootX = widthman2.matchsticks[0].firstPositionX;
		string = Integer.toString(secondFootX);
		matchManAngles2[matchManAngles2.length-2].setText(string);
		stringBuilder.append(string+", ");
		
		secondFootY = widthman2.matchsticks[0].firstPositionY;
		string = Integer.toString(secondFootY);
		matchManAngles2[matchManAngles2.length-1].setText(string);
		stringBuilder.append(string+"};\n\t���������(X,Y): int[] relative = {"+(secondFootX-firstFootX)+", "+(secondFootY-firstFootY)+"};\n\n");
		showDateTextArea.append(stringBuilder.toString());	
		counter++;
	}
	/**
	 * ��ǩ,�ı������
	 * @param jPanel
	 */
	private void addLabelAndTextField(JPanel jPanel) {
		JLabel leftFootLabel = new JLabel("���:", JLabel.CENTER);
		JLabel leftCrusLabel = new JLabel("��С��:", JLabel.CENTER);
		JLabel leftThighLabel = new JLabel("�����:", JLabel.CENTER);
		JLabel trunkLabel = new JLabel("���:", JLabel.CENTER);
		JLabel rightThighLabel = new JLabel("�Ҵ���:", JLabel.CENTER);
		JLabel rightCrusLabel = new JLabel("��С��:", JLabel.CENTER);
		JLabel rightFootLabel = new JLabel("�ҽ�:", JLabel.CENTER);
		JLabel leftArmLabel = new JLabel("��첲:", JLabel.CENTER);
		JLabel leftForearmLabel = new JLabel("��ǰ��:", JLabel.CENTER);
		JLabel rightArmLabel = new JLabel("�Ҹ첲:", JLabel.CENTER);
		JLabel rightForearmLabel = new JLabel("��ǰ��:", JLabel.CENTER);
		JLabel nullLabel = new JLabel("(x,y)", JLabel.CENTER);
		JLabel headLabel1 = new JLabel("1��ͷ:", JLabel.CENTER);
		JLabel headLabel2 = new JLabel("2��ͷ:", JLabel.CENTER);
		JLabel leftFoot1 = new JLabel("1�����:", JLabel.CENTER);
		JLabel leftFoot2 = new JLabel("2�����:", JLabel.CENTER);
		JLabel[] matchManLabels = {leftFootLabel,leftCrusLabel,leftThighLabel,
									trunkLabel,
									rightThighLabel,rightCrusLabel,rightFootLabel,
									leftArmLabel,leftForearmLabel,
									rightArmLabel,rightForearmLabel,
									nullLabel,
									headLabel1,headLabel2,
									leftFoot1,leftFoot2
		};
		

		JTextField leftFootAngle1 = new JTextField(4);
		JTextField leftCrusAngle1 = new JTextField(4);
		JTextField leftThighAngle1 = new JTextField(4);
		JTextField trunkAngle1 = new JTextField(4);
		JTextField rightThighAngle1 = new JTextField(4);
		JTextField rightCrusAngle1 = new JTextField(4);
		JTextField rightFootAngle1 = new JTextField(4);
		JTextField leftArmAngle1 = new JTextField(4);
		JTextField leftForearmAngle1 = new JTextField(4);
		JTextField rightArmAngle1 = new JTextField(4);
		JTextField rightForearmAngle1 = new JTextField(4);
		JTextField nullPosition1 = new JTextField("positionX");
		nullPosition1.setEnabled(false);
		JTextField head1X = new JTextField(4);
		JTextField head1Y = new JTextField(4);
		JTextField leftFoot1X = new JTextField(4);
		JTextField leftFoot1Y = new JTextField(4);
		matchManAngles1 = new JTextField[]{leftFootAngle1,leftCrusAngle1,leftThighAngle1,
											trunkAngle1,
											rightThighAngle1,rightCrusAngle1,rightFootAngle1,
											leftArmAngle1,leftForearmAngle1,
											rightArmAngle1,rightForearmAngle1,
											//nullAngle1,
											head1X,head1Y,
											leftFoot1X,leftFoot1Y
		};
		
		JTextField leftFootAngle2 = new JTextField(4);
		JTextField leftCrusAngle2 = new JTextField(4);
		JTextField leftThighAngle2 = new JTextField(4);
		JTextField trunkAngle2 = new JTextField(4);
		JTextField rightThighAngle2 = new JTextField(4);
		JTextField rightCrusAngle2 = new JTextField(4);
		JTextField rightFootAngle2 = new JTextField(4);
		JTextField leftArmAngle2 = new JTextField(4);
		JTextField leftForearmAngle2 = new JTextField(4);
		JTextField rightArmAngle2 = new JTextField(4);
		JTextField rightForearmAngle2 = new JTextField(4);
		JTextField nullPosition2 = new JTextField("positionY");
		nullPosition2.setEnabled(false);
		JTextField head2X = new JTextField(4);
		JTextField head2Y = new JTextField(4);
		JTextField leftFoot2X = new JTextField(4);
		JTextField leftFoot2Y = new JTextField(4);
		matchManAngles2 = new JTextField[]{leftFootAngle2,leftCrusAngle2,leftThighAngle2,
											trunkAngle2,
											rightThighAngle2,rightCrusAngle2,rightFootAngle2,
											leftArmAngle2,leftForearmAngle2,
											rightArmAngle2,rightForearmAngle2,
											//nullAngle2,
											head2X,head2Y,
											leftFoot2X,leftFoot2Y
		};
		JLabel angleLabel = new JLabel("Parters", JLabel.CENTER);
		JLabel angleLabel1 = new JLabel("angle1:", JLabel.CENTER);
		JLabel angleLabel2 = new JLabel("angle2:", JLabel.CENTER);
		jPanel.add(angleLabel);
		jPanel.add(angleLabel1);
		jPanel.add(angleLabel2);
		for (int i = 0; i < matchManAngles2.length-4; i++) {
			jPanel.add(matchManLabels[i]);
			jPanel.add(matchManAngles1[i]);
			matchManAngles1[i].setHorizontalAlignment(JTextField.CENTER);
			jPanel.add(matchManAngles2[i]);
			matchManAngles2[i].setHorizontalAlignment(JTextField.CENTER);
		}	
		//���´�����Ҫ��Ϊ�˽����ݽṹ�ϵ�һЩ����
		jPanel.add(matchManLabels[matchManAngles2.length-4]);
		jPanel.add(nullPosition1);
		nullPosition1.setHorizontalAlignment(JTextField.CENTER);
		jPanel.add(nullPosition2);
		nullPosition2.setHorizontalAlignment(JTextField.CENTER);
		//ͷ1
		jPanel.add(matchManLabels[matchManAngles2.length-3]);
		jPanel.add(matchManAngles1[matchManAngles1.length-4]);
		head1X.setHorizontalAlignment(JTextField.CENTER);
		jPanel.add(matchManAngles1[matchManAngles1.length-3]);
		head1Y.setHorizontalAlignment(JTextField.CENTER);
		//ͷ2
		jPanel.add(matchManLabels[matchManAngles2.length-2]);
		jPanel.add(matchManAngles2[matchManAngles2.length-4]);
		head2X.setHorizontalAlignment(JTextField.CENTER);
		jPanel.add(matchManAngles2[matchManAngles2.length-3]);
		head2Y.setHorizontalAlignment(JTextField.CENTER);
		//��1
		jPanel.add(matchManLabels[matchManAngles2.length-1]);
		jPanel.add(matchManAngles1[matchManAngles2.length-2]);
		leftFoot1X.setHorizontalAlignment(JTextField.CENTER);
		jPanel.add(matchManAngles1[matchManAngles2.length-1]);
		leftFoot1Y.setHorizontalAlignment(JTextField.CENTER);
		//��2
		jPanel.add(matchManLabels[matchManAngles2.length]);
		jPanel.add(matchManAngles2[matchManAngles2.length-2]);
		leftFoot2X.setHorizontalAlignment(JTextField.CENTER);
		jPanel.add(matchManAngles2[matchManAngles2.length-1]);
		leftFoot2Y.setHorizontalAlignment(JTextField.CENTER);
	}
	private void addMatchManJPanel() {
		MatchManJPanel matchManJPanel = new MatchManJPanel();
		matchManJPanel.start();
		add(BorderLayout.CENTER, matchManJPanel);
		showDateTextArea = new JTextArea(5, 5);
		JScrollPane jScrollPane = new JScrollPane(showDateTextArea);
		add(BorderLayout.SOUTH, jScrollPane);	
	}
	private void setJFrame() {
		setTitle("MatchMan");
		setSize(1024, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-1024)/2, 
					(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-600)/2);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MatchMan();
	}
	class MatchManJPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		public MatchManJPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int mouseDraggedX = e.getX();
					int mouseDraggedY = e.getY();
					if (matchstick != null) {
						if (rotateDirection == 1) {
							firstDragged(mouseDraggedX, mouseDraggedY);
						}else if (rotateDirection == 2) {
							secondDragged(mouseDraggedX, mouseDraggedY);
						}
					}
					if (matchstick == null && head != null) {
						head.headPositionX = mouseDraggedX;
						head.headPositionY = mouseDraggedY;
						widthMan[chooseMan].changedAngle(Man.HEAD_FOOT, 11, 0);
					}
				}
			});
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					matchstick = null;
					head = null;
				}
				@Override
				public void mousePressed(MouseEvent e) {
					int mouseClickedX = e.getX();
					int mouseClickedY = e.getY();
					for (int i = 0; i < matchsticks.length; i++) {
						int firstX = matchsticks[i].firstPositionX;
						int firstY = matchsticks[i].firstPositionY;
						int secondX = matchsticks[i].secondPositionX;
						int secondY = matchsticks[i].secondPositionY;
						/* �ڶ������ڵ�һ������ǰ�� */
						if ((firstX <= secondX) && (firstY <= secondY)) {
							if ((mouseClickedX >= firstX) && (mouseClickedX <= secondX) && (mouseClickedY >= firstY) && (mouseClickedY <= secondY)) {
								if (hasMatchstick(mouseClickedX, mouseClickedY, i, matchsticks)) {
									matchstick = matchsticks[i];
									return;
								}
							}
						/* �ڶ������ڵ�һ�������·� */
						} else if ((firstX >= secondX) && (firstY >= secondY)) {
							if ((mouseClickedX <= firstX) && (mouseClickedX >= secondX) && (mouseClickedY <= firstY) && (mouseClickedY >= secondY)) {
								if (hasMatchstick(mouseClickedX, mouseClickedY, i, matchsticks)) {
									matchstick = matchsticks[i];
									return;
								}
							}
						/* �ڶ������ڵ�һ�������·� */
						} else if ((firstX <= secondX) && (firstY >= secondY)) {
							if ((mouseClickedX >= firstX) && (mouseClickedX <= secondX) && (mouseClickedY <= firstY) && (mouseClickedY >= secondY)) {
								if (hasMatchstick(mouseClickedX, mouseClickedY, i, matchsticks)) {
									matchstick = matchsticks[i];
									return;
								}
							}
						/* �ڶ������ڵ�һ������ǰ�� */
						} else if ((firstX >= secondX) && (firstY <= secondY)) {
							if ((mouseClickedX <= firstX) && (mouseClickedX >= secondX) && (mouseClickedY >= firstY) && (mouseClickedY <= secondY)) {
								if (hasMatchstick(mouseClickedX, mouseClickedY, i, matchsticks)) {
									matchstick = matchsticks[i];
									return;
								}
							}
						}
						if (inThePoint(mouseClickedX, mouseClickedY, i, matchsticks)) {
							matchstick = matchsticks[i];
							return;
						}
						rotateDirection = 0;
					}
					if (ishead(mouseClickedX, mouseClickedY)) {
						head = widthMan[chooseMan].head;
					}
				}
			});
		}

		private boolean ishead(int mouseClickedX, int mouseClickedY) {
			int dx = mouseClickedX - widthMan[chooseMan].head.headPositionX;
			int dy = mouseClickedY - widthMan[chooseMan].head.headPositionY;
			if (Math.sqrt(dx*dx+dy*dy) <= widthMan[chooseMan].head.headCircleSemi) {
				return true;
			}
			return false;
		}
		private void secondDragged(int mouseDraggedX, int mouseDraggedY) {
			int dx = mouseDraggedX - matchstick.firstPositionX;
			int dy = mouseDraggedY - matchstick.firstPositionY;
			if (dy >= 1) {
				double angle = -Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI;
				widthMan[chooseMan].changedAngle(Man.FOOT_HEAD, matchstick.typeId, angle);
			}
			if (dy <= -1) {
				double angle = Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI;
				widthMan[chooseMan].changedAngle(Man.FOOT_HEAD, matchstick.typeId, angle);
			}
		}
		private void firstDragged(int mouseDraggedX, int mouseDraggedY) {
			int dx = mouseDraggedX - matchstick.secondPositionX;
			int dy = mouseDraggedY - matchstick.secondPositionY;
			//��ֹ������=0
			if (dy >= 1) {
				double angle = -Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI+180;
				//System.out.println(dx+"\t"+dy+"\t"+Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI+"\t"+angle);
				widthMan[chooseMan].changedAngle(Man.HEAD_FOOT, matchstick.typeId, angle);			
			}
			if (dy <= -1) {
				double angle = Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI+180;
				//System.out.println(dx+"\t"+dy+"\t"+Math.acos(dx/Math.sqrt(dx*dx+dy*dy))*180/Math.PI+"\t"+angle);
				widthMan[chooseMan].changedAngle(Man.HEAD_FOOT, matchstick.typeId, angle);			
			}
		}
		private boolean hasMatchstick(int mouseClickedX, int mouseClickedY, int i, Matchstick[] matchsticks) {
			if (inTheLine(mouseClickedX, mouseClickedY, i, matchsticks)) {
				return true;
			}
			return false;
		}
		/**
		 * ����ڽڵ���
		 */
		private boolean inThePoint(int mouseClickedX, int mouseClickedY, int i,
				Matchstick[] matchsticks) {
			int relativeX = mouseClickedX - matchsticks[i].firstPositionX;
			int relativeY = mouseClickedY - matchsticks[i].firstPositionY;
			if (Math.sqrt(relativeX*relativeX + relativeY*relativeY) <= testLineWidth){
				rotateDirection = 1;
				return true;
			}
			relativeX = mouseClickedX - matchsticks[i].secondPositionX;
			relativeY = mouseClickedY - matchsticks[i].secondPositionY;
			if (Math.sqrt(relativeX*relativeX + relativeY*relativeY) <= testLineWidth) {
				rotateDirection = 2;
				return true;
			}
			return false;
		}
		/**
		 * ���������
		 * @param mouseClickedX
		 * @param mouseClickedY
		 * @param i
		 * @param matchsticks
		 * @return
		 */
		private boolean inTheLine(int mouseClickedX, int mouseClickedY, int i,
				Matchstick[] matchsticks) {
			double k = Math.tan(Math.PI*matchsticks[i].angle/180);
			double b = matchsticks[i].firstPositionY - k*matchsticks[i].firstPositionX;
			double d = Math.abs(k*mouseClickedX-mouseClickedY+b)/Math.sqrt(k*k+1);
			if (d <= testLineWidth) {
				int dxFirstX = mouseClickedX - matchsticks[i].firstPositionX;
				int dxFirstY = mouseClickedY - matchsticks[i].firstPositionY;
				int dxSecondX = mouseClickedX - matchsticks[i].secondPositionX;
				int dxSecondY = mouseClickedY - matchsticks[i].secondPositionY;
				if ((dxFirstX*dxFirstX+dxFirstY*dxFirstY) <= (dxSecondX*dxSecondX+dxSecondY*dxSecondY)) {
					rotateDirection = 1;
				}else{
					rotateDirection = 2;
				}
				return true;
			}
			return false;
		}
		@Override
		public void paint(Graphics graphics) {
			super.paint(graphics);
			this.setBackground(Color.black);
			Graphics2D graphics2d = (Graphics2D)graphics;
			BasicStroke basicStroke = new BasicStroke(16, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
			graphics2d.setStroke(basicStroke);
			if (movieFlag == false && chooseMan == 0) {
				graphics.setColor(Color.white);
				widthman1.showMan(graphics2d);
				graphics.setColor(Color.gray);
				widthman2.showMan(graphics2d);
			}if (movieFlag == false && chooseMan == 1) {
				graphics.setColor(Color.white);
				widthman2.showMan(graphics2d);
				graphics.setColor(Color.gray);
				widthman1.showMan(graphics2d);
			}
			if (movieFlag == true) {
				graphics2d.setColor(Color.white);
				movieMan.changedAngle(Man.FOOT_HEAD, 0, actionArrays.get(frameCounter%8));
				movieMan.showMan(graphics2d);
			}
		}
		public void start(){
			new Thread(){
				public void run() {
					boolean flag = true;
					while (true) {
						if (flag) {
							if (++frameCounter == 8) {
								flag = false;
							}
						}else {
							if (--frameCounter == 0) {
								flag = true;
							}
						}
						
						try {
							Thread.sleep(100);
							repaint();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
		}
	}
}
