package com.sts3.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

@Service
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public int hitCount(int bm_no) {
		logger.info("called hitCount(bm_no):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("hitCount",bm_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Map<String, Object>> boardList(Map<String,Object> pMap) {
		logger.info("called boardList:void");
		List<Map<String, Object>> boardList = new ArrayList<>();
		boardList = sqlSessionTemplate.selectList("boardList", pMap);
		return boardList;
	}
	public int getTotal(BoardMasterVO bmVO) {
		logger.info("called getTotal(bmVO):int");
		int tot = 0;
		try {
			tot = sqlSessionTemplate.selectOne("getTotal",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tot;
	}
	public int getBmno() {
		logger.info("called getBmno():int");
		int bm_no = 0;
		try {
			bm_no = sqlSessionTemplate.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_no;
	}
	public int bmStepUpdate(Map<String, Object> pMap) {
		logger.info("called bmStepUpdate(map):int");
		logger.info("bm_group:"+pMap.get("bm_group")+", bm_step:"+pMap.get("bm_step"));
		int result = 0;
		BoardMasterVO bmVO = new BoardMasterVO();
		int ibm_group = 0;
		if(pMap.get("bm_group") != null) {
			ibm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		int ibm_step = 0;
		if(pMap.get("bm_step") != null) {
			ibm_step = Integer.parseInt(pMap.get("bm_step").toString());
		}
		bmVO.setBm_group(ibm_group);
		bmVO.setBm_step(ibm_step);
		try {
			result = sqlSessionTemplate.update("bmStepUpdate",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getBmgroup() {
		logger.info("called getBmgroup():int");
		int bm_group = 0;
		try {
			bm_group = sqlSessionTemplate.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_group;
	}
	public int boardMasterAdd(Map<String, Object> pMap) {
		logger.info("called boardMasterAdd(Map):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardMasterAdd",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardSubAdd(Map<String, Object> pMap) {
		logger.info("called boardSubAdd(Map):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardSubAdd",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		

	}
	public int boardMasterUpd(BoardMasterVO bmVO) {
		logger.info("called boardMaterUpd(bmVO):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardMasterUpd", bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardSubDel(BoardSubVO bsVO) {
		logger.info("called boardSubDel(bsVO):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("boardSubDel", bsVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardMasterDel(BoardMasterVO bmVO) {
		logger.info("called boardMasterDel(bmVO):int");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("boardMasterDel", bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void boardSubDelAll(String[] emnoArr) {
		logger.info("called boardSubDelAll(emnoArr):void");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		sqlSessionTemplate.delete("boardSubDelAll",list);
	}
	public int boardMasterDelAll(String[] emnoArr) {
		logger.info("called boardMasterDelAll(emnoArr):void");
		int result = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		result = sqlSessionTemplate.delete("boardMasterDelAll",list);
		return result;
	}

}
