package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository("userDAO")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	@Autowired
	public void setDs(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public void write(UserDTO userDTO) {
//		String sql = "insert into usertable values(?,?,?)";
//		getJdbcTemplate().update(sql, userDTO.getName(),userDTO.getId(),userDTO.getPwd());
		String sql = "insert into usertable values(:name,:id,:pwd)";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name",userDTO.getName());
		map.put("id",userDTO.getId());
		map.put("pwd",userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql,map);
		
	}
	@Override
	public List<UserDTO> getUserList(){
		String sql="select * from usertable";
		
		return getJdbcTemplate().query(sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=? ";
		try {
		return getJdbcTemplate().queryForObject(sql,new Object[]{id}, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public int getUserCount(String id) {
		String sql = "select count(*) from usertable where id=?";
		/*
		return getJdbcTemplate().queryForObject(
				sql,
				new Object[] {id}, 
				Integer.class);
		*/
		
		return getJdbcTemplate().queryForObject(
				sql,
				Integer.class,
				id);
	}
	@Override
	public void modify(Map<String, String> map) {
		map.get("name");
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql,map);

	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
	}
}
