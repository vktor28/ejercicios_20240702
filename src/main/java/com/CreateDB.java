package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;


public class CreateDB {
    public static void main(String[] args) {
    try {
        //aqui haremos la conexión y las consultas
        // 1-decirle el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- conectar con DB específica. Crear objeto de Conne
        Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/comics","root","");
        System.out.println("***CORRECTOOO ***");


        // 3- crear objeto Statement, que es el que se encargará de hacer consultas
        Statement stat1 = conexion1.createStatement();

        // 4 - Ejecutar instrucciones stat1 y mediante métodos executeQuery() y executeUpdate()
        // primero lo leemos todo y lo guardamos en onjeto ResultSet
        ResultSet resultado1 = stat1.executeQuery("SELECT * FROM personajes");

        // 5- recorrer el resultado mediante bucle

        while(resultado1.next()){
            System.out.println(resultado1.getString("nombre") + ", pertenece a la especie " + resultado1.getString("especie") + ", y su frase preferida es: " + resultado1.getString("frase"));
        }

        // 6 - INSERTAR daros en la tabla con un método executeUpdate()
        //String insertar = "INSERT INTO personajes (nombre, especie, frase) values ('Capitán america','Humanos','Via América')";
        //stat1.executeUpdate(insertar);
        //System.out.println("datos insertados!!");

        // 7 - Actualizar datos UPADTE
        String actualizar = "UPDATE personajes set id_autor=1 where idpersonaje=6";
        stat1.executeUpdate(actualizar);
        System.out.println("datos actualizados");

        // 8 - Borrar registros DELELTE
        String eliminar = "DELETE from personajes where idpersonaje=6";
        stat1.executeUpdate(eliminar);
        System.out.println("Elemento eliminado");

        
    }catch(Exception e){
        //mensaje de error
        System.out.println("***oohhhh ***");
    }

}
}