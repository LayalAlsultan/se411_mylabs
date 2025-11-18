package se.edu.psu.se411.ch07.demo01.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.edu.psu.se411.ch07.demo01.model.Invoice;
import se.edu.psu.se411.ch07.demo01.repository.InvoicesRepository;

@RestController
@RequestMapping("/api/v1/invoices")
public class Invoices {

	private InvoicesRepository invoiceRepository = new InvoicesRepository();
	
	@GetMapping
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}
	
}
