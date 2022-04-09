package egovframework.example.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.haksaengStatus.service.HaksaengStatusService;
import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.example.menu.service.MenuService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<EgovMap> selectMenuCatServiceList() throws Exception {

		return menuMapper.selectMenuCatServiceList();
	}

	@Override
	public List<EgovMap> selectMenuDtlServiceList(String menuCatCd) throws Exception {

		return menuMapper.selectMenuDtlServiceList(menuCatCd);
	}
	

}
