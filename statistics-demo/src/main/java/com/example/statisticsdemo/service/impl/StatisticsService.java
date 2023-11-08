package com.example.statisticsdemo.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.statisticsdemo.config.MyBatisConfig;
import com.example.statisticsdemo.dto.DataInputDTO;
import com.example.statisticsdemo.dto.StatisticDTO;
import com.example.statisticsdemo.persistance.mappers.IStatisticsMapper;
import com.example.statisticsdemo.service.IStatisticsService;

import lombok.RequiredArgsConstructor;

@Service
public class StatisticsService implements IStatisticsService{
	
	@Autowired
    private IStatisticsMapper statisticMapper;


	@Override
	public StatisticDTO getStatisticsInfo(DataInputDTO input) throws Exception {
		StatisticDTO s = new StatisticDTO();
		
		List<Double> numbers = input.getNumbers();
        if (numbers == null || numbers.isEmpty()) {
            return s;
        }

        // Calcula a soma dos números.
        double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        // Calcula a média dos números.
        double mean = sum / numbers.size();
        s.setMean(mean);

        // Ordena a lista para calcular a mediana.
        Collections.sort(numbers);

        // Calcula a mediana.
        double median;
        if (numbers.size() % 2 == 0) {
            int middle = numbers.size() / 2;
            median = (numbers.get(middle - 1) + numbers.get(middle)) / 2.0;
        } else {
            int middle = numbers.size() / 2;
            median = numbers.get(middle);
        }
        s.setMedian(median);

        // Calcula o mínimo e o máximo.
        double min = numbers.get(0);
        double max = numbers.get(numbers.size() - 1);
        s.setMin(min);
        s.setMax(max);

        return s;
	}

	@Override
	public void insertStatistics(StatisticDTO statisticDTO) throws Exception {
		statisticMapper.insertStatistic(statisticDTO);
	}

}
