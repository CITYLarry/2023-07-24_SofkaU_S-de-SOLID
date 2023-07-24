import java.util.ArrayList;

public class Usuarios {


    private UsuariosPersistencia usuariosPersistencia = new UsuariosPersistencia();

    public ArrayList<Usuario> listarUsuarios() {
        return usuariosPersistencia.convertirUsuariosEnList();
    }

    public Usuario obtenerUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(username);

        return usuariosPersistencia.buscar(usuario);
    }

    public void crearUsuario(Usuario usuario) {
        if (obtenerUsuario(usuario.getNombreUsuario()) != null) {
            return;
        }

        usuariosPersistencia.insertar(usuario);
    }

    public void borrarUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(username);

        usuariosPersistencia.borrar(usuario);
    }
}
