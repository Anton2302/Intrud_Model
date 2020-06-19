import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class actKanali extends JFrame {

    public actKanali(int main_mas[])
    {
        JFrame frame = new JFrame("Выбор каналов утечки информации");
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setBounds(300, 150, 400, 400);

        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 300, 300, 50);
        panel.add(back);

        JLabel label1 = new JLabel("Технические каналы утечки ифнормации");
        JLabel label2 = new JLabel(" - Электрические");
        JLabel label3 = new JLabel(" - Электромагнитные");
        JLabel label4 = new JLabel(" - Виброакустичесикие");
        JLabel label5 = new JLabel(" - Оптические");
        JLabel label6 = new JLabel(" - Комбинированные");
        JLabel label7 = new JLabel("Материально-вещественный");

        label1.setBounds(30, 20, 300, 50);
        label2.setBounds(50, 40, 300, 50);
        label3.setBounds(50, 60, 300, 50);
        label4.setBounds(50, 80, 300, 50);
        label5.setBounds(50, 100, 300, 50);
        label6.setBounds(50, 120, 300, 50);
        label7.setBounds(30, 160, 300, 50);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        JCheckBox checkBox3 = new JCheckBox();
        JCheckBox checkBox4 = new JCheckBox();
        JCheckBox checkBox5 = new JCheckBox();
        JCheckBox checkBox6 = new JCheckBox();

        checkBox1.setBounds(300, 50, 30, 30);
        checkBox2.setBounds(300, 70, 30, 30);
        checkBox3.setBounds(300, 90, 30, 30);
        checkBox4.setBounds(300, 110, 30, 30);
        checkBox5.setBounds(300, 130, 30, 30);
        checkBox6.setBounds(300, 170, 30, 30);


        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);
        panel.add(checkBox5);
        panel.add(checkBox6);

        if(main_mas[22] == 1 || main_mas[23] == 0)
            checkBox1.setSelected(true);

        if(main_mas[24] == 0 || main_mas[27] == 0)
            checkBox2.setSelected(true);

        if(main_mas[26] == 0 || main_mas[30] == 0)
            checkBox3.setSelected(true);

        if(main_mas[38] == 0)
            checkBox4.setSelected(true);

        checkBox5.setSelected(true);
        checkBox6.setSelected(true);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual sa = new Set_Actual();
                try(FileWriter fileWriter = new FileWriter("Kan.txt", false))
                {
                    if(checkBox1.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox2.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox3.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox4.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox5.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox6.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                frame.dispose();
            }
        };
        back.addActionListener(al);


        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
