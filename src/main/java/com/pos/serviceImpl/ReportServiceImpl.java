package com.pos.serviceImpl;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.Report;
import com.pos.service.ReportService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class ReportServiceImpl implements ReportService {

	private final EntityManager entityManager;

	@Autowired
	public ReportServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Report> dailyReports() {
		String sql = "SELECT " +
                "       COALESCE(SUM(p.purchaseCost), 0) AS totalPurchase, " +
                "       p.purchaseDate, " +
                "       COALESCE(SUM(s.sellPrice), 0) AS totalSell, " +
                "       COALESCE(SUM(s.paid), 0) AS totalPaid " +
                "FROM Purchase p " +
                "     JOIN Sell s ON p.purchaseDate = s.sellDate " +
                "GROUP BY p.purchaseDate";

		Query query = entityManager.createQuery(sql);
		List<Object[]> resultList = query.getResultList();
		List<Report> reports = new ArrayList<>();

		for (Object[] result : resultList) {
			Report report = new Report();
			report.setTotalPurchase((Double) result[0]);
			report.setPurchaseDate((Date) result[1]);
			report.setTotalSell((Double) result[2]);
			report.setTotalPaid((Double) result[3]);
			report.setTotalDue(report.getTotalSell() - report.getTotalPaid());
			reports.add(report);
		}
		return reports;
	}

}
