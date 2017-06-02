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

	// JPane要定义为全局变量，否则显示背景图片不成功。
	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;
	JPanel p4 = null;

	JLabel studentID = new JLabel("        学号：");
	JLabel name = new JLabel("        姓名：");
	JLabel academy = new JLabel("        学院：");
	JLabel country = new JLabel("        籍贯：");
	JLabel political = new JLabel("        政治面貌：");

	JTextField txtName = new JTextField(8);
	JTextField txtStudentID = new JTextField(5);
	JTextField txtCountry = new JTextField();
	JTextField txtPolitical = new JTextField();

	String[] academy1 = { "计算机学院", "外国语学院", "物理学院", "化环学院", "纺织学院", "文学院" };
	JComboBox jcb = new JComboBox(academy1);// JComboBox 复选框
	JButton btn1 = new JButton("录入");
	JButton btn2 = new JButton("删除");
	JButton btn3 = new JButton("查询");
	Object[][] data = null;
	String[] columnName = { "学号", "姓名", "籍贯", "政治面貌", "学院" };
	// JTable+DefaultTableModel +JScrollPane 表格显示数据
	DefaultTableModel d = new DefaultTableModel(data, columnName);// DefaultTableMode表格模型
	JTable jt = new JTable(d);// JTable將数据以表格的形式显示
	JScrollPane jsp = new JScrollPane(jt);// JScrollPane滚动条

	public StudentX() {

		super("个人信息管理");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		this.setLayout(new FlowLayout());
		this.setBounds(700, 200, 600, 600);// 添加测试

		ImageIcon background = new ImageIcon("2.jpg");//picture11
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p = (JPanel) this.getContentPane();
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		btn1.setFont(new Font("楷书", Font.PLAIN, 16));
		btn2.setFont(new Font("楷书", Font.PLAIN, 16));
		btn3.setFont(new Font("楷书", Font.PLAIN, 16));

		/* 
		 * //测试：以下方法的窗口大小取决于应用的背景图片的大小，并且标签被图片覆盖了，按钮要点击才出来。
		 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点关闭能够关闭面板的命令
		 * JPanel p=(JPanel)this.getContentPane(); p.setOpaque(false);
		 * p.setLayout(new BorderLayout()); ImageIcon background = new
		 * ImageIcon("11.jpg"); // 背景图片 JLabel label = new JLabel(background);
		 * p.add("Center", label); this.pack();//是调整外部容器大小的方法
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

		p1.setBorder(BorderFactory.createEtchedBorder());// setBorder() 给组件添加边框
		p2.setLayout(new BorderLayout());// 设置布局为边框布局

		DefaultTableCellRenderer thr = new DefaultTableCellRenderer();// 单元表格
		thr.setHorizontalAlignment(JLabel.CENTER);// 设置table表头居中
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
		p1.setBounds(100, 50, 400, 200);// 设置窗口位置和尺寸
		p2.setBounds(100, 300, 400, 200);
		p.add(p1);
		p.add(p2);

		// add(p); //添加背景图片时要删掉此句，否则会报错；不添加背景图片要添加这句。
		// setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 定义窗口关闭事件
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);// 禁止最大化
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {// 用于接收操作事件的侦听器接口
		if (ae.getSource() == btn1) {
			String[] row = new String[5];
			row[0] = txtStudentID.getText().trim();
			row[1] = txtName.getText().trim();// getText().trim()的作用是:在获得的文本中除去两端的空格，中间的空格不去掉
			row[2] = txtCountry.getText().trim();
			row[3] = txtPolitical.getText().trim();
			row[4] = (String) jcb.getSelectedItem();// 获取选项，getSelectedItem()返回一个对象
			d.addRow(row);// addRow() 向其它列添加数据
		}
	}

}
