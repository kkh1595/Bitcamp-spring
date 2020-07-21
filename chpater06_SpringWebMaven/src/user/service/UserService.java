package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {
	public String checkId(String id);
	public void write(UserDTO userDTO);
	public void delete(String id);
	public List<UserDTO> getUserList();
	public void modify(UserDTO userDTO);
}
