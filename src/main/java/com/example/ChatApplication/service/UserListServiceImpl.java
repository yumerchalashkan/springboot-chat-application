package com.example.ChatApplication.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserListServiceImpl implements UserListService{

    private static List<String> names = new ArrayList<>();

    @Override
    public void addUser(String username) {
        names.add(username);
    }

    @Override
    public void removeUser(String username) {
        names.remove(username);
    }

    @Override
    public String getUserList() {
        String resultList = "";
        for (int i = 0; i < names.size();i++)
        {
            if (i != names.size() - 1) {
                resultList += names.get(i)+";;";
            } else {
                resultList += names.get(i);
            }
        }
        return resultList;
    }
}
