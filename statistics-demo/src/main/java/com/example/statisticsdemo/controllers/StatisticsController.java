package com.example.statisticsdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.statisticsdemo.dto.DataInputDTO;
import com.example.statisticsdemo.dto.StatisticDTO;
import com.example.statisticsdemo.service.IStatisticsService;


@RestController
@RequestMapping("/statistics")
public class StatisticsController {
  
  private IStatisticsService statisticService;

  public StatisticsController(IStatisticsService statisticService) {
      this.statisticService = statisticService;
  }
  
  @PostMapping("/calculate")
  public StatisticDTO getStatisticsInfo(@RequestBody DataInputDTO dt) throws Exception {   	
  	StatisticDTO result = statisticService.getStatisticsInfo(dt);
      return result;
  }
  
  @PostMapping("/inserir")
  public ResponseEntity<Void> inserirEstatistica(@RequestBody StatisticDTO statisticDTO) {
      try {
          statisticService.insertStatistics(statisticDTO);
          
          return ResponseEntity.status(HttpStatus.CREATED).build();
      } catch (Exception e) {
    	  System.out.println("Erro:" +e.getLocalizedMessage());
    	  System.out.println("Erro:" +e.getMessage());
    	  System.out.println("Erro:"+ e.getCause());
          // Em caso de erro na inserção, você pode retornar um código de status 500
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
  
	
//	@PostMapping("/insert")
//    public ResponseEntity<String> insertStatistics(@RequestBody StatisticDTO statisticDTO) {
//        try {
//            statisticService.insertStatistics(statisticDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Estatísticas inseridas com sucesso.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao inserir estatísticas.");
//        }
//    }
}