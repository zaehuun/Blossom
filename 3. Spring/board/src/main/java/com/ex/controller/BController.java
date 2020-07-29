package com.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.command.Command;
import com.ex.command.ContentCommand;
import com.ex.command.DeleteCommand;
import com.ex.command.ListCommand;
import com.ex.command.ModifyCommand;
import com.ex.command.ReplyCommand;
import com.ex.command.ReplyViewCommand;
import com.ex.command.WriteCommand;

@Controller
public class BController {
	Command command;
	//리스트 확인
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new ListCommand();
		command.execute(model);
		
		return "list";
	}
	
	//작성하는 화면
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view");
		
		return "wirte_view";
	}
	
	//작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write");
		
		model.addAttribute("request",request);
		command = new WriteCommand();
		command.execute(model);
		
		return "redirect:list"; //작성하고 나서 리스트 페이지를 보여주려고
		
	}
	
	//컨텐츠 보는 화면
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view");
		
		model.addAttribute("request",request);
		
		command = new ContentCommand();
		command.execute(model);;
		return "content_view";
	}
	
	//수정
	@RequestMapping(method=RequestMethod.POST,value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify");
		
		model.addAttribute("request",request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirext:list"; //수정하고 리스트 페이지 보여줌
		
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view");
		
		model.addAttribute("request",request);
		command = new ReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply_command(HttpServletRequest request, Model model) {
		System.out.println("reply");
		
		model.addAttribute("request",request);
		command = new ReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
	
		System.out.println("delete");
		
		model.addAttribute("request",request);
		command = new DeleteCommand();
		command.execute(model);
			
		return "reply_view";
		
	}
}