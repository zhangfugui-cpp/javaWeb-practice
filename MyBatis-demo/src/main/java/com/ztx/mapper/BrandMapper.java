package com.ztx.mapper;


import com.ztx.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();

    Brand selectByIdBrand(int id);

    void add(Brand brand);
}
