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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class Vehicule extends JFrame {

	private JPanel contentPane;
	
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel =new DefaultListModel();
	private JTextField tf_cautaVehiculDupaPret;
		
	@SuppressWarnings("unchecked")
	public void addlista() throws Exceptions, proiect.Exceptions{
	
		ArrayList<Masina> lista=Vehicule.afiseazaMasina();
		listModel.clear();
		for(Masina m : lista)
			listModel.addElement(m);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicule frame = new Vehicule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Vehicule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JRadioButton radioMasini = new JRadioButton("Masini");
		final JRadioButton radioComponente = new JRadioButton("Componente");
		
		radioComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioMasini.setSelected(false);
			}
		});
		radioComponente.setBounds(20, 43, 109, 23);
		contentPane.add(radioComponente);
	
	
		radioMasini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioComponente.setSelected(false);
			}
		});
		
		radioMasini.setBounds(20, 17, 109, 23);
		contentPane.add(radioMasini);
		final JLabel label = new JLabel("");
		label.setBounds(135, 0, 288, 23);
		contentPane.add(label);
		
			
		JButton btnAfiseaza = new JButton("Afiseaza");
		btnAfiseaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(radioMasini.isSelected()){
					addlista();
					label.setText("");
					}
					else if(radioComponente.isSelected()){
						addlista();
						label.setText("");
					}
					else label.setText("Nu ati selectat nimic");
				} 
				catch (Exceptions e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAfiseaza.setBounds(20, 75, 89, 23);
		contentPane.add(btnAfiseaza);
		
		@SuppressWarnings({ "rawtypes" })
		JList list = new JList();
		list.setModel(listModel);
		list.setBounds(145, 20, 469, 114);
		contentPane.add(list);
		
		JLabel lblCautaVehiculDupaPret = new JLabel("Cauta vehicul dupa pret");
		lblCautaVehiculDupaPret.setBounds(321, 164, 141, 14);
		contentPane.add(lblCautaVehiculDupaPret);
		
		tf_cautaVehiculDupaPret = new JTextField();
		tf_cautaVehiculDupaPret.setBounds(145, 189, 469, 23);
		contentPane.add(tf_cautaVehiculDupaPret);
		tf_cautaVehiculDupaPret.setColumns(10);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(145, 219, 469, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tf_cautaVehiculDupaPret.getText().isEmpty())
						throw new Exception("Nu ati scris nimic");
					double pret=Double.valueOf(tf_cautaVehiculDupaPret.getText());
					
					Vehicul m= Vehicul.cautaVehiculDupaPret(afiseazaMasina(),pret);
					lblNewLabel.setText(m.toString());
				} catch (Exception e1) {
					lblNewLabel.setText(e1.toString());
				}
				
			}
		});
		btnCauta.setBounds(20, 189, 89, 23);
		contentPane.add(btnCauta);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 143, 89, 35);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnProfit = new JButton("Profit");
		btnProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarDealer o=new CarDealer();
				ArrayList<Vehicul> lista=new ArrayList<>();
				try {
					lista.addAll(afiseazaMasina());
					lista.addAll(afiseazaMasina());
					lblNewLabel_1.setText(String.valueOf(o.venitTotal(lista)));
					if(o.venitTotal(lista)==0.0) lblNewLabel_1.setText("Incorect");
				} catch (Exceptions e1) {
					lblNewLabel_1.setText(e1.toString());
				} catch (Exception e1) {
					lblNewLabel_1.setText(e1.toString());
				}
			}
		});
		btnProfit.setBounds(20, 109, 89, 23);
		contentPane.add(btnProfit);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame v=MainFrame.getInstanta();
				v.setVisible(true);
								
			}
		});
		btnInapoi.setBounds(20, 219, 89, 23);
		contentPane.add(btnInapoi);
		
	}
	
	public static ArrayList<Masina> afiseazaMasina() throws Exceptions, proiect.Exceptions{
		
		ArrayList<Masina> list=new ArrayList<>();
		Oras carD1 = new Oras("Bucuresti ", "1");
		Oras carD2= new Oras("Focsani", "2");

		ArrayList<Oras> vehicule = new ArrayList<>();
		vehicule.add(carD1);
		vehicule.add(carD2);
		
		
		Masina m1 = new Masina("1234","categorie 1" , vehicule, "serie 1", "masina 1", 200.0);
		
		m1.setTip("Masina");
		
		m1.setNrVanzari(2);
		Masina m2 = new Masina("3567", "categorie 2", vehicule , "serie 2", "masina 2", 800.60);
		m2.setNrVanzari(5);
        list.add(m1);
        list.add(m2);
		Masina.salvareFisier(list);
		ArrayList<Masina> lista=(ArrayList<Masina>) Masina.citireFisier();
		return lista;
		
	}
}
