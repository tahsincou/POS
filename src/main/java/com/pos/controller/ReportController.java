
package com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pos.model.Report;
import com.pos.service.ReportService;
import com.pos.serviceImpl.EmailService;

@Controller
@RequestMapping("")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@Autowired
    private EmailService emailService;

	@GetMapping("/dailyreports")
	public String saveOrUpdatePurchase(Model model) {
		List<Report> reports = reportService.dailyReports();
		model.addAttribute("reports", reports);
		return "report";
	}
	
	@PostMapping("/send")
	public String sendEmail(@RequestParam(required = false) String to, @RequestParam(required = false) String subject, @RequestParam(required = false) String text) {
		to= "tahsincou@gmail.com";
		text="Congratulations! Tahsin Rono.";
		subject="You nailed it!";
		emailService.sendEmail(to, subject, text);
		return "Email sent successfully";
	}

}
