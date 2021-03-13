package com.wzk.booking.model;

import com.wzk.booking.common.GenKeyId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/7 - 11:24
 * chain 一个布尔值。如果为真，产生的setter返回的this而不是void。默认是假。如果fluent=true，那么chain默认为真。
 */

@Data
@Accessors(chain = true)
@Table(name = "meeting")
public class Meeting {
    public final static String ID = "id";
    @Id
    private Long id;

    public final static String MEETING_ID = "meetingId";
    @Column(name = "meeting_id")
    @KeySql(genId = GenKeyId.class)
    @ApiModelProperty(value = "会议id")
    private String meetingId;

    public final static String ROOM_ID = "roomId";
    @Column(name = "room_id")
    @ApiModelProperty(value = "会议室ID")
    private String roomId;

    public final static String MEETING_NAME = "meetingName";
    @Column(name = "meeting_name")
    @ApiModelProperty(value = "会议名称")
    private String meetingName;

    public final static String MEETING_THEME = "meetingTheme";
    @Column(name = "meeting_theme")
    @ApiModelProperty(value = "会议主题")
    private String meetingTheme;

    public final static String START_TIME = "startTime";
    @Column(name = "start_time")
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    public final static String END_TIME = "endTime";
    @Column(name = "end_time")
    @ApiModelProperty(value = "结束时间")
    private String endTime;

    public final static String COUNT_PARTICIPANTS = "countParticipants";
    @Column(name = "count_participants")
    @ApiModelProperty(value = "参会人员数量")
    private String countParticipants;

    public final static String PROP_DELETE_FLAG = "deleteFlag";
    @Column(name = "delete_flag")
    @ApiModelProperty(value = "删除状态")
    private String deleteFlag;

    public final static String PROP_CREATE_TIME = "createTime";
    @Column(name = "create_time")
    private Date createTime;

    public final static String PROP_MODIFY_TIME = "modifyTime";
    @Column(name = "modify_time")
    private Date modifyTime;

}
