package main;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel container = new JPanel();
	private JButton returnButton = new JButton("Return");
	public Items items = new Items();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void changePage (Component page) {
		returnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnButton.setForeground(Color.WHITE);
		returnButton.setVisible(!(page instanceof MainPage));
		container.removeAll();
		container.add(page);
		container.updateUI();
	}
	private void goToMain () {
		changePage(new MainPage(this));
	}
	public Main() {
		setResizable(false);
		setTitle("LostLink");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel navigateur = new JPanel();
		navigateur.setBackground(new Color(9, 21, 64));
		navigateur.setPreferredSize(new Dimension(10, 80));
		contentPane.add(navigateur, BorderLayout.NORTH);
		navigateur.setLayout(null);
		
		JLabel mainTitle = new JLabel("LostLink");
		mainTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMain();
			}
		});
		mainTitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainTitle.setBounds(278, 30, 106, 27);
		mainTitle.setPreferredSize(new Dimension(40, 16));
		mainTitle.setForeground(new Color(171, 210, 250));
		mainTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		navigateur.add(mainTitle);
		
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMain();
			}
		});
		returnButton.setOpaque(false);
		returnButton.setBorder(new LineBorder(new Color(240, 240, 240), 1, true));
		returnButton.setBackground(new Color(0, 0, 0, 0));
		returnButton.setBounds(10, 30, 99, 27);
		navigateur.add(returnButton);
		
		
		container.setBackground(new Color(171, 210, 250));
		container.setLayout(new BorderLayout(0, 0));
		changePage(new MainPage(this));
		contentPane.add(container, BorderLayout.CENTER);
	}
}
