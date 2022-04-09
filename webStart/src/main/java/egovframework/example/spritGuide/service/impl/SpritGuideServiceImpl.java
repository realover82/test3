package egovframework.example.spritGuide.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.spritGuide.service.SpritGuideService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service
public class SpritGuideServiceImpl implements SpritGuideService {

	@Resource
	private SpritGuideMapper spritGuideMapper;
	
	@Override
	public List<EgovMap> selectSpritGuideServiceList() throws Exception {
		// TODO Auto-generated method stub
		return spritGuideMapper.selectSpritGuideServiceList();
	}

}
