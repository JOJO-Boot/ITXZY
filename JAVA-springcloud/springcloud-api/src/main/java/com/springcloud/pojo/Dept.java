package com.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //链式写法  true:支持 false : 不支持
public class Dept implements Serializable {

    private static final long serialVersionUID = 4286877423207134462L;

    private Long deptno;
    private String dname;

    //查看数据存在哪个数据库的字段 微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;
}
