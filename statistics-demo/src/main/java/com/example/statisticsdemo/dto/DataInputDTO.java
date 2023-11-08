package com.example.statisticsdemo.dto;

import java.util.List;

public class DataInputDTO {
    private List<Double> numbers;
    
    // Construtor padrão sem argumentos
    public DataInputDTO() {
    }
    
	public DataInputDTO(List<Double> numbers) {
		this.numbers = numbers;
	}

	public List<Double> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}
}
