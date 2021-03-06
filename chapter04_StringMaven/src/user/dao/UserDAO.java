package user.dao;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);
	public List<UserDTO> getUserList(); 
	public UserDTO getUser(String id); 
	public int getUserCount(String id);
	public void modify(Map<String, String> map);
	public void delete(String id);
}
