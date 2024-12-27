package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Cursor;

public class SearchePage extends JPanel {

	private static final long serialVersionUID = 1L;
	Main main ;
	private JTextField searchInput;
	private JPanel itemsContainer = new JPanel();
	private JButton searchButton = new JButton("search");
	public void addItem (ArrayList<Item> items) {
		itemsContainer.removeAll();
		for (int i=0 ; i<items.size();i++) {
			itemsContainer.add(new Card(main , items.get(i).getId()));
		}
		itemsContainer.updateUI();
	}
	public SearchePage(Main main) {
		this();
		this.main = main ;
		ArrayList<Item> items = main.items.showItems();
		addItem(items);
	}

	public SearchePage() {
		setBackground(new Color(9, 21, 64));
		setOpaque(false);
		setLayout(null);
		
		JLabel mainTitle = new JLabel("Search for a Lost Item");
		mainTitle.setForeground(new Color(9, 21, 64));
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		mainTitle.setAutoscrolls(true);
		mainTitle.setFocusable(true);
		mainTitle.setFocusTraversalPolicyProvider(true);
		mainTitle.setFocusTraversalKeysEnabled(true);
		mainTitle.setFocusCycleRoot(true);
		mainTitle.setEnabled(true);
		mainTitle.setDoubleBuffered(true);
		mainTitle.setInheritsPopupMenu(true);
		mainTitle.setIgnoreRepaint(true);
		mainTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		mainTitle.setBounds(0, 11, 690, 40);
		add(mainTitle);
		
		JPanel searchContainer = new JPanel();
		searchContainer.setOpaque(false);
		searchContainer.setBounds(182, 45, 366, 51);
		add(searchContainer);
		searchContainer.setLayout(null);
		
		searchInput = new JTextField();
		searchInput.setToolTipText("enter name of item");
		searchInput.setBounds(33, 11, 188, 30);
		searchInput.setPreferredSize(new Dimension(80, 30));
		searchInput.setBorder(new LineBorder(new Color(9, 21, 64), 1, true));
		searchContainer.add(searchInput);
		searchInput.setColumns(10);
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchButton.setForeground(new Color(255, 255, 255));
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = searchInput.getText();
				ArrayList<Item> itemsSearched = main.items.searchItem(value);
				addItem(itemsSearched);
			}
		});
		searchButton.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
		searchButton.setBackground(new Color(9, 21, 64));
		searchButton.setBounds(231, 11, 81, 30);
		searchContainer.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(9, 21, 64));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(0, 98, 690, 202);
		add(scrollPane);
		itemsContainer.setBackground(new Color(9, 21, 64));
		
		
		itemsContainer.setOpaque(false);
		scrollPane.setViewportView(itemsContainer);
		itemsContainer.setLayout(new GridLayout(0, 3, 5, 5));
		
	}
}
