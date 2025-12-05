import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaSimplificador extends JFrame {

    private JTextArea txtEntrada;
    private JTextArea txtSalida;
    private JButton btnSimplificar;

    public VentanaSimplificador() {

        setTitle("Recurso Simplificador Booleano V2");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(25, 25, 25));
        JLabel titulo = new JLabel("Simplificador Booleano PRO");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtEntrada = new JTextArea();
        txtEntrada.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtEntrada.setBorder(BorderFactory.createTitledBorder("Expresión de entrada"));
        panelCentro.add(new JScrollPane(txtEntrada));

        txtSalida = new JTextArea();
        txtSalida.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtSalida.setEditable(false);
        txtSalida.setBorder(BorderFactory.createTitledBorder("Resultado simplificado"));
        panelCentro.add(new JScrollPane(txtSalida));

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        btnSimplificar = new JButton("Simplificar");
        btnSimplificar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnSimplificar.setBackground(new Color(0, 150, 255));
        btnSimplificar.setForeground(Color.WHITE);
        btnSimplificar.setFocusPainted(false);
        btnSimplificar.setPreferredSize(new Dimension(220, 45));
        btnSimplificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelBoton.add(btnSimplificar);
        add(panelBoton, BorderLayout.SOUTH);

        btnSimplificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = txtEntrada.getText();
                String resultado = BooleanSimplifier.simplificar(exp);
                txtSalida.setText(resultado);
            }
        });
    }

    public static void main(String[] args) {
        new VentanaSimplificador().setVisible(true);
    }
}
