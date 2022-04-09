package egovframework.example.haksaengStatus.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface HaksaengStatusService {

//	List<EgovMap> selectHaksaengStatusServiceList = null;
	List<EgovMap> selectHaksaengStatusServiceList() throws Exception;

	List<EgovMap> selectHaksaengStatusChartServiceList() throws Exception;

	List<EgovMap> selectHaksaengStatusServiceList(EgovMap egovMap)throws Exception;

	List<EgovMap> stringParam(String paramStr)throws Exception;

	List<EgovMap> paramVO(HaksaengStatusVO haksaengStatusVO)throws Exception;

	List<EgovMap> selectClassServiceList() throws Exception;

	List<EgovMap> selectMainPartsServiceList() throws Exception;

	List<EgovMap> selectPartsDtlServiceList(String partsCd) throws Exception;

	List<EgovMap> selectMainHoonServiceList() throws Exception;

}
