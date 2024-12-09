import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Main_Project {

	public static void main(String[] args) {
		new JTabbedPane1();

	}
	
}

class checkInandOut extends JPanel implements ActionListener {
	
	JLabel jl;
	TextField tf;
	TextArea ta;
	JButton b1 = new JButton("check in");
	JButton b2 = new JButton("check out");
	JPanel jp = new JPanel();
	
	public checkInandOut() {
		tf = new TextField(20);
		ta = new TextArea();
		ta.setEditable(false);
		setLayout(new FlowLayout());
		jp.add(tf);
		jp.add(b1);
		jp.add(b2);
		add(jp);
		add(ta);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
}

class JRecord extends JPanel implements ActionListener {
	String stuString = "";
	String nameString = "";
	String timeString = "";
	JButton b3 = new JButton("출입 record");
	JButton b4 = new JButton("check in record");
	JButton b5 = new JButton("check out record");
	TextArea ta1;
	
	public JRecord() {
		ta1 = new TextArea();
		ta1.setEditable(false);
		setLayout(new FlowLayout());
		add(b3);
		add(b4);
		add(b5);
		add(ta1);
		
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(b3.equals(e.getSource())) {
			stuString = "";
			nameString = "";
			timeString = "";
			stuString = Team_Project_Select.selectInfo().stu_num;
			nameString = Team_Project_Select.selectInfo().name;
			timeString = Team_Project_Select.selectInfo().time;
			ta1.setText(stuString + " " + nameString + " " + timeString);
			}
		if(b4.equals(e.getSource())) {
			stuString = "";
			nameString = "";
			timeString = "";
			stuString = Team_Project_Select_2.selectInfo().stu_num;
			nameString = Team_Project_Select_2.selectInfo().name;
			timeString = Team_Project_Select_2.selectInfo().time;
			ta1.setText(stuString + " " + nameString + " " + timeString);
		}
		if(b5.equals(e.getSource())) {
			stuString = "";
			nameString = "";
			timeString = "";
			stuString = Team_Project_Select_3.selectInfo().stu_num;
			nameString = Team_Project_Select_3.selectInfo().name;
			timeString = Team_Project_Select_3.selectInfo().time;
			ta1.setText(stuString + " " + nameString + " " + timeString);
		}
	
	}
}
class JTabbedPane1 extends JFrame {
	public JTabbedPane1() {
		JTabbedPane jtp = new JTabbedPane();
		checkInandOut cio = new checkInandOut();
		JRecord jr = new JRecord();
		jtp.addTab("출입", cio);
		jtp.addTab("기록", jr);
		getContentPane().add(jtp);
		
		setTitle("기숙사 출입 관리 시스템");
        setSize(600, 400);
        setVisible(true);
	}
}
