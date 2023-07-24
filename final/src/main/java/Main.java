public class Main {
    public static void main(String []args) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUsuario");
        usuario.setNombre("testNombre");
        usuario.setApellidos("testApellidos");
        usuario.setEmail("test@email.com");
        usuario.setNivelAcceso(10);

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("testUsuario2");
        usuario2.setNombre("testNombre2");
        usuario2.setApellidos("testApellidos2");
        usuario2.setEmail("test2@email.com");
        usuario2.setNivelAcceso(5);

        Usuarios usuarios = new Usuarios();

        usuarios.crearUsuario(usuario);
        usuarios.crearUsuario(usuario2);

        Usuario obtener = usuarios.obtenerUsuario("testUsuario");
        System.out.println(obtener.getEmail());

        //usuarios.borrarUsuario("testUsuario");
        for (Usuario a : usuarios.listarUsuarios()) {
            System.out.println(a.getNombreUsuario());
        }
    }
}
