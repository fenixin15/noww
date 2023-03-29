import java.util.Scanner;

public class RegistroUsuario {
    private String nombreUsuario;
    private String email;
    private String password;
    private String codigoSeguridad;
    private validarCampos validaCampos = new validarCampos(null);
    private Scanner scanner = new Scanner(System.in);

    public void init(validarCampos validaCampos) {
        boolean formularioValido = false;

        while (!formularioValido) {
            System.out.println("Introduce tu nombre:");
            String nombre = scanner.nextLine();
            if (!validaCampos.compruebaNombre(nombre, new String[]{"Carles_345", "Joan-123"})) {
                System.out.println("Nombre inválido.");
                continue;
            }

            System.out.println("Introduce tu email:");
            String email = scanner.nextLine();
            if (!validaCampos.compruebaEmail(email)) {
                System.out.println("Email inválido.");
                continue;
            }

            System.out.println("Introduce tu contraseña:");
            String password = scanner.nextLine();
            if (!validaCampos.compruebaPassword(password)) {
                System.out.println("Contraseña inválida.");
                continue;
            }

            String codigoSeguridadGenerado = validaCampos.generaCodigoSeguridad();
            System.out.println("Código de seguridad generado: " + codigoSeguridadGenerado);
            System.out.println("Introduce el código de seguridad:");
            String codigoSeguridad = scanner.nextLine();
            if (!validaCampos.compruebaCodigoSeguridad(codigoSeguridadGenerado, codigoSeguridad)) {
                System.out.println("Código de seguridad inválido.");
                continue;
            }

            formularioValido = true;
            this.nombreUsuario = nombre;
            this.email = email;
            this.password = password;
            this.codigoSeguridad = codigoSeguridad;
        }
    }

    public void mostrarDatosUsuario() {
        System.out.println("Nombre: " + this.nombreUsuario);
        System.out.println("Email: " + this.email);
        System.out.println("Contraseña: " + this.password);
        System.out.println("Código de seguridad: " + this.codigoSeguridad);
    }
}
