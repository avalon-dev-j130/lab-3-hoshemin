package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    private final Path moveFrom;
    private final Path moveTo;

    public FileMoveAction(String moveFrom, String moveTo) {
        this.moveFrom = Paths.get(moveFrom);
        this.moveTo = Paths.get(moveTo);
    }
    
    private synchronized void move() throws IOException {

        if (!Files.exists(moveFrom)) {
            System.out.println("Файл не найден.");
        } else {
            Files.move(moveFrom, moveTo.resolve(moveFrom.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Перемещение завершено.");
        }
    }
    
    @Override
    public void run() {
        try{
            move();
        } catch (IOException e) {
            System.out.println("Перемещение не удалось: " + e.getMessage() + ".");   
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
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}
