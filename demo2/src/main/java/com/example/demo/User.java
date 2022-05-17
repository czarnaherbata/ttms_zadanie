package com.example.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private final String surname;


}
