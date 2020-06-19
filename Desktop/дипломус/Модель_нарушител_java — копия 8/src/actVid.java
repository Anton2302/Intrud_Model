import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class actVid extends JFrame {

    public actVid(int main_mas[])
    {
        int vid_mas[] = new int[11];
        vid_mas[1] = 1;
        vid_mas[2] = 1;
        vid_mas[3] = 1;
        vid_mas[4] = 1;
        vid_mas[8] = 1;
        vid_mas[9] = 1;
        vid_mas[10] = 1;

        JFrame frame = new JFrame("Выбор актуальных видов нарушителя ИБ в ИС");
        frame.setBounds(400, 200, 500, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Выберите актуальные виды нарушителей ИБ в ИС?");
        label.setBounds(100, 10, 300, 50);
        panel.add(label);

        JLabel label1 = new JLabel("Спец. службы иностранных государств");
        JLabel label2 = new JLabel("Террористически и экстремистские организации");
        JLabel label3 = new JLabel("Преступные (криминальные) структуры");
        JLabel label4 = new JLabel("Вшешние субъекты (физ. лица)");
        JLabel label5 = new JLabel("Конкурирующие организации");
        JLabel label6 = new JLabel("Разраб. произв. и поставщики ПО и техники");
        JLabel label7 = new JLabel("Лица, привлекаемые для установочных работ");
        JLabel label8 = new JLabel("Лица, обеспечивающие функционирование системы");
        JLabel label9 = new JLabel("Пользователи ИС");
        JLabel label10 = new JLabel("Администраторы ИС и ИБ");
        JLabel label11 = new JLabel("Бывшие работы");

        label1.setBounds(50, 50, 400, 50);
        label2.setBounds(50, 90, 400, 50);
        label3.setBounds(50, 130, 400, 50);
        label4.setBounds(50, 170, 400, 50);
        label5.setBounds(50, 210, 400, 50);
        label6.setBounds(50, 250, 400, 50);
        label7.setBounds(50, 290, 400, 50);
        label8.setBounds(50, 330, 400, 50);
        label9.setBounds(50, 370, 400, 50);
        label10.setBounds(50, 410, 400, 50);
        label11.setBounds(50, 450, 400, 50);

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
        panel.add(label11);

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

        if(main_mas[0] == 1)
        {
            checkBox1.setSelected(true);
            vid_mas[0] = 1;
        }
        else
            vid_mas[0] = 0;

        checkBox2.setSelected(true);
        checkBox3.setSelected(true);
        checkBox4.setSelected(true);
        checkBox5.setSelected(true);

        if(main_mas[31] == 0)
        {
            checkBox6.setSelected(true);
            vid_mas[5] = 1;
        }
        else
            vid_mas[5] = 0;

        if(main_mas[3] == 0)
        {
            checkBox7.setSelected(true);
            vid_mas[6] = 1;
        }
        else
            vid_mas[6] = 0;

        if(main_mas[4] == 0)
        {
            checkBox8.setSelected(true);
            vid_mas[7] = 1;
        }
        else
            vid_mas[7] = 0;

        checkBox8.setSelected(true);
        checkBox9.setSelected(true);
        checkBox10.setSelected(true);
        checkBox11.setSelected(true);

        checkBox1.setBounds(430, 60, 30, 30);
        checkBox2.setBounds(430, 100, 30, 30);
        checkBox3.setBounds(430, 140, 30, 30);
        checkBox4.setBounds(430, 180, 30, 30);
        checkBox5.setBounds(430, 220, 30, 30);
        checkBox6.setBounds(430, 260, 30, 30);
        checkBox7.setBounds(430, 300, 30, 30);
        checkBox8.setBounds(430, 340, 30, 30);
        checkBox9.setBounds(430, 380, 30, 30);
        checkBox10.setBounds(430, 420, 30, 30);
        checkBox11.setBounds(430, 460, 30, 30);

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
        panel.add(checkBox11);


        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 500, 400, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
                if(checkBox1.isSelected())
                    a1 = 1;
                else
                    a1 = 0;

                if(checkBox2.isSelected() == true)
                    a2 = 1;
                else
                    a2 = 0;

                if(checkBox3.isSelected() == true)
                    a3 = 1;
                else
                    a3 = 0;

                if(checkBox4.isSelected() == true)
                    a4 = 1;
                else
                    a4 = 0;

                if(checkBox5.isSelected() == true)
                    a5 = 1;
                else
                    a5 = 0;

                if(checkBox6.isSelected() == true)
                    a6 = 1;
                else
                    a6 = 0;

                if(checkBox7.isSelected() == true)
                    a7 = 1;
                else
                    a7 = 0;

                if(checkBox8.isSelected() == true)
                    a8 = 1;
                else
                    a8 = 0;

                if(checkBox9.isSelected() == true)
                    a9 = 1;
                else
                    a9 = 0;

                if(checkBox10.isSelected() == true)
                    a10 = 1;
                else
                    a10 = 0;

                if(checkBox11.isSelected() == true)
                    a11 = 1;
                else
                    a11 = 0;

                Set_Actual set_actual = new Set_Actual();
                setText(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
                frame.dispose();
            }
        };
        back.addActionListener(b);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    void setText(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11)
    {
        try(FileWriter fileWriter = new FileWriter("ActVid.txt", false)) {
            if(a1 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a2 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a3 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a4 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a5 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a6 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a7 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a8 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a9 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a10 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

            if(a11 == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
