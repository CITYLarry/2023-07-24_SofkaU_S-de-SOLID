import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosPersistencia {

    public String FICHERO_DATOS = "usuarios.txt";

    public UsuariosPersistencia() {
    }

    public ArrayList<Usuario> convertirUsuariosEnList() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(FICHERO_DATOS));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String partes[] = usuarioActual.split(",");

                Usuario usuario = new Usuario();
                usuario.setNombreUsuario(partes[0]);
                usuario.setNombre(partes[1]);
                usuario.setApellidos(partes[2]);
                usuario.setEmail(partes[3]);
                usuario.setNivelAcceso(Integer.parseInt(partes[4]));

                usuarios.add(usuario);
            }

            scanner.close();
        } catch (Exception e) {
        }

        return usuarios;
    }

    public Usuario buscar(Usuario usuario) {
        ArrayList<Usuario> usuarios = convertirUsuariosEnList();

        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario())) {
                return usuarioActual;
            }
        }

        return null;
    }

    public void insertar(Usuario usuario){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FICHERO_DATOS, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarUsuarioPorComas(usuario));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    public void borrar(Usuario usuario) {
        ArrayList<Usuario> usuarios = convertirUsuariosEnList();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario())) {
                usuarios.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(FICHERO_DATOS);

            for (Usuario usuarioActual : usuarios) {
                String usuarioComas = separarUsuarioPorComas(usuarioActual);
                printStream.println(usuarioComas);
            }

            printStream.flush();
            printStream.close();
        } catch (Exception e) {
        }
    }

    private String separarUsuarioPorComas(Usuario usuario) {
        return usuario.getNombreUsuario() + ","
                + usuario.getNombre() + ","
                + usuario.getApellidos() + ","
                + usuario.getEmail() + ","
                + usuario.getNivelAcceso();
    }
}
