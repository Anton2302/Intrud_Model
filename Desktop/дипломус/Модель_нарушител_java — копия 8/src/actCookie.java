import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class actCookie extends JFrame {

    public actCookie(int main_mas[])
    {
        JFrame frame = new JFrame("Возможности нарушителя при атаке на Cookie-файлы");
        frame.setBounds(400, 100, 800, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label10 = new JLabel();
        label10.setText("Возможность осуществления нарушителем несанкционированного доступа к защищаемой информации");
        label10.setBounds(30, 20, 700, 50);
        JLabel label11 = new JLabel();
        label11.setText("(учётным записям пользователей, сертификатам и т.п.), содержащейся в cookies-файлах");
        label11.setBounds(30, 40, 700, 50);
        panel.add(label10);
        panel.add(label11);

        JLabel label20 = new JLabel();
        JLabel label21 = new JLabel();
        label20.setBounds(30, 90, 750, 50);
        label21.setBounds(30, 110, 750, 50);
        label20.setText("Возможность хищения с использованием вредоносной программы аутентификационной информации");
        label21.setText("пользователей, их счетов, хранящейся во временных файлах cookie");
        panel.add(label20);
        panel.add(label21);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();

        checkBox1.setBounds(740, 50, 30, 30);
        checkBox2.setBounds(740, 120, 30, 30);

        panel.add(checkBox1);
        panel.add(checkBox2);

        try(FileReader fileReader = new FileReader("Cookie.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                checkBox1.setSelected(true);

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                checkBox2.setSelected(true);

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
                try(FileWriter fileWriter = new FileWriter("Cookie.txt", false))
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
