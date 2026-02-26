/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author laboratorio
 */
import entidad.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOArchivo {

    private String archivo = "usuarios.txt";
    public void guardarUsuario(Usuario usuario) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(usuario.toString());
            bw.newLine();
        }
    }


    public List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    lista.add(new Usuario(datos[0], datos[1]));
                }
            }
        }

        return lista;
    }
}