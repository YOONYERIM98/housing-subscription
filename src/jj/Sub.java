package jj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Sub extends JFrame{

	//청통 기간
	String[] CY= {"없음","6개월 미만","6개월 이상 ~ 1년 미만","1년 이상 ~ 2년 미만","2년 이상 ~ 3년 미만","3년 이상 ~ 4년 미만","4년 이상 ~ 5년 미만","5년 이상 ~ 6년 미만","6년 이상 ~ 7년 미만","7년 이상 ~ 8년 미만","8년 이상 ~ 9년 미만","9년 이상 ~ 10년 미만","10년 이상 ~ 11년 미만","11년 이상 ~ 12년 미만","12년 이상 ~ 13년 미만","13년 이상 ~ 14년 미만","14년 이상 ~ 15년 미만","15년 이상"};
	//무주택 기간
	String[] MJ= {"없음","1년 미만","1년 이상 ~ 2년 미만","2년 이상 ~ 3년 미만","3년 이상 ~ 4년 미만","4년 이상 ~ 5년 미만","5년 이상 ~ 6년 미만","6년 이상 ~ 7년 미만","7년 이상 ~ 8년 미만","8년 이상 ~ 9년 미만","9년 이상 ~ 10년 미만","10년 이상 ~ 11년 미만","11년 이상 ~ 12년 미만","12년 이상 ~ 13년 미만","13년 이상 ~ 14년 미만","14년 이상 ~ 15년 미만","15년 이상"};
	//부양가족수
	String[] BY= {"0명","1명","2명","3명","4명","5명","6명 이상"};
	//만19세미만자녀수
	String[] MS= {"0명","1명","2명","3명","4명","5명 이상"};

	String supply, rank;

	JCheckBox check1, check2;

	int a,b,d,ze,sum;
	int mj1, cy1, ms1;


	Sub(){
		setTitle("주택청약 시뮬레이터");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel cy = new JLabel("청약통장 가입기간 :");
		cy.setBounds(10, 20, 150, 20);
		JComboBox CYCombo= new JComboBox(CY);
		CYCombo.setBounds(170,20,150,20);
		CYCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cy = (JComboBox) e.getSource();
				cy1 = cy.getSelectedIndex();
				for(int i=0; i<=CY.length; i++) {
					if(i==cy1) {
						a = cy1;
					}    
				}
				check1.setSelected(false);
				check2.setSelected(false);
			}
		});
		c.add(CYCombo);
		c.add(cy);

		JLabel mj = new JLabel("무주택 기간 :");
		mj.setBounds(10, 70, 150, 20);
		JComboBox MJCombo= new JComboBox(MJ);
		MJCombo.setBounds(170,70,150,20);
		MJCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox mj = (JComboBox) e.getSource();
				mj1 = mj.getSelectedIndex();
				for(int i=0; i<=MJ.length; i++) {
					if(i==mj1) {
						if(i==0) {
							b = 0;
						}else {
							b = mj1*2;

						}
					}     
				}
				check1.setSelected(false);
				check2.setSelected(false);
			}
		});
		c.add(MJCombo);
		c.add(mj);

		JLabel by = new JLabel("부양가족수 :");
		by.setBounds(10, 120, 150, 20);
		JComboBox BYCombo= new JComboBox(BY);
		BYCombo.setBounds(170,120,150,20);
		BYCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox by = (JComboBox) e.getSource();
				int by1 = by.getSelectedIndex();
				for(int i=0; i<=BY.length; i++) {
					if(i==by1) {
						if(i==0) {
							d = 5;
						}else {
							d = by1*5+5;

						}
					}          
				}
				check1.setSelected(false);
				check2.setSelected(false);
			}
		});
		c.add(BYCombo);
		c.add(by);

		JLabel ms = new JLabel("만19세 미만 자녀수 :");
		ms.setBounds(10, 170, 150, 20);
		JComboBox MSCombo= new JComboBox(MS);
		MSCombo.setBounds(170,170,150,20);
		MSCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox ms = (JComboBox) e.getSource();
				ms1 = ms.getSelectedIndex();
				for(int i=0; i<=MS.length; i++) {
					if(i==ms1) {
						if(i<3) {
							ze = 0;
							supply = "일반공급";
						}else
						{
							supply = "다자녀공급";
							int k = 10;
							if(i==3) {
								ze = ms1*k;
							}else if(i==4){
								ze = ms1*k-5;
							}
							else {
								ze = ms1*k-10;
							}

						}
					}
				}
				Supply(supply, mj1);
				Bankbook(supply, cy1);

				check1.setSelected(false);
				check2.setSelected(false);
			}
		});

		c.add(MSCombo);
		c.add(ms);

		check1 = new JCheckBox("7년 미만의 신혼부부 입니까?");
		check1.setBounds(10,220,300,20);
		check2 = new JCheckBox("생애최초 구매입니까?");
		check2.setBounds(10,250,300,20);
		c.add(check1);
		c.add(check2);


		check1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				Object source = e.getStateChange();
				if((int)source == 1) {
					b=0;
					d=0;
					if(ms1 == 0) {
						supply = "일반공급";
						ze = 0;
					}else if(ms1 == 1) {
						ze = 1;
						supply = "신혼부부";
					}else if(ms1 == 2) {
						ze = 2;
						supply = "신혼부부";
					}else {
						ze = 3;
						supply = "신혼부부";
					}
				}

				if((int)source == 1) {
					b=0;
					d=0;
					if(a == 2) {
						a = 1;
					}else if(a== 3) {
						a = 2;
					}else if(a >= 4) {
						a = 3;
					}
				}

			}

		});


		check2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				Object source = e.getStateChange();
				if((int)source == 1) {
					if(cy1==0) {
						supply = "일반공급";
					}else if(cy1==1) {
						supply = "일반공급";
					}else if(cy1==2) {
						supply = "일반공급";
					}else if(cy1==3) {
						supply = "일반공급";
					}else {
						supply = "생애최초";
					}
				}
			}
		});


		JButton buttonPanel = new JButton("계산");
		buttonPanel.setBounds(119,320,100,20);
		buttonPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Rank(supply, cy1);

				sum = a+b+d+ze;

				JFrame Score = new Score(sum, supply, rank);
			}

		});
		c.add(buttonPanel);

		setLocationRelativeTo(null);
		setResizable(false);
		setSize(350,450);
		setVisible(true);

	}

	public void Supply(String supply, int mj1) {

		String supply1 = "다자녀공급";

		if(supply == supply1) {

			if(mj1  < 2) {
				b = 0;
			}else if (mj1 < 6) {
				b = 10;
			}else {
				b = 15;
			}
		}

	}

	public void Bankbook(String supply, int cy1) {

		String supply1 = "다자녀공급";

		if(supply == supply1) {

			if(cy1  < 12) {
				a = 0;
			}else {
				a = 5;
			}
		}

	}

	public void Rank(String supply, int cy1) {

		if(supply == "일반공급" || supply == "생애최초") {
			if(cy1 >= 4) {
				rank = "1순위";
			}else {
				rank = "2순위";
			}

		}else {
			if(cy1 >=2) {
				rank = "1순위";
			}else {
				rank = "2순위";
			}
		}



	}



}