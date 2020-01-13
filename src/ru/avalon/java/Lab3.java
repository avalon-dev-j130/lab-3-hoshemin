package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.io.InputStreamReader;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    private String copyFrom;
    private String copyTo;
    
    public static void main(String[] args) {
        new Lab3().run();
        
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
        System.out.println("Введите команду из списка: copy, move или exit\nи следуйте подсказкам");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                System.out.println("Копирование файла.");
                System.out.print("Введите путь к файлу: > ");
                copyFrom = reader.readLine();
                System.out.print("Введите путь для копирования: > ");
                copyTo = reader.readLine();
                FileCopyAction copy = new FileCopyAction(copyFrom, copyTo);
                copy.start();
                break;
            case move:
                System.out.println("Перемещение файла.");
                System.out.print("Введите к путь к файлу: > ");
                copyFrom = reader.readLine();
                System.out.print("Введите путь для перемещения: > ");
                copyTo = reader.readLine();
                FileMoveAction move = new FileMoveAction(copyFrom, copyTo);
                move.start();
                break;
            case exit:
                close();
                break;
            default: 
                System.out.println("Команды не существует, используйте copy, move и exit");
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
