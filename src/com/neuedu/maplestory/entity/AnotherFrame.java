package com.neuedu.maplestory.entity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.util.ImageUtil;
/**
 * ��½����
 * @author lunan
 *
 */
public class AnotherFrame extends JFrame {

 /**
  * 
  */
 private static final long serialVersionUID = 1L;

 public JButton jButton1 = new JButton(" ");
 public Image image = ImageUtil.get("bc");

 ImageIcon icon = new ImageIcon(
   AnotherFrame.class.getClassLoader().getSystemResource("com/neuedu/maplestory/images/icon/2.gif"));
 /**
  * ������
  */
 public AnotherFrame() {
  // TODO Auto-generated method stub
  setLayout(null);
  Container cp = getContentPane();
  cp.add(jButton1);
  jButton1.setBounds(250, 350, 300, 140);
  jButton1.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    new MapleStoryClient().loadFrame();
    setVisible(false);
   }
  });
  jButton1.setIcon(icon);
  setVisible(true);
  setSize(900, 850);
  setResizable(false);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  setIconImage(ImageUtil.get("icon"));
  setTitle("�ð�յ�v1.0_���ߣ���ľ");
 }

 @Override
 public void paint(Graphics g) {
  g.drawImage(image, 0, 0, null);
  Color color = g.getColor();
  Font font = g.getFont();
  g.setFont(new Font("΢���ź�", Font.BOLD, 30));
  g.setColor(Color.BLACK);
  g.drawString("��ӭ����ð�յ������磡", 250, 300);
  g.setFont(font);
  g.setColor(color);

 }
 /**
  * ���ƴ���
  * @param args args main������һ����д
  */
 public static void main(String[] args) {
	 new AnotherFrame();
	 }
 }