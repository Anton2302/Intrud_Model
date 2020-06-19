import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import java.io.FileOutputStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class save_file extends JFrame {

    public save_file(JFrame frame_main, XWPFDocument document)
    {

        frame_main.dispose();

        JFileChooser fileChooser = new JFileChooser();

        JFrame frame = new JFrame("Сохранение файла");
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(300, 200, 400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton button_direct = new JButton("Выбрать директорию");
        JButton button_save = new JButton("Сохранить файл");
        button_direct.setBounds(50, 50, 300, 60);
        button_save.setBounds(50, 150, 300, 60);
        panel.add(button_direct);
        panel.add(button_save);

        ActionListener b_d = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(save_file.this);
            }
        };
        button_direct.addActionListener(b_d);

        ActionListener b_s = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Сохранение файла");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(save_file.this);
                if (result == JFileChooser.APPROVE_OPTION )
                {
                    try(FileOutputStream out = new FileOutputStream(fileChooser.getSelectedFile() + ".docx"))
                    {
                        document.write(out);
                        out.close();
                        document.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                Welcome_Window welcome_window = new Welcome_Window();
                frame.dispose();
            }
        };
        button_save.addActionListener(b_s);


        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
