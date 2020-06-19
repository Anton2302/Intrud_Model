import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class clasISPDn extends JFrame {

    public clasISPDn()
    {
        JFrame frame = new JFrame("Выбор групп нарушителя ИБ в ИСПДн");
        frame.setBounds(400, 200, 400, 400);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Выбор возможных групп нарушителя ИСПДн");
        label.setBounds(20,20,380, 30);
        panel.add(label);

        JLabel label1 = new JLabel("1 группа");
        JLabel label2 = new JLabel("2 группа");
        JLabel label3 = new JLabel("3 группа");
        JLabel label4 = new JLabel("4 группа");
        JLabel label5 = new JLabel("5 группа");
        JLabel label6 = new JLabel("6 группа");
        JLabel label7 = new JLabel("7 группа");
        JLabel label8 = new JLabel("8 группа");

        label1.setBounds(100, 50, 100, 30);
        label2.setBounds(100, 80, 100, 30);
        label3.setBounds(100, 110, 100, 30);
        label4.setBounds(100, 140, 100, 30);
        label5.setBounds(100, 170, 100, 30);
        label6.setBounds(100, 200, 100, 30);
        label7.setBounds(100, 230, 100, 30);
        label8.setBounds(100, 260, 100, 30);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        JCheckBox checkBox3 = new JCheckBox();
        JCheckBox checkBox4 = new JCheckBox();
        JCheckBox checkBox5 = new JCheckBox();
        JCheckBox checkBox6 = new JCheckBox();
        JCheckBox checkBox7 = new JCheckBox();
        JCheckBox checkBox8 = new JCheckBox();

        checkBox1.setBounds(250, 50, 30, 30);
        checkBox2.setBounds(250, 80, 30, 30);
        checkBox3.setBounds(250, 110, 30, 30);
        checkBox4.setBounds(250, 140, 30, 30);
        checkBox5.setBounds(250, 170, 30, 30);
        checkBox6.setBounds(250, 200, 30, 30);
        checkBox7.setBounds(250, 230, 30, 30);
        checkBox8.setBounds(250, 260, 30, 30);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);
        panel.add(checkBox5);
        panel.add(checkBox6);
        panel.add(checkBox7);
        panel.add(checkBox8);

        try(FileReader fileReader = new FileReader("PDN.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                checkBox1.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox2.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox3.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox4.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox5.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox6.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox7.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox8.setSelected(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 320, 300, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                try(FileWriter fileWriter = new FileWriter("PDN.txt"))
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

                    if(checkBox7.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox8.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        };
        back.addActionListener(b);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
