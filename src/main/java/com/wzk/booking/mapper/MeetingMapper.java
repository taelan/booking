package com.wzk.booking.mapper;

import com.wzk.booking.model.Meeting;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/7 - 15:42
 */

@Repository
public interface MeetingMapper extends Mapper<Meeting> {
}
