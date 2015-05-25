package proiect;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import proiect.Vehicule;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private static MainFrame instanta;
	Oras cd1= new Oras("Bucuresti", "1 ");
	Oras cd2=new Oras("Ploiesti", "2 ");
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel =new DefaultListModel();
	
	
	private JTextField textCautMarca;
	ArrayList<Oras> listaCarDealer=new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public void addlista(){
		
		listModel.clear();
		listModel.addElement(cd1);
		listModel.addElement(cd2);
		
	}
	
	
	
	public static MainFrame getInstanta() {
		if(instanta== null)
			instanta= new MainFrame();
		return instanta;
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@SuppressWarnings("unchecked")
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Main Frame");
		setBounds(100, 100, 450, 278);
		getContentPane().setLayout(null);
		
		listaCarDealer.add(cd1);
		listaCarDealer.add(cd2);
		
		@SuppressWarnings("rawtypes")
		final JList lista = new JList();
		
		lista.setBounds(170, 35, 235, 104);
		lista.setModel(listModel);
		
		getContentPane().add(lista);
		getContentPane().setLayout(null);
		
		JButton btnOrase = new JButton("Orase");
		btnOrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addlista();
				
			}
		});
			
		btnOrase.setBounds(21, 32, 117, 23);
		getContentPane().add(btnOrase);
		
		JButton btnVehicule= new JButton("Vehicule");
		btnVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicule v=new Vehicule();
				v.setVisible(true);
			}
		});
		btnVehicule.setBounds(21, 67, 117, 23);
		getContentPane().add(btnVehicule);
		
		JLabel lblOrasDupaNume = new JLabel("Cauta dupa marca");
		lblOrasDupaNume.setBounds(239, 151, 110, 14);
		getContentPane().add(lblOrasDupaNume);
		final JLabel label = new JLabel("");
		label.setBounds(170, 207, 235, 23);
		getContentPane().add(label);
				
		textCautMarca = new JTextField();
		textCautMarca.setBounds(170, 176, 235, 24);
		getContentPane().add(textCautMarca);
		textCautMarca.setColumns(10);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod="";
				try{
					 cod=textCautMarca.getText();
				}catch(Exception ex) {}
				try {
					label.setText(Oras.cautaOrasDupaNume(listaCarDealer, cod).toString());
				} catch (Exception e1) {
					label.setText(e1.toString());
				}
			}
		});
		btnCauta.setBounds(21, 177, 117, 23);
		getContentPane().add(btnCauta);
	}
}

