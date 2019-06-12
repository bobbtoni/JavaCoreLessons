package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<String>> directory;

    public PhoneBook() {
        this.directory = new HashMap<>();
    }

    public void add(String name, String number){
        if(this.directory.get(name)==null){
            this.directory.put(name, new HashSet<>());
        }
        this.directory.get(name).add(number);
    }

    public HashSet<String> get(String name){
        // клонируем, чтобы не отдать ссылку на наш массив
        HashSet<String> ret = this.directory.get(name);
        return ret == null ? null : (HashSet<String>)ret.clone();
    }
}
