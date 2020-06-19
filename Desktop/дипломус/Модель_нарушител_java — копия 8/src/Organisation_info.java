import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Organisation_info extends JFrame {

    JTextField field_name, field_adress, field_year, field_city, field_small_name, field_number;
    JLabel label_name, label_adress, label_year, label_city, label_small_name, label_nubmer;

    public Organisation_info(JFrame obj){
        JFrame main_window_org_info = new JFrame("Ввод данных о защищаемой организации");
        main_window_org_info.setBounds(300, 100, 600, 400);
        main_window_org_info.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        main_window_org_info.setResizable(false);

        JPanel org_info_panel = new JPanel();
        org_info_panel.setLayout(null);

        JLabel label_info = new JLabel("Заполните следующие данные о организации:");
        label_info.setBounds(20, 40, 500, 30);
        org_info_panel.add(label_info);

        //кнопки
        JButton back = new JButton("На главную");
        back.setBounds(500, 330, 100, 50);
        org_info_panel.add(back);
        ActionListener back_button = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write_text(field_name.getText(), field_adress.getText(), field_year.getText(),
                        field_city.getText(), field_small_name.getText(), field_number.getText());
                main_window_org_info.dispose();
                obj.setVisible(true);
            }
        };
        back.addActionListener(back_button);


        //текстовые поля
        field_year = new JTextField("...", 4);
        field_year.setToolTipText("Введите текущий год");
        field_year.setBounds(240,160, 200, 30);

        field_adress  = new JTextField("...", 40);
        field_adress.setToolTipText("Введите адрес организации");
        field_adress.setBounds(240, 120, 200, 30);

        field_name = new JTextField("...", 60);
        field_name.setToolTipText("Введите название оргнизации");
        field_name.setBounds(240, 80, 200, 30);

        field_city = new JTextField("...", 20);
        field_city.setToolTipText("Введите название города");
        field_city.setBounds(240, 200, 200, 30);

        field_small_name = new JTextField("...", 20);
        field_small_name.setToolTipText("Введите абривиатуру организации");
        field_small_name.setBounds(240, 240, 200, 30);

        field_number = new JTextField("...", 11);
        field_number.setToolTipText("Введите контактный номер");
        field_number.setBounds(240, 280, 200, 30);

        org_info_panel.add(field_number);
        org_info_panel.add(field_small_name);
        org_info_panel.add(field_city);
        org_info_panel.add(field_name);
        org_info_panel.add(field_adress);
        org_info_panel.add(field_year);


        //labels
        label_year = new JLabel("Текущий год");
        label_year.setBounds(40, 160, 200, 30);
        label_year.setFont(new Font("Dialog", Font.BOLD, 14));

        label_name = new JLabel("Название организации");
        label_name.setBounds(40, 80, 200, 30);
        label_name.setFont(new Font("Dialog", Font.BOLD, 14));

        label_adress = new JLabel("Адрес оргназиации");
        label_adress.setBounds(40, 120, 200, 30);
        label_adress.setFont(new Font("Dialog", Font.BOLD, 14));

        label_city = new JLabel("Название города");
        label_city.setBounds(40, 200, 200, 30);
        label_city.setFont(new Font("Dialog", Font.BOLD, 14));

        label_small_name = new JLabel("Абривиатура организации");
        label_small_name.setBounds(40, 240, 200, 30);
        label_small_name.setFont(new Font("Dialog", Font.BOLD, 14));

        label_nubmer = new JLabel("Контактный телефон");
        label_nubmer.setBounds(40, 280, 200, 30);
        label_nubmer.setFont(new Font("Dialog", Font.BOLD, 14));

        org_info_panel.add(label_city);
        org_info_panel.add(label_small_name);
        org_info_panel.add(label_nubmer);
        org_info_panel.add(label_adress);
        org_info_panel.add(label_name);
        org_info_panel.add(label_year);


        set_text_to_fileds();
        main_window_org_info.getContentPane().add(org_info_panel);
        main_window_org_info.setVisible(true);
    }

    void write_text(String text_name, String text_adres, String text_year, String text_city, String text_small, String text_number)
    {
        try(FileWriter writer = new FileWriter("Organisation_info_text.txt", false))
        {
            writer.write(text_name);
            writer.write("\n");
            writer.write(text_adres);
            writer.write("\n");
            writer.write(text_year);
            writer.write("\n");
            writer.write(text_city);
            writer.write("\n");
            writer.write(text_small);
            writer.write("\n");
            writer.write(text_number);
            writer.write("\n");
            writer.write("=");
        }
        catch (IOException e)
        {
            System.out.println("Файл не найден");
        }
    }

    void set_text_to_fileds()
    {
        try(FileReader reader = new FileReader("Organisation_info_text.txt"))
        {
            int c;
            StringBuilder help = new StringBuilder();
            char[] buf = new char[500];
            int index = 0;
            while((c = reader.read()) != '=')
            {
                buf[index] = (char)c;
                index++;
            }
            for(int i = 0; i < index; i++)
            //работа с названием
            index = 0;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_name.setText(help.toString());
            //работа с адресом
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_adress.setText(help.toString());
            //работа с годом
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_year.setText(help.toString());
            //работа с городом
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_city.setText(help.toString());
            //работа с сокращенным названием
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_small_name.setText(help.toString());
            //работа с телефоном
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            field_number.setText(help.toString());


        }
        catch (IOException e)
        {

        }
    }
}
