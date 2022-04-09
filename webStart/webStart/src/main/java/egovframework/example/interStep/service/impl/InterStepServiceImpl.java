package egovframework.example.interStep.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.interStep.service.InterStepService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service
public class InterStepServiceImpl implements InterStepService {

	@Resource
	private InterStepMapper interStepMapper;
	
	@Override
	public List<EgovMap> selectInterStepServiceList() throws Exception {
		// TODO Auto-generated method stub
		return interStepMapper.selectInterStepServiceList();
	}

}
