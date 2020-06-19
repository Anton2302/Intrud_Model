import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

public class Set_Actual extends JFrame {

    public Set_Actual ()
    {
        
        int main_mas[] = new int[43];
        for(int i = 0; i < 43; i++)
        {
            main_mas[i] = setMas(i + 1);
           // System.out.println(i + 1 + " = " +  main_mas[i]);
        }

        JFrame frame = new JFrame("Проставление актуальности критериям модели нарушителя ИБ");
        frame.setBounds(300, 100, 700, 700);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);


        JButton back = new JButton("На главную");
        back.setBounds(50, 600, 600, 50);
        panel.add(back);
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        back.addActionListener(b);


        JButton type = new JButton("Выбрать актуальные типы нарушителя ИБ");
        type.setBounds(50, 50, 600, 50);
        panel.add(type);
        ActionListener t = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actType actType = new actType(main_mas[18], main_mas[22], main_mas[34]);
                frame.dispose();
            }
        };
        type.addActionListener(t);


        JButton vid = new JButton("Выбрать актуальные виды нарушителя ИБ");
        vid.setBounds(50, 120, 600, 50);
        panel.add(vid);
        ActionListener v = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actVid av = new actVid(main_mas);
                frame.dispose();
            }
        };
        vid.addActionListener(v);


        JButton obj = new JButton("Выбрать актуальные объекты атаки нарушителя ИБ");
        obj.setBounds(50, 190, 600, 50);
        panel.add(obj);
        ActionListener o = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actObject ao = new actObject(main_mas);
                frame.dispose();
            }
        };
        obj.addActionListener(o);

        JButton scenar = new JButton("Выбрать актуальные возможности нарушителя ИБ");
        scenar.setBounds(50, 260, 600, 50);
        panel.add(scenar);
        ActionListener as = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actScenarMain actS = new actScenarMain(main_mas);
                frame.dispose();
            }
        };
        scenar.addActionListener(as);

        JButton kanali = new JButton("Выбрать актуальные каналы утечки ифнормации");
        kanali.setBounds(50, 330, 600, 50);
        panel.add(kanali);
        ActionListener aKanali = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actKanali aKanal = new actKanali(main_mas);
                frame.dispose();
            }
        };
        kanali.addActionListener(aKanali);

        JButton ispdn = new JButton("Выбрать группы нарушителя ИБ в ИСПДн");
        ispdn.setBounds(50, 400, 600, 50);
        panel.add(ispdn);
        ActionListener aIspdn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clasISPDn cIs = new clasISPDn();
                frame.dispose();
            }
        };
        ispdn.addActionListener(aIspdn);
        if(main_mas[36] == 0)
            ispdn.setEnabled(false);

        JButton aS = new JButton("Выбрать уровни нарушителя ИБ в АС");
        aS.setBounds(50, 470, 600, 50);
        panel.add(aS);
        ActionListener alAs = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clasAS clAs = new clasAS();
                frame.dispose();
            }
        };
        aS.addActionListener(alAs);
        if(main_mas[32] == 0)
            aS.setEnabled(false);

        JButton buttonScen = new JButton("Выбрать актуальные сценарии нарушителя ИБ");
        buttonScen.setBounds(50, 540, 600, 50);
        panel.add(buttonScen);
        ActionListener alBScen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actScenar2020 act2020 = new actScenar2020();
                frame.dispose();
            }
        };
        buttonScen.addActionListener(alBScen);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    int setMas(int number)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("q").append(String.valueOf(number)).append(".txt");
        try(FileReader fileReader = new FileReader(stringBuilder.toString()))
        {
            int c = fileReader.read();
            if((char)c == '1')
            {
                return 1;
            }
            if((char)c == '0')
            {
                return 0;
            }
            if((char)c != '1' && (char)c != '0')
            {
                return -1;
            }
        }
        catch (IOException e)
        {

        }
        System.out.println("Ошибка");
        return -1;
    }
}
