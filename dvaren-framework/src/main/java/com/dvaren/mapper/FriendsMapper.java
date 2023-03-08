package com.dvaren.mapper;

import com.dvaren.domain.entity.Friends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 025
* @description 针对表【t_friends】的数据库操作Mapper
* @createDate 2023-03-06 18:11:26
* @Entity com.dvaren.domain.entity.Friends
*/
@Mapper
public interface FriendsMapper extends BaseMapper<Friends> {

}




