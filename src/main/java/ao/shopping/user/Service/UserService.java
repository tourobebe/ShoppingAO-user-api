package ao.shopping.user.Service;

import java.util.List; 
import java.util.Optional; 
import java.util.stream.Collectors; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import ao.shopping.user.dto.UserDTO; 
import ao.shopping.user.Model.User;
import ao.shopping.user.Repository.UserRepository; 

@Service 
public class UserService { 

@Autowired 
private UserRepository userRepository; 
public List<UserDTO> getAll() { 

       List<User> users = userRepository.findAll(); 
return users
           .stream() 
           .map(UserDTO::convert) 
           .collect(Collectors.toList());         
   } 

public UserDTO findById(long userId) { 
   Optional<User> usuario = userRepository.findById(userId); 
if ( usuario.isPresent()) { 
return UserDTO.convert(usuario.get()); 
   } 
return null; 
} 
public UserDTO save(UserDTO userDTO) { 
   User user = userRepository.save(User.convert(userDTO)); 
return UserDTO.convert(user); 
} 

public UserDTO delete(long serId) { 
   Optional<User> user = userRepository.findById(serId); 
if ( user.isPresent()) { 
       userRepository.delete( user.get()); 
   } 
return null; 
}

public UserDTO findByCpf(String bi) { 
   User user = userRepository.findBybi(bi); 
if ( user != null) { 
return UserDTO.convert(user); 
   } 
return null; 
} 

public List<UserDTO> queryByName(String name) { 
   List<User> users = userRepository.queryByNomeLike(name); 
return users 
       .stream() 
       .map(UserDTO::convert) 
       .collect(Collectors.toList());         
}


} 
    

