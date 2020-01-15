package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.io.InputStreamReader;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileCreateAction;
import ru.avalon.java.actions.FileDeleteAction;
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
    private String createFile;
    private String deleteFile;
    
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
        System.out.println("Введите команду из списка: copy, move, create, delete или exit\nи следуйте подсказкам");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                System.out.println("Копирование файла.");
                System.out.print("Введите к путь к файлу, его имя и расширение: > ");
                copyFrom = reader.readLine();
                System.out.print("Введите путь к папке для копирования: > ");
                copyTo = reader.readLine();
                FileCopyAction copy = new FileCopyAction(copyFrom, copyTo);
                copy.start();
                break;
            case move:
                System.out.println("Перемещение файла.");
                System.out.print("Введите к путь к файлу, его имя и расширение:: > ");
                copyFrom = reader.readLine();
                System.out.print("Введите путь к папке для перемещения: > ");
                copyTo = reader.readLine();
                FileMoveAction move = new FileMoveAction(copyFrom, copyTo);
                move.start();
                break;
            case create:
                System.out.println("Создание файла.");
                System.out.print("Введите к путь к файлу, его имя и расширение: > ");
                createFile = reader.readLine();
                FileCreateAction create = new FileCreateAction(createFile);
                create.start();
                break;
            case delete:
                System.out.println("Удаление файла.");
                System.out.print("Введите к путь к файлу, его имя и расширение: > ");
                deleteFile = reader.readLine();
                FileDeleteAction delete = new FileDeleteAction(deleteFile);
                delete.start();
                break;
            case exit:
                close();
                break;
            default: 
                System.out.println("Команды не существует, используйте copy, move, create, delete или exit");
                break;
        }
    }
    
}
