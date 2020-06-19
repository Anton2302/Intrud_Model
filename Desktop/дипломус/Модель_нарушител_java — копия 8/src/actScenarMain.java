import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class actScenarMain extends JFrame {

    public actScenarMain(int main_mas[])
    {
        int help_mas[] = new int[20];
        int index = 0;

        JFrame frame = new JFrame("Выбор актуальных возможностей нарушителя ИБ");
        frame.setBounds(400, 100, 500, 600);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Выберите объект для выбора");
        JLabel label2 = new JLabel("актуальности возможного сценария");
        label.setBounds(30, 20, 400, 50);
        label2.setBounds(160, 40, 300, 50);
        panel.add(label);
        panel.add(label2);

        JButton back = new JButton("К предыдущему окну");
        back.setBounds(50, 500, 400, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                frame.dispose();
            }
        };
        back.addActionListener(b);

        JButton button1 = new JButton("Грид-система");
        button1.setBounds(30, 80, 130, 40);
        panel.add(button1);

        JButton button2 = new JButton("Гипервизор(ы)");
        button2.setBounds(30, 130, 130, 40);
        panel.add(button2);

        JButton button3 = new JButton("BIOS/UEFI");
        button3.setBounds(30, 180, 130, 40);
        panel.add(button3);

        JButton button4 = new JButton("Суперкомпьютер");
        button4.setBounds(30, 230, 130, 40);
        panel.add(button4);

        JButton button5 = new JButton("Облачные сервера");
        button5.setBounds(30, 280, 130, 40);
        panel.add(button5);

        JButton button6 = new JButton("Инф. носители");
        button6.setBounds(30, 330, 130, 40);
        panel.add(button6);

        JButton button7 = new JButton("Моб. устройства");
        button7.setBounds(30, 380, 130, 40);
        panel.add(button7);

        JButton button8 = new JButton("Аутентификация");
        button8.setBounds(185, 80, 130,40);
        panel.add(button8);

        JButton button9 = new JButton("Фреймворки/код");
        button9.setBounds(185, 130, 130,40);
        panel.add(button9);

        JButton button10 = new JButton("Пользов. данные");
        button10.setBounds(185, 180, 130,40);
        panel.add(button10);

        JButton button11 = new JButton("Запросы");
        button11.setBounds(185, 230, 130,40);
        panel.add(button11);

        JButton button12 = new JButton("Cookie-файлы");
        button12.setBounds(185, 280, 130,40);
        panel.add(button12);

        JButton button13 = new JButton("XML-система");
        button13.setBounds(185, 330, 130,40);
        panel.add(button13);

        JButton button14 = new JButton("Отчеты ошибок");
        button14.setBounds(185, 380, 130,40);
        panel.add(button14);

        JButton button15 = new JButton("Хранилище данных");
        button15.setBounds(350, 80, 140, 40);
        panel.add(button15);

        JButton button16 = new JButton("Компон. с сетью");
        button16.setBounds(350, 130, 140, 40);
        panel.add(button16);

        JButton button17 = new JButton("Резервирование");
        button17.setBounds(350, 180, 140, 40);
        panel.add(button17);

        JButton button18 = new JButton("Сайт");
        button18.setBounds(350, 230, 140, 40);
        panel.add(button18);

        JButton button19 = new JButton("Фильтры");
        button19.setBounds(350, 280, 140, 40);
        panel.add(button19);

        JButton button20 = new JButton("Другие");
        button20.setBounds(350, 330, 140, 40);
        panel.add(button20);

        try(FileReader fileReader = new FileReader("ActObj.txt"))
        {
            for(int i = 0; i < 39; i++)
            {
                int c = fileReader.read();
                if(i % 2 == 0)
                {
                    if(c == 48)
                        help_mas[index] = 0;
                    if(c == 49)
                        help_mas[index] = 1;
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(help_mas[0] == 0)
            button1.setEnabled(false);

        if(help_mas[1] == 0)
            button2.setEnabled(false);

        if(help_mas[2] == 0)
            button3.setEnabled(false);

        if(help_mas[3] == 0)
            button4.setEnabled(false);

        if(help_mas[4] == 0)
            button5.setEnabled(false);

        if(help_mas[5] == 0)
            button6.setEnabled(false);

        if(help_mas[6] == 0)
            button7.setEnabled(false);

        if(help_mas[7] == 0)
            button8.setEnabled(false);

        if(help_mas[8] == 0)
            button9.setEnabled(false);

        if(help_mas[9] == 0)
            button10.setEnabled(false);

        if(help_mas[10] == 0)
            button11.setEnabled(false);

        if(help_mas[11] == 0)
            button12.setEnabled(false);

        if(help_mas[12] == 0)
            button13.setEnabled(false);

        if(help_mas[13] == 0)
            button14.setEnabled(false);

        if(help_mas[14] == 0)
            button15.setEnabled(false);

        if(help_mas[15] == 0)
            button16.setEnabled(false);

        if(help_mas[16] == 0)
            button17.setEnabled(false);

        if(help_mas[17] == 0)
            button18.setEnabled(false);

        if(help_mas[18] == 0)
            button19.setEnabled(false);

        if(help_mas[19] == 0)
            button20.setEnabled(false);

        ActionListener al1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actGrid aG = new actGrid(main_mas);
                frame.dispose();
            }
        };
        button1.addActionListener(al1);

        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actGiper aGip = new actGiper(main_mas);
                frame.dispose();
            }
        };
        button2.addActionListener(al2);

        ActionListener al3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actBIOS aBIOS = new actBIOS(main_mas);
                frame.dispose();
            }
        };
        button3.addActionListener(al3);

        ActionListener al4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actSuperComp aSuperC = new actSuperComp(main_mas);
                frame.dispose();
            }
        };
        button4.addActionListener(al4);

        ActionListener al5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actCloud aCloud = new actCloud(main_mas);
                frame.dispose();
            }
        };
        button5.addActionListener(al5);

        ActionListener al6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actNositInfo aNositI = new actNositInfo(main_mas);
                frame.dispose();
            }
        };
        button6.addActionListener(al6);

        ActionListener al7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actMobileDev aMobileD = new actMobileDev(main_mas);
                frame.dispose();
            }
        };
        button7.addActionListener(al7);

        ActionListener al8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actAutentific aAuten = new actAutentific(main_mas);
                frame.dispose();
            }
        };
        button8.addActionListener(al8);

        ActionListener al9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actFreimCode aFreim = new actFreimCode(main_mas);
                frame.dispose();
            }
        };
        button9.addActionListener(al9);

        ActionListener al10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actPolInfo aPolI = new actPolInfo(main_mas);
                frame.dispose();
            }
        };
        button10.addActionListener(al10);

        ActionListener al11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actZapros aZapr = new actZapros(main_mas);
                frame.dispose();
            }
        };
        button11.addActionListener(al11);

        ActionListener al12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actCookie aCookie = new actCookie(main_mas);
                frame.dispose();
            }
        };
        button12.addActionListener(al12);

        ActionListener al13 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actXML aXML = new actXML(main_mas);
                frame.dispose();
            }
        };
        button13.addActionListener(al13);

        ActionListener al14 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actOtchet aOtchet = new actOtchet(main_mas);
                frame.dispose();
            }
        };
        button14.addActionListener(al14);

        ActionListener al15 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actXranDan aXranD = new actXranDan(main_mas);
                frame.dispose();
            }
        };
        button15.addActionListener(al15);

        ActionListener al16 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actInternet aInter = new actInternet(main_mas);
                frame.dispose();
            }
        };
        button16.addActionListener(al16);

        ActionListener al17 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actRezerv aRez = new actRezerv(main_mas);
                frame.dispose();
            }
        };
        button17.addActionListener(al17);

        ActionListener al18 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actSait aSait = new actSait(main_mas);
                frame.dispose();
            }
        };
        button18.addActionListener(al18);

        ActionListener al19 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actFilters aFilters = new actFilters(main_mas);
                frame.dispose();
            }
        };
        button19.addActionListener(al19);

        ActionListener al20 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actOther aOther = new actOther(main_mas);
                frame.dispose();
            }
        };
        button20.addActionListener(al20);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
