package egovframework.example.interStep.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Mapper
public interface InterStepMapper {

	List<EgovMap> selectInterStepServiceList() throws Exception;

}
