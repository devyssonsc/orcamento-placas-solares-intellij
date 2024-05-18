/**
 *
 */
package orcamento;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Administrador
{
    private String nome;
    private String email;
    private String password;
    private String userId;



    /**
     * @param nome
     * @param email
     * @param password
     */
    public Administrador(String nome, String email, String password)
    {
        this.nome = nome;
        this.email = email;
        this.password = password;
        userId = gerarId();
    }

    public String gerarId()
    {
        Pattern pattern = Pattern.compile("^(?=(?:.*[A-Z]){2})(?=(?:.*[a-z]){2})(?=(?:.*\\d){2})[A-Za-z\\d]{7}$");
        Matcher matcher;
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ1234567890abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        String randomString = "";
        int index;
        do {
            for (int i = 0; i < 7; i++) {
                index = random.nextInt(letras.length());
                randomString += letras.substring(index, index + 1);
            }
            matcher = pattern.matcher(randomString);
        } while(!matcher.matches());
        return randomString;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the nome
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @return the userId
     */
    public String getUserId()
    {
        return userId;
    }

    public String getEmail()
    {
        return email;
    }
}
