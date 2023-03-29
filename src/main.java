public class main {
    public static void main(String[] args) {
        validarCampos validar = new validarCampos(args);
        RegistroUsuario registro = new RegistroUsuario(); 

        System.out.println(validar);
        System.out.println(registro);
    }
}
