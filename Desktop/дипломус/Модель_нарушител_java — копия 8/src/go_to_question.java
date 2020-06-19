import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class go_to_question extends JFrame {

    public go_to_question()
    {
        JFrame frame = new JFrame("Переход к вопросу");
        frame.setBounds(350, 100, 400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(50, 40, 300, 40);
        label.setText("Введите номер вопроса:");
        panel.add(label);

        JTextField textField = new JTextField("...");
        textField.setBounds(300, 40, 50, 40);
        panel.add(textField);

        JButton button_enter = new JButton("Перейти");
        button_enter.setBounds(50, 100, 300, 50);
        panel.add(button_enter);

        ActionListener al1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String que = textField.getText();
                int flag = 0;
                if(textField.getText().equals("1"))
                {
                    Question1 question1 = new Question1();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("2"))
                {
                    Question2 question1 = new Question2();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("3"))
                {
                    Question3 question1 = new Question3();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("4"))
                {
                    Question4 question1 = new Question4();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("5"))
                {
                    Question5 question1 = new Question5();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("6"))
                {
                    Question6 question1 = new Question6();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("7"))
                {
                    Question7 question1 = new Question7();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("8"))
                {
                    Question8 question1 = new Question8();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("9"))
                {
                    Question9 question1 = new Question9();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("10"))
                {
                    Question10 question1 = new Question10();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("11"))
                {
                    Question11 question1 = new Question11();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("12"))
                {
                    Question12 question1 = new Question12();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("13"))
                {
                    Question13 question1 = new Question13();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("14"))
                {
                    Question14 question1 = new Question14();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("15"))
                {
                    Question15 question1 = new Question15();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("16"))
                {
                    Question16 question1 = new Question16();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("17"))
                {
                    Question17 question1 = new Question17();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("18"))
                {
                    Question18 question1 = new Question18();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("19"))
                {
                    Question19 question1 = new Question19();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("20"))
                {
                    Question20 question1 = new Question20();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("21"))
                {
                    Question21 question1 = new Question21();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("22"))
                {
                    Question22 question1 = new Question22();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("23"))
                {
                    Question23 question1 = new Question23();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("24"))
                {
                    Question24 question1 = new Question24();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("25"))
                {
                    Question25 question1 = new Question25();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("26"))
                {
                    Question26 question1 = new Question26();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("27"))
                {
                    Question27 question1 = new Question27();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("28"))
                {
                    Question28 question1 = new Question28();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("29"))
                {
                    Question29 question1 = new Question29();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("30"))
                {
                    Question30 question1 = new Question30();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("31"))
                {
                    Question31 question1 = new Question31();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("32"))
                {
                    Question32 question1 = new Question32();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("33"))
                {
                    Question33 question1 = new Question33();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("34"))
                {
                    Question34 question1 = new Question34();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("35"))
                {
                    Question35 question1 = new Question35();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("36"))
                {
                    Question36 question1 = new Question36();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("37"))
                {
                    Question37 question1 = new Question37();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("38"))
                {
                    Question38 question1 = new Question38();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("39"))
                {
                    Question39 question1 = new Question39();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("40"))
                {
                    Question40 question1 = new Question40();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("41"))
                {
                    Question41 question1 = new Question41();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("42"))
                {
                    Question42 question1 = new Question42();
                    flag++;
                    frame.dispose();
                }
                if(textField.getText().equals("43"))
                {
                    Question43 question1 = new Question43();
                    flag++;
                    frame.dispose();
                }
                if(flag == 0)
                {
                    textField.setText("...");
                }
            }
        };
        button_enter.addActionListener(al1);

        JButton button_all_questions = new JButton("Просмотреть список вопросов");
        button_all_questions.setBounds(50, 200, 300, 50);
        panel.add(button_all_questions);

        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allQuestionsInfo allQuestI = new allQuestionsInfo();
                frame.dispose();
            }
        };
        button_all_questions.addActionListener(al2);


        JButton button_back = new JButton("На главную");
        button_back.setBounds(50, 300, 300, 50);
        panel.add(button_back);

        ActionListener al3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        button_back.addActionListener(al3);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
