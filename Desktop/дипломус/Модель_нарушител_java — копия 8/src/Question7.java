import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Question7 extends JFrame {

    public Question7()
    {
        JFrame frame = new JFrame("Вопрос 7 из 43");
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
        JLabel label2 = new JLabel("Присутствует ли блокировка аккаунта пользователя");
        JLabel label3 = new JLabel("в результате неверного введения ");
        JLabel label4 = new JLabel("аутентификационных данных, а так же ");
        JLabel label5 = new JLabel("преодоления ограниченного числаневерных вводов?");
        label2.setBounds(40, 25, 355, 15);
        label3.setBounds(40, 45, 355, 15);
        label4.setBounds(40, 65, 355, 15);
        label5.setBounds(40, 85, 355, 15);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);

        ActionListener al_yes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileWriter fileWriter = new FileWriter("q7.txt", false))
                {
                    fileWriter.write("1");
                }
                catch (IOException e1)
                {

                }
                Question8 question8 = new Question8();
                frame.dispose();
            }
        };

        ActionListener al_no = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileWriter fileWriter = new FileWriter("q7.txt", false))
                {
                    fileWriter.write("0");
                }
                catch (IOException e1)
                {

                }
                Question8 question8 = new Question8();
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

