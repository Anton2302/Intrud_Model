import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class clasAS extends JFrame {

    public clasAS(){
        JFrame frame = new JFrame("Выбор уровней нарушителя ИБ в АС");
        frame.setBounds(400, 200, 500, 400);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Выберите актуальныу уровни нарушителей в АС");
        label.setBounds(20,20,400, 30);
        panel.add(label);

        JLabel label1 = new JLabel("Первый уровень");
        JLabel label1help = new JLabel("(Запуск задач из фиксированного набора)");
        label1.setBounds(40,60,400,30);
        label1help.setBounds(60, 70, 400, 30);

        JLabel label2 = new JLabel("Второй уровень");
        JLabel label2help = new JLabel("(Создание и запуск собственных программ)");
        label2.setBounds(40,110,400,30);
        label2help.setBounds(60, 120, 400, 30);

        JLabel label3 = new JLabel("Третий уровень");
        JLabel label3help = new JLabel("(Управление функционированием АС)");
        label3.setBounds(40,160,400,30);
        label3help.setBounds(60, 170, 400, 30);

        JLabel label4 = new JLabel("Четвертый уровень");
        JLabel label4help = new JLabel("(Весь объекм возможностей)");
        label4.setBounds(40,210,400,30);
        label4help.setBounds(60, 220, 400, 30);

        panel.add(label1);
        panel.add(label1help);

        panel.add(label2);
        panel.add(label2help);

        panel.add(label3);
        panel.add(label3help);

        panel.add(label4);
        panel.add(label4help);

        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        JCheckBox checkBox3 = new JCheckBox();
        JCheckBox checkBox4 = new JCheckBox();

        checkBox1.setBounds(400,60, 30, 30);
        checkBox2.setBounds(400,110, 30, 30);
        checkBox3.setBounds(400,150, 30, 30);
        checkBox4.setBounds(400,200, 30, 30);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);

        try(FileReader fileReader = new FileReader("AS.txt"))
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 320, 400, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                try(FileWriter fileWriter = new FileWriter("AS.txt"))
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
