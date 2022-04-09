package egovframework.example.internationalStandard.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface InternationalStandardService {

	List<EgovMap> selectInternationalStandardServiceList() throws Exception;

}
