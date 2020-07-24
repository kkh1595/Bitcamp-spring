package member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Override
	public MemberDTO login(Map<String,Object> map) {
		return memberDAO.login(map);
	}
	@Override
	public MemberDTO getMemberInfo(String id) {
		return memberDAO.getMemberInfo(id);
	}
	@Override
	public List<ZipcodeDTO> addrList(ZipcodeDTO zipcodeDTO) {
		return memberDAO.addrList(zipcodeDTO);
	}


}
