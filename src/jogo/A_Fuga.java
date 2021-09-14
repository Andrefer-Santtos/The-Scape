package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class A_Fuga extends JFrame{
	
	private JButton taltris, jacali, arma, faca, bomba, click, direita, esquerda, next, nextStepTwo;
	private JPanel pane;
	private JLabel label;
	private Container container;
	private JTextArea textArea;
	private String planet;
	private JTextField timerField;
	private int count;
	private JProgressBar progressBar;
	private Timer timer;
	private JRadioButton ironia, estupidez, amigavel;
	private ButtonGroup group;

	public A_Fuga() {
		
		inicializarComponentes();
		definirEventos();
		
	}

	private void inicializarComponentes() {
		
		container = getContentPane();
	
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText("Bart � um homem de 25 anos que partiu para uma miss�o em um novo planeta com seus 2 amigos, Feh e Andrew, para descobrir se � habit�vel.\n\n"
				+ "Escolha o planeta que deseja explorar:");
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(150, 200, 600, 80);
		pane.add(textArea);
		
		taltris = new JButton("Taltris");
		taltris.setBounds(200, 400, 100, 30);
		taltris.setFocusable(false);
		pane.add(taltris);
		
		jacali = new JButton("Jacali");
		jacali.setBounds(600, 400, 100, 30);
		jacali.setFocusable(false);
		pane.add(jacali);
		
		container.add(pane);
		
	}
	
	private void definirEventos() {
		
		taltris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newGame("", "Taltis");
				
			}
		});
		
		jacali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newGame("Feh consegue ver naves alien�genas � frente.\n\n"
						+ "   -Cuidado, estamos sendo atacados. N�o deixe nos atingirem.\n\n"
						+ "Diz Feh para Bart.", "Jacali");
				
			}
		});
		
	}
	
	public void newGame(String text, String planet) {
		
		this.planet = planet;
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 700, 300);
		
		esquerda = new JButton("Esquerda");
		esquerda.setFocusable(false);
		esquerda.setBounds(250, 300, 100, 30);
		esquerda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				deathPorcentage("Andrew diz.\n\n"
						+ "   -Conseguimos! Achei f�cil haha.\n\n"
						+ "Bart responde.\n\n"
						+ "   -Concordo haha.\n\n"
						+ "Feh diz gritando.\n\n"
						+ "   -Presta aten��o Bart! Vamos bater!\n\n");
				
			}
		});
		
		direita = new JButton("Direita");
		direita.setFocusable(false);
		direita.setBounds(350, 300, 100, 30);
		direita.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				deathPorcentage("Andrew diz.\n\n"
						+ "   -Conseguimos! Achei f�cil haha.\n\n"
						+ "Bart responde.\n\n"
						+ "   -Concordo haha.\n\n"
						+ "Feh diz gritando.\n\n"
						+ "   -Presta aten��o Bart! Vamos bater!\n\n");
				
			}
		});
		
		
		timerField = new JTextField("3");
		timerField.setEditable(false);
		timerField.setBorder(null);
		timerField.setBackground(Color.WHITE);
		timerField.setFont(new Font("Arial", Font.BOLD, 14));
		timerField.setBounds(500, 300, 20, 20);
		
		startCountDown();
			
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
			
		pane.add(timerField);
		pane.add(esquerda);
		pane.add(direita);
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
		
	}
	
	public void deathPorcentage(String text) {
		
		if((int) (Math.random() * 0) == 1) {
			
			gameOver("GAME OVER");
			
		}else {
			
			count++;
		
			timer.cancel();
			timerField.setText("3");
			
			startCountDown();
			
			if(count == 5) {
				
				timer.cancel();
				
				chellangeComplete(text);
				
			}
		
		}
		
	}
	
	public void planetaTaltris() {
		
	}
	
	public void planetaJacali() {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText("Rumo ao planeta Jacali em sua nave, eles acabam batendo em algo e milagrosamente a nave n�o explodiu. Bart preocupado pergunta:"
				+ "\n\n- Todos bem?\n\nOs dois respondem:");
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 300);
		
		ironia = new JRadioButton("N�o, n�o, a nave bateu e eu to morrendo aqui. HAHAHA (TOM IR�NICO)");
		ironia.setFocusable(false);
		ironia.setBackground(Color.WHITE);
		ironia.setBounds(100, 300, 425, 30);
		ironia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newDialog("Minutos depois eles descobrem que a coisa que eles bateram era uma nave alien�gena que estava com seu modo de camuflagem ativo. Eles escutam outro barulho, "
						+ "mas dessa vez � um tipo de �grito�, ent�o eles resolvem dar uma olhada. Quando chegam no local do grito, avistam uma criatura de pernas longas, com uma cauda "
						+ "larga e aparentemente muito dura, dentes afiados capazes de romper uma liga de metal f�cil e olhos com uma fenda no meio. A criatura estava comendo uma pessoa, "
						+ "imediatamente Feh e Andrew perguntam baixinho:\n\n"
						+ "O que � aquilo e quem � a pessoa que ela est� comendo!? \n\n"
						+ "Bart responde.\n\n"
						+ "   -Parece ser uma das pessoas do grupo passado da nossa miss�o, mas eu n�o fa�o ideia do que aquilo seja.\n\n"
						+ "Andrew estava hiperventilando muito alto, Feh e Bart tentam acalm�-lo, mas a criatura escuta e corre atr�s deles. Imediatamente Bart grita:\n\n");
				
			}
		});
		
		estupidez = new JRadioButton("Mas � claro que n�o, seu idiota! (TOM EST�PIDO)");
		estupidez.setFocusable(false);
		estupidez.setBackground(Color.WHITE);
		estupidez.setBounds(100, 350, 425, 30);
		estupidez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newDialog("Minutos depois eles descobrem que a coisa que eles bateram era uma nave alien�gena que estava com seu modo de camuflagem ativo. Eles escutam outro barulho, "
						+ "mas dessa vez � um tipo de �grito�, ent�o eles resolvem dar uma olhada. Quando chegam no local do grito, avistam uma criatura de pernas longas, com uma cauda "
						+ "larga e aparentemente muito dura, dentes afiados capazes de romper uma liga de metal f�cil e olhos com uma fenda no meio. A criatura estava comendo uma pessoa, "
						+ "imediatamente Feh e Andrew perguntam baixinho:\n\n"
						+ "O que � aquilo e quem � a pessoa que ela est� comendo!? \n\n"
						+ "Bart responde.\n\n"
						+ "   -Parece ser uma das pessoas do grupo passado da nossa miss�o, mas eu n�o fa�o ideia do que aquilo seja.\n\n"
						+ "Andrew estava hiperventilando muito alto, Feh e Bart tentam acalm�-lo, mas a criatura escuta e corre atr�s deles. Imediatamente Bart grita:\n\n");
				
			}
		});
		
		amigavel = new JRadioButton("Sim, estamos! (TOM AMIG�VEL)");
		amigavel.setFocusable(false);
		amigavel.setBackground(Color.WHITE);
		amigavel.setBounds(100, 400, 425, 30);
		amigavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newDialog("Minutos depois eles descobrem que a coisa que eles bateram era uma nave alien�gena que estava com seu modo de camuflagem ativo. Eles escutam outro barulho, "
						+ "mas dessa vez � um tipo de �grito�, ent�o eles resolvem dar uma olhada. Quando chegam no local do grito, avistam uma criatura de pernas longas, com uma cauda "
						+ "larga e aparentemente muito dura, dentes afiados capazes de romper uma liga de metal f�cil e olhos com uma fenda no meio. A criatura estava comendo uma pessoa, "
						+ "imediatamente Feh e Andrew perguntam baixinho:\n\n"
						+ "O que � aquilo e quem � a pessoa que ela est� comendo!? \n\n"
						+ "Bart responde.\n\n"
						+ "   -Parece ser uma das pessoas do grupo passado da nossa miss�o, mas eu n�o fa�o ideia do que aquilo seja.\n\n"
						+ "Andrew estava hiperventilando muito alto, Feh e Bart tentam acalm�-lo, mas a criatura escuta e corre atr�s deles. Imediatamente Bart grita:\n\n");
				
			}
		});
		
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		group = new ButtonGroup();
		group.add(ironia);
		group.add(estupidez);
		group.add(amigavel);
		
		pane.add(ironia);
		pane.add(estupidez);
		pane.add(amigavel);
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
	}
	
	public void newDialog(String text) {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 500);
		
		next = new JButton("Prosseguir");
		next.setFocusable(false);
		next.setBounds(200, 500, 100, 30);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textArea.setText("   -Corram!\n\n"
						+ "Ent�o eles correm desesperados, mas a criatura � muito r�pida e acaba puxando Andrew pelas pernas. Andrew grita por socorro, mas Bart e Feh j� est�o muito longe e n�o conseguem escutar. Bart e Feh encontram equipamentos num lugar da nave. Uma Arma de fogo, uma Arma Branca e uma esp�cie de Bomba.\n\n"
						+ "   -Feh, cad� o Andrew? \n\n"
						+ "Feh responde:\n\n"
						+ "   -Ele n�o estava atr�s da gente? Ai meu deus, a gente vai morrer.\n\n"
						+ "-Se acalma Feh, vamos levar tudo isso e correr at� a nave. A gente vai sair daqui!\n\n"
						+ "Eles avistaram a criatura e correram de novo e dessa vez a criatura pega o Feh.\n\n"
						+ "   -Feh, n�o!\n\n");
				
				next.setVisible(false);
				nextStepTwo.setVisible(true);
				
				nextStepTwo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						fight("Bart tem que pensar r�pido e lembra que pegou 3 itens na sala que acharam. Agora, qual escolher?");
					
					}
				});
				
			}
		});
		
		nextStepTwo = new JButton("Prosseguir");
		nextStepTwo.setFocusable(false);
		nextStepTwo.setVisible(false);
		nextStepTwo.setBounds(200, 500, 100, 30);
		
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		pane.add(next);
		pane.add(nextStepTwo);
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
		
	}
	
	public void fight(String text) {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 500);
		
		arma = new JButton("Arma");
		arma.setFocusable(false);
		arma.setBounds(200, 500, 100, 30);
		arma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weapon("Bart pega a arma de fogo e avista uma porta. Ele tenta atirar, mas a arma emperra.\n\nCom suas m�os ligeiras ele tenta arrumar a arma.", "Arrumar");
			}
		});
		
		faca = new JButton("Faca");
		faca.setFocusable(false);
		faca.setBounds(300, 500, 100, 30);
		faca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weapon("Bart decide usar a faca, mas ela et� sem fio.\n\nCom suas m�os ligeiras ele tenta amolar a faca.", "Amolar");
			}
		});
		
		bomba = new JButton("Bomba");
		bomba.setFocusable(false);
		bomba.setBounds(400, 500, 100, 30);
		bomba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int deathChance = (int) (Math.random() * 2);
				
				if(deathChance == 0) {
					
					gameOver("\n\n\t                  Game Over\n\nBart resolve usar a bomba. Ele tira o pino por�m ela explode\nimediatamente em sua m�o.");
					
				}else {
					
					gameOver("\n\n\t                  Game Over\n\nBart resolve usar a bomba. Ele joga na criatura e a criatura come, \ndepois joga Feh pra longe, fazendo ele bater a cabe�a com for�a, \nque come�a a inchar.\n\n"
							+ "   -Feh, vamos, levanta!\n\n"
							+ "Feh estava inconsciente. A criatura os explode junto dela. \n\n");
					
				}
					
			}
		});
		
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		pane.add(arma);
		pane.add(faca);
		pane.add(bomba);
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
	}
	
	public void weapon(String text, String action) {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 100);
		
		timerField = new JTextField("3");
		timerField.setEditable(false);
		timerField.setBorder(null);
		timerField.setBackground(Color.WHITE);
		timerField.setFont(new Font("Arial", Font.BOLD, 14));
		timerField.setBounds(500, 300, 20, 20);
		
		click = new JButton(action);
		click.setBounds(300, 300, 100, 30);
		click.setFocusable(false);
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(progressBar.getValue() == 100) {
					
					timer.cancel();
					
					if(action.equals("Arrumar")) {
						
						weaponFixed("Ele atira na porta, a porta abre, mas eles est�o no espa�o, ou seja, eles s�o puxados para fora. Bart consegue ver a criatura explodindo do lado de fora da nave.\n\n"
							+ "   -Parece que voc� n�o consegue sobreviver 1 segundo fora da sua nave. \n\n"
							+ "Imediatamente Bart perde a consci�ncia. Horas depois Bart acorda em uma sala com v�rias pessoas.\n\n"
							+ "   -Onde estou? Quem s�o voc�s?\n\n"
							+ "   -Somos a equipe de resgate, vimos daqui da terra que sua nave ficou inoperante, ent�o imediatamente fomos at� o local e avistamos voc� flutuando no espa�o.\n\n"
							+ "Bart se lembra de seus amigos mortos e come�a a chorar. Fim!");
						
					}else if(action.equals("Amolar")) {
						
						gameOver("\n\n\n\n\t                       Game Over\n\nBart resolve usar a faca amolada e avan�a para cima da criatura,\nvisando a cabe�a. A criatura defende com a calda, "
								+ "mas a mesma � cortada ao meio. \nBart convencido de que ir� mat�-la, � pego desprevenido, sendo empurrado para longe, \ndepois sua faca � quebrada.\n\n"
								+ "A criatura arranca a cabe�a de Feh com seus dentes e parte para cima de Bart.\n\n"
								+ "   -Eu vou matar voc� sua criatura feia!");
						
					}
						
		
				}
				
				progressBar.setValue(progressBar.getValue() + 5);
				
			}
		});
		
		progressBar = new JProgressBar();
		progressBar.setBounds(200, 500, 300, 30);
		
		startCountDown();
		
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		pane.add(timerField);
		pane.add(textArea);
		pane.add(click);
		pane.add(progressBar);
		container.removeAll();
		container.add(pane);
		container.validate();
		
		
	}
	
	public void weaponFixed(String text) {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 500);
		
		pane = new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();

	}
	
	public void gameOver(String message) {
		
		textArea = new JTextArea(message);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.BOLD, 20));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		
		pane =  new JPanel();
		pane.setOpaque(true);
		pane.setBackground(Color.BLACK);
		
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
	}
	
	public void chellangeComplete(String text) {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(text);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(200, 100, 500, 300);
		
		pane =  new JPanel(null);
		pane.setOpaque(true);
		pane.setBackground(Color.WHITE);
		
		next = new JButton("Prosseguir");
		next.setFocusable(false);
		next.setBounds(200, 500, 100, 30);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(planet.equals("Jacali")) {
					
					planetaJacali();
					
				}else {
					
					planetaTaltris();
					
				}
				
			}
		});
		
		pane.add(next);
		pane.add(textArea);
		container.removeAll();
		container.add(pane);
		container.validate();
		
	}
	
	public void startCountDown() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				
				timerField.setText(""+setInterval());
				
				try {
					
					Thread.sleep(500);
					
					if(Integer.parseInt(timerField.getText()) == 0){
						
						gameOver("GAME OVER");
						
					}
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}, 1000, 1000);
		
		
	}
	
	private final int setInterval() {
		
		if(Integer.parseInt(timerField.getText()) == 1) {
			timer.cancel();
		}
		
		return  Integer.parseInt(timerField.getText()) - 1;
	}
	
	public static void main(String args[]) {
		
		A_Fuga frame = new A_Fuga();
		frame.setTitle("The-Scape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
}