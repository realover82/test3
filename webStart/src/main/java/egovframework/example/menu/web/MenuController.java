package egovframework.example.menu.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.menu.service.MenuService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class MenuController {
	
	@Resource
	private MenuService menuService;

//	@Resource
//	private UserService userService;	
	
	@RequestMapping(value = "/initMenuSelectBox.do")
		public String initMenuSelectBox(ModelMap model) throws Exception {
		
		List<EgovMap> menuCatList = menuService.selectMenuCatServiceList();
		
		model.addAttribute("menuCatList", menuCatList);
		
		System.out.println(menuCatList);
//		System.out.println(menuDtlList);
		
		return "menu/menuSelectBox.tiles";
	}
	
	
	@RequestMapping(value = "/selectMenuDtl.do", produces="application/json; charset=utf-8")
	@ResponseBody
		public String selectMenuDtl(@RequestParam String menuCatCd) throws Exception {
		
		List<EgovMap> menuDtlList = menuService.selectMenuDtlServiceList(menuCatCd);

//		System.out.println(menuDtlList);
		
		return JsonUtil.ListToJson(menuDtlList);
	}
	
}
