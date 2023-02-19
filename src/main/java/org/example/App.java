package org.example;

import org.apache.log4j.Logger;

public class App
{
    private static final Logger log = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        log.info("Начало создания проекта");
        System.out.println( "Hello World!" );
    }
}