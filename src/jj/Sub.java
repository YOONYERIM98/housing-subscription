package jj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Sub extends JFrame{

	//û�� �Ⱓ
	String[] CY= {"����","6���� �̸�","6���� �̻� ~ 1�� �̸�","1�� �̻� ~ 2�� �̸�","2�� �̻� ~ 3�� �̸�","3�� �̻� ~ 4�� �̸�","4�� �̻� ~ 5�� �̸�","5�� �̻� ~ 6�� �̸�","6�� �̻� ~ 7�� �̸�","7�� �̻� ~ 8�� �̸�","8�� �̻� ~ 9�� �̸�","9�� �̻� ~ 10�� �̸�","10�� �̻� ~ 11�� �̸�","11�� �̻� ~ 12�� �̸�","12�� �̻� ~ 13�� �̸�","13�� �̻� ~ 14�� �̸�","14�� �̻� ~ 15�� �̸�","15�� �̻�"};
	//������ �Ⱓ
	String[] MJ= {"����","1�� �̸�","1�� �̻� ~ 2�� �̸�","2�� �̻� ~ 3�� �̸�","3�� �̻� ~ 4�� �̸�","4�� �̻� ~ 5�� �̸�","5�� �̻� ~ 6�� �̸�","6�� �̻� ~ 7�� �̸�","7�� �̻� ~ 8�� �̸�","8�� �̻� ~ 9�� �̸�","9�� �̻� ~ 10�� �̸�","10�� �̻� ~ 11�� �̸�","11�� �̻� ~ 12�� �̸�","12�� �̻� ~ 13�� �̸�","13�� �̻� ~ 14�� �̸�","14�� �̻� ~ 15�� �̸�","15�� �̻�"};
	//�ξ簡����
	String[] BY= {"0��","1��","2��","3��","4��","5��","6�� �̻�"};
	//��19���̸��ڳ��
	String[] MS= {"0��","1��","2��","3��","4��","5�� �̻�"};

	String supply, rank;

	JCheckBox check1, check2;

	int a,b,d,ze,sum;
	int mj1, cy1, ms1;


	Sub(){
		setTitle("����û�� �ùķ�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel cy = new JLabel("û������ ���ԱⰣ :");
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

		JLabel mj = new JLabel("������ �Ⱓ :");
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

		JLabel by = new JLabel("�ξ簡���� :");
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

		JLabel ms = new JLabel("��19�� �̸� �ڳ�� :");
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
							supply = "�Ϲݰ���";
						}else
						{
							supply = "���ڳ����";
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

		check1 = new JCheckBox("7�� �̸��� ��ȥ�κ� �Դϱ�?");
		check1.setBounds(10,220,300,20);
		check2 = new JCheckBox("�������� �����Դϱ�?");
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
						supply = "�Ϲݰ���";
						ze = 0;
					}else if(ms1 == 1) {
						ze = 1;
						supply = "��ȥ�κ�";
					}else if(ms1 == 2) {
						ze = 2;
						supply = "��ȥ�κ�";
					}else {
						ze = 3;
						supply = "��ȥ�κ�";
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
						supply = "�Ϲݰ���";
					}else if(cy1==1) {
						supply = "�Ϲݰ���";
					}else if(cy1==2) {
						supply = "�Ϲݰ���";
					}else if(cy1==3) {
						supply = "�Ϲݰ���";
					}else {
						supply = "��������";
					}
				}
			}
		});


		JButton buttonPanel = new JButton("���");
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

		String supply1 = "���ڳ����";

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

		String supply1 = "���ڳ����";

		if(supply == supply1) {

			if(cy1  < 12) {
				a = 0;
			}else {
				a = 5;
			}
		}

	}

	public void Rank(String supply, int cy1) {

		if(supply == "�Ϲݰ���" || supply == "��������") {
			if(cy1 >= 4) {
				rank = "1����";
			}else {
				rank = "2����";
			}

		}else {
			if(cy1 >=2) {
				rank = "1����";
			}else {
				rank = "2����";
			}
		}



	}



}