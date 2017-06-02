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

	JLabel userName = new JLabel("用户：");
	JTextField txtUser = new JTextField();

	final JLabel jLabel = new JLabel("学生信息管理系统");
	final JLabel passWord = new JLabel("密码：");
	final JPasswordField txtPwd = new JPasswordField(6);

	JButton btnLogin = new JButton("登录");
	JButton btncz = new JButton("重置");
	JButton btnCancel = new JButton("取消");

	public MainFrame() {
		super("管理系统用户登录");
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
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
		JPanel p = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

		btnLogin.setFont(new Font("黑体", Font.PLAIN, 16));
		btncz.setFont(new Font("黑体", Font.PLAIN, 16));
		btnCancel.setFont(new Font("黑体", Font.PLAIN, 16));

		p1.setLayout(new GridLayout(2, 2));// 添加面板1：2行2列的流式布局管理器（用户、密码）
		p1.add(userName);
		p1.add(txtUser);
		p1.add(passWord);
		p1.add(txtPwd);

		p2.setLayout(new GridLayout(1, 3));
		p2.add(btnLogin);// 登陆
		p2.add(btncz);// 重置
		p2.add(btnCancel);// 取消
		p3.add(jLabel);

		p.setLayout(null);// 关闭窗口布局管理器使得后面的setBounds生效
		p3.setBounds(200, 50, 200, 25);
		p1.setBounds(200, 150, 200, 50);
		p2.setBounds(200, 300, 200, 50);
		add(p3);
		add(p1);
		add(p2);

		this.setResizable(false);// 禁止最大化
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置可关闭
		this.setVisible(true);// 窗口可视化

		// 调用按钮点击事件的方法
		btnLogin.addActionListener(this);
		btncz.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); // getSource() 获取被点击的按钮上的字符串
		if (source == btnLogin) {

			/**
			 * 测试代码 System.out.println("这里登陆");
			 * System.out.println("测试用户名："+txtUser.getText());
			 * System.out.println("测试密码："+new String(txtPwd.getPassword()));
			 * System.out.println("登陆成功了");
			 */

			// new String(txtPwd.getPassword()) new
			// 一个String对象，把从输入框获取到的内容转换成String型
			if (txtUser.getText().equals(userName1) && new String(txtPwd.getPassword()).equals(passWord1)) {
				// System.out.println("登陆成功了");
				JOptionPane.showMessageDialog(null, "登录成功", "btnLogin", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);// 登录页面隐藏
				new StudentFrame(); // 进入个人信息管理系统
			} else { // 登录不成功，重新登录
				JOptionPane.showMessageDialog(null, "登录失败，请重新登录", "btnLogin", JOptionPane.INFORMATION_MESSAGE);
				// 设置输入框的内容为空，让用户重新输入
				txtUser.setText("");
				txtPwd.setText("");
			}
		} else if (source == btncz) {// 重置
			txtUser.setText("");
			txtPwd.setText("");
		} else if (source == btnCancel) {// 取消
			System.exit(0);
		}
	}

}
