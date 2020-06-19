import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Welcome_Window extends JFrame {

    private String version_text = new String("Версия 1.0");

    public Welcome_Window(){
        JFrame main_window = new JFrame("ПО для разработки модели нарушителя ИБ для ИС организации");
        main_window.setBounds(350, 50, 600, 600);
        main_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main_window.setResizable(false);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);

        JLabel label_version = new JLabel(version_text);
        label_version.setBounds(2, 550, 100, 30);
        main_panel.add(label_version);


        JButton button_organization_info = new JButton("Ввести данные о защищаемой организации");
        button_organization_info.setBounds(50, 50, 500, 50);
        main_panel.add(button_organization_info);
        ActionListener org_info = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_window.setVisible(false);
                Organisation_info org = new Organisation_info(main_window);
            }
        };
        button_organization_info.addActionListener(org_info);

        JButton start_all_questions = new JButton("Перейти к ответам на все вопросы");
        start_all_questions.setBounds(50, 110, 500, 50);
        main_panel.add(start_all_questions);
        ActionListener start_q = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Question1 question1 = new Question1();
                main_window.dispose();
            }
        };
        start_all_questions.addActionListener(start_q);

        JButton construct_file = new JButton("Создать модель нарушителя ИБ для ИС организации");
        construct_file.setBounds(50, 410, 500, 50);
        main_panel.add(construct_file);
        ActionListener c_f = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Cons_file cons_file = new Cons_file();
                ConstFile2 constFile2 = new ConstFile2(main_window);
            }
        };
        construct_file.addActionListener(c_f);

        JButton actual = new JButton("Выбрать актуальность характеристик модели нарушителя ИБ");
        actual.setBounds(50, 260, 500, 50);
        main_window.add(actual);
        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set_Actual set_actual = new Set_Actual();
                main_window.dispose();
            }
        };
        actual.addActionListener(act);

        JButton buttonAdd = new JButton("Добавить возможные объекты атаки нарушителя");
        buttonAdd.setBounds(50, 320, 500, 50);
        main_panel.add(buttonAdd);
        ActionListener alAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classAdd1 classAd = new classAdd1();
                main_window.dispose();
            }
        };
        buttonAdd.addActionListener(alAdd);

        JButton button_go_to_q = new JButton("Перейти к ответу на конкретный вопрос");
        button_go_to_q.setBounds(50,170, 500, 50);
        main_panel.add(button_go_to_q);

        ActionListener alGo_to = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                go_to_question go = new go_to_question();
                main_window.dispose();
            }
        };
        button_go_to_q.addActionListener(alGo_to);

        JButton button_inst = new JButton("Инструкция");
        button_inst.setBounds(45, 490, 150, 50);
        main_panel.add(button_inst);

        ActionListener alInst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instruction instruction = new Instruction();
                main_window.dispose();
            }
        };
        button_inst.addActionListener(alInst);

        JButton button_end = new JButton("Выход");
        button_end.setBounds(225, 510, 150, 50);
        main_panel.add(button_end);

        ActionListener alEnd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        button_end.addActionListener(alEnd);

        JButton button_spravka = new JButton("Справка");
        button_spravka.setBounds(405, 490, 150, 50);
        main_panel.add(button_spravka);

        ActionListener alSprav = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spravka spravka = new Spravka();
                main_window.dispose();
            }
        };
        button_spravka.addActionListener(alSprav);

        JLabel label1 = new JLabel("Раздел 1: Формирование модели нарушителя ИБ");
        JLabel label2 = new JLabel("Раздел 2: Корректирование модели нарушителя ИБ");
        JLabel label3 = new JLabel("Раздел 3: Формирование документа с итоговой моделью нарушителя ИБ");

        label1.setBounds(50, 20, 500, 30);
        label2.setBounds(50, 230, 500, 30);
        label3.setBounds(50, 380, 500, 30);

        main_panel.add(label1);
        main_panel.add(label2);
        main_panel.add(label3);

        main_window.getContentPane().add(main_panel);
        main_window.setVisible(true);
    }

    public static void main(String args[]){
        Welcome_Window start = new Welcome_Window();
    }
}
