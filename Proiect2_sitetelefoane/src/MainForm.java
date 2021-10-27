import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;


public class MainForm {
    private JPanel Main;
    private JButton cautabtn;
    private JButton ratebtn;
    private JButton stergebtn;
    private JButton cumparabtn;
    private JTextField marcatxt;
    private JTextField modeltxt;
    private JTextField memorietxt;
    private JTextField prettxt;
    private JComboBox sistemlst;
    private ArrayList<Telefon> telefoane;


    public MainForm() {
        telefoane = new ArrayList<Telefon>();
        telefoane.add(0, new Telefon("iOS", "iPhone", "13 Pro Max", "512GB", 7900));
        telefoane.add(1, new Telefon("Android", "Samsung", "Galaxy S21 Ultra", "128GB", 6000));
        telefoane.add(2, new Telefon("Harmony OS", "Huawei", "P50 PRO", "256GB", 6500));
        sistemlst.setSelectedItem(null);

        stergebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Ești sigur că vrei să ștergi toate datele introduse?" , "Question",
                        JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION){
                    marcatxt.setText("");
                    modeltxt.setText("");
                    memorietxt.setText("");
                    prettxt.setText("");

                    JLabel label = new JLabel("Datele au fost șterse!");
                    JOptionPane.showMessageDialog(null, label, "Atenție", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JLabel label = new JLabel("Datele NU au fost șterse!");
                    JOptionPane.showMessageDialog(null, label, "Atenție", JOptionPane.INFORMATION_MESSAGE);
                }

                System.out.println(result);
            }
        });

        ratebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pret = telefoane.get(sistemlst.getSelectedIndex()).getPret();
                int dobanda = 18;
                int nr_rate = 24;

                JLabel label = new JLabel("<html>Rată lunară (24 rate): " + String.format("%.2f", (1 + (double)dobanda / 100) * pret / nr_rate) + " lei <br> Preț total: " + String.format("%.2f", (1 + (double)dobanda / 100) * pret) + " lei <br> Dobânda: " + dobanda + "%");
                JOptionPane.showMessageDialog(null, label, "Rata lunara", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cumparabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel("<html>Felicitari ! <br> Ai achizitionat "
                        + telefoane.get(sistemlst.getSelectedIndex()).getMarca() + " "
                        + telefoane.get(sistemlst.getSelectedIndex()).getModel() + " "+"!");
                JOptionPane.showMessageDialog(null, label, "Achizitionat", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        sistemlst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcatxt.setText(telefoane.get(sistemlst.getSelectedIndex()).getMarca());
                modeltxt.setText(telefoane.get(sistemlst.getSelectedIndex()).getModel());
                memorietxt.setText(telefoane.get(sistemlst.getSelectedIndex()).getMemorie_interna());
                prettxt.setText(Integer.toString(telefoane.get(sistemlst.getSelectedIndex()).getPret()));
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Site Telefoane");
        frame.setContentPane(new MainForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 450);
        frame.getContentPane().setBackground(new Color(0, 250, 154));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
}