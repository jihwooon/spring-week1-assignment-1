package com.codesoom.assignment;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    private static final int PORT = 8000;
    private static final String TASKS = "/tasks";

    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress(PORT);

        try {
            HttpServer httpServer = HttpServer.create(address, 0);
            HttpHandler handler = new TasksHttpHandler(TASKS);

            httpServer.createContext(TASKS, handler);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
