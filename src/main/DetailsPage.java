package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class DetailsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	// elements
	private JLabel itemNameLabel = new JLabel();
	private JLabel itemImageLabel = new JLabel();
	private JTextPane descriptionLabel = new JTextPane();
	private JTextPane locationLabel = new JTextPane();
	private JLabel contactLabel = new JLabel();
	private JLabel dateLabel = new JLabel();
	public DetailsPage(Main main , int id) {
		this();
		Item item = main.items.searchItem(id);
		itemImageLabel.setIcon(Item.genImage(item.getImg()));
		itemNameLabel.setText(item.getName());
		locationLabel.setText(item.getLocation());
		descriptionLabel.setText(item.getDescription());
		dateLabel.setText(item.getDate());
		contactLabel.setText(item.founder.getPhoneNumber());
 	}
	public DetailsPage() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		itemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		itemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		itemImageLabel.setPreferredSize(new Dimension(300, 14));
		add(itemImageLabel, BorderLayout.WEST);
		
		JPanel container = new JPanel();
		container.setOpaque(false);
		add(container, BorderLayout.CENTER);
		container.setLayout(null);
		
		itemNameLabel.setForeground(new Color(9, 21, 64));
		itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		itemNameLabel.setBounds(10, 11, 157, 21);
		container.add(itemNameLabel);
		
		JLabel lblNewLabel = new JLabel("description");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 81, 140));
		lblNewLabel.setBounds(10, 43, 107, 14);
		container.add(lblNewLabel);
		
		descriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		descriptionLabel.setForeground(new Color(9, 21, 64));
		descriptionLabel.setOpaque(false);
		descriptionLabel.setEditable(false);
		descriptionLabel.setBounds(10, 64, 370, 62);
		container.add(descriptionLabel);
		
		locationLabel.setOpaque(false);
		locationLabel.setForeground(new Color(9, 21, 64));
		locationLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		locationLabel.setEditable(false);
		locationLabel.setBounds(10, 145, 370, 54);
		container.add(locationLabel);
		
		JLabel lblLocation = new JLabel("location");
		lblLocation.setForeground(new Color(255, 81, 140));
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocation.setBounds(10, 125, 107, 14);
		container.add(lblLocation);
		
		JLabel lblFoundDate = new JLabel("Found date :");
		lblFoundDate.setForeground(new Color(255, 81, 140));
		lblFoundDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFoundDate.setBounds(11, 210, 107, 14);
		container.add(lblFoundDate);
		
		dateLabel.setForeground(new Color(9, 21, 64));
		dateLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		dateLabel.setBounds(10, 228, 107, 14);
		container.add(dateLabel);
		
		JLabel lblPhoneNumber = new JLabel("Contact");
		lblPhoneNumber.setForeground(new Color(255, 81, 140));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNumber.setBounds(10, 252, 107, 14);
		container.add(lblPhoneNumber);
		
		contactLabel.setForeground(new Color(9, 21, 64));
		contactLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		contactLabel.setBounds(11, 267, 107, 14);
		container.add(contactLabel);
		
		JLabel title = new JLabel("Item Details ");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(9, 21, 64));
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(title, BorderLayout.NORTH);

	}
}
