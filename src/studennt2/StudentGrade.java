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

	JLabel name = new JLabel("姓名:");
	JLabel course1 = new JLabel("         C++:");
	JLabel course2 = new JLabel("体育:");
	JLabel course3 = new JLabel("         java:");
	JLabel course4 = new JLabel("高数:");
	JLabel course5 = new JLabel("         英语:");
	JLabel course6 = new JLabel("电工:");
	JLabel course7 = new JLabel("         军事:");

	JTextField txtName = new JTextField(5);
	JTextField txtCourse1 = new JTextField(4);
	JTextField txtCourse2 = new JTextField(4);
	JTextField txtCourse3 = new JTextField(4);
	JTextField txtCourse4 = new JTextField(4);
	JTextField txtCourse5 = new JTextField(4);
	JTextField txtCourse6 = new JTextField(4);

	String[] rank = { "A", "B", "C", "D" };
	// JComboBox 下拉框选项事件
	JComboBox jcb = new JComboBox(rank);
	JButton btn1 = new JButton("录入");
	JButton btn2 = new JButton("删除");
	JButton btn3 = new JButton("查询");
	JButton btn4 = new JButton("修改");
	Object[][] data = null;
	String[] columnName = { "        姓名", "        C++", "        体育", "        java", "        高数", "        英语",
			"        电工", "        军事" };
	DefaultTableModel dtm = new DefaultTableModel(data, columnName);// DefaultTableMode表格模型
	JTable jt = new JTable(dtm);// JTable將数据以表格的形式显示
	JScrollPane jsp = new JScrollPane(jt);// JScrollPane滚动条

	// JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	public StudentGrade() {
		super("成绩信息管理");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		this.setLayout(new FlowLayout());
		this.setBounds(700, 200, 700, 550);// 添加测试

		ImageIcon background = new ImageIcon("5.jpg"); // 背景图片
		JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
		JPanel p = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
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

		p1.setBorder(BorderFactory.createEtchedBorder());// setBorder() 给组件添加边框
		p2.setLayout(new BorderLayout());// 设置布局为边框布局
		DefaultTableCellRenderer thr = new DefaultTableCellRenderer();// 单元表格
		thr.setHorizontalAlignment(JLabel.LEFT);// 设置table表头居左
		jt.getTableHeader().setDefaultRenderer(thr);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (row % 2 == 0)
					setBackground(Color.white); // 设置奇数行底色
				else if (row % 2 == 1)
					setBackground(new Color(246, 246, 246)); // 设置偶数行底色，那三个数字代表三个颜色值
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};

		tcr.setHorizontalAlignment(JLabel.CENTER); // 设置table内容居中
		jt.setDefaultRenderer(Object.class, tcr);
		p2.add(jsp);
		p.setLayout(null);// 禁用窗口布局管理器，使得后面的setBounds生效
		p1.setBounds(150, 50, 400, 150);// 设置窗口位置和尺寸
		p2.setBounds(50, 250, 600, 200);

		add(p1);
		add(p2);

		// add(p);
		// setSize(700, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 定义窗口关闭事件
		setLocationRelativeTo(null);// 窗口将置于屏幕的中央
		setVisible(true);
		setResizable(false);// 禁止最大化
	}

	public void actionPerformed(ActionEvent ae) {// 用于接收操作事件的侦听器接口
		if (ae.getSource() == btn1) {
			String[] row = new String[8];
			row[0] = txtName.getText().trim();
			row[1] = txtCourse1.getText().trim();// getText().trim()的作用是:在获得的文本中除去两端的空格，中间的空格不去掉
			row[2] = txtCourse2.getText().trim();
			row[3] = txtCourse3.getText().trim();
			row[4] = txtCourse4.getText().trim();
			row[5] = txtCourse3.getText().trim();
			row[6] = txtCourse4.getText().trim();
			row[7] = (String) jcb.getSelectedItem();// 获取选项，getSelectedItem()返回一个对象
			dtm.addRow(row);// addRow() 向其它列添加数据
		}
	}

}
