package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONObject;
import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId",id);
	}
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write",userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete",id);
	}

	@Override
	public List<UserDTO> getUserLiSt() {
		 List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		return list;
	}

	@Override
	public void modify(Map<String,String> map) {
		sqlSession.update("userSQL.modify",map);
	}
		



}
