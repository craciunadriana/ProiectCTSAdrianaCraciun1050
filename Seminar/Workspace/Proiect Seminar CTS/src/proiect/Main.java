package proiect;

public class Main {

	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	Login l=Login.getInstanta();
	                l.setVisible(true);
	            }
	        });
		}
	
}
