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
        Random random = new Random();
        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";

        while (true) {
            StringBuilder randomString = new StringBuilder();
            int minCount = 0;
            int maiCount = 0;
            int numCount = 0;

            for (int i = 0; i < 7; i++) {
                int type = random.nextInt(3); // 0: minúscula, 1: maiúscula, 2: número

                if (type == 0 && minCount < 2) {
                    randomString.append(letrasMinusculas.charAt(random.nextInt(letrasMinusculas.length())));
                    minCount++;
                } else if (type == 1 && maiCount < 2) {
                    randomString.append(letrasMaiusculas.charAt(random.nextInt(letrasMaiusculas.length())));
                    maiCount++;
                } else if (type == 2 && numCount < 3) {
                    randomString.append(numeros.charAt(random.nextInt(numeros.length())));
                    numCount++;
                } else {
                    i--; // If no valid character was added, stay on the same iteration
                }
            }

            if (minCount == 2 && maiCount == 2 && numCount == 3) {
                return randomString.toString();
            }
        }
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
