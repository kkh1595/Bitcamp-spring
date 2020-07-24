package member.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberService {
	public MemberDTO login(Map<String,Object> map);
	public MemberDTO getMemberInfo(String id);
	public List<ZipcodeDTO> addrList(ZipcodeDTO zipcodeDTO);
	
}
