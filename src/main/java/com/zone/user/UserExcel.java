package com.zone.user;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class UserExcel extends AbstractExcelView{
	
	@Override
	protected void buildExcelDocument(Map<String,Object> model, HSSFWorkbook workbook, 
			HttpServletRequest request, HttpServletResponse response) {
		
		@SuppressWarnings("unchecked")
		List<UserModel> userList = (List<UserModel>) model.get("userList");
		
		int rowcount =0;
		
		HSSFSheet sheet = workbook.createSheet("User");
		sheet.setDefaultColumnWidth(40);
		
		//===== Create a Style =======//
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Times New Roman");
		font.setBoldweight(HSSFColor.WHITE.index);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		HSSFRow header = sheet.createRow(rowcount++);
		header.createCell(0).setCellValue("NAME");
		header.createCell(1).setCellValue("USERNAME");
		header.createCell(2).setCellValue("ROLE");
		header.createCell(3).setCellValue("EMAIL");
		header.createCell(4).setCellValue("PHONE");
		
		header.getCell(0).setCellStyle(style);
		header.getCell(1).setCellStyle(style);
		header.getCell(2).setCellStyle(style);
		header.getCell(3).setCellStyle(style);
		header.getCell(4).setCellStyle(style);
		
		
		DecimalFormat format = new DecimalFormat("##.00");
		System.err.println(format);
		
		for(UserModel user: userList) {
			HSSFRow row = sheet.createRow(rowcount++);
			row.createCell(0).setCellValue(user.getName());
			row.createCell(1).setCellValue(user.getUsername());
			row.createCell(2).setCellValue(user.getRole_id().getRole_name());
			row.createCell(3).setCellValue(user.getEmail());
			row.createCell(4).setCellValue(user.getMobileno());
			
		}
		
		
		
	}

}
