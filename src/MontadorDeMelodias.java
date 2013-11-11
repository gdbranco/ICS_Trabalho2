import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import sintese.Melodia;
import sintese.Nota;
import sintese.Som;

public class MontadorDeMelodias {

	Instrumento_1 ins1 = new Instrumento_1();
	Instrumento_2 ins2 = new Instrumento_2();
	Instrumento_3 ins3 = new Instrumento_3();

	public Melodia melodia = new Melodia();
	int numeroNotas = 0;
	// so Globals , much program
	JFrame frame = new JFrame();
	public JTable TabelaNotas = new JTable();
	JLabel lblAmplitude = new JLabel("Amplitude");
	JLabel lblFrequencia = new JLabel("Frequencia");
	JLabel lblDuracao = new JLabel("Duracao");
	JLabel lblFase = new JLabel("Fase");
	JSpinner DuracaoSpinner = new JSpinner();
	JSpinner FrequenciaSpinner = new JSpinner();
	JSpinner AmplitudeSpinner = new JSpinner();
	JSpinner FaseSpinner = new JSpinner();
	JButton NovaNotaBtn = new JButton("Nova Nota");
	private final JButton btnPlay_1 = new JButton("Play 2");
	private final JButton btnPlay_2 = new JButton("Play 3");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MontadorDeMelodias window = new MontadorDeMelodias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MontadorDeMelodias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 572, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblAmplitude.setBounds(10, 26, 58, 14);
		frame.getContentPane().add(lblAmplitude);

		lblFrequencia.setBounds(10, 51, 60, 14);
		frame.getContentPane().add(lblFrequencia);

		lblDuracao.setBounds(10, 76, 46, 14);
		frame.getContentPane().add(lblDuracao);

		lblFase.setBounds(10, 101, 46, 14);
		frame.getContentPane().add(lblFase);

		DuracaoSpinner.setModel(new SpinnerNumberModel(new Float(0), null,
				null, new Float(1)));
		DuracaoSpinner.setBounds(101, 73, 39, 20);
		frame.getContentPane().add(DuracaoSpinner);

		FrequenciaSpinner.setModel(new SpinnerNumberModel(new Float(0), null,
				null, new Float(100)));
		FrequenciaSpinner.setBounds(84, 48, 56, 20);
		frame.getContentPane().add(FrequenciaSpinner);

		AmplitudeSpinner.setModel(new SpinnerNumberModel(new Float(0), null,
				null, new Float(5)));
		AmplitudeSpinner.setBounds(94, 23, 46, 20);
		frame.getContentPane().add(AmplitudeSpinner);

		FaseSpinner.setModel(new SpinnerNumberModel(new Float(0), null, null,
				new Float(1)));
		FaseSpinner.setBounds(101, 98, 39, 20);
		frame.getContentPane().add(FaseSpinner);
		NovaNotaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listenerAdd();
			}
		});

		NovaNotaBtn.setBounds(10, 126, 120, 23);
		frame.getContentPane().add(NovaNotaBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(171, 11, 375, 296);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(TabelaNotas);

		TabelaNotas.setColumnSelectionAllowed(true);
		TabelaNotas.setCellSelectionEnabled(true);
		TabelaNotas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero", "Duracao", "Amplitude", "Frequencia",
						"Fase" }) {
			Class[] columnTypes = new Class[] { Integer.class, Float.class,
					Float.class, Float.class, Float.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JButton btnPlay = new JButton("Play 1");
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				play1();
			}
		});
		btnPlay.setBounds(10, 160, 89, 23);
		frame.getContentPane().add(btnPlay);
		btnPlay_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				play2();
			}
		});
		btnPlay_1.setBounds(10, 194, 89, 23);

		frame.getContentPane().add(btnPlay_1);
		btnPlay_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				play3();
			}
		});
		btnPlay_2.setBounds(10, 228, 89, 23);

		frame.getContentPane().add(btnPlay_2);
		TabelaNotas.getColumnModel().getColumn(4).setPreferredWidth(76);
	}

	public void play1() {
		Som som1 = melodia.getSom(ins1);
		som1.visualiza();
	}

	public void play2() {
		Som som2 = melodia.getSom(ins2);
		som2.visualiza();
	}

	public void play3() {
		Som som3 = melodia.getSom(ins3);
		som3.visualiza();
	}

	public void listenerAdd() {
		DefaultTableModel model = (DefaultTableModel) TabelaNotas.getModel();
		model.addRow(new Object[] { numeroNotas,
				(Float) DuracaoSpinner.getValue(),
				(Float) AmplitudeSpinner.getValue(),
				(Float) FrequenciaSpinner.getValue(),
				(Float) FaseSpinner.getValue() });
		melodia.addNota(new Nota((Float) DuracaoSpinner.getValue(),
				(Float) AmplitudeSpinner.getValue(), (Float) FrequenciaSpinner
						.getValue(), (Float) FaseSpinner.getValue()));
		numeroNotas++;
	}
}
