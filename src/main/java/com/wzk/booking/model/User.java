package com.wzk.booking.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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

}
