package util;

public class Validador {
    public boolean validarCorreo(String correo){
        return correo.contains("@") && correo.contains(".");
    }
    public boolean validarTelefono(String telefono) {

        for (int i = 0; i < telefono.length(); i++) {

            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean campoVacio(String texto) {
        return texto.trim().isEmpty();
    }
}
