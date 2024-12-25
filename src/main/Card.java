package main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class Card extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel = new JLabel();
	private JLabel titleLabel = new JLabel();
	private JLabel dateLabel = new JLabel();
	private Main main = null ;
	private int id = -1 ;
	public Card(Main main , int id) {
		this();
		this.main = main ;
		this.id = id ;
		Item item = main.items.searchItem(id);
		dateLabel.setText(item.getDate());
		titleLabel.setText(item.getName());
		ImageIcon icon = Item.genImage(item.getImg());
		imageLabel.setIcon(icon);
	}
	public Card() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.changePage(new DetailsPage(main , id));
			}
		});
		setPreferredSize(new Dimension(200, 179));
		setBorder(new LineBorder(new Color(9, 21, 64), 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 60));
		panel.setOpaque(false);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		titleLabel.setForeground(new Color(9, 21, 64));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(10, 11, 275, 22);
		panel.add(titleLabel);
		
		dateLabel.setForeground(new Color(9, 21, 64));
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateLabel.setBounds(10, 35, 78, 14);
		panel.add(dateLabel);
		
		
		
		add(imageLabel, BorderLayout.CENTER);

	}

}
