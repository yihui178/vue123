package com.rabbiter.sms.dao.User;

import com.rabbiter.sms.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Description 登陆用户mapper层
 * Author: rabbiter
 * Date2019/10/21 21:08
 **/
@Mapper
public interface UserMapper {
  /**
   * description: 根据学生用户、密码登陆
   * @params: condition
   * @return: com.zjh.sms.dto.User
   * @Author: rabbiter
   * @Date: 2021/10/21 21:05
   */
  User getStudentInfo(@Param("condition") Map<String, Object> condition);
  /**
   * description: 根据老师用户、密码登陆
   * @params: condition
   * @return: com.zjh.sms.dto.User
   * @Author: rabbiter
   * @Date: 2021/10/21 21:05
   */
  User getTeacherInfo(@Param("condition") Map<String, Object> condition);
  /**
   * description: 根据管理员用户、密码登陆
   * @params: condition
   * @return: com.zjh.sms.dto.User
   * @Author: rabbiter
   * @Date: 2021/10/21 21:05
   */
  User getAdminInfo(@Param("condition") Map<String, Object> condition);
  /**
   * description: 修改密码
   * @params: condition
   * @return: void
   * @Author: rabbiter
   * @Date: 2022/3/4 23:05
   */
  void update(@Param("condition") Map<String, Object> condition);
  /**
   * description: 查询是否与原密码相同
   * @params: condition
   * @return: Integer
   * @Author: rabbiter
   * @Date: 2022/3/4 23:05
   */
  Integer checkPasswordCount(@Param("condition") Map<String, Object> condition);
  /**
  * description: 获取默哀模式
  * return: Integer
  * Author: rabbiter
  * @Date: 2022/5/1 13:10
  */
  Integer getSilent();
  /**
   * description: 获取默哀模式
   * return: Integer
   * Author: rabbiter
   * @Date: 2022/5/1 13:10
   */
  void setSilent(@Param("state") Integer state);
}
