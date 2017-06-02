package studennt2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StudentGrade extends JFrame implements ActionListener {

	JLabel name = new JLabel("����:");
	JLabel course1 = new JLabel("         C++:");
	JLabel course2 = new JLabel("����:");
	JLabel course3 = new JLabel("         java:");
	JLabel course4 = new JLabel("����:");
	JLabel course5 = new JLabel("         Ӣ��:");
	JLabel course6 = new JLabel("�繤:");
	JLabel course7 = new JLabel("         ����:");

	JTextField txtName = new JTextField(5);
	JTextField txtCourse1 = new JTextField(4);
	JTextField txtCourse2 = new JTextField(4);
	JTextField txtCourse3 = new JTextField(4);
	JTextField txtCourse4 = new JTextField(4);
	JTextField txtCourse5 = new JTextField(4);
	JTextField txtCourse6 = new JTextField(4);

	String[] rank = { "A", "B", "C", "D" };
	// JComboBox ������ѡ���¼�
	JComboBox jcb = new JComboBox(rank);
	JButton btn1 = new JButton("¼��");
	JButton btn2 = new JButton("ɾ��");
	JButton btn3 = new JButton("��ѯ");
	JButton btn4 = new JButton("�޸�");
	Object[][] data = null;
	String[] columnName = { "        ����", "        C++", "        ����", "        java", "        ����", "        Ӣ��",
			"        �繤", "        ����" };
	DefaultTableModel dtm = new DefaultTableModel(data, columnName);// DefaultTableMode���ģ��
	JTable jt = new JTable(dtm);// JTable�������Ա�����ʽ��ʾ
	JScrollPane jsp = new JScrollPane(jt);// JScrollPane������

	// JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	public StudentGrade() {
		super("�ɼ���Ϣ����");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		this.setLayout(new FlowLayout());
		this.setBounds(700, 200, 700, 550);// ��Ӳ���

		ImageIcon background = new ImageIcon("5.jpg"); // ����ͼƬ
		JLabel label = new JLabel(background); // �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		JPanel p = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		p3.setLayout(new GridLayout(4, 4));
		p3.add(name);
		p3.add(txtName);
		p3.add(course1);
		p3.add(txtCourse1);
		p3.add(course2);
		p3.add(txtCourse2);
		p3.add(course3);
		p3.add(txtCourse3);
		p3.add(course4);
		p3.add(txtCourse4);
		p3.add(course5);
		p3.add(txtCourse5);
		p3.add(course6);
		p3.add(txtCourse6);
		p3.add(course7);
		p3.add(jcb);
		p4.setLayout(new GridLayout(4, 2));
		p4.add(btn1);
		p4.add(btn2);
		p4.add(btn3);
		p4.add(btn4);
		p1.setLayout(new BorderLayout());
		p1.add(p3, BorderLayout.WEST);
		p1.add(p4, BorderLayout.EAST);

		p1.setBorder(BorderFactory.createEtchedBorder());// setBorder() �������ӱ߿�
		p2.setLayout(new BorderLayout());// ���ò���Ϊ�߿򲼾�
		DefaultTableCellRenderer thr = new DefaultTableCellRenderer();// ��Ԫ���
		thr.setHorizontalAlignment(JLabel.LEFT);// ����table��ͷ����
		jt.getTableHeader().setDefaultRenderer(thr);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (row % 2 == 0)
					setBackground(Color.white); // ���������е�ɫ
				else if (row % 2 == 1)
					setBackground(new Color(246, 246, 246)); // ����ż���е�ɫ�����������ִ���������ɫֵ
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};

		tcr.setHorizontalAlignment(JLabel.CENTER); // ����table���ݾ���
		jt.setDefaultRenderer(Object.class, tcr);
		p2.add(jsp);
		p.setLayout(null);// ���ô��ڲ��ֹ�������ʹ�ú����setBounds��Ч
		p1.setBounds(150, 50, 400, 150);// ���ô���λ�úͳߴ�
		p2.setBounds(50, 250, 600, 200);

		add(p1);
		add(p2);

		// add(p);
		// setSize(700, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���崰�ڹر��¼�
		setLocationRelativeTo(null);// ���ڽ�������Ļ������
		setVisible(true);
		setResizable(false);// ��ֹ���
	}

	public void actionPerformed(ActionEvent ae) {// ���ڽ��ղ����¼����������ӿ�
		if (ae.getSource() == btn1) {
			String[] row = new String[8];
			row[0] = txtName.getText().trim();
			row[1] = txtCourse1.getText().trim();// getText().trim()��������:�ڻ�õ��ı��г�ȥ���˵Ŀո��м�Ŀո�ȥ��
			row[2] = txtCourse2.getText().trim();
			row[3] = txtCourse3.getText().trim();
			row[4] = txtCourse4.getText().trim();
			row[5] = txtCourse3.getText().trim();
			row[6] = txtCourse4.getText().trim();
			row[7] = (String) jcb.getSelectedItem();// ��ȡѡ�getSelectedItem()����һ������
			dtm.addRow(row);// addRow() ���������������
		}
	}

}
