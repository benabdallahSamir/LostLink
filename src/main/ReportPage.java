package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.util.regex.Pattern;

public class ReportPage extends JPanel {

	private static final long serialVersionUID = 1L;
	Main main = null ;
	private JTextField founderNameInput = new JTextField();
	private JTextField founderPhoneNumberInput = new JTextField();
	private JTextField itemNameInput = new JTextField();
	private JTextField itemLocationInput = new JTextField();
	private JTextField itemImageInput = new JTextField();
	private JButton validateButton = new JButton("Validate");
	private JTextArea itemDescriptionInput = new JTextArea();
	// vars
	private String foundername =""; 
	private String founderphonenumber = "";
	private String itemname = "";
	private String itemlocation = "";
	private String itemdescription = "";
	private String itemimage = "";
	public ReportPage(Main main) {
		this();
		this.main = main;
	}
	private boolean hundleInputs () {
		validateButton.setBackground(Color.gray);
		validateButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		foundername = founderNameInput.getText().toString(); 
		founderphonenumber = founderPhoneNumberInput.getText().toString();
		itemname = itemNameInput.getText().toString();
		itemlocation = itemLocationInput.getText().toString();
		itemdescription = itemDescriptionInput.getText().toString();
		itemimage = itemImageInput.getText().toString();
		boolean isInputsEmpty = foundername.isEmpty() || 
				founderphonenumber.isEmpty() ||
				itemname.isEmpty() ||
				itemlocation.isEmpty() ||
				itemimage.isEmpty() ||
				itemdescription.isEmpty() ;
		boolean isPhoneNumberCorrect = Founder.isPhoneNumberCorrect(founderphonenumber);
		if (!isInputsEmpty && isPhoneNumberCorrect) {
			validateButton.setBackground(new Color(9,21,64));
			validateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			return true ;
		}
		return false;
	}
	public ReportPage() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		// create main title
		JLabel mainTitle = new JLabel("Report a Found Item");
		mainTitle.setForeground(new Color(9, 21, 64));
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(mainTitle, BorderLayout.NORTH);
		// create form 
		JPanel form = new JPanel();
		form.setOpaque(false);
		add(form, BorderLayout.CENTER);
		form.setLayout(new BorderLayout(0, 0));
		// create founder information part form
		JPanel founderForm = new JPanel();
		founderForm.setOpaque(false);
		founderForm.setPreferredSize(new Dimension(250, 10));
		form.add(founderForm, BorderLayout.EAST);
		founderForm.setLayout(new GridLayout(6, 0, 0, 0));
		// title of founder information part
		JLabel founderContainerTitle = new JLabel("Founder details:");
		founderContainerTitle.setForeground(new Color(9, 21, 64));
		founderContainerTitle.setPreferredSize(new Dimension(79, 20));
		founderContainerTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		founderForm.add(founderContainerTitle);
		// founder name 
		JPanel founderNameContainer = new JPanel();
		founderNameContainer.setOpaque(false);
		founderForm.add(founderNameContainer);
		founderNameContainer.setLayout(null);
		
		JLabel founderNameLabel = new JLabel("Name:*");
		founderNameLabel.setForeground(new Color(9, 21, 64));
		founderNameLabel.setMinimumSize(new Dimension(37, 16));
		founderNameLabel.setPreferredSize(new Dimension(79, 20));
		founderNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		founderNameLabel.setBounds(0, 11, 250, 14);
		founderNameContainer.add(founderNameLabel);
		
		founderNameInput = new JTextField();
		founderNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		founderNameInput.setMargin(new Insets(2, 10, 2, 2));
		founderNameInput.setLocation(new Point(0, 18));
		founderNameInput.setBorder(new LineBorder(new Color(9, 21, 64)));
		founderNameInput.setForeground(new Color(9, 21, 64));
		founderNameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		founderNameInput.setBounds(0, 25, 213, 20);
		founderNameContainer.add(founderNameInput);
		founderNameInput.setColumns(10);
		// founder phone number
		JPanel founderPhoneNumberContainer = new JPanel();
		founderPhoneNumberContainer.setOpaque(false);
		founderPhoneNumberContainer.setLayout(null);
		founderForm.add(founderPhoneNumberContainer);
		
		JLabel founderPhonenumberLabel = new JLabel("PhoneNumber:*");
		founderPhonenumberLabel.setForeground(new Color(9, 21, 64));
		founderPhonenumberLabel.setPreferredSize(new Dimension(79, 20));
		founderPhonenumberLabel.setMinimumSize(new Dimension(37, 16));
		founderPhonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		founderPhonenumberLabel.setBounds(0, 11, 250, 14);
		founderPhoneNumberContainer.add(founderPhonenumberLabel);
		
		founderPhoneNumberInput = new JTextField();
		founderPhoneNumberInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		founderPhoneNumberInput.setMargin(new Insets(2, 10, 2, 2));
		founderPhoneNumberInput.setLocation(new Point(0, 18));
		founderPhoneNumberInput.setForeground(new Color(61, 61, 140));
		founderPhoneNumberInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		founderPhoneNumberInput.setColumns(10);
		founderPhoneNumberInput.setBorder(new LineBorder(new Color(9, 21, 64)));
		founderPhoneNumberInput.setBounds(0, 25, 213, 20);
		founderPhoneNumberContainer.add(founderPhoneNumberInput);
		// create spacing 
		JPanel space = new JPanel();
		space.setOpaque(false);
		founderForm.add(space);
		space.setLayout(null);
		
		JLabel lblExemple = new JLabel("exemple: 0123456789");
		lblExemple.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExemple.setBounds(0, 0, 125, 14);
		space.add(lblExemple);
		
		JPanel sapce_2 = new JPanel();
		sapce_2.setOpaque(false);
		founderForm.add(sapce_2);
		// create buttons 
		JPanel buttonContainer = new JPanel();
		buttonContainer.setOpaque(false);
		founderForm.add(buttonContainer);
		buttonContainer.setLayout(null);
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!hundleInputs()) return ;
				ValidateConfirm validateConfirm = new ValidateConfirm(main);
				if (!validateConfirm.isConfirm) return;
				// create item
				Founder founder = new Founder(foundername, founderphonenumber);
				Item item = new Item(main.items.getLastId(), itemname,itemdescription, itemlocation, itemimage, founder);
				main.items.addItem(item);
				// reset intputs
				founderNameInput.setText("");
				founderPhoneNumberInput.setText("");
				itemNameInput.setText("");
				itemLocationInput.setText("");
				itemDescriptionInput.setText("");
				itemImageInput.setText("");
				// go to main
				main.changePage(new MainPage(main));
			}
		});

		validateButton.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
		validateButton.setForeground(new Color(255, 255, 255));
		validateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		validateButton.setBackground(Color.gray);
		validateButton.setBounds(57, 12, 89, 23);
		buttonContainer.add(validateButton);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetConfirm resetConfirm = new ResetConfirm(main);
				if (!resetConfirm.isConfirm) return;
				founderNameInput.setText("");
				founderPhoneNumberInput.setText("");
				itemNameInput.setText("");
				itemLocationInput.setText("");
				itemDescriptionInput.setText("");
				itemImageInput.setText("");
			}
		});
		ResetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ResetButton.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
		ResetButton.setOpaque(false);
		ResetButton.setForeground(new Color(9, 21, 64));
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ResetButton.setBackground(new Color(9, 21, 64));
		ResetButton.setBounds(151, 12, 89, 23);
		buttonContainer.add(ResetButton);
		// create item part form
		JPanel itemForm = new JPanel();
		itemForm.setOpaque(false);
		form.add(itemForm, BorderLayout.CENTER);
		itemForm.setLayout(new GridLayout(7, 0, 0, 0));
		
		// item title
		
		JLabel itemContainerTitle = new JLabel("       Found item details:");
		itemContainerTitle.setForeground(new Color(9, 21, 64));
		itemContainerTitle.setPreferredSize(new Dimension(79, 20));
		itemContainerTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		itemForm.add(itemContainerTitle);
		
		// item name field
		
		JPanel itemNameContainer = new JPanel();
		itemNameContainer.setLayout(null);
		itemNameContainer.setOpaque(false);
		itemForm.add(itemNameContainer);
		
		JLabel itemNameLabel = new JLabel("Item Name:*");
		itemNameLabel.setForeground(new Color(9, 21, 64));
		itemNameLabel.setPreferredSize(new Dimension(79, 20));
		itemNameLabel.setMinimumSize(new Dimension(37, 16));
		itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		itemNameLabel.setBounds(20, 11, 117, 14);
		itemNameContainer.add(itemNameLabel);
		
		itemNameInput = new JTextField();
		itemNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		itemNameInput.setMargin(new Insets(2, 10, 2, 2));
		itemNameInput.setLocation(new Point(0, 18));
		itemNameInput.setForeground(new Color(9, 21, 64));
		itemNameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemNameInput.setColumns(10);
		itemNameInput.setBorder(new LineBorder(new Color(9, 21, 64)));
		itemNameInput.setBounds(147, 10, 213, 20);
		itemNameContainer.add(itemNameInput);
		
		// item location field
		
		JPanel itemLocationContainer = new JPanel();
		itemLocationContainer.setLayout(null);
		itemLocationContainer.setOpaque(false);
		itemForm.add(itemLocationContainer);
		
		JLabel itemLocationLabel = new JLabel("Item Location:*");
		itemLocationLabel.setForeground(new Color(9, 21, 64));
		itemLocationLabel.setPreferredSize(new Dimension(79, 20));
		itemLocationLabel.setMinimumSize(new Dimension(37, 16));
		itemLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		itemLocationLabel.setBounds(20, 11, 117, 14);
		itemLocationContainer.add(itemLocationLabel);
		
		itemLocationInput = new JTextField();
		itemLocationInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		itemLocationInput.setMargin(new Insets(2, 10, 2, 2));
		itemLocationInput.setLocation(new Point(0, 18));
		itemLocationInput.setForeground(new Color(9, 21, 64));
		itemLocationInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemLocationInput.setColumns(10);
		itemLocationInput.setBorder(new LineBorder(new Color(9, 21, 64)));
		itemLocationInput.setBounds(147, 10, 213, 20);
		itemLocationContainer.add(itemLocationInput);
		
        // item description field
        
		JLabel itemDescriptionLabel = new JLabel("     Item Description:*");
		itemDescriptionLabel.setForeground(new Color(9, 21, 64));
		itemDescriptionLabel.setPreferredSize(new Dimension(79, 20));
		itemDescriptionLabel.setMinimumSize(new Dimension(37, 16));
		itemDescriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		itemForm.add(itemDescriptionLabel);
		
		JPanel itemDescriptionContainer = new JPanel();
		itemDescriptionContainer.setOpaque(false);
		itemForm.add(itemDescriptionContainer);
		itemDescriptionContainer.setLayout(null);
		itemLocationInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		itemDescriptionInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				hundleInputs();
			}
		});
		
		itemDescriptionInput.setForeground(new Color(9, 21, 64));
		itemDescriptionInput.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
		itemDescriptionInput.setBounds(20, 0, 390, 33);
		itemDescriptionContainer.add(itemDescriptionInput);
		
		//item image field
		
		JPanel itemImageContainer = new JPanel();
		itemImageContainer.setLayout(null);
		itemImageContainer.setOpaque(false);
		itemForm.add(itemImageContainer);
		
		JLabel itemImageLabel = new JLabel("Item Image:*");
		itemImageLabel.setForeground(new Color(9, 21, 64));
		itemImageLabel.setPreferredSize(new Dimension(79, 20));
		itemImageLabel.setMinimumSize(new Dimension(37, 16));
		itemImageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		itemImageLabel.setBounds(22, 11, 115, 19);
		itemImageContainer.add(itemImageLabel);
		
		itemImageInput = new JTextField();
		itemImageInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChoose = new JFileChooser();
				int returnValue = fileChoose.showOpenDialog(null);
				 if (returnValue == JFileChooser.APPROVE_OPTION) {
					 if (Pattern.matches("^.+(.jpg|.png|.jpeg|.gif)$", fileChoose.getSelectedFile().getAbsolutePath())) 						 
						 itemImageInput.setText(fileChoose.getSelectedFile().getAbsolutePath());
				 }
				 hundleInputs();
			}
		});
		itemImageInput.setEnabled(false);
		itemImageInput.setEditable(false);
		itemImageInput.setMargin(new Insets(2, 10, 2, 2));
		itemImageInput.setLocation(new Point(0, 18));
		itemImageInput.setForeground(new Color(9, 21, 64));
		itemImageInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemImageInput.setColumns(10);
		itemImageInput.setBorder(new LineBorder(new Color(9, 21, 64)));
		itemImageInput.setBounds(147, 10, 213, 20);
		itemImageContainer.add(itemImageInput);

	}
}
