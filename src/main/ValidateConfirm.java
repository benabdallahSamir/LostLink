package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ValidateConfirm extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public boolean isConfirm = false ;


	public ValidateConfirm(Main main) {
        super(main,"validate confirm", true);
        setUndecorated(true);
        setResizable(false);
		setSize(378, 133);
		setLocationRelativeTo(main);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Validate Form?");
		titleLabel.setForeground(new Color(9, 21, 64));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(10, 11, 273, 21);
		contentPanel.add(titleLabel);
		
		JTextPane txtpnAreYouSure = new JTextPane();
		txtpnAreYouSure.setFocusable(false);
		txtpnAreYouSure.setEditable(false);
		txtpnAreYouSure.setForeground(new Color(100, 116, 139));
		txtpnAreYouSure.setText("All required fields have been filled correctly. You can now submit the report.");
		txtpnAreYouSure.setBounds(10, 37, 352, 41);
		contentPanel.add(txtpnAreYouSure);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 40));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continue");
				okButton.setPreferredSize(new Dimension(80, 23));
				okButton.setMargin(new Insets(2, 20, 2, 20));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				okButton.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
				okButton.setBackground(new Color(9, 21, 64));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isConfirm = true;
						dispose();
					}
				});
				buttonPane.add(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setPreferredSize(new Dimension(80, 23));
				cancelButton.setMargin(new Insets(2, 20, 2, 20));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				cancelButton.setForeground(new Color(9, 21, 64));
				cancelButton.setBorder(new LineBorder(new Color(9, 21, 64), 2, true));
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
}
