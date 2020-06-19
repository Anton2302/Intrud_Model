import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JFrame {

    public Instruction(){

        String text = "Для грамотной работы программы следует пользоваться следующей последовательностью: \n\n" +
                "   1)Перейти по кнопке \"Ввести данные о защищаемой организации\". После перехода заполнить все текстовые поля окна.\n\n" +
                "   2)Перейти по кнопке \"Перейти к ответам на все вопросы\". После чего ответить на все предоставленные вопросы.\n\n" +
                "   3)При необходимости изменения ответа на конкретный вопрос стоит перейти по кнопке \"Перейти к ответу на конкретный вопрос\".\n\n" +
                "   4)В появившимся окне стоит выбрать одну из двух следующих возможностей:\n\n" +
                "       - \"Просмотреть список вопросов\", для повторного ознакомления с вопросами;\n\n" +
                "       - \"Перейти\", для перехода к вопросу, написанному в поле выше.\n\n" +
                "   5)Перейти по кнопке \"Выбрать актуальность характеристик модели нарушителя ИБ\".\n\n" +
                "   6)В появившемся окне перейти по каждой кнопке и проставить и (или) проверить правильность выставленной актуальности.\n\n" +
                "   7)При необходимости добавления нового объекта воздействия нарушителя стоит перейти по кнопке\n" +
                "   \"Добавить возможные объекты атаки нарушителя\". В появившемся окне сперва нажать на кнопку \"Очистить кэш\", а затем \n" +
                "   по кнопке \"Добавить объект атаки\". В появившемся окне заполнить все поля и добавить столько объектов, сколько необходимо\n\n" +
                "   8)Перейти по кнопке \"Создать модель нарушителя ИБ для ИС организации\". После указать название и директорию для файла.";

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextArea textArea = new JTextArea(10, 10);
        textArea.setText(text);
        panel.add(textArea);
        textArea.setBounds(0, 150, 1000, 400);

        JButton button_back = new JButton("На главную");
        button_back.setBounds(50, 50, 900, 50);
        panel.add(button_back);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        button_back.addActionListener(al);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
