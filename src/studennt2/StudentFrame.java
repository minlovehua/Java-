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
	JButton btns = new JButton("个人信息管理");
	JButton btng = new JButton("成绩信息管理");
	JButton btnClose = new JButton("退出管理系统");

	StudentFrame() {
		super("学生信息管理系统");
		p = new JPanel();
		this.setBounds(700, 200, 600, 480);

		ImageIcon background = new ImageIcon("7.jpg");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p = (JPanel) this.getContentPane();
		p.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		p.setLayout(null);// 关闭窗口布局管理器使得后面的setBounds生效
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
		if (e.getActionCommand() == "个人信息管理") {
			setVisible(false);
			new StudentX();
		}
		if (e.getActionCommand() == "成绩信息管理") {
			setVisible(false);
			new StudentGrade();
		}
		if (e.getActionCommand() == "退出管理系统") {
			System.exit(0);
		}
	}
}

/**
 * e.getActionCommand() 以 按纽的事件为例，同一个JFrame里可能有多个按钮的事件，
 * 为了避免冲突，给每个按钮设置不同的ActionCommand， 在监听时间的时候，用这个做条件区分事件，以做不同的响应.
 * 而这个e.getActionCommand方法返回String, 通过这个String能判断是哪个按钮触发了事件
 * 
 */
