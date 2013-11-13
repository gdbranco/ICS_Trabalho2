import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	JSpinner HarmonicoSpinner = new JSpinner();
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
		frame.setBounds(100, 100, 795, 514);
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

		DuracaoSpinner.setModel(new SpinnerNumberModel(new Double(0), null,
				null, new Double(1)));
		DuracaoSpinner.setBounds(101, 73, 39, 20);
		frame.getContentPane().add(DuracaoSpinner);

		FrequenciaSpinner.setModel(new SpinnerNumberModel(new Double(0), null,
				null, new Double(100)));
		FrequenciaSpinner.setBounds(84, 48, 56, 20);
		frame.getContentPane().add(FrequenciaSpinner);

		AmplitudeSpinner.setModel(new SpinnerNumberModel(new Double(0), null,
				null, new Double(5)));
		AmplitudeSpinner.setBounds(94, 23, 46, 20);
		frame.getContentPane().add(AmplitudeSpinner);

		FaseSpinner.setModel(new SpinnerNumberModel(new Double(0), null, null,
				new Double(1)));
		FaseSpinner.setBounds(101, 98, 39, 20);
		frame.getContentPane().add(FaseSpinner);
		NovaNotaBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		NovaNotaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listenerAdd();
			}
		});

		NovaNotaBtn.setBounds(10, 126, 120, 23);
		frame.getContentPane().add(NovaNotaBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 11, 486, 296);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(TabelaNotas);

		TabelaNotas.setColumnSelectionAllowed(true);
		TabelaNotas.setCellSelectionEnabled(true);
		TabelaNotas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero", "Duracao", "Amplitude", "Frequencia",
						"Fase" }) {
			Class[] columnTypes = new Class[] { Integer.class, Float.class,
					Float.class, Float.class, Float.class };

		});
		TabelaNotas.getColumnModel().getColumn(4).setPreferredWidth(76);

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

		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(27.5 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnA.setBounds(10, 318, 58, 23);
		frame.getContentPane().add(btnA);

		JButton btnA_1 = new JButton("A#");
		btnA_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(29.14 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnA_1.setBounds(10, 354, 58, 23);
		frame.getContentPane().add(btnA_1);

		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(30.87 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnB.setBounds(10, 388, 58, 23);
		frame.getContentPane().add(btnB);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(16.35 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnC.setBounds(82, 318, 58, 23);
		frame.getContentPane().add(btnC);

		JButton btnC_1 = new JButton("C#");
		btnC_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(17.32 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnC_1.setBounds(84, 354, 56, 23);
		frame.getContentPane().add(btnC_1);

		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(18.35 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnD.setBounds(84, 388, 56, 23);
		frame.getContentPane().add(btnD);

		JButton btnD_1 = new JButton("D#");
		btnD_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(19.45 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnD_1.setBounds(150, 318, 56, 23);
		frame.getContentPane().add(btnD_1);

		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(20.60 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnE.setBounds(150, 354, 58, 23);
		frame.getContentPane().add(btnE);

		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(21.83 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnF.setBounds(148, 388, 58, 23);
		frame.getContentPane().add(btnF);

		JButton btnF_1 = new JButton("F#");
		btnF_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(23.12 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnF_1.setBounds(216, 318, 56, 23);
		frame.getContentPane().add(btnF_1);

		JButton btnG = new JButton("G");
		btnG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(24.5 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnG.setBounds(218, 354, 54, 23);
		frame.getContentPane().add(btnG);

		JButton btnG_1 = new JButton("G#");
		btnG_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrequenciaSpinner.setValue(25.96 * Math.pow(2,
						(int) HarmonicoSpinner.getValue()));
			}
		});
		btnG_1.setBounds(216, 388, 58, 23);
		frame.getContentPane().add(btnG_1);

		HarmonicoSpinner.setModel(new SpinnerNumberModel(new Integer(4),
				new Integer(0), null, new Integer(1)));
		HarmonicoSpinner.setBounds(101, 290, 29, 20);
		frame.getContentPane().add(HarmonicoSpinner);

		JLabel lblHarmnico = new JLabel("Harmônico");
		lblHarmnico.setBounds(10, 293, 81, 14);
		frame.getContentPane().add(lblHarmnico);

		JPanel panelKeysNotas = new JPanel();
		panelKeysNotas.setBounds(10, 318, 263, 92);
		frame.getContentPane().add(panelKeysNotas);
	}

	// public void parseMidi() throws InvalidMidiDataException, IOException {
	// File arq = new File("./midis/");
	// JFileChooser escolha = new JFileChooser();
	// escolha.setCurrentDirectory(arq);
	// escolha.setFileSelectionMode(JFileChooser.FILES_ONLY);
	// escolha.showOpenDialog(btnParseMidi);
	// Sequence s = MidiSystem.getSequence(new File(escolha.getSelectedFile()
	// .toString()));
	// Track[] trilhas = s.getTracks();
	// for (Track track : trilhas) {
	// int k;
	// for (k = 0; k < track.size(); k++) {
	// // buscar em cada menságem , duração , amplitude , frequencia ,
	// // fase
	// // realizar as chamadas , uma unidade H para cada track, simples
	// // de fazer
	// }
	// }
	// }

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
		Double duracao = (Double) DuracaoSpinner.getValue();
		Double amp = (Double) AmplitudeSpinner.getValue();
		Double freq = (Double) FrequenciaSpinner.getValue();
		Double fase = (Double) FaseSpinner.getValue();

		DefaultTableModel model = (DefaultTableModel) TabelaNotas.getModel();
		model.addRow(new Object[] { numeroNotas, DuracaoSpinner.getValue(),
				AmplitudeSpinner.getValue(), FrequenciaSpinner.getValue(),
				FaseSpinner.getValue() });
		melodia.addNota(new Nota(duracao.floatValue(), amp.floatValue(), freq
				.floatValue(), fase.floatValue()));
		numeroNotas++;
	}
}
