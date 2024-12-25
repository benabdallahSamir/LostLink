package main;

import java.util.ArrayList;

public class Items {
	private ArrayList<Item> items = new ArrayList<Item>();
	private int lastId = 0;
	public void addItem (Item item) {
		items.add(item);
		lastId ++ ;
	}
	public int getLastId() {
		return lastId;
	}

	public ArrayList<Item> showItems () {
		return items;
	}
	
	public ArrayList<Item> searchItem (String name) {
		ArrayList<Item> result = new ArrayList<Item>();
		for (int i=0 ; i<items.size() ; i++) {
			if (items.get(i).getName().contains(name)) {
				result.add(items.get(i));
			}
		}
		return result;
	}
	public Item searchItem (int id) {
		for (int i=0 ; i<items.size() ; i++) {
			if (items.get(i).getId()== id) {
				return items.get(i);
			}
		}
		return null;
	}
	public boolean removeItem (int id) {
		for (int i=0 ; i<items.size() ; i++) {
			if (items.get(i).getId() == id) {
				items.remove(i);
				return true ;
			}
		}
		return false ; 
	}
	public boolean updateItem (int id , Item item) {
		for (int i=0 ; i<items.size() ; i++) {
			if (items.get(i).getId() == id) {
				items.remove(i);
				items.add(item);
				return true ;
			}
		}
		return false ; 
	}
	
}
