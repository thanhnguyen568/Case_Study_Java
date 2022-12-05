package service;

import validate.CustomizeException;

import java.io.IOException;
import java.text.ParseException;

public interface Service {
    void display() throws IOException;
    void update() throws IOException;
    void delete() throws IOException, CustomizeException;
}
