package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.control.*;
import cn.edu.zucc.takeaway.model.BeanAddresser;
import cn.edu.zucc.takeaway.model.BeanKind;
import cn.edu.zucc.takeaway.model.BeanOwnerCount;
import cn.edu.zucc.takeaway.model.BeanShops;
import cn.edu.zucc.takeaway.util.BaseException;




public class FrmAddCount extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("添加");
	private Button btnCancel = new Button("取消");
	
	private JLabel labelPrice = new JLabel("需求消费额：");
	private JTextField jt1=new JTextField(15);
	
	private JLabel labelVip = new JLabel("减免消费额：");
	private JTextField jt2=new JTextField(15);
	

	
	private BeanShops bs ;
	public FrmAddCount(FrmCount frmCount, String s, boolean b, BeanShops curshop) {
		super(frmCount, s, b);
	
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelPrice);
		workPane.add(jt1);
		workPane.add(labelVip);
		workPane.add(jt2);
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(290, 160);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
		bs=curshop;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			if(this.jt1.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog(null, "需求价格为空","错误",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(this.jt2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "减免为空","错误",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			
			ExampleCountManager ex=new ExampleCountManager();
			try {
				double p1=Double.parseDouble(this.jt1.getText());
				double p2=Double.parseDouble(this.jt2.getText());
				ex.addcount(bs,p1,p2);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
					return;
				
			}
			JOptionPane.showMessageDialog(null, "添加成功","成功",JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
			
		
	}


}
