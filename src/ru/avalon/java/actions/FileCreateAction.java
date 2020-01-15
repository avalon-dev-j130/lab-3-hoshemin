package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCreateAction implements Action {
    private final Path createFile;
    

    public FileCreateAction(String createFile) {
        this.createFile = Paths.get(createFile);
        
    }
    
    private synchronized void create() throws IOException {

        if (Files.exists(createFile)) {
            System.out.println("Файл уже существует.");
        } else {
            Files.createFile(createFile);
            System.out.println("Создание завершено.");
        }
    }
    @Override
    public void run() {
        try {            
            create();  
        } catch (IOException e) {
            System.out.println("Создание не удалось: " + e.getMessage() + ".");   
        }
        System.out.println("Введите команду из списка: copy, move, create, delete или exit\nи следуйте подсказкам");
        System.out.print("> ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
