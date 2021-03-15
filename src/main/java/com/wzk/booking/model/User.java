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
 * @date 2021/3/13 - 17:22
 */
@Data
@Accessors(chain = true)
@Table(name = "user")
public class User {
    public final static String ID = "id";
    @Id
    private Long id;

    public final static String USER_ID = "userId";
    @Column(name = "user_id")
    @KeySql(genId = GenKeyId.class)
    @ApiModelProperty(value = "用户id")
    private String userId;

    public final static String NICE_NAME = "nickName";
    @Column(name = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    public final static String AVATAR_URL = "avatarUrl";
    @Column(name = "avatar_url")
    @ApiModelProperty(value = "用户头像url")
    private String avatarUrl;

    public final static String GENDER = "gender";
    @Column(name = "gender")
    @ApiModelProperty(value = "性别")
    private String gender;

    public final static String COUNTRY = "country";
    @Column(name = "country")
    @ApiModelProperty(value = "国家")
    private String country;

    public final static String PROVINCE = "province";
    @Column(name = "province")
    @ApiModelProperty(value = "省份")
    private String province;

    public final static String CITY = "city";
    @Column(name = "city")
    @ApiModelProperty(value = "城市")
    private String city;

    public final static String OPEN_ID = "openId";
    @Column(name = "open_id")
    @ApiModelProperty(value = "用户唯一标识")
    private String openId;

    public final static String UNION_ID = "unionId";
    @Column(name = "union_id")
    @ApiModelProperty(value = "用户在开放平台的唯一标识符")
    private String unionId;

    public final static String MOBILE = "mobile";
    @Column(name = "mobile")
    @ApiModelProperty(value = "手机")
    private String mobile;

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
