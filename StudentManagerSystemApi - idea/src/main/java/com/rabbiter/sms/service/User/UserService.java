package com.rabbiter.sms.service.User;

import com.rabbiter.sms.dto.User;

import java.util.List;
import java.util.Map;

/**
 * Description 登陆用户接口
 * Author: rabbiter
 * Date2019/10/21 21:01
 **/
public interface UserService {
  /**
  * description: 根据用户、密码登陆
  * @params: condition
  * @return: com.zjh.student_mis.dto.User
  * @Author: rabbiter
  * @Date: 2021/10/21 21:05
  */
  User getStudentInfo(Map<String, Object> condition);
  /**
   * description: 修改密码
   * @param condition
   * @return void
   * @author rabbiter
   * @Date: 2022/3/4 23:05
   */
  boolean update(Map<String, Object> condition);
  /**
  * description: 获取树状数据
  * return: List<Object>
  * Author: rabbiter
  * @Date: 2022/3/27 22:13
  */
  List<Object> getTree();
  /**
  * description: 获取token
  * @param: User
  * return: String
  * Author: rabbiter
  * @Date: 2022/3/30 23:21
  */
  String getToken(User user, long time);
  /**
  * description: 根据等级和id获取用户信息
  * @param: condition
  * return: User
  * Author: rabbiter
  * @Date: 2022/3/30 23:42
  */
  User findUser(Map<String, Object> condition);
  /**
  * description: 获取默哀模式
  * return: boolean
  * Author: rabbiter
  * @Date: 2022/5/1 13:09
  */
  boolean getSilent();
  /**
  * description: 修改默哀模式
  * @param: String
  * return: boolean
  * Author: rabbiter
  * @Date: 2022/5/1 13:29
  */
  boolean setSilent(Integer state);
}
