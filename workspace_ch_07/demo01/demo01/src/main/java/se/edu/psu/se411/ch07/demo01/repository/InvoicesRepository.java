package se.edu.psu.se411.ch07.demo01.repository;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import se.edu.psu.se411.ch07.demo01.model.Invoice;

public class InvoicesRepository {

	private List<Invoice> invoices = Arrays.asList(
		new Invoice(1, new Date(2025, 2, 11), 340.0),
		new Invoice(1, new Date(2025, 3, 2), 120.0)
	);
	
	public List<Invoice> findAll() {
		return invoices;
	}
	
	public Invoice findById(Integer id) {
		Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()) {
            Invoice inv = iterator.next();
            if (inv.id() == id) {
                return inv;
            }
        }
        return null;
	}
	
	public void save(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public void deleteById(Integer id) {
		Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()) {
            Invoice inv = iterator.next();
            if (inv.id() == id) {
                iterator.remove();
            }
        }
	}
}
