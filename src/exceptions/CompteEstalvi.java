package exceptions;


import java.util.ArrayList;
import java.util.List;


public class CompteEstalvi {
    private String numCompte;
    private double saldo;

    private List<Client> llista_usuaris;

    public CompteEstalvi(String numCompte) {
        this.numCompte = numCompte;
        llista_usuaris = new ArrayList<>();
        saldo = 0;
    }

    /**
     Afegeix un usuari d'aquest compte
     @param client
     @return quantitat d'usuaris que té el compte
     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/
    public int removeUser(String dni) {
        //TODO
        llista_usuaris.removeIf(u -> {
            try {
                return dni.equals(u.getNom()) && remover();
            } catch (BankAccountException e) {
                e.printStackTrace();
            }
            return false;
        });
        return 0;
    }

    private boolean remover() throws BankAccountException {

        if (llista_usuaris.size() >= 2) {
            return true;
        } else {
            throw new BankAccountException(ExceptionMessage.ACCOUNT_ZERO_USER);
        }

    }

    /**
     * Afegeix m diners al saldo
     * @param amount
     */
    public void ingressar(double amount) {
        //TODO
        saldo += amount;
    }

    /**
     * Treu m diners del compte si n'hi han suficient
     * @param amount
     * @throws BankAccountException
     */
    public void treure(double amount) throws BankAccountException {
        //TODO treu sum de diners del saldo
        if (saldo < amount)  {
            throw new BankAccountException(ExceptionMessage.ACCOUNT_OVERDRAFT);
        } else {
            saldo -= amount;
        }
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }
}
