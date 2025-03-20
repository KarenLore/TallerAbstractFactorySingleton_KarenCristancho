package com.tarea.infrastructure.database;

public class ConnectionFactory {
    public static ConnectionDb crearConexion() {
        return new ConnMySql();
    }
}
