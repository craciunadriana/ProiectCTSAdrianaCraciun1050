package proiect;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Login extends JFrame {

	JTextField textNume;
	JTextField textCod;
	private static Login instanta;

	public boolean logare(Oras c){
		boolean login= false;
		if("Bucuresti".equals(c.getNume()) & "1993".equals(c.getCod()))
			login= true;
	
		else
		if(textNume.getText()==null || textCod.getText()==null)
			login= false;
			
	return login;

	}

	public static Login getInstanta()
	{
		if(instanta == null)
			instanta=new Login();
		return instanta;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setTitle("Login");
		setEnabled(true);
		setBounds(100, 100, 455, 209);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Car Dealer Location");
		lblNewLabel.setBounds(75, 53, 117, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblParola = new JLabel("Code");
		lblParola.setBounds(75, 86, 46, 14);
		getContentPane().add(lblParola);
		
		textNume = new JTextField();
		textNume.setBounds(216, 50, 177, 17);
		getContentPane().add(textNume);
		textNume.setColumns(10);
		
		textCod = new JTextField();
		textCod.setBounds(216, 83, 177, 17);
		getContentPane().add(textCod);
		textCod.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				Oras c= new Oras(textNume.getText(), textCod.getText());
			
				boolean login=logare(c);
			
				if(login){
				MainFrame v=MainFrame.getInstanta();
				v.setVisible(login);
			}
				
				
			}
		});
		btnLogIn.setBounds(181, 125, 89, 23);
		getContentPane().add(btnLogIn);
		
	}

}
