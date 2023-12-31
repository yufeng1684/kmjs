package org.kmjs.springcloudserviceprovider.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kmjs.springcloudserviceprovider.model.User;
import org.kmjs.springcloudserviceprovider.model.UserExample;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, address, ",
        "age, name, phone_num)",
        "values (#{id,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{phoneNum,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, address, age, name, phone_num",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.kmjs.springcloudserviceprovider.model.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set address = #{address,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "phone_num = #{phoneNum,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}