package org.example.final2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.final2.entities.Szry;
import java.util.List;

@Mapper
public interface ISzryDao {
    @Select("select *, ST_X(geom) as lon, ST_Y(geom) as lat from szry")
    List<Szry> selectAll();
}