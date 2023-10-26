package br.com.payapp.utils;

public class SecretKey {

    public String insereCPF() {
        String cpf = System.getenv("CPF");
        return cpf;
    }
}
