package egovframework.example.main.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
	
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < 3; i++) {
//			list.add(index, element);
			Map<String, Object> map = new HashMap<String, Object>();
			
			list.add(i, map);
			
//			list.add(new HashMap<String, Object>());
			
			list.get(i).put(Integer.toString(i), i);

				
		}
//		if (i % 2 == 0) {
//			
//		}
		
//		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			Object valStr = null;
			
			Map<String, Object> map = new HashMap<String, Object>();
			
//			list.add(i, map);
		if (i % 2 == 0) {
			
			if (i < 2) {
				valStr = "dp" + i;
			} else {
				valStr = i;
			}
		} else {
			
		}
			map.put(Integer.toString(i), valStr);
			
			list.set(i, map);
		}
		System.out.println(list);
		
	}
// [{0=dp0}, {1=dp1}, {2=2}]

//	<과제4>
//	Test.jsp 과제
//
//	TestVO 넣어주세요
//
//	넣은걸 빼세요
//
//	짝수는 빼서 TestVO 안에 넣구요
//
//	넣은걸 빼세요
//
//	출력해주세요
//
//	[{ 0={0=dp0}}, 2={2=2}]

}
