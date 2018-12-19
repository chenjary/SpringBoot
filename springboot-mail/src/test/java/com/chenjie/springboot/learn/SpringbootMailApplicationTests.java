package com.chenjie.springboot.learn;

import com.chenjie.springboot.learn.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {


    @Autowired
    private IMailService mailService;
    @Test
    public void sendSimpleEmail() {
        mailService.sendSimpleEmail("chenjie_task@163.com","test simple mail"," hello this is simple mail");
    }

    @Test
    public void sendTemplateMail() {
        String template = "mail/templateMail";
        Context context = new Context();

        context.setVariable("id", "006");

        mailService.sendTemplateMail("chenjie_task@163.com","模板邮件",template,context);
    }

    @Test
    public void sendHtmlMail() {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("chenjie_task@163.com","test simple mail",content);
    }

    @Test
    public void sendFileMail() {
        String filePath="E:\\拓尔思\\周报\\陈洁_拓尔思实习周报_6.docx";
        mailService.sendFileMail("chenjie_task@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\Job\\cloud.jpg";

        mailService.sendInlineResourceMail("chenjie_task@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
}

