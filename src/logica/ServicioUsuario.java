/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author laboratorio
 */
import entidad.Usuario;
import datos.UsuarioDAOArchivo;
import java.io.IOException;
import java.util.List;

public class ServicioUsuario {

    private UsuarioDAOArchivo dao = new UsuarioDAOArchivo();

    public void registrarUsuario(String nombre, String correo) {

        if (nombre.isEmpty() || correo.isEmpty()) {
            System.out.println("Error: Los campos no pueden estar vacíos.");
            return;
        }

        if (!correo.contains("@")) {
            System.out.println("Error: Correo inválido.");
            return;
        }

        Usuario usuario = new Usuario(nombre, correo);

        try {
            dao.guardarUsuario(usuario);
            System.out.println("Usuario guardado correctamente (:");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario ):");
        }
    }

    public void mostrarUsuarios() {

        try {
            List<Usuario> usuarios = dao.listarUsuarios();

            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios registrados ):");
            } else {
                for (Usuario u : usuarios) {
                    System.out.println("Nombre: " + u.getNombre() + 
                                       " | Correo: " + u.getCorreo());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo ):");
        }
    }
}
