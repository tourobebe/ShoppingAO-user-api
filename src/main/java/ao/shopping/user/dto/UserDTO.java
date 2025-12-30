package ao.shopping.user.dto;

import java.util.Date;
import ao.shopping.user.Model.User;

public class UserDTO {
private String nome;
private String bi;
private String endereco;
private String email;
private String telefone;
private Date dataCadastro;
   

public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}

public String getbi() {
    return bi;
}

public void setbi(String bi) {
    this.bi = bi;
}
public String getEndereco() {
    return endereco;
}
public void setEndereco(String endereco) {
    this.endereco = endereco;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getTelefone() {
    return telefone;
}
public void setTelefone(String telefone) {
    this.telefone = telefone;
}

public Date getDataCadastro() {
    return dataCadastro;
}

public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
} 

public static UserDTO convert(User user) { 
   UserDTO userDTO = new UserDTO(); 
   userDTO.setNome(user.getNome()); 
   userDTO.setEndereco(user.getEndereco()); 
   userDTO.setbi(user.getbi()); 
   userDTO.setEmail(user.getEmail()); 
   userDTO.setTelefone(user.getTelefone()); 
   userDTO.setDataCadastro(user.getDataCadastro()); 
return userDTO; 
}


}

