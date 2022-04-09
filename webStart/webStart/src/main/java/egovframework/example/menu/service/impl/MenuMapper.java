package egovframework.example.menu.service.impl;

import java.util.List;

import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface MenuMapper {

	List<EgovMap> selectMenuCatServiceList() throws Exception;

	List<EgovMap> selectMenuDtlServiceList(String menuCatCd) throws Exception;



}
