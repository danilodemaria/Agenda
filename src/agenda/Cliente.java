package agenda;

public class Cliente {
    private String nome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefoneFixo
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /**
     * @param telefoneFixo the telefoneFixo to set
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Cliente validaCampos(Cliente cliente){
        if(cliente.getTelefoneFixo().equals("(__) ____-____")){
            cliente.setTelefoneFixo("Não possui");
        }
        
        if(cliente.getTelefoneCelular().equals("(__) ____-____")){
            cliente.setTelefoneCelular("Não possui");
        }
        
        if(cliente.getEmail().equals("exemplo@exemplo.com")){
            cliente.setEmail("Não possui");
        }
        
        return cliente;
    }
    
}
