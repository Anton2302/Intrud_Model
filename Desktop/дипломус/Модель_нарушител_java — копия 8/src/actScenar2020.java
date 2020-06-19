import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class actScenar2020 extends JFrame {

    public actScenar2020()
    {
        JFrame frame = new JFrame("Выбор актуальных сценариев атак");
        frame.setBounds(100, 200, 1100, 500);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label1 = new JLabel("T1 - Сбор информации о системах и сетях");
        JLabel label2 = new JLabel("T2 - Получение первоначального доступа к компонентам систем и сетей");
        JLabel label3 = new JLabel("T3 - Внедрение и исполнение вредоносного программного обеспечения в системах и сетях");
        JLabel label4 = new JLabel("T4 - Закрепление (сохранение доступа) в системе или сети");
        JLabel label5 = new JLabel("T5 - Управление вредоносным программным обеспечением и (или) компонентами, к которым ранее был получен доступ");
        JLabel label6 = new JLabel("T6 - Повышение привилегий по доступу компонентам систем и сетей");
        JLabel label7 = new JLabel("T7 - Сокрытие действий и применяемых при этом средств от обнаружения");
        JLabel label8 = new JLabel("T8 - Получение доступа (распространение доступа) к другим компонентам систем и сетей или смежным системам и сетям");
        JLabel label9 = new JLabel("T9 - Сбор и вывод из системы или сети информации, необходимой для дальнейших действий при реализации угроз БИ или реализации новых угроз");
        JLabel label10 = new JLabel("T10 - Неправомерный доступ и (или) воздействие на ИР или компоненты систем и сетей, приводящее к негативным последствиям");

        label1.setBounds(20, 20, 1000, 30);
        label2.setBounds(20, 60, 1000, 30);
        label3.setBounds(20, 100, 1000, 30);
        label4.setBounds(20, 140, 1000, 30);
        label5.setBounds(20, 180, 1000, 30);
        label6.setBounds(20, 220, 1000, 30);
        label7.setBounds(20, 260, 1000, 30);
        label8.setBounds(20, 300, 1000, 30);
        label9.setBounds(20, 340, 1000, 30);
        label10.setBounds(20, 380, 1000, 30);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        JCheckBox checkBox3 = new JCheckBox();
        JCheckBox checkBox4 = new JCheckBox();
        JCheckBox checkBox5 = new JCheckBox();
        JCheckBox checkBox6 = new JCheckBox();
        JCheckBox checkBox7 = new JCheckBox();
        JCheckBox checkBox8 = new JCheckBox();
        JCheckBox checkBox9 = new JCheckBox();
        JCheckBox checkBox10 = new JCheckBox();

        checkBox1.setBounds(1030, 20, 30, 30);
        checkBox2.setBounds(1030, 60, 30, 30);
        checkBox3.setBounds(1030, 100, 30, 30);
        checkBox4.setBounds(1030, 140, 30, 30);
        checkBox5.setBounds(1030, 180, 30, 30);
        checkBox6.setBounds(1030, 220, 30, 30);
        checkBox7.setBounds(1030, 260, 30, 30);
        checkBox8.setBounds(1030, 300, 30, 30);
        checkBox9.setBounds(1030, 340, 30, 30);
        checkBox10.setBounds(1030, 380, 30, 30);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);
        panel.add(checkBox5);
        panel.add(checkBox6);
        panel.add(checkBox7);
        panel.add(checkBox8);
        panel.add(checkBox9);
        panel.add(checkBox10);

        try(FileReader fileReader = new FileReader("ScenarT.txt"))
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
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox9.setSelected(true);
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox10.setSelected(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton back = new JButton("К окну Проставление актуальности");
        back.setBounds(50, 420, 1000, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                try(FileWriter fileWriter = new FileWriter("ScenarT.txt", false))
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
                    fileWriter.write("\n");

                    if(checkBox9.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox10.isSelected())
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
