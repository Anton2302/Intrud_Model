import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class actType extends JFrame {

    public actType(int intern, int fd, int sistem)
    {
        int flag_vne = 0;

        JFrame frame = new JFrame("Выбор актуальных типов нарушителей ИБ в ИС");
        frame.setBounds(400, 200, 600, 300);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Выберите актуальные типы нарушителей ИБ в ИС?");
        label.setBounds(50, 10, 500, 50);
        panel.add(label);


        JCheckBox vne = new JCheckBox("Внешний");
        JCheckBox vnu = new JCheckBox("Внутренний");
        vne.setBounds(200, 100, 100, 50);
        vnu.setBounds(350, 100, 150, 50);
        panel.add(vne);
        panel.add(vnu);

        vnu.setSelected(true);
        if(intern == 1 || fd == 1 || sistem == 1)
        {
            vne.setSelected(true);
            flag_vne = 1;
        }

        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 200, 500, 50);
        panel.add(back);
        int finalFlag_vne = flag_vne;
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a, b;
                if(vne.isSelected())
                {
                    a = 1;
                }
                else
                    a = 0;

                if(vnu.isSelected())
                {
                    b = 1;
                }
                else
                    b = 0;
                Set_Actual set_actual = new Set_Actual();
                setText(a,b);
                frame.dispose();
            }
        };
        back.addActionListener(b);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    void setText(int vne, int vnu)
    {
        try(FileWriter fileWriter = new FileWriter("ActType.txt", false))
        {
            if(vne == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
            fileWriter.write("\n");
            if(vnu == 1)
                fileWriter.write("1");
            else
                fileWriter.write("0");
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}
