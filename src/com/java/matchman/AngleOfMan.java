package com.java.matchman;
/**
 * <h4>AngleOfMan��˵��:</h4><br><ol>
 * 		<li>�������еĽǶȶ����ڵѿ������ϵ�µ����;
 * 		<li>��Ļ���ϵ�͵ѿ������ϵ�ǹ���X��ԳƵ�;
 *</ol>
 */
public class AngleOfMan {
	
	/** �����X�������ɵĽǶ� */
	private double leftFootAngle;
	/** ��С����X�������ɵĽǶ� */
	private double leftCrusAngle;
	/** �������X�������ɵĽǶ� */
	private double leftThighAngle;
	/** �����X�������ɵĽǶ� */
	private double trunkAngle;
	/** �Ҵ�����X�������ɵĽǶ� */
	private double rightThighAngle;
	/** ��С����X�������ɵĽǶ� */
	private double rightCrusAngle;
	/** �ҽ���X�������ɵĽǶ� */
	private double rightFootAngle;
	/** ��첲��X�������ɵĽǶ� */
	private double leftArmAngle;
	/** ��ǰ����X�������ɵĽǶ� */
	private double leftForearmAngle;
	/** �Ҹ첲��X�������ɵĽǶ� */
	private double rightArmAngle;
	/** ��ǰ����X�������ɵĽǶ� */
	private double rightForearmAngle;
	public double[] angles;
	public AngleOfMan() {
	}
	/**
	 * ���캯�����һ��double[]������ڲ����Խ��г�ʼ��,ͬʱ���䱨����angles��
	 * @param angles
	 */
	public AngleOfMan(double[] angles) {
		this.leftFootAngle = angles[0];
		this.leftCrusAngle = angles[1];
		this.leftThighAngle = angles[2];
		this.trunkAngle = angles[3];
		this.rightThighAngle = angles[4];
		this.rightCrusAngle = angles[5];
		this.rightFootAngle = angles[6];
		this.leftArmAngle = angles[7];
		this.leftForearmAngle = angles[8];
		this.rightArmAngle = angles[9];
		this.rightForearmAngle = angles[10];
		this.angles = new double[]{leftFootAngle,leftCrusAngle,leftThighAngle,
				trunkAngle,rightThighAngle,rightCrusAngle,rightFootAngle,
				leftArmAngle,leftForearmAngle,rightArmAngle,rightForearmAngle};
	}
	/**
	 * ���캯�����һ��int[]������ڲ����Խ��г�ʼ��,ͬʱ���䱨����angles��
	 * @param angles
	 */
	public AngleOfMan(int[] angles) {
		this.leftFootAngle = (double)angles[0];
		this.leftCrusAngle = (double)angles[1];
		this.leftThighAngle = (double)angles[2];
		this.trunkAngle = (double)angles[3];
		this.rightThighAngle = (double)angles[4];
		this.rightCrusAngle = (double)angles[5];
		this.rightFootAngle = (double)angles[6];
		this.leftArmAngle = (double)angles[7];
		this.leftForearmAngle = (double)angles[8];
		this.rightArmAngle = (double)angles[9];
		this.rightForearmAngle = (double)angles[10];
		this.angles = new double[]{leftFootAngle,leftCrusAngle,leftThighAngle,
				trunkAngle,rightThighAngle,rightCrusAngle,rightFootAngle,
				leftArmAngle,leftForearmAngle,rightArmAngle,rightForearmAngle};
	}
	/**
	 * ���캯�����һ��string���ڲ����Խ��г�ʼ��,ͬʱ���䱨����angles��
	 * @param angles
	 */
	public AngleOfMan(String string) {
		string.replace("[", "");
		string.replace("]", "");
		String[] strings = string.split(", ");
		this.leftFootAngle = Double.parseDouble(strings[0]);
		this.leftCrusAngle = Double.parseDouble(strings[1]);
		this.leftThighAngle = Double.parseDouble(strings[2]);
		this.trunkAngle = Double.parseDouble(strings[3]);
		this.rightThighAngle = Double.parseDouble(strings[4]);
		this.rightCrusAngle = Double.parseDouble(strings[5]);
		this.rightFootAngle = Double.parseDouble(strings[6]);
		this.leftArmAngle = Double.parseDouble(strings[7]);
		this.leftForearmAngle = Double.parseDouble(strings[8]);
		this.rightArmAngle = Double.parseDouble(strings[9]);
		this.rightForearmAngle = Double.parseDouble(strings[10]);
		this.angles = new double[]{leftFootAngle,leftCrusAngle,leftThighAngle,
				trunkAngle,rightThighAngle,rightCrusAngle,rightFootAngle,
				leftArmAngle,leftForearmAngle,rightArmAngle,rightForearmAngle};
	}
	@Override
	public String toString() {
		return "["+
					leftFootAngle+", "+leftCrusAngle+", "+leftThighAngle+", "+
					trunkAngle+", "+
					rightThighAngle+", "+rightCrusAngle+","+rightFootAngle+	
					", "+leftArmAngle+", "+leftForearmAngle+", "+
					rightArmAngle+", "+rightForearmAngle+
				"]";
	}
}
