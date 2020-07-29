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
	//����Ʈ Ȯ��
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new ListCommand();
		command.execute(model);
		
		return "list";
	}
	
	//�ۼ��ϴ� ȭ��
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view");
		
		return "wirte_view";
	}
	
	//�ۼ�
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write");
		
		model.addAttribute("request",request);
		command = new WriteCommand();
		command.execute(model);
		
		return "redirect:list"; //�ۼ��ϰ� ���� ����Ʈ �������� �����ַ���
		
	}
	
	//������ ���� ȭ��
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view");
		
		model.addAttribute("request",request);
		
		command = new ContentCommand();
		command.execute(model);;
		return "content_view";
	}
	
	//����
	@RequestMapping(method=RequestMethod.POST,value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify");
		
		model.addAttribute("request",request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirext:list"; //�����ϰ� ����Ʈ ������ ������
		
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