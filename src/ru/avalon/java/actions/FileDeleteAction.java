package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileDeleteAction implements Action {
    private final Path deleteFile;
    

    public FileDeleteAction(String deleteFile) {
        this.deleteFile = Paths.get(deleteFile);
        
    }
    
    private synchronized void delete() throws IOException {

        if (!Files.exists(deleteFile)) {
            System.out.println("Файл не найден.");
        } else {
            Files.delete(deleteFile);
            System.out.println("Удаление завершено.");
        }
    }
    @Override
    public void run() {
        try {            
            delete();  
        } catch (IOException e) {
            System.out.println("Удаление не удалось: " + e.getMessage() + ".");   
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
