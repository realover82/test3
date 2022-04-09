package egovframework.example.haksaengStatus.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.haksaengStatus.service.HaksaengStatusService;
import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.example.interStep.service.InterStepService;
import egovframework.example.internationalStandard.service.InternationalStandardService;
import egovframework.example.menu.service.MenuService;
import egovframework.example.spritGuide.service.SpritGuideService;
import egovframework.example.studyGuide.service.StudyGuideService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class HaksaengStatusController {
	
	@Resource
	private HaksaengStatusService haksaengStatusService;
	
	@Resource
	private InternationalStandardService internationalStandardService;
	
	@Resource
	private SpritGuideService spritGuideService;
	
	@Resource
	private StudyGuideService studyGuideService;
	
	@Resource
	private InterStepService interStepService;
	
	
	
	@RequestMapping(value = "/initHaksaengStatus.do")
//	public String initHaksaengStatus() throws Exception {
		public String initHaksaengStatus(ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		List<EgovMap> internationalList = internationalStandardService.selectInternationalStandardServiceList();
		List<EgovMap> spritList = spritGuideService.selectSpritGuideServiceList();
		List<EgovMap> studyList = studyGuideService.selectStudyGuideServiceList();
		List<EgovMap> interStepList = interStepService.selectInterStepServiceList();
		List<EgovMap> haksaengChartList = haksaengStatusService.selectHaksaengStatusChartServiceList();
				
		
		System.out.println(haksaengList);
		System.out.println("다 잘 되겠지: " + haksaengChartList);

		System.out.println(internationalList);
		System.out.println(spritList);
		System.out.println(studyList);
		System.out.println(interStepList);
		
		model.addAttribute("haksaengList", haksaengList);
		model.addAttribute("haksaengChartList", haksaengChartList);

		
		return "haksaengStatus/haksaengStatus.tiles";
	}
	
	@RequestMapping(value = "/initHaksaengStatusChart.do")
//	public String initHaksaengStatusChart() throws Exception {
		public String initHaksaengStatusChart(ModelMap model) throws Exception {

		List<EgovMap> haksaengChartList = haksaengStatusService.selectHaksaengStatusChartServiceList();

		System.out.println("다 잘 되겠지: " + haksaengChartList);
		
		model.addAttribute("haksaengChartList", haksaengChartList);	
		return "haksaengStatus/haksaengStatusChart.tiles";
	}
	
	@RequestMapping(value = "/initHaksaengStatusTable.do")
//	public String initHaksaengStatusTable() throws Exception {
		public String initHaksaengStatusTable(ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		System.out.println(haksaengList);

		model.addAttribute("haksaengList", haksaengList);
		
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	//복제함
	@RequestMapping(value = "/oneMapping.do") //복제함
//	public String initHaksaengStatusTable() throws Exception {
	public String initOneMapping(HttpServletRequest req, 
			ModelMap model) throws Exception {
//		req.getParameter("pageName");
		String menuNm = req.getParameter("pageName"),
			   returAddrStr = "";
//		String returAddrStr = "";
		
//		if (menuNm == "initHaksaengStatusChart") {
		if (menuNm.equals("initHaksaengStatusChart")) {
			
			List<EgovMap> haksaengChartList = haksaengStatusService.selectHaksaengStatusChartServiceList();
//			System.out.println("다 잘 되겠지: " + haksaengChartList);
			
			model.addAttribute("haksaengChartList", haksaengChartList);			
			
//		return "haksaengStatus/haksaengStatusChart.tiles";
			returAddrStr = "haksaengStatus/haksaengStatusChart.tiles";
//		} else if (menuNm == "initHaksaengStatusTable") {			
		} else if (menuNm.equals("initHaksaengStatusTable")) {
			EgovMap egovMap = new EgovMap(); 
			egovMap.put("userNm", req.getParameter("haksaengName"));
			egovMap.put("userId", "hanq");
			
			System.out.println("111111111 : " + req.getParameter("haksaengName"));
			
//			List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
			List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(egovMap);
//			System.out.println(haksaengList);

			model.addAttribute("haksaengList", haksaengList);
			
//		return "haksaengStatus/haksaengStatusTable.tiles";
			returAddrStr = "haksaengStatus/haksaengStatusTable.tiles";
		}
		return returAddrStr;
		
	}
	//복제함
	
	@RequestMapping(value = "/stringParam.do")
//	public String initHaksaengStatusTable() throws Exception {
		public String initStringParam(HttpServletRequest req, 
				ModelMap model) throws Exception {
		
//		String paramStr = req.getParameter("pageName");
		String paramStr = "한석현";
		
		System.out.println(paramStr);
		
		List<EgovMap> haksaengList = haksaengStatusService.stringParam(paramStr);
//		System.out.println(haksaengList);
//
		model.addAttribute("haksaengList", haksaengList);
		
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/paramVO.do")
//	public String initHaksaengStatusTable() throws Exception {
	public String initParamVO(HttpServletRequest req, 
			ModelMap model) throws Exception {
		
		HaksaengStatusVO haksaengStatusVO = new HaksaengStatusVO();
		
		haksaengStatusVO.setUserId("hanq");
		haksaengStatusVO.setUserNm("한석현");
		haksaengStatusVO.setAge(38);
		
//		System.out.println(haksaengStatusVO.getUserId());
//		System.out.println(haksaengStatusVO.getUserNm());
//		System.out.println(haksaengStatusVO.getAge());
		
//		String paramStr = req.getParameter("pageName");
//		String paramStr = "한석현";
		
//		System.out.println(paramStr);
		
		List<EgovMap> haksaengList = haksaengStatusService.paramVO(haksaengStatusVO);
		System.out.println(haksaengList);
//
//		model.addAttribute("haksaengList", haksaengList);
		
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/reqParam.do")
//	public String initHaksaengStatusTable() throws Exception {
//		public String initReqParam(@RequestParam String pageName, 
//				@RequestParam String param1,
//				@RequestParam String param2,
//				@RequestParam String param3,
		public String initReqParam(
//				String pageName, 
//				String param1,
//				String param2,
//				String param3,
//				String notParam,
				@RequestParam Map<String, String> paramMap,
				
				ModelMap model) throws Exception {
		
//		String paramStr = req.getParameter("pageName");
//		String paramStr = "한석현";
		
//		System.out.println(pageName);
//		System.out.println(param1);
//		System.out.println(param2);
//		System.out.println(param3);
//		System.out.println("notParam = " + notParam);
//		System.out.println("paramMap = " + paramMap);
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
//		System.out.println(haksaengList);
		System.out.println("paramMap = " + paramMap);

		model.addAttribute("haksaengList", haksaengList);
		
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	@RequestMapping(value = "/modelAttr.do")
//	public String initHaksaengStatusTable() throws Exception {
//		public String initReqParam(@RequestParam String pageName, 
//				@RequestParam String param1,
//				@RequestParam String param2,
//				@RequestParam String param3,
	public String initModelAttr(
//				String pageName, 
//				String param1,
//				String param2,
//				String param3,
//				String notParam,
//			@RequestParam Map<String, String> paramMap,
//			@ModelAttribute HaksaengStatusVO haksaengStatusVO,
//			HaksaengStatusVO haksaengStatusVO,
//			@ModelAttribute HaksaengStatusVO vo,
			@ModelAttribute("vo") HaksaengStatusVO vo,
			
//			ModelMap model) throws Exception {
		ModelMap model) throws Exception {
		
//		System.out.println(haksaengStatusVO.getUserId());
//		System.out.println(haksaengStatusVO.getUserNm());
//		System.out.println(vo.getUserId());
//		System.out.println(vo.getUserNm());
		
		EgovMap egovMap = new EgovMap();
		
//		egovMap.put("userId", paramMap.get("userId"));
//		egovMap.put("userNm", paramMap.get("userNm"));
//		egovMap.put("userNm", haksaengStatusVO.getUserId());
//		egovMap.put("userNm", haksaengStatusVO.getUserNm());
		egovMap.put("userNm", vo.getUserId());
		egovMap.put("userNm", vo.getUserNm());
		
//		String paramStr = req.getParameter("pageName");
//		String paramStr = "한석현";
		
//		System.out.println(pageName);
//		System.out.println(param1);
//		System.out.println(param2);
//		System.out.println(param3);
//		System.out.println("notParam = " + notParam);
//		System.out.println("paramMap = " + paramMap);
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(egovMap);
//		System.out.println(haksaengList);
//		System.out.println("paramMap = " + paramMap);
		
		model.addAttribute("haksaengList", haksaengList);
//		model.addAttribute("haksaengStatusVO", haksaengStatusVO);
//		model.addAttribute("userNm", haksaengStatusVO.getUserNm());
//		model.addAttribute("userNm", vo.getUserNm());
//		model.addAttribute("vo", vo);
		
		
		return "haksaengStatus/modelAttrTable.tiles";
	}

	@RequestMapping(value = "/chkBox.do")
		public String initChkBox(
//				@RequestParam Map<String, String> paramMap,
				@RequestParam(required=false) String[] chkArr,
//				String[] chkArr,
				ModelMap model) throws Exception {
//		String chkArr = paramMap.get("chkArr");
		
//		System.out.println(chkArr);
//		System.out.println(Arrays.toString(chkArr));
//		System.out.println("chkArr.length = " + chkArr.length);
//		System.out.println("chkArr[0] = " + chkArr[0]);
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		
		model.addAttribute("haksaengList", haksaengList);
		
		if (chkArr != null) {
			model.addAttribute("chkArr", chkArr);
			
		}

		return "haksaengStatus/array.tiles";
	}
	@RequestMapping(value = "/chkBox2.do")
	public String initChkBox2(
//				@RequestParam Map<String, String> paramMap,
			@RequestParam(required=false) String[] chkArr,
//				String[] chkArr,
			ModelMap model) throws Exception {
//		String chkArr = paramMap.get("chkArr");
		
//		System.out.println(chkArr);
//		System.out.println(Arrays.toString(chkArr));
//		System.out.println("chkArr.length = " + chkArr.length);
//		System.out.println("chkArr[0] = " + chkArr[0]);
		
		List<EgovMap> classList = haksaengStatusService.selectClassServiceList();
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		
		System.out.println(classList);
		model.addAttribute("classList", classList);
		model.addAttribute("haksaengList", haksaengList);
		
		if (chkArr != null) {
			model.addAttribute("chkArr", chkArr);
			
		}
		
		return "haksaengStatus/array2.tiles";
	}
	@RequestMapping(value = "/multiSelectBox.do")
	public String initMultiSelectBox(ModelMap model) throws Exception {
//		
		List<EgovMap> mainPartsList = haksaengStatusService.selectMainPartsServiceList();
		
		System.out.println(mainPartsList);
		model.addAttribute("mainPartsList", mainPartsList);
		
		return "haksaengStatus/multiSelectBox.tiles";
	}
	
//	@RequestMapping(value = "/selectPartsDtl.do")
	@RequestMapping(value = "/selectPartsDtl.do", produces="application/json; charset=utf-8")
	@ResponseBody
//	public void selectPartsDtl(ModelMap model) throws Exception {
//	public void selectPartsDtl(@RequestParam String partsCd) throws Exception {
//		public void selectPartsDtl(@RequestParam String partsCd,
//			HttpServletResponse res) throws Exception {
		public String selectPartsDtl(@RequestParam String partsCd) throws Exception {
//		System.out.println(partsCd);
		List<EgovMap> partsDtlList = haksaengStatusService.selectPartsDtlServiceList(partsCd);

//		System.out.println(partsDtlList);
//		res.setCharacterEncoding("utf-8");
		
//		res.setContentType("text/plain");
//		res.setContentType("application/json");
		
//		res.setHeader("Content-Type", "application/json; charset=utf-8");
		
//		res.getWriter().write(JsonUtil.ListToJson(partsDtlList));
//		res.getWriter().write(partsDtlList.toString());
		
		return JsonUtil.ListToJson(partsDtlList);
	}
	
	@RequestMapping(value = "/multiHoon.do")
	public String initMultiHoon(ModelMap model) throws Exception {
//		
		List<EgovMap> mainHoonList = haksaengStatusService.selectMainHoonServiceList();
		
		System.out.println(mainHoonList);
		model.addAttribute("mainHoonList", mainHoonList);
		
		return "haksaengStatus/multiHoon.tiles";
	}
	
	@RequestMapping(value = "/selectHaksaengStatusList.do", produces="application/json; charset=utf-8")
	@ResponseBody
		public String selectHaksaengStatusList(@RequestParam String param) throws Exception {
//		System.out.println(param);
		EgovMap paramMap = new EgovMap();
		
		paramMap.put("classNm", param);
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(paramMap);
		
		return JsonUtil.ListToJson(haksaengList);
	}
	
}