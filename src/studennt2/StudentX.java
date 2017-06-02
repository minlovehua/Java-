package studennt2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class StudentX extends JFrame implements ActionListener {

	// JPaneҪ����Ϊȫ�ֱ�����������ʾ����ͼƬ���ɹ���
	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;
	JPanel p4 = null;

	JLabel studentID = new JLabel("        ѧ�ţ�");
	JLabel name = new JLabel("        ������");
	JLabel academy = new JLabel("        ѧԺ��");
	JLabel country = new JLabel("        ���᣺");
	JLabel political = new JLabel("        ������ò��");

	JTextField txtName = new JTextField(8);
	JTextField txtStudentID = new JTextField(5);
	JTextField txtCountry = new JTextField();
	JTextField txtPolitical = new JTextField();

	String[] academy1 = { "�����ѧԺ", "�����ѧԺ", "����ѧԺ", "����ѧԺ", "��֯ѧԺ", "��ѧԺ" };
	JComboBox jcb = new JComboBox(academy1);// JComboBox ��ѡ��
	JButton btn1 = new JButton("¼��");
	JButton btn2 = new JButton("ɾ��");
	JButton btn3 = new JButton("��ѯ");
	Object[][] data = null;
	String[] columnName = { "ѧ��", "����", "����", "������ò", "ѧԺ" };
	// JTable+DefaultTableModel +JScrollPane �����ʾ����
	DefaultTableModel d = new DefaultTableModel(data, columnName);// DefaultTableMode���ģ��
	JTable jt = new JTable(d);// JTable�������Ա�����ʽ��ʾ
	JScrollPane jsp = new JScrollPane(jt);// JScrollPane������

	public StudentX() {

		super("������Ϣ����");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		this.setLayout(new FlowLayout());
		this.setBounds(700, 200, 600, 600);// ��Ӳ���

		ImageIcon background = new ImageIcon("2.jpg");//picture11
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p = (JPanel) this.getContentPane();
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		btn1.setFont(new Font("����", Font.PLAIN, 16));
		btn2.setFont(new Font("����", Font.PLAIN, 16));
		btn3.setFont(new Font("����", Font.PLAIN, 16));

		/* 
		 * //���ԣ����·����Ĵ��ڴ�Сȡ����Ӧ�õı���ͼƬ�Ĵ�С�����ұ�ǩ��ͼƬ�����ˣ���ťҪ����ų�����
		 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�ر��ܹ��ر���������
		 * JPanel p=(JPanel)this.getContentPane(); p.setOpaque(false);
		 * p.setLayout(new BorderLayout()); ImageIcon background = new
		 * ImageIcon("11.jpg"); // ����ͼƬ JLabel label = new JLabel(background);
		 * p.add("Center", label); this.pack();//�ǵ����ⲿ������С�ķ���
		 * this.setVisible(true);
		 */

		p3.setLayout(new GridLayout(5, 2));
		p3.add(name);
		p3.add(txtName);
		p3.add(studentID);
		p3.add(txtStudentID);
		p3.add(country);
		p3.add(txtCountry);
		p3.add(political);
		p3.add(txtPolitical);
		p3.add(academy);
		p3.add(jcb);

		p4.setLayout(new GridLayout(3, 1));
		p4.add(btn1);
		p4.add(btn2);
		p4.add(btn3);

		p1.setLayout(new BorderLayout());
		p1.add(p3, BorderLayout.WEST);
		p1.add(p4, BorderLayout.EAST);

		p1.setBorder(BorderFactory.createEtchedBorder());// setBorder() �������ӱ߿�
		p2.setLayout(new BorderLayout());// ���ò���Ϊ�߿򲼾�

		DefaultTableCellRenderer thr = new DefaultTableCellRenderer();// ��Ԫ���
		thr.setHorizontalAlignment(JLabel.CENTER);// ����table��ͷ����
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
		p1.setBounds(100, 50, 400, 200);// ���ô���λ�úͳߴ�
		p2.setBounds(100, 300, 400, 200);
		p.add(p1);
		p.add(p2);

		// add(p); //��ӱ���ͼƬʱҪɾ���˾䣬����ᱨ������ӱ���ͼƬҪ�����䡣
		// setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���崰�ڹر��¼�
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);// ��ֹ���
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {// ���ڽ��ղ����¼����������ӿ�
		if (ae.getSource() == btn1) {
			String[] row = new String[5];
			row[0] = txtStudentID.getText().trim();
			row[1] = txtName.getText().trim();// getText().trim()��������:�ڻ�õ��ı��г�ȥ���˵Ŀո��м�Ŀո�ȥ��
			row[2] = txtCountry.getText().trim();
			row[3] = txtPolitical.getText().trim();
			row[4] = (String) jcb.getSelectedItem();// ��ȡѡ�getSelectedItem()����һ������
			d.addRow(row);// addRow() ���������������
		}
	}

}
