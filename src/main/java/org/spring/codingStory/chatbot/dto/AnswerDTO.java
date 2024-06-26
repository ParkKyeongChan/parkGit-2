package org.spring.codingStory.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AnswerDTO {
	
	private long id;

	private String content;

	private String keyword;//name
	
	private PhoneInfo phone;

	private List<PhoneInfo> phoneInfoList;
	
	public AnswerDTO phone(PhoneInfo phone){
		this.phone=phone;
		return this;
	}



}
