import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class actRezerv extends JFrame {

    public actRezerv(int main_mas[])
    {
        JFrame frame = new JFrame("Возможности нарушителя при атаке на компоненты, отвечающие за резервирование");
        frame.setBounds(400, 100, 800, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label10 = new JLabel();
        label10.setText("Возможность снижения качества облачных услуг из-за возникновения технических сбоев");
        label10.setBounds(30, 20, 700, 50);
        JLabel label11 = new JLabel();
        label11.setText("хотя бы у одного из поставщиков облачных услуг, а также из-за возникновения существенных задержек");
        label11.setBounds(30, 40, 700, 50);
        JLabel label12 = new JLabel();
        label12.setBounds(30, 60, 700, 50);
        label12.setText("или потерь в каналах передачи данных, арендуемых потребителем или поставщиками облачных услуг");
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);

        JCheckBox checkBox1 = new JCheckBox();

        checkBox1.setBounds(740, 50, 30, 30);

        panel.add(checkBox1);

        try(FileReader fileReader = new FileReader("Rezerv.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                checkBox1.setSelected(true);


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
                try(FileWriter fileWriter = new FileWriter("Rezerv.txt", false))
                {
                    if(checkBox1.isSelected())
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
