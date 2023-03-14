package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private static final String TO = "thassio.santos@dbccompany.com.br";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(TO);
        message.setSubject("E-mail Simples");
        message.setText("Teste \n minha mensagem \n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException, FileNotFoundException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(TO);
        helper.setSubject("E-mail com Anexo");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");

        File file1 = ResourceUtils.getFile("classpath:imagem.jpg");
        //File file1 = new File("imagem.jpg");
        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(PessoaEntity pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(TO);
            mimeMessageHelper.setSubject("E-mail Template");
            mimeMessageHelper.setText(getPessoaTemplate(pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }
    // tipoFuncao = GET , Post , put , delete
    public void sendEmailEndereco(PessoaEntity pessoa , EnderecoEntity endereco, String tipoFuncao) throws RegraDeNegocioException {
        String mensagem = null;
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");
            switch (tipoFuncao) {
                case "1" -> mensagem = "Endereço Criado";
                case "2" -> mensagem = "Endereço Editado";
                case "3" -> mensagem = "Endereço Excluido";
            }
            mimeMessageHelper.setText(getEnderecoTemplate(pessoa, endereco , mensagem), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Pessoal do sistema");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getPessoaTemplate(PessoaEntity pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Pessoal do sistema");
        dados.put("pessoa", pessoa);

        Template template = fmConfiguration.getTemplate("email-template-pessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getEnderecoTemplate(PessoaEntity pessoa, EnderecoEntity endereco, String mensagem) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("pessoa", pessoa);
        dados.put("endereco", endereco);
        dados.put("funcao", mensagem);

        Template template = fmConfiguration.getTemplate("email-template-pessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}