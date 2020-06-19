import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spravka extends JFrame {

    public Spravka()
    {
        JFrame frame = new JFrame("Справка");
        frame.setBounds(450,100, 400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label1 = new JLabel("                   Данное программное обеспечение");
        JLabel label2 = new JLabel("                было создано в рамказ ВКР, студентом");
        JLabel label3 = new JLabel("                            группы 5612, кафедры 51 ");
        JLabel label4 = new JLabel("                                     СПбГУАП");
        JLabel label5 = new JLabel("                   Ялиничем Антоном Александровичем");
        JLabel label6 = new JLabel("                                 в 2020 году");

        label1.setBounds(10, 30, 350, 30);
        label2.setBounds(10, 70, 350, 30);
        label3.setBounds(10, 110, 350, 30);
        label4.setBounds(10, 150, 350, 30);
        label5.setBounds(10, 190, 350, 30);
        label6.setBounds(10, 230, 350, 30);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);



        JButton button_back = new JButton("На главную");
        button_back.setBounds(50, 300, 300, 50);
        panel.add(button_back);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        button_back.addActionListener(al);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
