package egovframework.example.menu.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MenuService {

	List<EgovMap> selectMenuCatServiceList() throws Exception;

	List<EgovMap> selectMenuDtlServiceList(String menuCatCd) throws Exception;


}
