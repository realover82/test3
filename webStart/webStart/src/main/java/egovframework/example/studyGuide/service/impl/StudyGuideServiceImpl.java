package egovframework.example.studyGuide.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.studyGuide.service.StudyGuideService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service
public class StudyGuideServiceImpl implements StudyGuideService {

	@Resource
	private StudyGuideMapper studyGuideMapper;
	
	@Override
	public List<EgovMap> selectStudyGuideServiceList() throws Exception {
		// TODO Auto-generated method stub
		return studyGuideMapper.selectStudyGuideServiceList();
	}

}
