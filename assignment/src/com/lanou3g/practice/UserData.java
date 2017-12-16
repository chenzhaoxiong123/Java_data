package com.lanou3g.practice;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    public void register(User user) throws DocumentException, IOException {
//        UserData ud = new UserData();
        SAXReader reader = new SAXReader();
        Document read = reader.read(new File("src\\user.xml"));
        Element element = read.getRootElement();
//        Document document = DocumentHelper.createDocument();
        Element el = element.addElement("xx");
        Element ele = el.addElement("t");
        Element n = ele.addElement("name");
        n.addText(user.getName());
        Element un = ele.addElement("username");
        un.addText(user.getUserName());
        Element p = ele.addElement("pass");
        p.addText(user.getPassword());
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("utf-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/user.xml"),prettyPrint);
        xmlWriter.write(read);
        xmlWriter.close();
    }


    public static List<User> login() throws DocumentException, FileNotFoundException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new FileReader("src/user.xml"));
        Element element = read.getRootElement();
        List<Element> elements = element.elements("t");
        List<User> us = new ArrayList<>();
//        System.out.println("123");
        for (int i = 0; i < elements.size(); i++) {
            User user = new User();
            Element ele = elements.get(i);
            Element name = ele.element("name");
            String n = name.getText();
            user.setName(n);
            Element un = ele.element("username");
            String u = un.getText();
            user.setUserName(u);
//            System.out.println("1");
            Element pass = ele.element("pass");
            String p = pass.getText();
            user.setPassword(p);
//            System.out.println("2");

            us.add(user);
//            System.out.println(u);
        }
//        System.out.println(us.size());
        return us;
    }
}
