import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class classAdd1 extends JFrame {

    public classAdd1()
    {
        JFrame frame = new JFrame("Добавление нового объекта");
        frame.setBounds(400, 200, 300, 300);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton buttonClear = new JButton("Очистить кэш");
        buttonClear.setBounds(50, 120, 200, 50);
        panel.add(buttonClear);
        ActionListener alC = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileWriter fileWriter = new FileWriter("DOP.txt", false))
                {
                    fileWriter.write("0");
                    fileWriter.write("\n");
                    fileWriter.write("=");
                    fileWriter.write("\n");
                    fileWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
        buttonClear.addActionListener(alC);

        JButton buttonAdd = new JButton("Добавить объект атаки");
        buttonAdd.setBounds(50, 40, 200, 50);
        panel.add(buttonAdd);
        ActionListener alAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewObject aNO = new addNewObject();
                frame.dispose();
            }
        };
        buttonAdd.addActionListener(alAdd);

        JButton back = new JButton("На главную");
        back.setBounds(50, 200, 200, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        back.addActionListener(b);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
