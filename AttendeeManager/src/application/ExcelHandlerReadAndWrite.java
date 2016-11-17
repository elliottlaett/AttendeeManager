package application;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ExcelHandlerReadAndWrite {

	static List<String> listOfHeaders = new ArrayList<>();

	public static String excelFilePath = null;

	static String fileName = null;

	public static List<Attendee> readExcelFile() {

		List<Attendee> listOfAttendees = new ArrayList<>();

		List<Attendee> notAcceptedList = new ArrayList<>();

		Date date = null;
		String name = null;
		String program = null;
		Integer grade = null;
		String alergies = null;
		String email = null;
		Integer phoneNum = null;
		String motivation = null;
		String participated = null;

		boolean checkBlankRow = true;

		try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				Workbook workbook = new XSSFWorkbook(inputStream)) {
			Sheet firstSheet = workbook.getSheetAt(0);

			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					if (row.getRowNum() >= 1) {

						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:

							switch (cell.getColumnIndex()) {
							case 0:

								break;
							case 1:
								name = cell.getStringCellValue();

								break;
							case 2:
								program = cell.getStringCellValue();

								break;
							case 4:
								alergies = cell.getStringCellValue();

								break;
							case 5:
								email = cell.getStringCellValue();

								break;
							case 7:
								motivation = cell.getStringCellValue();

								break;
							case 8:
								participated = cell.getStringCellValue();

								break;

							default:
								break;
							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (DateUtil.isCellDateFormatted(cell)) {

								date = cell.getDateCellValue();

							} else if (cell.getColumnIndex() == 3) {

								grade = (int) cell.getNumericCellValue();

							} else {
								phoneNum = (int) cell.getNumericCellValue();

							}
							break;

						case Cell.CELL_TYPE_BLANK:

							if (row.getRowNum() > 2) {

								checkBlankRow = false;

							}

							break;

						}
					} else if (row.getRowNum() == 0) {
						listOfHeaders.add(cell.getStringCellValue());
					}

				}
				if (checkBlankRow) {
					listOfAttendees.add(new Attendee(date, name, program, grade, alergies, email, phoneNum, motivation,
							participated));
				}

			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(ExcelHandlerReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ExcelHandlerReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listOfAttendees;
	}

	public static File createNewExcelSheets(List<Attendee> attendees) {

		// Adding empty attendees but are not used because of the looks of the
		// created excel file
		attendees.add(0, new Attendee(null, null, null, null, null, null, null, null, null));
		attendees.add(0, new Attendee(null, null, null, null, null, null, null, null, null));

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");

		List<Object> listOfAttendees = new ArrayList<>();

		int rowCount = 0;

		for (Attendee attendee : attendees) {

			Row row = sheet.createRow(rowCount++);

			listOfAttendees.add(attendee.getDate());
			listOfAttendees.add(attendee.getName());
			listOfAttendees.add(attendee.getProgram());
			listOfAttendees.add(attendee.getGrade());
			listOfAttendees.add(attendee.getAlergies());
			listOfAttendees.add(attendee.getEmail());
			listOfAttendees.add(attendee.getPhoneNum());
			listOfAttendees.add(attendee.getMotivation());
			listOfAttendees.add(attendee.getMember());

			int columnCount = 0;

			for (Object field : listOfAttendees) {
				Cell cell = row.createCell(columnCount++);

				if (rowCount == 1 || rowCount == 2) {

					switch (columnCount - 1) {
					case 0:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(0));

						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 1:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(1));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 2:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(2));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 3:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(3));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 4:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(4));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 5:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(5));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 6:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(6));
						} else {
							cell.setCellValue((String) "");
						}

						break;
					case 7:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(7));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					case 8:
						if (rowCount == 1) {
							cell.setCellValue((String) listOfHeaders.get(8));
						} else {
							cell.setCellValue((String) "");
						}
						break;
					default:
						break;
					}

				} else if (field instanceof String) {

					cell.setCellValue((String) field);

				} else if (field instanceof Integer) {

					cell.setCellValue((Integer) field);

				} else if (field instanceof Date) {

					CellStyle cellStyle = workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd hh:mm:ss"));
					cell.setCellValue(new Date());
					cell.setCellStyle(cellStyle);

				}
			}
			listOfAttendees.clear();
		}

		// Removing the empty attendees
		attendees.remove(0);
		attendees.remove(0);

		File file = new File(fileName + ".xlsx");

		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			workbook.write(outputStream);

		} catch (FileNotFoundException ex) {
			Logger.getLogger(ExcelHandlerReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ExcelHandlerReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}

}