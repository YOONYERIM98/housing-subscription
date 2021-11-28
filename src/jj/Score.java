package jj;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame{
	JLabel grade,sup,num,gr,su,nu;
	public Score(int sum, String supply, String rank) {
		
		String sum1 = Integer.toString(sum);
		
		setTitle("결과");
		Container c = getContentPane();
		c.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(250,350);
		setLocation(1200,200);
		setVisible(true);

		gr = new JLabel("순 위 :");
		grade = new JLabel(rank);
		grade.setBounds(130, 70, 150, 20);
		gr.setBounds(30, 70, 150, 20);
		c.add(grade);
		c.add(gr);
		su = new JLabel("공 급 :");
		sup = new JLabel(supply);
		sup.setBounds(130,100, 150, 20);
		su.setBounds(30, 100, 150, 20);
		c.add(sup);
		c.add(su);
		
		nu = new JLabel("점 수 :");
		num = new JLabel(sum1);
		num.setBounds(130,130, 150, 20);
		nu.setBounds(30, 130, 150, 20);
		c.add(num);
		c.add(nu);
	}
	public void actionPerformed(ActionEvent e) {
	}

}