package jgame23;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class SistemaJuego extends JFrame implements ActionListener{
    JFrame mainFrame;
    JPanel leftPanel, midPanel;
    JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    ImageIcon i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10,i11, i12, i13, i14, i15;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    ImageIcon home, user, community;
    JButton homeButton, communityButton, userButton;
    Thread t;


    public SistemaJuego() {
        this.GUI();
    }
    private void GUI() {
        /*CONFIGURACION DEL FRAME PRINCIPAL*/
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        leftPanel = new JPanel();
        mainFrame.add(leftPanel, BorderLayout.NORTH);
        midPanel = new JPanel();
        mainFrame.add(midPanel, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);

        /*CONFIGURACION EL PANEL SUPERIOR*/
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);
        leftPanel.setBackground(new Color(100,100,100));

        user = new ImageIcon("app/src/main/resources/ImagesSisJuego/hombre.png");
        userButton = new JButton("Ususario");
        userButton.setIcon(user);
        constraints.gridx = 0;
        constraints.gridy = 0;
        leftPanel.add(userButton, constraints);
        home = new ImageIcon("app/src/main/resources/ImagesSisJuego/hogar.png");
        homeButton = new JButton("Libreria");
        homeButton.setIcon(home);
        constraints.gridx = 1;
        leftPanel.add(homeButton, constraints);
        community = new ImageIcon("app/src/main/resources/ImagesSisJuego/equipo.png");
        communityButton = new JButton("Comunidad");
        communityButton.setIcon(community);
        constraints.gridx = 2;
        leftPanel.add(communityButton, constraints);

        /*CONFIGURACION EL PANEL CENTRAL*/
        midPanel.setBackground(new Color(133,133,133));
        midPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.insets = new Insets(3,3,3,3);

        /*BOTON Y MINIATURA DEL JUEGO*/
        i0 = new ImageIcon("app/src/main/resources/ImagesSisJuego/1943.png");
        l0 = new JLabel(i0);
        b0 = new JButton("Jugar");
        b0.addActionListener(this);
        constraints1.gridx = 1;
        constraints1.gridy = 0;
        midPanel.add(l0, constraints1);
        constraints1.gridy = 1;
        midPanel.add(b0, constraints1);
        /*BOTONES Y JUEGOS DE RELLENO*/
        i1 = new ImageIcon("app/src/main/resources/ImagesSisJuego/Grounded.jpg");
        i2 = new ImageIcon("app/src/main/resources/ImagesSisJuego/supermario64.png");
        i3 = new ImageIcon("app/src/main/resources/ImagesSisJuego/Pacman.jpg");
        i4 = new ImageIcon("app/src/main/resources/ImagesSisJuego/MK.png");
        i5 = new ImageIcon("app/src/main/resources/ImagesSisJuego/BattleFrontII.png");
        i6 = new ImageIcon("app/src/main/resources/ImagesSisJuego/Tetris.png");
        i7 = new ImageIcon("app/src/main/resources/ImagesSisJuego/Buscaminas.png");
        i8 = new ImageIcon("app/src/main/resources/ImagesSisJuego/bomberman.png");
        i9 = new ImageIcon("app/src/main/resources/ImagesSisJuego/streetfighter.png");
        i10 = new ImageIcon("app/src/main/resources/ImagesSisJuego/pinball.png");
        i11 = new ImageIcon("app/src/main/resources/ImagesSisJuego/gta.png");
        i12 = new ImageIcon("app/src/main/resources/ImagesSisJuego/CrashBandicoot.png");
        i13 = new ImageIcon("app/src/main/resources/ImagesSisJuego/DonkeyKong.png");
        i14 = new ImageIcon("app/src/main/resources/ImagesSisJuego/counterstrike.jpg");
        i15 = new ImageIcon("app/src/main/resources/ImagesSisJuego/phasmophobia.png");
        l1 = new JLabel(i1);
        l2 = new JLabel(i2);
        l3 = new JLabel(i3);
        l4 = new JLabel(i4);
        l5 = new JLabel(i5);
        l6 = new JLabel(i6);
        l7 = new JLabel(i7);
        l8 = new JLabel(i8);
        l9 = new JLabel(i9);
        l10 = new JLabel(i10);
        l11 = new JLabel(i11);
        l12 = new JLabel(i12);
        l13 = new JLabel(i13);
        l14 = new JLabel(i14);
        l15 = new JLabel(i15);
        /*AGREGO LOS BOTONES DE "DESCARGAR"*/
        constraints1.gridy = 1;
        int index = 2;
        for (JButton jbutton : Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15)) {
            if(index == 9){
                constraints1.gridy = 3;
                index = 1;
            }
            constraints1.gridx = index;
            jbutton = new JButton("Descargar");
            midPanel.add(jbutton, constraints1);
            index++;
        }
        /*AGREGO EL RESTO DE ETIQUETAS CON LOS JUEGOS EN BLANCO*/
        constraints1.gridx = 2;
        constraints1.gridy = 0;
        midPanel.add(l1, constraints1);
        constraints1.gridx = 3;
        midPanel.add(l2, constraints1);
        constraints1.gridx = 4;
        midPanel.add(l3, constraints1);
        constraints1.gridx = 5;
        midPanel.add(l4, constraints1);
        constraints1.gridx = 6;
        midPanel.add(l5, constraints1);
        constraints1.gridx = 7;
        midPanel.add(l6, constraints1);
        constraints1.gridx = 8;
        midPanel.add(l7, constraints1);
        constraints1.gridx = 1;
        constraints1.gridy = 2;
        midPanel.add(l8, constraints1);
        constraints1.gridx = 2;
        midPanel.add(l9, constraints1);
        constraints1.gridx = 3;
        midPanel.add(l10, constraints1);
        constraints1.gridx = 4;
        midPanel.add(l11, constraints1);
        constraints1.gridx = 5;
        midPanel.add(l12, constraints1);
        constraints1.gridx = 6;
        midPanel.add(l13, constraints1);
        constraints1.gridx = 7;
        midPanel.add(l14, constraints1);
        constraints1.gridx = 8;
        midPanel.add(l15, constraints1);
        //System.out.println(System.getProperty("user.dir"));

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals(b0.getActionCommand())){
            BattleOfMidway game = new BattleOfMidway();
            t = new Thread(() -> game.run(1.0 / 60.0));
            t.start();
        }
    }
    public static void main(String[] args) {
        new SistemaJuego();
    }
}
