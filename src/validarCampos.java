import java.util.Random;

public class validarCampos {
    private String[] baseDatos = {"Carles_345", "Joan_123", "Maria_567", "Lluisa_890", "Pere_432",
                                  "Laura_321", "Xavi_654", "Eva_987", "Jordi_210", "Anna_543"};

        public boolean compruebaNombre(String nombre, String[] strings) {
        // Comprueba que el nombre cumple las restricciones
        if (nombre.length() > 16) {
        return false;
        }
        if (!Character.isUpperCase(nombre.charAt(0))) {
        return false;
        }
        if (!nombre.matches("[a-z]+[\\-_]\\d{3}")) {
        return false;
        }                   
        // Comprueba que el nombre no existe en la base de datos
        for (String usuario : baseDatos) {
        if (nombre.equalsIgnoreCase(usuario)) {
        return false;
        }
     }                        
      return true;
}

    public boolean compruebaEmail(String email) {
        // Comprueba que el email contiene un "@" y acaba en una extensión permitida
        if (!email.contains("@")) {
            return false;
        }
        if (!email.matches("\\w+@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)")) {
            return false;
        }

        return true;
    }

    public boolean compruebaPassword(String password) {
        // Comprueba que la contraseña cumple las restricciones
        if (password.length() != 8) {
            return false;
        }
        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }
        if (!password.matches(".*[@\\-#_].*\\d{2}")) {
            return false;
        }

        return true;
    }

    public String generaCodigoSeguridad() {
        // Genera un código de seguridad aleatorio de 8 caracteres
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#_-";
        StringBuilder codigoSeguridad = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            codigoSeguridad.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        }
        System.out.println("Código de seguridad generado: " + codigoSeguridad);
        return codigoSeguridad.toString();
    }

    public boolean compruebaCodigoSeguridad(String codigoSeguridadIntroducido, String codigoSeguridadGenerado) {
        // Comprueba que el código de seguridad introducido coincide con el autogenerado
        return codigoSeguridadIntroducido.equals(codigoSeguridadGenerado);
    }

    public validarCampos(String[] baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String[] getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String[] baseDatos) {
        this.baseDatos = baseDatos;
    }
}
