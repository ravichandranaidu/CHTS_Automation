package com.ch.tbc.utils.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.ch.tbc.bean.Databean;
import com.ch.tbc.bean.User;
import com.ch.tbc.utils.TBCConstants;

public class FileUtility implements TBCConstants
{
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
            if (records.length >= 10)
            {
                data.add(new User(records));
            }
            line = reader.readLine();
        }
        reader.close();
        
        return data;
    }
}