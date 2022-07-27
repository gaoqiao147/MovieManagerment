package com.freesoft.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("movie_information")
public class MovieInformationDO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 电影详情id
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    /**
     * 电影名称
     */
    private String mname;

    /**
     * 电影票单价
     */
    private BigDecimal price;

    /**
     * 电影上映时间
     */
    private Date date;

    /**
     * 外键_电影类别id
     */
    private Integer movieCid;


}
