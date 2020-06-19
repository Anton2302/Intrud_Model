import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class actObject extends JFrame {

    public actObject(int main_mas[])
    {
        JFrame frame = new JFrame("Выбор актуальных объектов атаки нарушителя ИБ в ИС");
        frame.setBounds(300, 100, 800, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Выберите актуальные объекты воздействия нарушителя");
        label.setBounds(40, 10, 700, 50);
        panel.add(label);
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
        JCheckBox checkBox11 = new JCheckBox();
        JCheckBox checkBox12 = new JCheckBox();
        JCheckBox checkBox13 = new JCheckBox();
        JCheckBox checkBox14 = new JCheckBox();
        JCheckBox checkBox15 = new JCheckBox();
        JCheckBox checkBox16 = new JCheckBox();
        JCheckBox checkBox17 = new JCheckBox();
        JCheckBox checkBox18 = new JCheckBox();
        JCheckBox checkBox19 = new JCheckBox();
        JCheckBox checkBox20 = new JCheckBox();

        JLabel label1 = new JLabel("Грид-система");
        JLabel label2 = new JLabel("Гипервозор(ы)");
        JLabel label3 = new JLabel("BIOS/UEFI");
        JLabel label4 = new JLabel("Суперкомпьютер");
        JLabel label5 = new JLabel("Облачные сервера");
        JLabel label6 = new JLabel("Носители информации");
        JLabel label7 = new JLabel("Мобильные устройства");
        JLabel label8 = new JLabel("Компоненты, отвечающие за аутентификаицю");
        JLabel label9 = new JLabel("Фреймворки и код");
        JLabel label10 = new JLabel("Данные пользователей");
        JLabel label11 = new JLabel("Компоненты, отвечющие за обработку запросов");
        JLabel label12 = new JLabel("Cookie-файлы");
        JLabel label13 = new JLabel("XML-система");
        JLabel label14 = new JLabel("Компонеты, отвечающие за обработку отчетов");
        JLabel label15 = new JLabel("Хранилище больших данных");
        JLabel label16 = new JLabel("Компоненты, отвечающие за работу с Интернетом");
        JLabel label17 = new JLabel("ПО, предназначенное для резервирования данных");
        JLabel label18 = new JLabel("Сайт организации");
        JLabel label19 = new JLabel("Фильтры");
        JLabel label20 = new JLabel("Другие");

        label1.setBounds(20, 70, 200, 40);
        panel.add(label1);

        label2.setBounds(20, 110, 200, 40);
        panel.add(label2);

        label3.setBounds(20, 150, 200, 40);
        panel.add(label3);

        label4.setBounds(20, 190, 200, 40);
        panel.add(label4);

        label5.setBounds(20, 230, 200, 40);
        panel.add(label5);

        label6.setBounds(20, 270, 200, 40);
        panel.add(label6);

        label7.setBounds(20, 310, 200, 40);
        panel.add(label7);

        label8.setBounds(20, 350, 300, 40);
        panel.add(label8);

        label9.setBounds(20, 390, 200, 40);
        panel.add(label9);

        label10.setBounds(20, 430, 200, 40);
        panel.add(label10);

        label11.setBounds(400, 70, 400, 40);
        panel.add(label11);

        label12.setBounds(400, 110, 300, 40);
        panel.add(label12);

        label13.setBounds(400, 150, 300, 40);
        panel.add(label13);

        label14.setBounds(400, 190, 300, 40);
        panel.add(label14);

        label15.setBounds(400, 230, 400, 40);
        panel.add(label15);

        label16.setBounds(400, 270, 400, 40);
        panel.add(label16);

        label17.setBounds(400, 310, 400, 40);
        panel.add(label17);

        label18.setBounds(400, 350, 300, 40);
        panel.add(label18);

        label19.setBounds(400, 390, 300, 40);
        panel.add(label19);

        label20.setBounds(400, 430, 300, 40);
        panel.add(label20);

        checkBox1.setBounds(340, 80, 30, 30);
        panel.add(checkBox1);

        checkBox2.setBounds(340, 120, 30, 30);
        panel.add(checkBox2);

        checkBox3.setBounds(340, 160, 30, 30);
        panel.add(checkBox3);

        checkBox4.setBounds(340, 200, 30, 30);
        panel.add(checkBox4);

        checkBox5.setBounds(340, 240, 30, 30);
        panel.add(checkBox5);

        checkBox6.setBounds(340, 280, 30, 30);
        panel.add(checkBox6);

        checkBox7.setBounds(340, 320, 30, 30);
        panel.add(checkBox7);

        checkBox8.setBounds(340, 360, 30, 30);
        panel.add(checkBox8);

        checkBox9.setBounds(340, 400, 30, 30);
        panel.add(checkBox9);

        checkBox10.setBounds(340, 440, 30, 30);
        panel.add(checkBox10);

        checkBox11.setBounds(740, 80, 30, 30);
        panel.add(checkBox11);

        checkBox12.setBounds(740, 120, 30, 30);
        panel.add(checkBox12);

        checkBox13.setBounds(740, 160, 30, 30);
        panel.add(checkBox13);

        checkBox14.setBounds(740, 200, 30, 30);
        panel.add(checkBox14);

        checkBox15.setBounds(740, 240, 30, 30);
        panel.add(checkBox15);

        checkBox16.setBounds(740, 280, 30, 30);
        panel.add(checkBox16);

        checkBox17.setBounds(740, 320, 30, 30);
        panel.add(checkBox17);

        checkBox18.setBounds(740, 360, 30, 30);
        panel.add(checkBox18);

        checkBox19.setBounds(740, 400, 30, 30);
        panel.add(checkBox19);

        checkBox20.setBounds(740, 440, 30, 30);
        panel.add(checkBox20);

        if(main_mas[1] == 1)
            checkBox1.setSelected(true);

        if(main_mas[8] == 1)
            checkBox2.setSelected(true);

        if(main_mas[7] == 0)
            checkBox3.setSelected(true);

        if(main_mas[42] == 1)
            checkBox4.setSelected(true);

        if(main_mas[37] == 1)
            checkBox5.setSelected(true);

        if(main_mas[28] == 1)
            checkBox6.setSelected(true);

        if(main_mas[21] == 1)
            checkBox7.setSelected(true);

        if(main_mas[6] == 0)
            checkBox8.setSelected(true);

        if(main_mas[9] == 0)
            checkBox9.setSelected(true);

        checkBox10.setSelected(true);

        if(main_mas[11] == 1)
            checkBox11.setSelected(true);

        if(main_mas[12] == 0)
            checkBox12.setSelected(true);

        if(main_mas[13] == 0)
            checkBox13.setSelected(true);

        if(main_mas[14] == 1)
            checkBox14.setSelected(true);

        if(main_mas[15] == 0 || main_mas[16] == 0)
            checkBox15.setSelected(true);

        if(main_mas[18] == 1)
            checkBox16.setSelected(true);

        if(main_mas[19] == 0)
            checkBox17.setSelected(true);

        if(main_mas[20] == 0)
            checkBox18.setSelected(true);

        if(main_mas[33] == 0)
            checkBox19.setSelected(true);

        checkBox20.setSelected(true);


        JButton back = new JButton("К предыдущему окну");
        back.setBounds(200, 500, 400, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                try(FileWriter fileWriter = new FileWriter("ActObj.txt", false))
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
                    fileWriter.write("\n");

                    if(checkBox11.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox12.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox13.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox14.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox15.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox16.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox17.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox18.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox19.isSelected())
                        fileWriter.write("1");
                    else
                        fileWriter.write("0");
                    fileWriter.write("\n");

                    if(checkBox20.isSelected())
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
        back.addActionListener(b);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
