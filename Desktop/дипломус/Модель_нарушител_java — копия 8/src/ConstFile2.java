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
import javax.swing.text.Document;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ConstFile2 {

    public ConstFile2(JFrame frame_main){
        int flag = 1;
        int numeration = 1;
        int main_mas[] = new int[43];

        for(int i = 0; i < 43; i++)
        {
            main_mas[i] = searcher(i + 1);
            if(main_mas[i] == -1)
            {
                flag = 0;
            }
        }
        if(flag == 0)
        {
            JOptionPane pane = new JOptionPane();
            pane.setBounds(40, 40, 100, 100);
            pane.setVisible(true);
        }

        int vid_mas[] = new int[11];
        int type[] = new int[2];

        try(FileReader fileReader = new FileReader("ActType.txt"))
        {
            int c, k;
            c = fileReader.read();
            k = fileReader.read();
            k = fileReader.read();
            if(c == 49)
                type[0] = 1;
            else
                type[0] = 0;
            if(k == 49)
                type[1] = 1;
            else
                type[1] = 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileReader fileReader = new FileReader("ActVid.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                vid_mas[0] = 1;
            else
                vid_mas[0] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[1] = 1;
            else
                vid_mas[1] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[2] = 1;
            else
                vid_mas[2] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[3] = 1;
            else
                vid_mas[3] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[4] = 1;
            else
                vid_mas[4] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[5] = 1;
            else
                vid_mas[5] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[6] = 1;
            else
                vid_mas[6] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[7] = 1;
            else
                vid_mas[7] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[8] = 1;
            else
                vid_mas[8] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[9] = 1;
            else
                vid_mas[9] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                vid_mas[10] = 1;
            else
                vid_mas[10] = 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 11; i++)
            System.out.println(vid_mas[i]);

        XWPFDocument document = new XWPFDocument();

        doTitul(document);

        doType(document, numeration);
        numeration++;

        doVid(document, numeration);
        numeration++;

        doPotencialText(document, numeration);
        numeration++;

        if(main_mas[2] == 1)
        {
            doSKZI(document, numeration);
            numeration++;
        }

        doTable1(document, main_mas, vid_mas, type, numeration);
        numeration++;

        doKanals(document, numeration);
        numeration++;

        if(main_mas[36] == 1)
        {
            doTableIspdn(document, vid_mas, main_mas, numeration);
            numeration++;
        }

        if(main_mas[32] == 1)
        {
            doAS(document, numeration);
            numeration++;
        }

        doTable2(document,main_mas, type, numeration);
        numeration++;

        doScenar(document, numeration);
        numeration++;

        doVivod(document, main_mas, numeration);

        save_file s_f = new save_file(frame_main, document);

    }

    int searcher(int number)
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

    void doTitul(XWPFDocument document)
    {
        StringBuilder help = new StringBuilder();
        String full_name, adress, year, city, smal_name, number;
        int c, index = 0;
        char buf[] = new char[500];
        try(FileReader fileReader = new FileReader("Organisation_info_text.txt"))
        {
            while((c = fileReader.read()) != '=')
            {
                buf[index] = (char)c;
                index++;
            }
            index = 0;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            full_name = help.toString();
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            adress = help.toString();
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            year = help.toString();
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            city = help.toString();
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            smal_name = help.toString();
            help.delete(0, index);
            index++;
            while(buf[index] != '\n')
            {
                help.append(buf[index]);
                index++;
            }
            number = help.toString();
            help.delete(0, index);

            XWPFParagraph titul1 = document.createParagraph();
            titul1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r_titul1 = titul1.createRun();
            r_titul1.setFontSize(16);
            r_titul1.setItalic(true);
            r_titul1.setColor("001000");
            r_titul1.setText(full_name);
            for(int i = 0; i < 10; i++)
                r_titul1.addBreak();



            XWPFParagraph titul2 = document.createParagraph();
            titul2.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r_titul2 = titul2.createRun();
            r_titul2.setFontSize(21);
            r_titul2.setBold(true);
            r_titul2.setColor("001000");
            r_titul2.setText("Модель нарушителя");
            r_titul2.addBreak();
            r_titul2.setText(smal_name);
            for(int i = 0; i < 10; i++)
                r_titul2.addBreak();


            XWPFParagraph titul3 = document.createParagraph();
            titul3.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun r_titul3 = titul3.createRun();
            r_titul3.setFontSize(15);
            r_titul3.setItalic(true);
            r_titul3.setText(adress);

            XWPFParagraph titul4 = document.createParagraph();
            titul4.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun r_titul4 = titul4.createRun();
            r_titul4.setFontSize(15);
            r_titul4.setItalic(true);
            r_titul4.setText(number);
            for(int i = 0; i < 4; i++)
                r_titul4.addBreak();

            XWPFParagraph titul5 = document.createParagraph();
            titul5.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r_titul5 = titul5.createRun();
            r_titul5.setFontSize(15);
            r_titul5.setItalic(true);
            r_titul5.setText(city);
            r_titul5.addBreak();
            r_titul5.setText(year);
            r_titul5.addBreak(BreakType.PAGE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void doType(XWPFDocument document, int numeration)
    {
        XWPFParagraph type0 = document.createParagraph();
        type0.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t0 = type0.createRun();
        r_t0.setFontSize(16);
        r_t0.setBold(true);
        r_t0.setText(numeration + ") Тип нарушителя ИБ.");
        r_t0.addBreak();

        XWPFParagraph type1 = document.createParagraph();
        type1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t1 = type1.createRun();
        r_t1.setFontSize(12);
        r_t1.setBold(false);
        r_t1.setText("      В данной ИС была проведена классификация нарушителей на внешних и внутренних:");
        r_t1.addBreak();
        r_t1.setText("              - Под внешними будем понимать нарушителя, не имеющего прав доступа к ресурсам системы и сетей, а так же " +
                "осуществляющего воздействия из-за пределов КЗ;");
        r_t1.addBreak();
        r_t1.setText("              - Под внутренним будем понимать нарушителя, обладающего правами доступа к ресурсам и системы и сетей, а так же " +
                "осуществляющего воздействия из КЗ ");
        r_t1.addBreak();
        try(FileReader fileReader = new FileReader("ActType.txt"))
        {
            int c, k;
            c = fileReader.read();
            k = fileReader.read();
            k = fileReader.read();

            if(c == 49 && k == 49)
                r_t1.setText("      Для данной организации характерны ВСЕ типы нарушителей.");

            if(c == 49 && k == 48)
                r_t1.setText("      Для данной организации характерен только ВНЕШНИЙ нарушитель.");

            if(c == 48 && k == 49)
                r_t1.setText("      Для данной организации характерен только ВНУТРЕННИЙ нарушитель.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        r_t1.addBreak();
        numeration++;
    }

    void doVid(XWPFDocument document, int numeration)
    {
        XWPFParagraph vid1 = document.createParagraph();
        vid1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_v1 = vid1.createRun();
        r_v1.setFontSize(16);
        r_v1.setText(numeration + ") Виды нарушителя ИБ.");
        r_v1.setBold(true);
        r_v1.addBreak();

        XWPFParagraph vid2 = document.createParagraph();
        vid2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_v2 = vid2.createRun();
        r_v2.setFontSize(12);
        r_v2.setText("  Для данной системы характеры следующие виды нарушителей:");
        r_v2.addBreak();
        r_v2.addBreak();

        try(FileReader fileReader = new FileReader("ActVid.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Специальные службы иностранных государств;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Террористические, экстремистские группировки;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Преступные группы;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Внешние субъекты (физ. лица);");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Конкурирующие организации;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Разработчики, производители, поставщики ПО и техники;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Лица, привлекаемые для установочных работ;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Лица, обеспечивающие функционирование системы;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Пользователи ИС;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Администраторы ИС и ИБ;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_v2.setText("      - Бывшие работники;");
                r_v2.addBreak();
                r_v2.addBreak();
            }
            r_v2.addBreak();
            r_v2.addBreak();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        numeration++;
    }

    void doPotencialText(XWPFDocument document, int numeration)
    {
        XWPFParagraph par1 = document.createParagraph();
        par1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_p1 = par1.createRun();
        r_p1.setFontSize(16);
        r_p1.setBold(true);
        r_p1.setText(numeration + ") Потенциал нарушителя ИБ.");

        XWPFParagraph par2 = document.createParagraph();
        par2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_p2 = par2.createRun();
        r_p2.setFontSize(12);
        r_p2.setText("(Согласно методическому документу \" Методика моделирования угроз безопасности информации\" 2020г (проект))");
        r_p2.addBreak();
        r_p2.addBreak();
        r_p2.setText("  Для характеризации нарушителя, ему будет присвоен один из четырех следующих потенциалов:");
        r_p2.addBreak();
        r_p2.addBreak();
        r_p2.setText("      - Н1 - нарушитель, обладающий базовым потенциалом;");
        r_p2.addBreak();
        r_p2.addBreak();
        r_p2.setText("      - Н2 - нарушитель, обладающий базовым повышенным потенциалом;");
        r_p2.addBreak();
        r_p2.addBreak();
        r_p2.setText("      - Н3 - нарушитель, обладающий средним потенциалом;");
        r_p2.addBreak();
        r_p2.addBreak();
        r_p2.setText("      - Н4 - нарушитель, обладающий высоким потенциалом;");
        r_p2.addBreak();
        r_p2.addBreak();

        XWPFParagraph parH1 = document.createParagraph();
        parH1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH1 = parH1.createRun();
        r_pH1.setFontSize(14);
        r_pH1.setItalic(true);
        r_pH1.setText(" Для нарушителя с потенциалом H1 характерно:");
        r_pH1.addBreak();

        XWPFParagraph parH12 = document.createParagraph();
        parH12.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH12 = parH12.createRun();
        r_pH12.setFontSize(12);
        r_pH12.setText("        •Использование при реализации угроз БИ только известных уязвимостей, скриптов и инструментов;");
        r_pH12.addBreak();
        r_pH12.addBreak();
        r_pH12.setText("        •Использование средств реализации угроз, свободно распространяемых в сети Интернет и (или) " +
                "разработанных другими лицами, однако с минимальными знаниями об этих инструментах;");
        r_pH12.addBreak();
        r_pH12.addBreak();
        r_pH12.setText("        •Обладание базовыми компьютерными навыками и знаниями на уровне пользователя.");
        r_pH12.addBreak();
        r_pH12.addBreak();


        XWPFParagraph parH2 = document.createParagraph();
        parH2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH2 = parH2.createRun();
        r_pH2.setFontSize(14);
        r_pH2.setItalic(true);
        r_pH2.setText(" Для нарушителя с потенциалом H2 характерно:");
        r_pH2.addBreak();

        XWPFParagraph parH22 = document.createParagraph();
        parH22.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH22 = parH22.createRun();
        r_pH22.setFontSize(12);
        r_pH22.setText("       •Обладание возможностями нарушителей с Н1 потенциалом;");
        r_pH22.addBreak();
        r_pH22.addBreak();
        r_pH22.setText("       •Использование средств реализации угроз, свободно распространяемых " +
                "в сети Интернет и (или) разработанных другими лицами, с повышенными знаниями об этих инструментах;");
        r_pH22.addBreak();
        r_pH22.addBreak();
        r_pH22.setText("       •Хорошее владение фреймворками;");
        r_pH22.addBreak();
        r_pH22.addBreak();
        r_pH22.setText("       •Обладание навыками самостоятельного планирования угроз БИ;");
        r_pH22.addBreak();
        r_pH22.addBreak();
        r_pH22.setText("       •Обладание знаниями о защитных механизмах, применямых в ПО и программно-аппаратных средствах;");
        r_pH22.addBreak();
        r_pH22.addBreak();
        r_pH22.setText("       •Имеет возможность производить атаки, направленные на недокументированные уязвимости.");
        r_pH22.addBreak();
        r_pH22.addBreak();

        XWPFParagraph parH3 = document.createParagraph();
        parH3.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH3 = parH3.createRun();
        r_pH3.setFontSize(14);
        r_pH3.setItalic(true);
        r_pH3.setText(" Для нарушителя с потенциалом H3 характерно:");
        r_pH3.addBreak();

        XWPFParagraph parH32 = document.createParagraph();
        parH3.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH32 = parH32.createRun();
        r_pH32.setFontSize(12);
        r_pH32.setText("       •Обладание возможностями нарушителей с Н2 потенциалом;");
        r_pH32.addBreak();
        r_pH22.addBreak();
        r_pH32.setText("       •Возможностью приобритения информации об уязвимостях, размещаемых на специализированных" +
                " платных ресурсах;");
        r_pH32.addBreak();
        r_pH32.addBreak();
        r_pH32.setText("       •Возможность приобретения дорогостоящих средств реализации угроз;");
        r_pH32.addBreak();
        r_pH32.addBreak();
        r_pH32.setText("       •Возможность самостоятельной разработки средств реализации угроз;");
        r_pH32.addBreak();
        r_pH32.addBreak();
        r_pH32.setText("       •Обладание возможностью получения прав доступа к встраиваемому ПО для проведения анализа;");
        r_pH32.addBreak();
        r_pH32.addBreak();
        r_pH32.setText("       •Обладание знаниями и навыками проведения анализа программного кода;");
        r_pH32.addBreak();
        r_pH32.addBreak();
        r_pH32.setText("       •Обладание возможностью реализовывания угроз БИ в составе группы лиц.");
        r_pH32.addBreak();
        r_pH32.addBreak();

        XWPFParagraph parH4 = document.createParagraph();
        parH4.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH4 = parH4.createRun();
        r_pH4.setFontSize(14);
        r_pH4.setItalic(true);
        r_pH4.setText(" Для нарушителя с потенциалом H3 характерно:");
        r_pH4.addBreak();

        XWPFParagraph parH42 = document.createParagraph();
        parH42.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_pH42 = parH42.createRun();
        r_pH42.setFontSize(12);
        r_pH42.setText("       •Обладание возможностями нарушителей с Н4 потенциалом;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        r_pH42.setText("       •Обладание возможностью получения доступа к исходному коду встраиваемого ПО;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        r_pH42.setText("       •Обладание возможностью внедрения программных закладок или уязвимостей " +
                "на различных этапах постановки ПО или программно-аппаратных средств;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        r_pH42.setText("       •Обладание возможностью создания методов и средств реализации угроз, с " +
                "привлечением специалистов, имеющих разные степени возможности;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        r_pH42.setText("       •Обладание возможностью реализовывать угрозы на протяжении долговременного " +
                "периода без обнаружения его операторами систем и сетей;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        r_pH42.setText("       •Имеет исключительные теоретические и практические знания о функционировании системы и сетей;");
        r_pH42.addBreak();
        r_pH42.addBreak();
        numeration++;
    }

    void doSKZI(XWPFDocument document, int numeration)
    {
        XWPFParagraph skzi1 = document.createParagraph();
        skzi1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_s1 = skzi1.createRun();
        r_s1.setFontSize(16);
        r_s1.setBold(true);
        r_s1.setText(numeration + ") Классификация нарушителя при использовании СКЗИ.");

        XWPFParagraph sk = document.createParagraph();
        sk.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun sk1 = sk.createRun();
        sk1.setFontSize(12);
        sk1.setText("(Согласно приказу ФСБ № 149/7/2/6-432)");
        sk1.addBreak();
        sk1.addBreak();

        XWPFParagraph skzi2 = document.createParagraph();
        skzi2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_s2 = skzi2.createRun();
        r_s2.setFontSize(14);
        r_s2.setItalic(true);
        r_s2.setText("По типу прав нарушители делятся на:");
        r_s2.addBreak();

        XWPFParagraph skzi3 = document.createParagraph();
        skzi3.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_s3 = skzi3.createRun();
        r_s3.setFontSize(12);
        r_s3.setText("      - Привилегированных пользователей, к которым относятся:");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             a) Пользователи с правами доступа;");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             б) Члены группы администраторов;");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             в) Члены персонала, обслуживающие составляющие ИС;");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("      - Непривилегированных пользователей, к которым относятся:");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             a) Пользователи без прав доступа;");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             б) Внешне физ. лицо;");
        r_s3.addBreak();
        r_s3.addBreak();
        r_s3.setText("             в) Внешние группы лиц;");
        r_s3.addBreak();
        r_s3.addBreak();

        XWPFParagraph skzi4 = document.createParagraph();
        skzi4.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_s4 = skzi4.createRun();
        r_s4.setFontSize(14);
        r_s4.setItalic(true);
        r_s4.setText("По возможностям нарушителей подразделяем на:");
        r_s4.addBreak();

        XWPFParagraph skzi5 = document.createParagraph();
        skzi5.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_s5 = skzi5.createRun();
        r_s5.setFontSize(12);
        r_s5.setText("  •K1 - Возможность самостоятельной подготовки в лице создания и проведения способов атак за пределами КЗ;");
        r_s5.addBreak();
        r_s5.addBreak();
        r_s5.setText("  •K2 - Возможность самостоятельной подготовки в лице создания и проведения способов атак в пределах КЗ," +
                " но без физического доступа к аппаратной составляющей, на которых реализованы СКЗИ;");
        r_s5.addBreak();
        r_s5.addBreak();
        r_s5.setText("  •K3 - Возможность самостоятельной подготовки в лице создания и проведения способов атак в пределах КЗ, " +
                "а также с физическим доступом к аппаратной составляющей, на которых реализованы СКЗИ;");
        r_s5.addBreak();
        r_s5.addBreak();
        r_s5.setText("  •K4 - Возможности привлечения специалистов, имеющих опыт разработки и анализа СКЗИ, специализирующихся на сигналах;");
        r_s5.addBreak();
        r_s5.addBreak();
        r_s5.setText("  •K5 - Возможности привлечения специалистов, имеющих опыт разработки и анализа СКЗИ, специализирующихся на НДВ прикладного ПО;");
        r_s5.addBreak();
        r_s5.addBreak();
        r_s5.setText("  •K6 - Возможности привлечения специалистов, имеющих опыт разработки и анализа СКЗИ, специализирующихся" +
                " на НДВ аппаратных и программных компонентов среды функционирования СКЗИ.");
        r_s5.addBreak();
        r_s5.addBreak();
        numeration++;
    }

    void doTable1(XWPFDocument document, int main_mas[], int vid_mas[], int type_mas[], int numeration)
    {
        XWPFParagraph parTable1 = document.createParagraph();
        parTable1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_parTable1  = parTable1.createRun();
        r_parTable1.setFontSize(16);
        r_parTable1.setBold(true);
        r_parTable1.setText(numeration + ") Виды нарушителя для конкретной организации.");
        r_parTable1.addBreak();


        XWPFTable table1 = document.createTable();
        XWPFTableRow tableRowOne = table1.getRow(0);
        tableRowOne.getCell(0).setText("Вид нарушителя");
        tableRowOne.getCell(0).setColor("001000");
        tableRowOne.addNewTableCell().setText("Тип нарушителя");
        tableRowOne.getCell(1).setColor("001000");
        tableRowOne.addNewTableCell().setText("Максимальный потенциал нарушителя");
        tableRowOne.getCell(2).setColor("001000");
        if(main_mas[2] == 1)
        {
            tableRowOne.addNewTableCell().setText("Привилегированность нарушителя при использовании в ИС СКЗИ");
            tableRowOne.getCell(3).setColor("001000");
            tableRowOne.addNewTableCell().setText("Возможности нарушителя при использовании в ИС СКЗИ");
            tableRowOne.getCell(4).setColor("001000");
        }


        if(vid_mas[0] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("Специальные службы иностранных государств");
            if(type_mas[0] == 1 && type_mas[1] == 1)
                tR1.getCell(1).setText("Внутренний и внешний");
            if(type_mas[0] == 0 && type_mas[1] == 1)
                tR1.getCell(1).setText("Внутренний");
            if(type_mas[0] == 1 && type_mas[1] == 0)
                tR1.getCell(1).setText("Внешний");
            tR1.getCell(2).setText("H4");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Непривилегированный и Привилегированный");
                if(type_mas[0] == 1 && type_mas[1] == 1)
                    tR1.getCell(4).setText("K2 К3 К6");

                if(type_mas[0] == 0 && type_mas[1] == 1)
                    tR1.getCell(4).setText("К3 К6");

                if(type_mas[0] == 1 && type_mas[1] == 0)
                    tR1.getCell(4).setText("K2 К6");
            }
        }

        if(vid_mas[1] == 1)
        {
            XWPFTableRow tR2 = table1.createRow();
            tR2.getCell(0).setText("Террористические и экстремистские группировки");
            if(type_mas[0] == 1 && type_mas[1] == 1)
                tR2.getCell(1).setText("Внутренний и внешний");
            if(type_mas[0] == 0 && type_mas[1] == 1)
                tR2.getCell(1).setText("Внутренний");
            if(type_mas[0] == 1 && type_mas[1] == 0)
                tR2.getCell(1).setText("Внешний");


            tR2.getCell(2).setText("H3");
            if(main_mas[2] == 1)
            {
                tR2.getCell(3).setText("Непривилегированный");
                if(type_mas[0] == 1 && type_mas[1] == 1)
                    tR2.getCell(4).setText("K2 К3 К5");

                if(type_mas[0] == 0 && type_mas[1] == 1)
                    tR2.getCell(4).setText("К3 К5");

                if(type_mas[0] == 1 && type_mas[1] == 0)
                    tR2.getCell(4).setText("K2 К5");
            }
        }

        if(vid_mas[2] == 1)
        {
            XWPFTableRow tR3 = table1.createRow();
            tR3.getCell(0).setText("Преступные группы");
            if(type_mas[0] == 1)
                tR3.getCell(1).setText("Внешний");
            else
                tR3.getCell(1).setText("Внутренний");
            tR3.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR3.getCell(3).setText("Непривилегированный");
                tR3.getCell(4).setText("K1 К4");
            }
        }

        if(vid_mas[3] == 1 && type_mas[0] == 1)
        {
            XWPFTableRow tR4 = table1.createRow();
            tR4.getCell(0).setText("Внешние субъекты (физ. лица)");
            tR4.getCell(1).setText("Внешний");
            tR4.getCell(2).setText("H1");
            if(main_mas[2] == 1)
            {
                tR4.getCell(3).setText("Непривилегированный");
                tR4.getCell(4).setText("K1");
            }
        }

        if(vid_mas[4] == 1)
        {
            XWPFTableRow tR5 = table1.createRow();
            tR5.getCell(0).setText("Конкурирующие организации");
            if(type_mas[0] == 1)
                tR5.getCell(1).setText("Внешний");
            else
                tR5.getCell(1).setText("Внутренний");
            tR5.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR5.getCell(3).setText("Непривилегированный");
                tR5.getCell(4).setText("K1 K5");
            }
        }

        if(vid_mas[5] == 1 && type_mas[0] == 1)
        {
            XWPFTableRow tR6 = table1.createRow();
            tR6.getCell(0).setText("Разработчики, производители и поставщики ПО и АО");
            tR6.getCell(1).setText("Внешний");
            tR6.getCell(2).setText("H4");
            if(main_mas[2] == 1)
            {
                tR6.getCell(3).setText("Непривилегированный");
                tR6.getCell(4).setText("K1 К3 K6");
            }
        }

        if(vid_mas[6] == 1 && type_mas[1] == 1)
        {
            XWPFTableRow tR7 = table1.createRow();
            tR7.getCell(0).setText("Лица, привлекаемые для установочных работ");
            tR7.getCell(1).setText("Внутренний");
            tR7.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR7.getCell(3).setText("Привилегированный");
                tR7.getCell(4).setText("K1 К3");
            }
        }

        if(vid_mas[7] == 1 && type_mas[1] == 1)
        {
            XWPFTableRow tR8 = table1.createRow();
            tR8.getCell(0).setText("Лица, обеспечивающие функционирование системы");
            tR8.getCell(1).setText("Внутренний");
            tR8.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR8.getCell(3).setText("Привилегированный");
                tR8.getCell(4).setText("K1 К3");
            }
        }

        if(vid_mas[8] == 1 && type_mas[1] == 1)
        {
            XWPFTableRow tR9 = table1.createRow();
            tR9.getCell(0).setText("Пользователи ИС");
            tR9.getCell(1).setText("Внутренний");
            tR9.getCell(2).setText("H1");
            if(main_mas[2] == 1)
            {
                tR9.getCell(3).setText("Привилегированный");
                tR9.getCell(4).setText("К3");
            }
        }

        if(vid_mas[9] == 1 && type_mas[1] == 1)
        {
            XWPFTableRow tR10 = table1.createRow();
            tR10.getCell(0).setText("Администраторы ИБ и ИС");
            tR10.getCell(1).setText("Внутренний");
            tR10.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR10.getCell(3).setText("Привилегированный");
                tR10.getCell(4).setText("K1 К2 К3");
            }
        }

        if(vid_mas[10] == 1 && type_mas[0] == 1)
        {
            XWPFTableRow tR11 = table1.createRow();
            tR11.getCell(0).setText("Бывшие работники");
            tR11.getCell(1).setText("Внешний");
            tR11.getCell(2).setText("H1");
            if(main_mas[2] == 1)
            {
                tR11.getCell(3).setText("Непривилегированный");
                tR11.getCell(4).setText("K1");
            }
        }
        XWPFParagraph paragraph_help = document.createParagraph();
        XWPFRun r_p_h = paragraph_help.createRun();
        r_p_h.addBreak();
        r_p_h.addBreak();
        numeration++;
    }

    void doKanals(XWPFDocument document, int numeration)
    {
        int kan_mas[] = new int[6];

        try(FileReader fileReader = new FileReader("Kan.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                kan_mas[0] = 1;
            else
                kan_mas[0] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                kan_mas[1] = 1;
            else
                kan_mas[1] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                kan_mas[2] = 1;
            else
                kan_mas[2] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                kan_mas[3] = 1;
            else
                kan_mas[3] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                kan_mas[4] = 1;
            else
                kan_mas[4] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                kan_mas[5] = 1;
            else
                kan_mas[5] = 0;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XWPFParagraph canals1 = document.createParagraph();
        canals1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_c1 = canals1.createRun();
        r_c1.setFontSize(16);
        r_c1.setBold(true);
        r_c1.setText(numeration + ") Действующие возможные каналы перехвата нарушителем информации.");
        r_c1.addBreak();
        r_c1.addBreak();

        XWPFParagraph canals2 = document.createParagraph();
        canals2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_c2 = canals2.createRun();
        r_c2.setFontSize(14);
        r_c2.setText("      Для данной ИС характерны следующие каналы утечки информации:");
        r_c2.addBreak();
        r_c2.addBreak();
        r_c2.setText("      Технические каналы утечки информации:");
        r_c2.addBreak();
        r_c2.addBreak();
        if(kan_mas[0] == 1)
        {
            r_c2.setText("          - Электрический канал утечки информации;");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        if(kan_mas[1] == 1)
        {
            r_c2.setText("          - Электромагнитный канал утечки информации;");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        if(kan_mas[2] == 1)
        {
            r_c2.setText("          - Виброакустический канал утечки информации;");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        if(kan_mas[3] == 1)
        {
            r_c2.setText("          - Оптический канал утечки информации;");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        if(kan_mas[4] == 1)
        {
            r_c2.setText("          - Комбинированный канал утечки информации;");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        if(kan_mas[5] == 1)
        {
            r_c2.setText("      Материально-вещественный канал утечки информации.");
            r_c2.addBreak();
            r_c2.addBreak();
        }
        r_c2.addBreak();
        r_c2.addBreak();
        numeration++;
    }

    void doTableIspdn(XWPFDocument document, int type_mas[], int main_mas[], int numeration)
    {
        int ispn_mas[] = new int[8];

        try(FileReader fileReader = new FileReader("PDN.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                ispn_mas[0] = 1;
            else
                ispn_mas[0] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[1] = 1;
            else
                ispn_mas[1] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[2] = 1;
            else
                ispn_mas[2] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[3] = 1;
            else
                ispn_mas[3] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[4] = 1;
            else
                ispn_mas[4] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[5] = 1;
            else
                ispn_mas[5] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[6] = 1;
            else
                ispn_mas[6] = 0;

            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                ispn_mas[7] = 1;
            else
                ispn_mas[7] = 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XWPFParagraph parTable1 = document.createParagraph();
        parTable1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_parTable1  = parTable1.createRun();
        r_parTable1.setFontSize(16);
        r_parTable1.setBold(true);
        r_parTable1.setText(numeration + ") Классификация нарушителя в ИСПДн для конкретной организации.");
        r_parTable1.addBreak();

        XWPFTable table1 = document.createTable();
        XWPFTableRow tableRowOne = table1.getRow(0);
        tableRowOne.getCell(0).setText("Группа нарушителя в ИСПДн");
        tableRowOne.getCell(0).setColor("001000");
        tableRowOne.addNewTableCell().setText("Тип нарушителя");
        tableRowOne.getCell(1).setColor("001000");
        tableRowOne.addNewTableCell().setText("Потенциал нарушителя");
        tableRowOne.getCell(2).setColor("001000");
        if(main_mas[2] == 1)
        {
            tableRowOne.addNewTableCell().setText("Привилегированность нарушителя при использовании в ИС СКЗИ");
            tableRowOne.getCell(3).setColor("001000");
            tableRowOne.addNewTableCell().setText("Возможности нарушителя при использовании в ИС СКЗИ");
            tableRowOne.getCell(4).setColor("001000");
        }

        if(ispn_mas[0] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("1 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H1");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Непривилегированный");
                tR1.getCell(4).setText("K2");
            }
        }

        if(ispn_mas[1] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("2 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K3");
            }
        }

        if(ispn_mas[2] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("3 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H2");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K3");
            }
        }

        if(ispn_mas[3] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("4 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H3");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K3 K4");
            }
        }

        if(ispn_mas[4] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("5 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H3");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K3 K4");
            }
        }

        if(ispn_mas[5] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("6 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H4");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K3 K5");
            }
        }

        if(ispn_mas[6] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("7 группа");
            tR1.getCell(1).setText("Внешний");
            tR1.getCell(2).setText("H4");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K2 K6");
            }
        }

        if(ispn_mas[7] == 1)
        {
            XWPFTableRow tR1 = table1.createRow();
            tR1.getCell(0).setText("8 группа");
            tR1.getCell(1).setText("Внутренний");
            tR1.getCell(2).setText("H4");
            if(main_mas[2] == 1)
            {
                tR1.getCell(3).setText("Привилегированный");
                tR1.getCell(4).setText("K1 K3 K6");
            }
        }

        XWPFParagraph paragraph_help = document.createParagraph();
        XWPFRun r_p_h = paragraph_help.createRun();
        r_p_h.addBreak();
        r_p_h.addBreak();
        numeration++;
    }

    void doAS(XWPFDocument document, int numeration)
    {
        XWPFParagraph type0 = document.createParagraph();
        type0.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t0 = type0.createRun();
        r_t0.setFontSize(16);
        r_t0.setBold(true);
        r_t0.setText(numeration + ") Уровень нарушителя в АС.");
        r_t0.addBreak();
        XWPFParagraph type1 = document.createParagraph();
        type1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t1 = type1.createRun();
        r_t1.setFontSize(12);
        r_t1.setBold(false);
        r_t1.setText("      В данной ИС была проведена классификация нарушителей в АС. Были выделены следующие возможные уровни нарушителя::");
        r_t1.addBreak();
        r_t1.addBreak();
        try(FileReader fileReader = new FileReader("AS.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      - Первый уровень (Запуск задач из фиксированного набора)");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      - Второй уровень (Создание и запуск собственных программ)");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      - Третий уровень (Управление функционированием АС)");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      - Четвертый уровень (Весь объем возможностей)");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            r_t1.addBreak();
            r_t1.addBreak();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        numeration++;
    }

    void doTable2(XWPFDocument document, int main_mas[], int type_mas[], int numeration)
    {
        int act_obj[] = new int[20];

        try(FileReader fileReader = new FileReader("ActObj.txt"))
        {
            int c = 0;
            c = fileReader.read();
            if(c == 49)
                act_obj[0] = 1;
            else
                act_obj[0] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[1] = 1;
            else
                act_obj[1] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[2] = 1;
            else
                act_obj[2] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[3] = 1;
            else
                act_obj[3] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[4] = 1;
            else
                act_obj[4] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[5] = 1;
            else
                act_obj[5] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[6] = 1;
            else
                act_obj[6] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[7] = 1;
            else
                act_obj[7] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[8] = 1;
            else
                act_obj[8] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[9] = 1;
            else
                act_obj[9] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[10] = 1;
            else
                act_obj[10] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[11] = 1;
            else
                act_obj[11] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[12] = 1;
            else
                act_obj[12] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[13] = 1;
            else
                act_obj[13] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[14] = 1;
            else
                act_obj[14] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[15] = 1;
            else
                act_obj[15] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[16] = 1;
            else
                act_obj[16] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[17] = 1;
            else
                act_obj[17] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[18] = 1;
            else
                act_obj[18] = 0;
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
                act_obj[19] = 1;
            else
                act_obj[19] = 0;
            c = fileReader.read();
            c = fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Объекты");
        for(int i = 0; i < 20; i++)
            System.out.println(act_obj[i]);

        XWPFParagraph parTable2 = document.createParagraph();
        parTable2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_parTable2  = parTable2.createRun();
        r_parTable2.setFontSize(16);
        r_parTable2.setBold(true);
        r_parTable2.setText(numeration + ") Таблица \"объект - возможности воздействия на него\".");
        r_parTable2.addBreak();
        r_parTable2.setText("(построена на основании ответов и БДУ");

        XWPFTable table2 = document.createTable();
        XWPFTableRow tableRowOne = table2.getRow(0);
        tableRowOne.getCell(0).setText("Объект воздействия нарушителя");
        tableRowOne.getCell(0).setColor("001000");
        tableRowOne.addNewTableCell().setText("Тип нарушителя");
        tableRowOne.getCell(1).setColor("001000");
        tableRowOne.addNewTableCell().setText("Потенциал нарушителя");
        tableRowOne.getCell(2).setColor("001000");
        tableRowOne.addNewTableCell().setText("Возможности нарушителя");
        tableRowOne.getCell(3).setColor("001000");

        //грид система
        if(act_obj[0] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Грид-система");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("grid.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {//1
                    XWPFTableRow r1 = table2.createRow();
                    r1.getCell(0).setText("Ресурсные центры грид-системы");
                    r1.getCell(1).setText("Внешний и Внутренний");
                    r1.getCell(2).setText("H3");
                    r1.getCell(3).setText("Возможность внедрения и запуска вредоносного кода от имени доверенного процесса на любом из ресурсных центров грид-системы и его автоматического распространения на все узлы грид-системы");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//2
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой трафик");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность раскрытия нарушителем защищаемой информации путём выявления задействованных в её обработке узлов, сбора, анализа и обобщения данных, перехватываемых в сети передачи данных грид-системы");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//3
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Грид система и сетевой трафик");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность значительного снижения производительности грид-системы, вплоть до временного нарушения её работоспособности при появлении нетипичной сетевой нагрузки");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//4
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Узлы грид-системы");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность выполнения нарушителем сетевого входа на узел грид-системы с правами одной из учётных записей");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//5
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Ресурсные центры грид-системы");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность снижения пропускной способность ресурсных центров при отправке большого количества заданий одним пользователем (нарушителем) случайно или намеренно");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//6
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Ресурсные центры грид-системы, узлы грид-системы, грид-система, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность автоматического распространения на всю грид-систему несанкционировано полученных нарушителем на одном узле привилегий");

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //гипервизор(ы)
        if(act_obj[1] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Гипервизор");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("giper.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Информационная система, сетевой узел, носитель информации, объекты файловой системы, учётные данные пользователя, образ виртуальной машины");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность запуска вредоносной программой собственного гипервизора, функционирующего по уровню логического взаимодействия ниже компрометируемого гипервизора");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Гипервизор");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность приведения нарушителем всей или части виртуальной инфраструктуры в состояние «отказ в обслуживании»");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, гипервизор");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность дискредитации нарушителем функционирующих на базе гипервизора защитных механизмов предотвращающих НСД к образам виртуальных машин, из-за ошибок его обновления");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, гипервизор, консоль управления гипервизором");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления нарушителем несанкционированного доступа к информационным, программным и вычислительным ресурсам, зарезервированным и управляемым гипервизором");

                }
                c = fileReader.read();
                c = fileReader.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //BIOS/UEFI
        if(act_obj[2] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("BIOS/UEFI");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("BIOS.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {//1
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность осуществления вынужденного перехода на использование BIOS/UEFI содержащей уязвимости");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//2
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность неправомерного использования декларированного функционала BIOS/UEFI для нарушения целостности информации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//3
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность подмены нарушителем загружаемой операционной системы путём несанкционированного переконфигурирования в BIOS/UEFI пути доступа к загрузчику операционной системы");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//4
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное и аппаратное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H4");
                    r2.getCell(3).setText("Возможность изменения нарушителем режимов работы аппаратных элементов компьютера путём несанкционированного переконфигурирования BIOS/UEFI");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//5
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное и аппаратное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность установки уязвимой версии обновления BIOS/UEFI или версии, содержащей вредоносное программное обеспечение, но имеющей цифровую подпись");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//6
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное и аппаратное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность изменения параметров и (или) логики работы программного обеспечения BIOS/UEFI путём программного воздействия из операционной системы компьютера");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Суперкомпьютер
        if(act_obj[3] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Суперкомпьютер");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("SuperComp.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Вычислительные узлы суперкомпьютера");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность возникновения ситуации типа «отказ в обслуживании» со стороны вычислительного поля суперкомпьютера");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Вычислительные узлы суперкомпьютера, каналы передачи данных суперкомпьютера, системное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления процессом нарушителя, функционирующем в вычислительном поле суперком. считывания защищаемых данных из оперативной памяти, выделенной для параллельного процесса");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Система хранения данных суперкомпьютера");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность значительного замедления работы терминальных сессий всех пользователей суперкомпьютера вплоть до достижения всем суперкомпьютером состояния «отказ в обслуживании»");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Вычислительные узлы суперкомпьютера");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность существенного снижения производительности вычислительного поля суперкомпьютера и эффект. выполнения на нём текущих параллельных вычислений из-за потребления ресурсов «паразитными» процессами");

                }
                c = fileReader.read();
                c = fileReader.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //облачные сервера
        if(act_obj[4] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Облачные сервера");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Cloud.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {//1
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Облачная система, облачный сервер");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность создания ситуации прекращения оказания облачных услуг всем потребителям из-за нарушения доступности для них облачной инфраструктуры");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//2
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Облачная система");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность отказа в трансграничной передаче защищаемой информации в рамках оказания облачных услуг в соответствии с требованиями локального законодательства стран");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//3
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Облачная система");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность нарушения  защищённости информации потребителей облачных услуг внутренними нарушителями поставщика облачных услуг");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//4
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Объекты файловой системы, аппаратное обеспечение, облачный сервер");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления несанкционированного доступа к защищаемой информации одного потребителя облачных услуг со стороны другого");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//5
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Облачная инфраструктура, созданная с использованием технологий виртуализации");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность распространения негативных последствий от реализации угроз на физическом или виртуальном уровне облачной инфраструктуры на уровни управления и оркестровки");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//6
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Информационная система, иммигрированная в облако, системное программное обеспечение, прикладное программное обеспечение, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность допуска ошибок в управлении инфраструктурой системы потребителя облачных услуг со стороны поставщика облачных услуг из-за отсутствия у него сведений о системе");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //носители инфомрации
        if(act_obj[5] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Носители информации");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("NositInfo.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Машинный носитель информации");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность осуществления прямого доступа (доступа с уровней архитектуры более низких по отношению к уровню операционной системы) к данным, хранящимся на машинном носителе информации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Носитель информации");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность утраты хранящейся на форматируемом носителе информации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сервер, рабочая станция, носитель информации, аппаратное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность осуществления внешним нарушителем кражи компьютера, USB-накопителей, оптических дисков или других средств хранения, обработки, ввода/вывода/передачи информации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Носитель информации, объекты файловой системы");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность нарушения конфиденциальности информации, содержащейся в распределённых файлах, путем восстановления данных распределённых файлов из их множества отдельных фрагментов");

                }
                c = fileReader.read();
                c = fileReader.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Мобильные устройства
        if(act_obj[6] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Мобильные устройства");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Mobile.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Мобильные устройства");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H4");
                    r2.getCell(3).setText("Возможность снятия нарушителем предустановленных производителем ограничений на конфигурирование привилегированных функций мобильного устройства");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Мобильное устройство (аппаратное устройство)");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H4");
                    r2.getCell(3).setText("Возможность использования вредоносной программы для контроля списка приложений, запущенных на мобильном устройстве");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Мобильные устройства (аппаратное устройство, программное обеспечение)");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность установки приложений на виртуальные машины мобильных устройств, работающих под операционной системы Android, несанкционировано запущенных внедренной вредоносным ПО");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Мобильные устройства");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления нарушителем сбора и анализа информации, обрабатываемой с помощью мобильного устройства за счёт использования специального программного обеспечения");

                }
                c = fileReader.read();
                c = fileReader.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //аутентификация
        if(act_obj[7] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Аутентификация");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Autent.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, микропрограммное обеспечение, учётные данные пользователя");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность доступа к данным пользователя в результате подбора аутентификационной информации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, сетевое программное обеспечение, метаданные, учётные данные пользователя");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность подмены субъекта виртуального информационного взаимодействия, а также в возможности возникновения состояния неспособности осуществления такого взаимодействия");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность получения нарушителем привилегий в системе без прохождения процедуры аутентификации засчет выполнения действий, нарушающих условия корректной работы средств аутентификации");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //фрейм и код
        if(act_obj[8] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Фреймворки и код");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("FreCode.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, прикладное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность повышения нарушителем привилегий в системах, использующих цифровую подпись кода в качестве связующей информации между программой и её привилегиями");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность нарушителя получить права на доступ к защищаемой информации путём перехвата исключений/сигналов, сгенерированных участком программного кода");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Прикладное программное обеспечение, сетевое программное обеспечение, системное программное обеспечение");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления нарушителем внедрения в систему вредоносного программного обеспечения за счёт загрузки и установки вредоносного программного обеспечения");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //данные пользователя
        if(act_obj[9] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Данные пользователя");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("PolzInfo.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, объекты файловой системы, прикладное программное обеспечение, системное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность осуществления нарушителем несанкционированного доступа к защищаемой информации в обход штатных механизмов с помощью нестандартных интерфейсов");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Данные пользователя (программное обеспечение)");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность утечки пользовательских данных за счет использования реализованной в браузерах функции автоматического заполнение форм авторизации");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Программное обеспечение, каналы связи (передачи) данных");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность действия нарушителя в связи с пропуском и/или значительной временной задержке определения (выявления) событий безопасности информации");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //запросы
        if(act_obj[10] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Запросы");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Zapros.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность передачи нарушителем дискредитируемому браузеру запроса на доступ к файловой системе пользователя вместо URL-запроса");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, сетевое программное обеспечение, сетевой трафик, прикладное программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность раскрытия нарушителем защищаемых сведений о состоянии защищённости путём проведения мероприятий по сбору и анализу доступной информации о системе");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Cookie
        if(act_obj[11] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Cookie - файлы");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Cookie.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Прикладное программное обеспечение, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность осуществления нарушителем несанкционированного доступа к защищаемой информации (учётным записям пользователей, сертификатам и т.п.), содержащейся в cookies-файлах");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Информация, хранящаяся на компьютере во временных файлах (программное обеспечение)");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность хищения с использованием вредоносной программы аутентификационной информации пользователей, их счетов, хранящейся во временных файлах cookie");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //XML-система
        if(act_obj[12] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("XML - система");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("XML.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, сетевое программное обеспечение, сетевой трафик");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность изменения нарушителем алгоритма обработки информации приложениями функционирующими на основе XML-схем, вплоть до приведения приложения в состояние \"отказ в обслуживании\" путём изменения XML-схемы, передаваемой между клиентом и сервером");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //Отчеты об ошибках
        if(act_obj[13] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Отчеты об ошибках");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Otcheti.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, прикладное программное обеспечение, сетевое программное обеспечение, микропрограммное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность исследования нарушителем алгоритма работы дискредитируемого приложения и его предполагаемой структуры путём анализа генерируемых этим приложением отчётов об ошибках");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, сетевое программное обеспечение, сетевой трафик, прикладное программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность раскрытия нарушителем защищаемых сведений о состоянии защищённости дискредитируемой системы, путём проведения мероприятий по сбору и анализу доступной информации о системе");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //хранилище данных
        if(act_obj[14] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Хранилище данных");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Xranilishe.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Хранилище больших данных, метаданные, защищаемые данные");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность воздействия нарушителя в связи со сложностью контроля за всеми автоматически создаваемыми копиями информации в хранилище больших данных из-за временной несогласованности данных операций");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Интернет
        if(act_obj[15] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Компоненты работы с Интернетом");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Internet.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Информационная система, аппаратное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H4");
                    r2.getCell(3).setText("Возможность получения нарушителем привилегий управления системой путём использования удалённого внеполосного (по независимому вспомогательному каналу TCP/IP) доступа");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевой узел, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность получения нарушителем доступа к защищаемой информации, выполнения привилегированных операций или осуществления иных деструктивных воздействий на некорректно защищённые компоненты");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H3");
                    r2.getCell(3).setText("Возможность осуществления нарушителем внедрения вредоносного кода в компьютер пользователя при посещении зараженных сайтов");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //резервирование
        if(act_obj[16] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Резервирование");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Rezerv.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, аппаратное обеспечение, канал связи");
                    r2.getCell(1).setText(" - ");
                    r2.getCell(2).setText(" - ");
                    r2.getCell(3).setText("Возможность снижения качества облачных услуг из-за возникновения технических сбоев хотя бы у одного из поставщиков облачных услуг, а также из-за возникновения существенных задержек или потерь в каналах передачи данных, арендуемых потребителем или поставщиками облачных услуг");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Сайт
        if(act_obj[17] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Сайт");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Sait.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность неправомерного осуществления нарушителем массовой рассылки коммерческих, политических мошеннических и иных сообщений на веб-сервер без запроса со стороны дискредитируемых веб-серверов");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Рабочая станция, сетевое программное обеспечение, сетевой трафик");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность неправомерного ознакомления нарушителем с защищаемой информацией пользователя путем скрытного перенаправления пользователя на поддельный сайт");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Рабочая станция, сетевое программное обеспечение, сетевой трафик");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность неправомерного ознакомления нарушителем с защищаемой информацией пользователя путём убеждения его с помощью методов социальной инженерии");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Фильтры
        if(act_obj[18] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Фильтры");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Filter.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, сетевое программное обеспечение, сетевой трафик");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность осуществления нарушителем несанкционированного доступа к передаваемой в системе защ. информации за счёт деструктивного воздействия на протоколы сетевого/локального обмена данными в ИС");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Прикладное программное обеспечение, сетевое программное обеспечение, сетевой трафик");
                    r2.getCell(1).setText("Внешний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность осуществления нарушителем несанкционированного доступа к защищаемым данным пользователей сети или проведения различных мошеннических действий путём скрытной подмены содержимого хранящихся");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Другие
        if(act_obj[19] == 1)
        {
            XWPFTableRow r0 = table2.createRow();
            r0.getCell(0).setText("Другие");
            r0.getCell(0).setColor("001000");
            r0.getCell(1).setColor("001000");
            r0.getCell(2).setColor("001000");
            r0.getCell(3).setColor("001000");

            try(FileReader fileReader = new FileReader("Other.txt"))
            {
                int c;
                c = fileReader.read();
                if(c == 49)
                {//1
                    XWPFTableRow r1 = table2.createRow();
                    r1.getCell(0).setText("Информационная система, виртуальная машина, сетевое программное обеспечение, сетевой трафик");
                    r1.getCell(1).setText("Внешний и Внутренний");
                    r1.getCell(2).setText("H3");
                    r1.getCell(3).setText("Возможность повышения нарушителем своих привилегий в дискредитированной системе путём использования ошибок в программах и выполнения произвольного кода с их привилегиями");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//2
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность размещения нарушителем в кеше приложения или службы некорректных данных таким образом, что до обновления кеша дискредитируемое приложение будет считать эти данные корректными");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//3
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность обеспечения нарушителем информационной изоляции системы безопасности путём прерывания канала связи с контрольными датчиками, следящими за параметрами состояния системы");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//4
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность внесения нарушителем изменений в журналы регистрации событий безопасности дискредитируемой системы для введения в заблуждение её администраторов или сокрытия следов реализации других угроз");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//5
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Системное программное обеспечение, прикладное программное обеспечение, сетевое программное обеспечение");
                    r2.getCell(1).setText("Внешний и Внутренний");
                    r2.getCell(2).setText("H1");
                    r2.getCell(3).setText("Возможность внедрения нарушителем в дискредитируемую систему вредоносного программного обеспечения путём обманного перенаправления запросов пользователя или его программ на собственный сетевой ресурс");

                }
                c = fileReader.read();
                c = fileReader.read();
                if(c == 49)
                {//6
                    XWPFTableRow r2 = table2.createRow();
                    r2.getCell(0).setText("Микропрограммное и аппаратное обеспечение BIOS/UEFI");
                    r2.getCell(1).setText("Внутренний");
                    r2.getCell(2).setText("H2");
                    r2.getCell(3).setText("Возможность изменения параметров и (или) логики работы программного обеспечения путём программного воздействия из операционной системы компьютера");

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(FileReader fileReader = new FileReader("DOP.txt"))
        {
            int add_count;
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            int c;
            c = fileReader.read();
            add_count = c - 48;
            c = fileReader.read();
            int count = 0;
            if(add_count != 0)
            {
                for(int i = 0; i < add_count; i++)
                {
                    XWPFTableRow row_add = table2.createRow();
                    while((c = fileReader.read()) != '+')
                    {
                        stringBuilder.append((char)c);
                        count++;
                    }
                    row_add.getCell(0).setText(stringBuilder.toString());
                    stringBuilder.delete(0, count);
                    count = 0;
                    while((c = fileReader.read()) != '+')
                    {
                        stringBuilder.append((char)c);
                        count++;
                    }
                    row_add.getCell(1).setText(stringBuilder.toString());
                    stringBuilder.delete(0, count);
                    count = 0;
                    while((c = fileReader.read()) != '+')
                    {
                        stringBuilder.append((char)c);
                        count++;
                    }
                    row_add.getCell(2).setText(stringBuilder.toString());
                    stringBuilder.delete(0, count);
                    count = 0;
                    while((c = fileReader.read()) != '\n')
                    {
                        stringBuilder.append((char)c);
                        count++;
                    }
                    row_add.getCell(3).setText(stringBuilder.toString());
                    stringBuilder.delete(0, count);
                    count = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XWPFParagraph parHelp = document.createParagraph();
        parHelp.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun parH = parHelp.createRun();
        parH.addBreak();
        parH.addBreak();
        numeration++;
    }

    void doScenar(XWPFDocument document, int numeration)
    {
        XWPFParagraph type0 = document.createParagraph();
        type0.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t0 = type0.createRun();
        r_t0.setFontSize(16);
        r_t0.setBold(true);
        r_t0.setText(numeration + ") Возможные сценарии атак.");
        r_t0.addBreak();

        XWPFParagraph type17 = document.createParagraph();
        type17.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t17 = type0.createRun();
        r_t17.setFontSize(10);
        r_t17.setText("(По методике моделирования угроз безопасности информации 2020 (проект))");
        r_t17.addBreak();

        XWPFParagraph type1 = document.createParagraph();
        type1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_t1 = type0.createRun();
        r_t1.setFontSize(12);
        r_t1.setText("Для данной организации были выбраны следующие возможные сценарии атак:");
        r_t1.addBreak();
        r_t1.addBreak();
        try(FileReader fileReader = new FileReader("ScenarT.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T1 - Сбор информации о системах и сетях;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T2 - Получение первоначального доступа к компонентам систем и сетей;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T3 - Внедрение и исполнение вредоносного программного обеспечения в системах и сетях;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T4 - Закрепление (сохранение доступа) в системе или сети;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T5 - Управление вредоносным программным обеспечением и (или) компонентами, к которым ранее был получен доступ;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T6 - Повышение привилегий по доступу компонентам систем и сетей;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T7 - Сокрытие действий и применяемых при этом средств от обнаружения;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T8 - Получение доступа (распространение доступа) к другим компонентам систем и сетей или смежным системам и сетям;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T9 - Сбор и вывод из системы или сети информации, необходимой для дальнейших действий при реализации угроз БИ или реализации новых угроз;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
            c = fileReader.read();
            c = fileReader.read();
            if(c == 49)
            {
                r_t1.setText("      * T10 - Неправомерный доступ и (или) воздействие на ИР или компоненты систем и сетей, приводящее к негативным последствиям;");
                r_t1.addBreak();
                r_t1.addBreak();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        r_t1.addBreak();
        r_t1.addBreak();
        numeration++;
    }

    void doVivod(XWPFDocument document, int main_mas[], int numeration)
    {
        int vidM[] = new int[11];
        int flag_vid = 0;
        try(FileReader fileReader = new FileReader("ActVid.txt"))
        {
            int c;
            c = fileReader.read();
            if(c == 49)
                vidM[0] = 1;
            else
                vidM[0] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[1] = 1;
            else
                vidM[1] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[2] = 1;
            else
                vidM[2] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[3] = 1;
            else
                vidM[3] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[4] = 1;
            else
                vidM[4] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[5] = 1;
            else
                vidM[5] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[6] = 1;
            else
                vidM[6] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[7] = 1;
            else
                vidM[7] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[8] = 1;
            else
                vidM[8] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[9] = 1;
            else
                vidM[9] = 0;
            c = fileReader.read();
            c = fileReader.read();

            if(c == 49)
                vidM[10] = 1;
            else
                vidM[10] = 0;

            for(int i = 0; i < 11; i++)
            {
                if(vidM[i] == 1)
                    flag_vid++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XWPFParagraph par = document.createParagraph();
        par.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_par = par.createRun();
        r_par.setBold(true);
        r_par.setFontSize(16);
        r_par.setText(numeration + ") Вывод.");
        r_par.addBreak();

        XWPFParagraph text_end = document.createParagraph();
        text_end.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r_text_end = text_end.createRun();
        r_text_end.setFontSize(12);
        r_text_end.setText("        Для данной организации построена модель нарушителя.");
        r_text_end.setText(" В ней присутствует " + flag_vid + " возможных видов нарушителей, самым опасным из которых является ");
        if(vidM[0] == 1)
            r_text_end.setText("\"спцеильные службы иностранных государств\".");
        else
        {
            if(vidM[5] == 1)
                r_text_end.setText("\"разработчики, производители и поставщики ПО и техники\".");
            else
            {
                if(vidM[9] == 1)
                    r_text_end.setText("\"администраторы ИС и ИБ\".");
                else
                {
                    if(vidM[1] == 1)
                        r_text_end.setText("\"террористические и экстремистские группировки\".");
                    else
                    {
                        if(vidM[6] == 1)
                            r_text_end.setText("\"лица, привлекаемые для установочных работ \".");
                        else
                        {
                            if(vidM[7] == 1)
                                r_text_end.setText("\"лица, обеспечивающие функционирование системы\".");
                            else
                            {
                                if(vidM[2] == 1)
                                    r_text_end.setText("\"преступные группировки\".");
                                else
                                {
                                    if(vidM[4] == 1)
                                        r_text_end.setText("\"конкурирующие организации\".");
                                    else
                                    {
                                        if(vidM[8] == 1)
                                            r_text_end.setText("\"пользователи ИС\".");
                                        else
                                        {
                                            if(vidM[10] == 1)
                                                r_text_end.setText("\"бывшие работники\".");
                                            else
                                                r_text_end.setText("\"физические лица(внешние субъекты)\".");
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        r_text_end.setText(" Каждому нарушителю был присвоен свой потенциал");
        if(main_mas[2] == 1)
        {
            r_text_end.setText(", а так же, так как в системе используются СКЗИ, свой класс СКЗИ и привилегированность для СКЗИ.");
        }
        else
            r_text_end.setText(".");
        r_text_end.setText(" Все ранее перечисленные критерии были систематизированы и представлены в виде таблицы. Так же были выделены каналы, по которым в данной организации могут происходить утечка информации.");
        if(main_mas[36] == 1)
            r_text_end.setText(" В организации присутствует ИСПДн, поэтому возможный нарушитель был характеризован и по группам для ИСПДн.");
        if(main_mas[32] == 1)
            r_text_end.setText(" Так же в организации присутствует АС, таким образом были выделены возможные уровни воздействия нарушителя.");
        r_text_end.setText(" В конце были так же приведены возможные актуальные объекты атаки нарушителей, а так же возможности, с помощью которых он может осуществить атаку.");
        r_text_end.setText(" Финальным критерием было выявление актуальных сценариев атак.");
    }
}
