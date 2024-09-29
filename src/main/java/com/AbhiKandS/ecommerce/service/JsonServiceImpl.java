package com.AbhiKandS.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public class JsonServiceImpl implements JsonService{
    String json = "{}";

    @Override
    public String displayString() {
        return this.json;
    }

    @Override
    public String saveString(String json) {
        this.json = json;
        return "saved " + this.json;
    }
}
