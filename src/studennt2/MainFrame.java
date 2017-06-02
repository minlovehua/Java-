package studennt2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MainFrame extends JFrame implements ActionListener {

	private final String userName1 = "123";
	private final String passWord1 = "123";

	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;

	JLabel userName = new JLabel("�û���");
	JTextField txtUser = new JTextField();

	final JLabel jLabel = new JLabel("ѧ����Ϣ����ϵͳ");
	final JLabel passWord = new JLabel("���룺");
	final JPasswordField txtPwd = new JPasswordField(6);

	JButton btnLogin = new JButton("��¼");
	JButton btncz = new JButton("����");
	JButton btnCancel = new JButton("ȡ��");

	public MainFrame() {
		super("����ϵͳ�û���¼");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		this.setLayout(new FlowLayout());
		this.setBounds(700, 200, 600, 480);

		jLabel.setFont(new java.awt.Font("Dialog", 1, 16));
		userName.setFont(new java.awt.Font("Dialog", 1, 16));
		passWord.setFont(new java.awt.Font("Dialog", 1, 16));

		ImageIcon background = new ImageIcon("1.jpg");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		JPanel p = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		btnLogin.setFont(new Font("����", Font.PLAIN, 16));
		btncz.setFont(new Font("����", Font.PLAIN, 16));
		btnCancel.setFont(new Font("����", Font.PLAIN, 16));

		p1.setLayout(new GridLayout(2, 2));// ������1��2��2�е���ʽ���ֹ��������û������룩
		p1.add(userName);
		p1.add(txtUser);
		p1.add(passWord);
		p1.add(txtPwd);

		p2.setLayout(new GridLayout(1, 3));
		p2.add(btnLogin);// ��½
		p2.add(btncz);// ����
		p2.add(btnCancel);// ȡ��
		p3.add(jLabel);

		p.setLayout(null);// �رմ��ڲ��ֹ�����ʹ�ú����setBounds��Ч
		p3.setBounds(200, 50, 200, 25);
		p1.setBounds(200, 150, 200, 50);
		p2.setBounds(200, 300, 200, 50);
		add(p3);
		add(p1);
		add(p2);

		this.setResizable(false);// ��ֹ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// ���ÿɹر�
		this.setVisible(true);// ���ڿ��ӻ�

		// ���ð�ť����¼��ķ���
		btnLogin.addActionListener(this);
		btncz.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); // getSource() ��ȡ������İ�ť�ϵ��ַ���
		if (source == btnLogin) {

			/**
			 * ���Դ��� System.out.println("�����½");
			 * System.out.println("�����û�����"+txtUser.getText());
			 * System.out.println("�������룺"+new String(txtPwd.getPassword()));
			 * System.out.println("��½�ɹ���");
			 */

			// new String(txtPwd.getPassword()) new
			// һ��String���󣬰Ѵ�������ȡ��������ת����String��
			if (txtUser.getText().equals(userName1) && new String(txtPwd.getPassword()).equals(passWord1)) {
				// System.out.println("��½�ɹ���");
				JOptionPane.showMessageDialog(null, "��¼�ɹ�", "btnLogin", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);// ��¼ҳ������
				new StudentFrame(); // ���������Ϣ����ϵͳ
			} else { // ��¼���ɹ������µ�¼
				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������µ�¼", "btnLogin", JOptionPane.INFORMATION_MESSAGE);
				// ��������������Ϊ�գ����û���������
				txtUser.setText("");
				txtPwd.setText("");
			}
		} else if (source == btncz) {// ����
			txtUser.setText("");
			txtPwd.setText("");
		} else if (source == btnCancel) {// ȡ��
			System.exit(0);
		}
	}

}
