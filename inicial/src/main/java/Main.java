public class Main {
    public static void main(String []args) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = "testUsuario";
        usuario.nombre = "testNombre";
        usuario.apellidos = "testApellidos";
        usuario.email = "test@mail.com";
        usuario.nivelAcceso = 10;

        Usuario usuario2 = new Usuario();
        usuario2.nombreUsuario = "test2";
        usuario2.nombre = "testNombre2";
        usuario2.apellidos = "testApellidos2";
        usuario2.email = "test2@mail.com";
        usuario2.nivelAcceso = 5;

        Usuarios usuarios = new Usuarios();

        usuarios.crearUsuario(usuario);
        usuarios.crearUsuario(usuario2);

        //Usuario obtener = usuarios.obtenerUsuario("openbootcamp2");
        //System.out.println(obtener.email);

        //usuarios.borrarUsuario("openbootcamp2");
        for (Usuario a : usuarios.listarUsuarios()) {
            System.out.println(a.nombreUsuario);
        }
    }
}
