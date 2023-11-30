package org.example.Lesson2;
/*
Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код. Фронтендеры, которые могут программировать
экранные формы, и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
все его методы.
 */
abstract class Developer {
    public static void main(String[] args) {
        Developer dev = new Frontender();
        if (dev instanceof FrontAction) {
            ((FrontAction) dev).front();
        }
    }
}
