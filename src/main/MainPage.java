package main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MainPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private Main main = null;
	public MainPage (Main main) {
		this();
		this.main = main ;	
	}
	public MainPage() {
		setOpaque(false);
		setLayout(null);
		JPanel reportButton = new JPanel();
		reportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reportButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			main.changePage(new ReportPage(main));
			}
		});
		reportButton.setBackground(new Color(118, 146, 255));
		reportButton.setBorder(new LineBorder(new Color(9, 21, 64), 1, true));
		reportButton.setBounds(111, 82, 216, 151);
		add(reportButton);
		reportButton.setLayout(null);
		
		JLabel reportTitle = new JLabel("Report a Found Item");
		reportTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		reportTitle.setForeground(new Color(9, 21, 64));
		reportTitle.setHorizontalAlignment(SwingConstants.CENTER);
		reportTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		reportTitle.setBounds(0, 11, 216, 22);
		reportButton.add(reportTitle);
		
		JTextPane reportDescription = new JTextPane();
		reportDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.changePage(new ReportPage(main));
			}
		});
		reportDescription.setFocusable(false);
		reportDescription.setEditable(false);
		reportDescription.setForeground(new Color(61, 61, 140));
		reportDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reportDescription.setText("Help reunite someone\r\nwith their lost belongings. \r\nSubmit details of the item\r\nyou’ve found and bring\r\na smile to someone’s day.");
		reportDescription.setOpaque(false);
		reportDescription.setBounds(10, 44, 177, 96);
		reportButton.add(reportDescription);
		
		JPanel searchButton = new JPanel();
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.changePage(new SearchePage(main));
			}
		});
		searchButton.setLayout(null);
		searchButton.setBorder(new LineBorder(new Color(9, 21, 64), 1, true));
		searchButton.setBackground(new Color(118, 146, 255));
		searchButton.setBounds(369, 82, 216, 151);
		add(searchButton);
		
		JLabel searchTitle = new JLabel("Search for a Lost Item");
		searchTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		searchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitle.setForeground(new Color(9, 21, 64));
		searchTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchTitle.setBounds(0, 11, 212, 22);
		searchButton.add(searchTitle);
		
		JTextPane searchDescription = new JTextPane();
		searchDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.changePage(new SearchePage(main));
			}
		});
		searchDescription.setFocusable(false);
		searchDescription.setEditable(false);
		searchDescription.setText("Lost something important? \r\nBrowse reported found items \r\nand take a step closer\r\nto retrieving what’s yours.");
		searchDescription.setOpaque(false);
		searchDescription.setForeground(new Color(61, 61, 140));
		searchDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchDescription.setBounds(10, 44, 202, 96);
		searchButton.add(searchDescription);
		
		this.setVisible(true);
	}
}
