package jogo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {

	private final int LARGURA_IMG = 405;
	private final int ALTURA_IMG = 405;
	private final int TEMPO_DE_SPLASH = 4000;
	private ImageIcon logo;

	public Splash() {
		// INSTANCIANDO GIF
		logo = new ImageIcon("C:\\Users\\Raio1\\Desktop\\CEAP\\Aulas Java\\the-scape\\src\\imagem\\gifespaco.gif");
		// INSTANCIANDO JANELA
		JWindow janelaSplash = new JWindow();
		// INSERINDO O GIF
		janelaSplash.getContentPane().add(new JLabel("", logo, SwingConstants.CENTER));
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		// POSICIONANDO
		janelaSplash.setBounds((dimension.width - LARGURA_IMG) / 2, (dimension.height - ALTURA_IMG) / 2, LARGURA_IMG,
				ALTURA_IMG

		);
		// VISIBILIDADE
		janelaSplash.setVisible(true);
		// TIMER
		try {
			Thread.sleep(TEMPO_DE_SPLASH);
		} catch (InterruptedException e) {
		}

		janelaSplash.dispose();

	}
}