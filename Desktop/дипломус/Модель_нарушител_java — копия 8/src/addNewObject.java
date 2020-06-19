import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class addNewObject extends JFrame {

    public addNewObject()
    {
        JFrame frame = new JFrame("Добавление нового объекта");
        frame.setBounds(400, 200, 400, 400);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //объект
        JTextField textFieldObject = new JTextField("...");
        JLabel label1 = new JLabel("Наименование объекта:");
        label1.setBounds(20, 20, 200, 50);
        panel.add(label1);
        textFieldObject.setBounds(200, 30, 150, 30);
        panel.add(textFieldObject);

        //тип
        JLabel labelType = new JLabel("Выберите тип нарушителя ИБ:");
        JCheckBox checkBoxType1 = new JCheckBox();
        JCheckBox checkBoxType2 = new JCheckBox();
        JLabel vne = new JLabel("Внешний");
        JLabel vnu = new JLabel("Внутренний");

        labelType.setBounds(20, 90, 200, 30);
        vne.setBounds(50, 110, 100, 30);
        checkBoxType1.setBounds(160, 110, 30, 30);
        vnu.setBounds(230, 110, 100, 30);
        checkBoxType2.setBounds(340, 110, 30, 30);

        panel.add(labelType);
        panel.add(vne);
        panel.add(vnu);
        panel.add(checkBoxType1);
        panel.add(checkBoxType2);

        checkBoxType1.setSelected(true);
        checkBoxType2.setSelected(true);

        //потенциал

        JRadioButton rb1 = new JRadioButton();
        JRadioButton rb2 = new JRadioButton();
        JRadioButton rb3 = new JRadioButton();
        JRadioButton rb4 = new JRadioButton();

        rb1.setBounds(50, 190, 30, 30);
        rb2.setBounds(130, 190, 30, 30);
        rb3.setBounds(210, 190, 30, 30);
        rb4.setBounds(290, 190, 30, 30);

        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);
        panel.add(rb4);

        JLabel l1 = new JLabel("H1");
        JLabel l2 = new JLabel("H2");
        JLabel l3 = new JLabel("H3");
        JLabel l4 = new JLabel("H4");

        l1.setBounds(50, 170, 30, 30);
        l2.setBounds(130, 170, 30, 30);
        l3.setBounds(210, 170, 30, 30);
        l4.setBounds(290, 170, 30, 30);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);

        rb1.setSelected(true);

        JLabel labelPoten = new JLabel("Выберите потенциал нарушителя ИБ:");
        labelPoten.setBounds(20, 150, 300, 30);
        panel.add(labelPoten);

        ActionListener al1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb2.setSelected(false);
                rb3.setSelected(false);
                rb4.setSelected(false);
            }
        };
        rb1.addActionListener(al1);

        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb1.setSelected(false);
                rb3.setSelected(false);
                rb4.setSelected(false);
            }
        };
        rb2.addActionListener(al2);

        ActionListener al3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb1.setSelected(false);
                rb2.setSelected(false);
                rb4.setSelected(false);
            }
        };
        rb3.addActionListener(al3);

        ActionListener al4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb1.setSelected(false);
                rb2.setSelected(false);
                rb3.setSelected(false);
            }
        };
        rb4.addActionListener(al4);

        //Возможность
        JLabel labelVoz = new JLabel("Опишите возможность нарушителя");
        labelVoz.setBounds(20, 250, 300, 30);
        panel.add(labelVoz);

        JTextField textFieldVoz = new JTextField("...");
        textFieldVoz.setBounds(20, 270, 360, 30);
        panel.add(textFieldVoz);


        JButton back = new JButton("Назад");
        back.setBounds(210, 320, 140, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classAdd1 cA = new classAdd1();
                frame.dispose();
            }
        };
        back.addActionListener(b);

        try(FileReader fileReader = new FileReader("ActType.txt")) {
            int c;
            c = fileReader.read();
            if (c == 48)
            {
                checkBoxType1.setSelected(false);
                checkBoxType1.setEnabled(false);
                //checkBoxType1.setVisible(false);
            }
            else
                checkBoxType1.setSelected(true);
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
            {
                checkBoxType2.setSelected(false);
                checkBoxType2.setEnabled(false);
            }
            else
                checkBoxType2.setSelected(true);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try(FileReader fileReader = new FileReader("ActVid.txt"))
        {
            int v_mas[] = new int[11];
            int c;
            c = fileReader.read();
            if(c == 48)
                v_mas[0] = 0;
            else
                v_mas[0] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[1] = 0;
            else
                v_mas[1] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[2] = 0;
            else
                v_mas[2] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[3] = 0;
            else
                v_mas[3] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[4] = 0;
            else
                v_mas[4] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[5] = 0;
            else
                v_mas[5] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[6] = 0;
            else
                v_mas[6] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[7] = 0;
            else
                v_mas[7] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[8] = 0;
            else
                v_mas[8] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[9] = 0;
            else
                v_mas[9] = 1;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 48)
                v_mas[10] = 0;
            else
                v_mas[10] = 1;
            if(v_mas[0] == 1 || v_mas[5] == 1)
            {
                rb1.setEnabled(true);
                rb2.setEnabled(true);
                rb3.setEnabled(true);
                rb4.setEnabled(true);
            }
            else
            {
                rb4.setEnabled(false);
                if(v_mas[1] == 1)
                {
                    rb1.setEnabled(true);
                    rb2.setEnabled(true);
                    rb3.setEnabled(true);
                }
                else
                {
                    rb3.setEnabled(false);
                    if(v_mas[2] == 1 || v_mas[4] == 1 || v_mas[6] == 1 || v_mas[7] == 1|| v_mas[9] == 1)
                    {
                        rb1.setEnabled(true);
                        rb2.setEnabled(true);
                    }
                    else
                    {
                        rb1.setEnabled(true);
                        rb2.setEnabled(false);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton butAdd = new JButton("Добавить");
        butAdd.setBounds(50, 320, 140, 50);
        panel.add(butAdd);
        ActionListener actionListenerButAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char buf[] = new char[100000];
                int index = 0;
                try(FileReader fileReader = new FileReader("DOP.txt"))
                {
                    int c;
                    while ((c = fileReader.read()) != '=')
                    {
                        buf[index] = (char)c;
                        index++;
                    }
                    int k = buf[0];
                    k = k + 1;
                    buf[0] = (char)k;
                    fileReader.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try(FileWriter fileWriter = new FileWriter("DOP.txt", false))
                {
                    for(int i = 0; i < index; i++)
                        fileWriter.write(buf[i]);

                    fileWriter.write(textFieldObject.getText());
                    fileWriter.write("+");
                    if(checkBoxType1.isSelected() && checkBoxType2.isSelected())
                        fileWriter.write("Внешний и Внутренний");
                    else
                    {
                        if(checkBoxType1.isSelected())
                            fileWriter.write("Внешний");
                        else
                            fileWriter.write("Внутренний");
                    }
                    fileWriter.write("+");
                    if(rb1.isSelected())
                        fileWriter.write("H1");
                    if(rb2.isSelected())
                        fileWriter.write("H2");
                    if(rb3.isSelected())
                        fileWriter.write("H3");
                    if(rb4.isSelected())
                        fileWriter.write("H4");
                    fileWriter.write("+");
                    fileWriter.write(textFieldVoz.getText());
                    fileWriter.write("\n");
                    fileWriter.write("=");
                    fileWriter.write("\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                rb1.setSelected(true);
                rb2.setSelected(false);
                rb3.setSelected(false);
                rb4.setSelected(false);

                checkBoxType1.setSelected(false);
                checkBoxType2.setSelected(false);

                textFieldObject.setText("...");
                textFieldVoz.setText("...");

            }
        };
        butAdd.addActionListener(actionListenerButAdd);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
