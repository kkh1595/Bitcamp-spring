package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

@Repository
@Transactional
public class MemberDAOMybatis implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDTO login(Map<String,Object> map) {
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login",map);
		return memberDTO;
	}

	@Override
	public MemberDTO getMemberInfo(String id) {
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMemberInfo", id);
		return memberDTO;
	}

	@Override
	public List<ZipcodeDTO> addrList(ZipcodeDTO zipcodeDTO) {
		List<ZipcodeDTO> list = sqlSession.selectList("memberSQL.addrList",zipcodeDTO);
		return list;
	}

	
	
}
