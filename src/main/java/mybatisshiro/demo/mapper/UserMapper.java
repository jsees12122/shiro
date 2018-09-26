package mybatisshiro.demo.mapper;

import mybatisshiro.demo.vo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from User where username = #{username,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "rid",property = "rid"),
            @Result(column = "rid",property = "role",one = @One(select = "mybatisshiro.demo.mapper.RoleMapper.selectByKey"))
    })
    User selectByUsername(@Param("username")String username);

    @Select("select * from User where uid = #{uid,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "rid",property = "rid"),
            @Result(column = "rid",property = "role",one = @One(select = "mybatisshiro.demo.mapper.RoleMapper.selectByKey"))
    })
    User selectByKey(@Param("username")String username);
}