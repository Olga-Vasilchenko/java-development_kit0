package org.example.Lesson2;

public class Frontender extends Developer implements FrontAction{
    @Override
    public void front() {
        System.out.println("Frontender working");
    }
}
