package ao.shopping.user.api.controller;


import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestParam;
import ao.shopping.user.dto.UserDTO;
import ao.shopping.user.Service.UserService;

@RestController 
public class UserController { 
@Autowired 
private UserService userService; 
@GetMapping("/ser/") 
public List<UserDTO> getUsers() {         
       List<UserDTO> usuarios = userService.getAll();         
return usuarios; 
   } 
@GetMapping("/ser/{id}") 
UserDTO findById(@PathVariable Long id) { 
return userService.findById(id); 
   } 

@PostMapping("/user") 
UserDTO newUser(@RequestBody UserDTO serDTO) {         
return userService.save(serDTO); 
   } 
@GetMapping("/ser/cpf/{bi}") 
UserDTO findByCpf(@PathVariable String bi) { 
return userService.findByCpf(bi); 
   } 
@DeleteMapping("/user/{id}") 
UserDTO delete(@PathVariable Long id) { 
return userService.delete(id); 
   } 
@GetMapping("/user/search") 
public List<UserDTO> queryByName( 
           @RequestParam(name="nome", required = true)  
           String nome) { 
return userService.queryByName(nome); 
   } 
}