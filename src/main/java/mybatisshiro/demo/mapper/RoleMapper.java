package mybatisshiro.demo.mapper;

import mybatisshiro.demo.vo.Role;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    int deleteByPrimaryKey(String rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select * from Role where rid = #{rid,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "mybatisshiro.demo.mapper.UserMapper.selectByPrimaryKey")),
            @Result(column = "pid",property = "permission",one = @One(select = "mybatisshiro.demo.mapper.PermissionMapper.selectByKey"))
    })
    Role selectByKey(String rid);
}