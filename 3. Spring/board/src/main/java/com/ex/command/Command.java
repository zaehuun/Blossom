package com.ex.command;

import org.springframework.ui.Model;

public interface Command {
	public void execute(Model model);
}
