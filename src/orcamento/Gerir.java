/**
 *
 */
package orcamento;

import java.util.ArrayList;
import java.util.regex.*;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 */
public class Gerir {
    private ArrayList<Administrador> listaUtilizadores;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{8,}$\n";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    /**
     *
     */
    public Gerir() {
        listaUtilizadores = new ArrayList<>();
    }

    public void inserirUsuario(Administrador newCliente)
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

    public String fazerLogin(String email, String password) {
        boolean encontrou = false;
        for(Administrador utilizador:listaUtilizadores) {
            if(utilizador.getEmail().equals(email)) {
                encontrou = true;
                if(utilizador.getPassword().equals(password)) {
                    System.out.println(utilizador.getClass().getSimpleName());
                    return utilizador.getClass().getSimpleName();
                }
            }

        }
        if(encontrou){
            System.out.println("E-mail ou senha incorretos!\n");
            return "";
        }

        System.out.println("Usuário não encontrado.\n");
        return "";
    }

    /**
     * @return the listaUtilizadores
     */
    public ArrayList<Administrador> getListaUtilizadores() {
        return listaUtilizadores;
    }


}
