package com.example.ChatApplication.service;

public interface UserListService {
    void addUser(String username);
    void removeUser(String username);
    String getUserList();
}
