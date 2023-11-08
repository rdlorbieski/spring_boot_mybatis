package com.example.statisticsdemo.service;

import com.example.statisticsdemo.dto.DataInputDTO;
import com.example.statisticsdemo.dto.StatisticDTO;

public interface IStatisticsService {

	StatisticDTO getStatisticsInfo(DataInputDTO input) throws Exception;
	
	void insertStatistics(StatisticDTO statisticDTO)  throws Exception;

}
