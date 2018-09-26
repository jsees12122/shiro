package mybatisshiro.demo.mapper;

import mybatisshiro.demo.vo.Permission;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PermissionMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    @Select("select * from Permission where pid = #{pid,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "rid",property = "role",one = @One(select = "mybatisshiro.demo.mapper.RoleMapper.selectByKey"))
    })
    Permission selectByKey(String pid);
}