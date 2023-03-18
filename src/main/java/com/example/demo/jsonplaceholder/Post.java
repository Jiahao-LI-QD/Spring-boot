package com.example.demo.jsonplaceholder;

import lombok.Data;


public record Post(Integer userId, Integer id, String title, String body) {
}
