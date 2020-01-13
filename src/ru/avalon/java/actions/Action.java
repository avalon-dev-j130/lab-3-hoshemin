package ru.avalon.java.actions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Абстрактное представление о действии, как функциональном
 * элементе приложения.
 * <p>
 * Действие является потоковым объектом, что позволяет
 * исполнять несколько действий параллельно и не блокировать
 * основной поток исполнения.
 */
public interface Action extends Runnable, AutoCloseable {
    /**
     * Запускает потоковый объект на исполнение в отдельном
     * потоке исполнения.
     */
    default void start() {
        ExecutorService es = Executors.newCachedThreadPool();
   
        
        es.execute(this);
        }  
    
    
}
