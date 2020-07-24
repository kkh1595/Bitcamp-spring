package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {
	public MemberDTO login(Map<String,Object> map);
	public MemberDTO getMemberInfo(String id);
	public List<ZipcodeDTO> addrList(ZipcodeDTO zipcodeDTO);
	

}
