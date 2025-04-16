package com.ztx.mapper;

import com.ztx.pojo.emp;

import java.util.List;

public interface UserMapper {
    List<emp>selectAll();

    emp selectBuyId(int id);
}
