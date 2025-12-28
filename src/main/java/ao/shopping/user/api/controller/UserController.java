package ao.shopping.user.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;


import ao.shopping.user.dto.UserDTO;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {

        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setbi("123");
        userDTO.setEndereco("Viana");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setbi("456");
        userDTO2.setEndereco("Rangel");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setbi("678");
        userDTO3.setEndereco("camama");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;

    }

@GetMapping("/users/{bi}") 
public UserDTO getUsersFiltro(@PathVariable String bi) {           
for (UserDTO userFilter: usuarios) { 
if (userFilter.getbi().equals(bi)) { 
return userFilter; 
       } 
   } 
return null; 
}

//inserir novo usuario
@PostMapping("/newUser") 
UserDTO inserir(@RequestBody UserDTO userDTO) {     
   userDTO.setDataCadastro(new Date());     
   usuarios.add(userDTO); 
return userDTO; 
} 

//excluir usuario
@DeleteMapping("/deleteUser/{bi}")
public boolean deleteUser(@PathVariable String bi) {
    for (UserDTO userFilter : usuarios) {
        if (userFilter.getbi().equals(bi)) {
            usuarios.remove(userFilter);
            return true;
        }
    }
    return false;
}



}
