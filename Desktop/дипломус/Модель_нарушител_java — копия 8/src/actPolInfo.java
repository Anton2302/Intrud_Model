import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class actPolInfo extends JFrame {

    public actPolInfo(int main_mas[])
    {
        JFrame frame = new JFrame("Возможности нарушителя при атаке на данные пользователей");
        frame.setBounds(400, 100, 800, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label10 = new JLabel();
        label10.setText("Возможность осуществления нарушителем несанкционированного доступа к защищаемой информации в");
        label10.setBounds(30, 20, 700, 50);
        JLabel label11 = new JLabel();
        label11.setText("обход штатных механизмов с помощью нестандартных интерфейсов ");
        label11.setBounds(30, 40, 700, 50);
        panel.add(label10);
        panel.add(label11);

        JLabel label20 = new JLabel();
        JLabel label21 = new JLabel();
        label20.setBounds(30, 90, 750, 50);
        label21.setBounds(30, 110, 750, 50);
        label20.setText("Возможность утечки пользовательских данных за счет использования реализованной");
        label21.setText("в браузерах функции автоматического заполнение форм авторизации");
        panel.add(label20);
        panel.add(label21);

        JLabel label30 = new JLabel();
        JLabel label31 = new JLabel();
        label30.setBounds(30, 160, 700, 50);
        label31.setBounds(30, 180, 700, 50);
        label30.setText("Возможность действия нарушителя в связи с пропуском и/или значительной временной");
        label31.setText("задержке определения (выявления) событий безопасности информации");
        panel.add(label30);
        panel.add(label31);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        JCheckBox checkBox3 = new JCheckBox();

        checkBox1.setBounds(740, 50, 30, 30);
        checkBox2.setBounds(740, 120, 30, 30);
        checkBox3.setBounds(740, 190, 30, 30);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);

        try(FileReader fileReader = new FileReader("PolzInfo.txt"))
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 500, 700, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actScenarMain aS = new actScenarMain(main_mas);
                try(FileWriter fileWriter = new FileWriter("PolzInfo.txt", false))
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