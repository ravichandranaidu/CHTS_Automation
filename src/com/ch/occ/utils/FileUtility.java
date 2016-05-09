package com.ch.occ.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.ch.occ.bean.CheckoutBean;
import com.ch.occ.bean.Databean;
import com.ch.occ.bean.ImageTextBean;
import com.ch.occ.bean.User;
import com.ch.occ.constants.FileConstants;

public class FileUtility implements FileConstants
{
    public static String readContent(String file) throws Exception
    {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (null != line)
        {
            content.append(line);
            line = reader.readLine();
        }
        reader.close();

        return content.toString();
    }

    public static void writeHTMLContent(String file, String content) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }

    public static ArrayList<Databean> readAllLoginData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
        ArrayList<Databean> data = new ArrayList<Databean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new Databean(records[0], records[1]));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<User> readAllUserData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE));
        ArrayList<User> data = new ArrayList<User>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 4)
            {
                data.add(new User(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<CheckoutBean> readCheckoutData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_DATA));
        ArrayList<CheckoutBean> data = new ArrayList<CheckoutBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 15)
            {
                data.add(new CheckoutBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<ImageTextBean> readAllImages(String suiteName) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(IMAGE_DATA_FILE));
        ArrayList<ImageTextBean> data = new ArrayList<ImageTextBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 10)
            {
                if ("".equalsIgnoreCase(suiteName) || line.contains(suiteName))
                {
                    data.add(new ImageTextBean(line));
                }
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }
}