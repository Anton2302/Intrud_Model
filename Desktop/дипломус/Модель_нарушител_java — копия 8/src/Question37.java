import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Question37 extends JFrame {

    public Question37()
    {
        JFrame frame = new JFrame("Вопрос 37 из 43");
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setBounds(400, 200, 400, 300);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button_yes = new JButton("Да");
        JButton button_no = new JButton("Нет");
        JButton button_back = new JButton("На главную");
        button_yes.setBounds(75, 145, 100, 60);
        button_no.setBounds(225, 145, 100, 60);
        button_back.setBounds(50, 210, 300, 50);
        panel.add(button_yes);
        panel.add(button_no);
        panel.add(button_back);
        JLabel label2 = new JLabel("Хранятся ли персональные данные");
        JLabel label3 = new JLabel("в информационной системе?");
        label2.setBounds(40, 25, 355, 15);
        label3.setBounds(40, 45, 355, 15);
        panel.add(label2);
        panel.add(label3);

        ActionListener al_yes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileWriter fileWriter = new FileWriter("q37.txt", false))
                {
                    fileWriter.write("1");
                }
                catch (IOException e1)
                {

                }
                Question38 question38 = new Question38();
                frame.dispose();
            }
        };

        ActionListener al_no = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileWriter fileWriter = new FileWriter("q37.txt", false))
                {
                    fileWriter.write("0");
                }
                catch (IOException e1)
                {

                }
                Question38 question38 = new Question38();
                frame.dispose();
            }
        };

        ActionListener al_back = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };

        button_yes.addActionListener(al_yes);
        button_no.addActionListener(al_no);
        button_back.addActionListener(al_back);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

