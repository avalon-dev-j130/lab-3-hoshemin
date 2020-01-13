package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    private final Path copyFrom;
    private final Path copyTo;

    public FileCopyAction(String copyFrom, String copyTo) {
        this.copyFrom = Paths.get(copyFrom);
        this.copyTo = Paths.get(copyTo);
    }
    
    private synchronized void copy() throws IOException {

        if (!Files.exists(copyFrom)) {
            System.out.println("Файл не найден.");
        } else {
            Files.copy(copyFrom, copyTo.resolve(copyFrom.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Копирование завершено.");
        }
    }
    @Override
    public void run() {
        try {            
            copy();  
        } catch (IOException e) {
            System.out.println("Копирование не удалось: " + e.getMessage() + ".");   
        }
        System.out.println("Введите команду из списка: copy, move или exit\nи следуйте подсказкам");
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
