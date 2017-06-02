package studennt2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StudentFrame extends JFrame implements ActionListener {

	JPanel p = null;
	JButton btns = new JButton("������Ϣ����");
	JButton btng = new JButton("�ɼ���Ϣ����");
	JButton btnClose = new JButton("�˳�����ϵͳ");

	StudentFrame() {
		super("ѧ����Ϣ����ϵͳ");
		p = new JPanel();
		this.setBounds(700, 200, 600, 480);

		ImageIcon background = new ImageIcon("7.jpg");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p = (JPanel) this.getContentPane();
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		p.setLayout(null);// �رմ��ڲ��ֹ�����ʹ�ú����setBounds��Ч
		btns.setBounds(225, 50, 150, 50);
		btng.setBounds(225, 150, 150, 50);
		btnClose.setBounds(225, 250, 150, 50);
		p.add(btns);
		p.add(btng);
		p.add(btnClose);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		p.setVisible(true);

		btns.addActionListener(this);
		btng.addActionListener(this);
		btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "������Ϣ����") {
			setVisible(false);
			new StudentX();
		}
		if (e.getActionCommand() == "�ɼ���Ϣ����") {
			setVisible(false);
			new StudentGrade();
		}
		if (e.getActionCommand() == "�˳�����ϵͳ") {
			System.exit(0);
		}
	}
}

/**
 * e.getActionCommand() �� ��Ŧ���¼�Ϊ����ͬһ��JFrame������ж����ť���¼���
 * Ϊ�˱����ͻ����ÿ����ť���ò�ͬ��ActionCommand�� �ڼ���ʱ���ʱ������������������¼���������ͬ����Ӧ.
 * �����e.getActionCommand��������String, ͨ�����String���ж����ĸ���ť�������¼�
 * 
 */
