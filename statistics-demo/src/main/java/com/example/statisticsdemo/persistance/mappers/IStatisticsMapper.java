package com.example.statisticsdemo.persistance.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.statisticsdemo.dto.StatisticDTO;

@Mapper
public interface IStatisticsMapper {
	 // @Options(useGeneratedKeys = true, keyProperty = "id")
	//	@Insert("INSERT INTO statistics_data (mean, median, min, max) VALUES (1, 1, 0, 2)") 
	@Insert("INSERT INTO statistic (max, mean, median, min) VALUES (#{max}, #{mean}, #{median}, #{min})") 
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insertStatistic(StatisticDTO s);
	 
	 
}
