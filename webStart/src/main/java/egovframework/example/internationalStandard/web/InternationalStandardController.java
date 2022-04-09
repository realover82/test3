package egovframework.example.internationalStandard.web;

//import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.internationalStandard.service.InternationalStandardService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InternationalStandardController {
	
//	@Resource
//	private InternationalStandardService internationalStandardService;
//	
//	@RequestMapping(value = "/initInternationalStandard.do")
//	@RequestMapping(value = "/initHaksaengStatus.do")
	@RequestMapping(value = "/initA.do")
//	public String initInternationalStandard() throws Exception {
//	public String initHaksaengStatus(ModelMap model) throws Exception {
	public String initA() throws Exception {
		
//		List<EgovMap> internationalList = internationalStandardService.selectInternationalStandardServiceList();

//		System.out.println(internationalList);
		
//		model.addAttribute("internationalList", internationalList);		
		
//		return "internationalStandard/internationalStandard.tiles";
//		return "haksaengStatus/haksaengStatus.tiles";
		return "a/a.tiles";
	}

}
