/**
 *
 */
package orcamento;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 */
public class Gerir {
    private ArrayList<Administrador> listaUtilizadores;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])" +          // pelo menos um dígito
                    "(?=.*[a-z])" +           // pelo menos uma letra minúscula
                    "(?=.*[A-Z])" +           // pelo menos uma letra maiúscula
                    "(?=.*[@#$%&])" +      // pelo menos um caractere especial
                    ".{8,}$";                 // pelo menos 1 caractere no total

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    /**
     *
     */
    public Gerir() {
        listaUtilizadores = new ArrayList<>();
    }

    public void inserirUsuario(Cliente newCliente)
    {
        listaUtilizadores.add(newCliente);
    }

    public boolean validarEmail(String email)
    {
        EmailValidator emailValidator = EmailValidator.getInstance();
        boolean isValid = emailValidator.isValid(email);

        if(!isValid) {
            System.out.println("E-mail inválido!");
        }

        return isValid;
    }

    public boolean validarSenha(String password) {
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            System.out.println("A sua senha precisa conter:\n"
                    + "-Pelo menos 8 caractéres.\n"
                    + "-Pelo menos 1 letra maiúscula.\n"
                    + "-Pelo menos 1 letra minúscula.\n"
                    + "-Pelo menos 1 número\n"
                    + "-Pelo menos 1 caractere especial (@#$%&)\n");
        }

        return matcher.matches();
    }

    public boolean fazerLogin(String email, String password) {
        for(Administrador utilizador:listaUtilizadores) {
            if(utilizador.getEmail().equals(email)) {
                if(utilizador.getPassword().equals(password)) {
                    return true;
                }
            } else {
                System.out.println("Usuário não encontrado.\n");
                return false;
            }
        }
        System.out.println("E-mail ou senha incorretos!\n");
        return false;
    }

    /**
     * @return the listaUtilizadores
     */
    public ArrayList<Administrador> getListaUtilizadores() {
        return listaUtilizadores;
    }


}
