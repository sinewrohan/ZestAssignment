package com.zest.assigmnment;


	import java.io.File;
	import java.io.FileInputStream;

	import java.util.Date;

	import org.apache.poi.ss.format.CellDateFormatter;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.FormulaEvaluator;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;



	public class ExcelLib<ExcelFileUtility> {

		private static Sheet ExcelWSheet;
		private static Workbook ExcelWBook;
		private static Row row;
		private static Cell cell;
		static int rowNum, cellNum;
		static String Standpath="C:\\Users\\BandiH\\Documents\\autoIT_Data\\Test_Sample.exe";

		
		public static String[][] getExcelFile(String path,String sheet ) throws Exception {
			String data[][] = null;
			Date date; 
			String dateFormat;
			int type;
			FileInputStream ExcelFile = new FileInputStream(new File(path));
 
			ExcelWBook  =WorkbookFactory.create(ExcelFile);
			try{
			 
			}catch(Exception e){
				e.printStackTrace();
			}
		
			FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
			 ExcelWSheet=ExcelWBook.getSheet(sheet);
			rowNum = ExcelWSheet.getLastRowNum()+1;
			data = new String[rowNum][];

			for (int i = 0; i < rowNum ; i++) {
				row=ExcelWSheet.getRow(i);
				cellNum = row.getLastCellNum();
				data[i]=new String[cellNum];
			
				for (int j = 0; j < cellNum; j++) {				
					cell = ExcelWSheet.getRow(i).getCell(j);
					try{
					type=evaluator.evaluateInCell(cell).getCellType();				
					
					if((type)==1 || (type)==0){
					switch (type) {
					case Cell.CELL_TYPE_BLANK:		
						data[i][j]=String.valueOf(" ");
						break;
						
					case Cell.CELL_TYPE_ERROR:
						data[i][j]=String.valueOf(cell.getErrorCellValue());
						break;
						
					case Cell.CELL_TYPE_FORMULA:
						data[i][j]=String.valueOf(cell.getCellFormula());
						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						// if Date is there in excel if block will pick and formatted to Date format
						if (DateUtil.isCellDateFormatted(cell)) {
						   date = DateUtil.getJavaDate(cell.getNumericCellValue());
						   dateFormat = cell.getCellStyle().getDataFormatString();
						    data[i][j] = new CellDateFormatter(dateFormat).format(date); 
						} 
						// other than Date format this else will execute
						else {
		        		data[i][j]=String.valueOf(cell.getNumericCellValue());
						}
			
						break;
					case Cell.CELL_TYPE_STRING:
				    	data[i][j]=cell.getStringCellValue();
					
						break;
					default:
						System.out.println("Cell data not found");
					}
					}
					}catch(Exception e){	
					}				
				}		
			}
			return data;
		}
		public static int gettotalColumn(String FilePath, String sheet) throws Exception{

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			XSSFWorkbook workbook= new XSSFWorkbook(ExcelFile);
			XSSFSheet sh=workbook.getSheet(sheet);
			int column=sh.getRow(0).getLastCellNum();
			return column;
			}
		}