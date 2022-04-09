package egovframework.example.studyGuide.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Mapper
public interface StudyGuideMapper {

	List<EgovMap> selectStudyGuideServiceList() throws Exception;

}
