package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Item {
	private int id ; 
	private String location , name , img , description;
	public Founder founder ;
	
	public static ImageIcon genImage (String path) {
		ImageIcon originalIcon = new ImageIcon(path);
		Image scaledImage = originalIcon.getImage().getScaledInstance(210, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		 return scaledIcon;
	}
	public static ImageIcon genImage (String path , int w , int h) {
		ImageIcon originalIcon = new ImageIcon(path);
		Image scaledImage = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		 return scaledIcon;
	}
	public Item (int id , String name ,String description, String location , String img , Founder founder) {
		this.id = id ;
		this.name = name ;
		this.description = description;
		this.founder = founder ;
		this.img = img ; 
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
}
