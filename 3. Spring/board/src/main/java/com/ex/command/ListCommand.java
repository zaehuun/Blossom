package com.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.ex.dao.BDao;
import com.ex.dto.BDto;

public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list",dtos);
	}

}
