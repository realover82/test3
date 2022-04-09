package egovframework.example.spritGuide.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
@Mapper
public interface SpritGuideMapper {

	List<EgovMap> selectSpritGuideServiceList() throws Exception;

}
