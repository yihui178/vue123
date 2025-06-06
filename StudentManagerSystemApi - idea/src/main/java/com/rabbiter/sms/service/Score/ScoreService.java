package com.rabbiter.sms.service.Score;

import com.rabbiter.sms.dto.Course;
import com.rabbiter.sms.dto.Score;
import com.rabbiter.sms.utils.PagingResult;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Description 分数信息Service类
 * Author: rabbiter
 * Date: 2020/3/13 15:47
 **/
public interface ScoreService {
  /**
   * description: 根据班级等信息获取课程信息
   * @param rowBounds
   * @param condition
   * @author rabbiter
   * @return com.jw.zjh.sms.utils.PagingResult
   * @date 2020/3/4 23:05
   */
  PagingResult<Course> getCourseList(RowBounds rowBounds, Map<String, Object> condition);
  /**
  * description: 录入成绩
  * @param: List<Score>
  * return: void
  * Author: rabbiter
  * @Date: 2022/3/19 16:23
  */
  void addEntry(List<Score> list);
  /**
  * description: 导出成绩到Excel
  * @param: Map<String, Object> condition
  * return: List<Course>
  * Author: rabbiter
  * @Date: 2022/3/21 16:26
  */
  List<Course> getExportList(Map<String, Object> condition);
  /**
  * description: 根据成绩划分等级（不及格、及格、优秀）
  * @param: Map<String, Object> condition
  * return: List<Map<String, Object>>
  * Author: rabbiter
  * @Date: 2022/4/3 22:53
  */
  List<Map<String, Object>> getUserNum(Map<String, Object> condition);
  /**
   * description: 学生用户根据id获取总学分和总绩点
   * @param: Map<String, Object> condition
   * return: Map<String, Object>
   * Author: rabbiter
   * @Date: 2022/4/3 22:53
   */
  Map<String, Object> getUserTotal(Map<String, Object> condition);
}
