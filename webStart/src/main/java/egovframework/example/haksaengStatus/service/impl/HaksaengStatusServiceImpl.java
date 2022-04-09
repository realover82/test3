package egovframework.example.haksaengStatus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.haksaengStatus.service.HaksaengStatusService;
import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class HaksaengStatusServiceImpl implements HaksaengStatusService {
	
	@Resource
//	@Autowired
	private HaksaengStatusMapper haksaengStatusMapper;

	@Override
	public List<EgovMap> selectHaksaengStatusServiceList() throws Exception {
		
		return haksaengStatusMapper.selectHaksaengStatusServiceList();
	}

	@Override
	public List<EgovMap> selectHaksaengStatusChartServiceList() throws Exception {
		
		return haksaengStatusMapper.selectHaksaengChartStatusServiceList();
	}

	@Override
	public List<EgovMap> selectHaksaengStatusServiceList(EgovMap egovMap) throws Exception {
		// TODO Auto-generated method stub
//		return null;
		return haksaengStatusMapper.selectHaksaengStatusServiceList(egovMap);
	}

	@Override
	public List<EgovMap> stringParam(String paramStr) throws Exception {
		// TODO Auto-generated method stub
//		return null;
		return haksaengStatusMapper.stringParam(paramStr);
	}

	@Override
	public List<EgovMap> paramVO(HaksaengStatusVO haksaengStatusVO) throws Exception {
		// TODO Auto-generated method stub
//		return null;
		return haksaengStatusMapper.paramVO(haksaengStatusVO);

	}

	@Override
	public List<EgovMap> selectClassServiceList() throws Exception {
		// TODO Auto-generated method stub
		return haksaengStatusMapper.selectClassServiceList();
	}

	@Override
	public List<EgovMap> selectMainPartsServiceList() throws Exception {
		// TODO Auto-generated method stub
		return haksaengStatusMapper.selectMainPartsServiceList();
	}

	@Override
	public List<EgovMap> selectPartsDtlServiceList(String partsCd) throws Exception {
		// TODO Auto-generated method stub
		return haksaengStatusMapper.selectPartsDtlServiceList(partsCd);
	}

	@Override
	public List<EgovMap> selectMainHoonServiceList() throws Exception {
		// TODO Auto-generated method stub
		return haksaengStatusMapper.selectMainHoonServiceList();
	}

}
