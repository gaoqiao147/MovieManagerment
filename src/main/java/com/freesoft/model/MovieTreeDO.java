package com.freesoft.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhouwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("movie_tree")
public class MovieTreeDO implements Serializable {
    @TableId
    private Integer id;
    /**
     * 类型
     */
    private String typeName;
    /**
     * 标志
     */
    private String typeSign;
    /**
     * 父id
     */
    private Integer parentID;
    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<MovieTreeDO> childrenList;
}

