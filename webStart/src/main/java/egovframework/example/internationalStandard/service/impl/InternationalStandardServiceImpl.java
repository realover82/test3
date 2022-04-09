package egovframework.example.internationalStandard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.internationalStandard.service.InternationalStandardService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service
public class InternationalStandardServiceImpl implements InternationalStandardService {

	@Resource
	private InternationalStandardMapper internationalStandardMapper;
	
	@Override
	public List<EgovMap> selectInternationalStandardServiceList() throws Exception {
		// TODO Auto-generated method stub
		return internationalStandardMapper.selectInternationalStandardServiceList();
//		return null;
	}

}
